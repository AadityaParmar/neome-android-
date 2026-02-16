package com.neome.feature.form.domain.util.FieldVal

import com.neome.api.meta.base.SysId
import com.neome.api.meta.base.Types
import com.neome.api.meta.base.Types.EntUserId
import com.neome.api.meta.base.Types.EnumDefnCompType
import com.neome.api.meta.base.Types.MetaIdComp
import com.neome.api.meta.base.Types.RowId
import com.neome.api.meta.base.dto.DefnFieldEditableText
import com.neome.api.meta.base.dto.DefnFieldInfo
import com.neome.api.meta.base.dto.DefnFieldParagraph
import com.neome.api.meta.base.dto.DefnForm
import com.neome.core.common.serializer.api.meta.base.dto.DefnCompSeal
import com.neome.core.common.serializer.api.meta.base.dto.DefnGridData
import com.neome.core.common.serializer.api.meta.base.dto.FieldDtoGridRowData
import com.neome.core.common.serializer.api.meta.base.dto.FieldValueGridData
import com.neome.core.common.serializer.api.meta.base.dto.FormValueData
import com.neome.feature.form.domain.util.ArgValueResolver
import com.neome.feature.form.domain.util.FormPlus
import kotlinx.serialization.json.JsonElement


internal interface DefaultValue : Converter {

    companion object {
        private const val TAG = "DefaultValue"
    }

    // ── Public API ─────────────────────────────────────────────────────


    fun fnEnsureInit(
        defnForm: DefnForm,
        formValue: FormValueData?,
        defaultValue: Map<MetaIdComp, JsonElement> = emptyMap()
    ): FormValueData {

        val mutableFormValue = MutableFormValue(
            rowId = formValue?.rowId,
            createdBy = formValue?.createdBy,
            updatedBy = formValue?.updatedBy,
            createdOn = formValue?.createdOn,
            updatedOn = formValue?.updatedOn,
            rowOrder = formValue?.rowOrder,
            existingValueMap = formValue?.valueMap,
            defaultValue = defaultValue
        )
        val gridSet = mutableSetOf<MetaIdComp>()


        FormPlus.loopDefnForm(defnForm) { comp, parent ->

            if (parent.type == EnumDefnCompType.section) {

                val resolvedSet = mutableSetOf<MetaIdComp>()

                val compId = FormPlus.getCompMetaId(comp)
                if (compId != null) {
                    val fieldValue = resolveCompDefaultValue(
                        defnForm,
                        comp,
                        mutableFormValue, // for grid this will be FieldDtoGridRow
                        mutableFormValue.toFormValueData(), // for grid rows to access parent
                        resolvedSet
                    )
                    if (fieldValue != null) {
                        val jsonElement = fnFieldValueToJsonElement(comp.type, fieldValue)
                        if (jsonElement != null) {
                            mutableFormValue.putValue(compId, jsonElement)
                        }
                    }
                }
            } else if (parent.type == EnumDefnCompType.grid) {
                val compId = FormPlus.getCompMetaId(comp)
                if (compId != null)
                    gridSet.add(compId)
            }

            null // continue iteration — never break early
        }
        if (gridSet.isNotEmpty()) {
            gridSet.forEach { gridId ->
                val grid = defnForm.compMap[gridId] as? DefnGridData ?: return@forEach

                fnEnsureInitGrid(defnForm, grid, mutableFormValue.toFormValueData())

            }
        }

        return mutableFormValue.toFormValueData()
    }

    /**
     * Ensures every leaf field inside [fieldGrid] has an initial value for a
     * single grid row.
     *
     */
    private fun fnEnsureInitGrid(
        defnForm: DefnForm,
        fieldGrid: DefnGridData,
        formValue: FormValueData?,
    ) {
        val gridId = FormPlus.getCompMetaId(fieldGrid) ?: return
        val fieldValueGrid = FieldValueResolver.fnJsonElementFieldValue(
            fieldGrid.type,
            formValue?.valueMap[gridId]
        ) as FieldValueGridData?
        val newGridRowMap = mutableMapOf<Types.RowId, FieldDtoGridRowData>().apply {
            val map = fieldValueGrid?.map
            if (map != null)
                putAll(map)
        }


        fieldValueGrid?.keys?.forEach { rowId ->
            val gridRow = fieldValueGrid.map[rowId]
            val newGridRow = fnEnsureInitGridRow(defnForm, fieldGrid, formValue, gridRow)
            newGridRowMap.set(rowId, newGridRow)
        }
    }

    fun fnEnsureInitGridRow(
        defnForm: DefnForm,
        fieldGrid: DefnGridData,
        formValue: FormValueData?,
        gridRow: FieldDtoGridRowData?,
    ): FieldDtoGridRowData {

        val mutableGridValue = MutableFormValue(
            rowId = gridRow?.rowId,
            createdBy = gridRow?.createdBy,
            updatedBy = gridRow?.updatedBy,
            createdOn = gridRow?.createdOn,
            updatedOn = gridRow?.updatedOn,
            rowOrder = gridRow?.rowOrder,
            existingValueMap = gridRow?.valueMap as Map<MetaIdComp, JsonElement>?,
        )
        fieldGrid.fieldIdSet?.forEach { fieldId ->
            val resolvedSet = mutableSetOf<MetaIdComp>()
            val comp = defnForm.compMap[fieldId] as? DefnCompSeal ?: return@forEach
            val compId = FormPlus.getCompMetaId(comp) ?: return@forEach

            val fieldValue = resolveCompDefaultValue(
                defnForm,
                comp,
                mutableGridValue, // for grid this will be FieldDtoGridRow
                formValue, // for grid rows to access parent
                resolvedSet
            )
            if (fieldValue != null) {
                val jsonElement = fnFieldValueToJsonElement(comp.type, fieldValue)
                if (jsonElement != null) {
                    mutableGridValue.putValue(compId, jsonElement)
                }
            }
        }

        return mutableGridValue.toFieldDtoGridRowData()

    }

    // ── Dispatch ───────────────────────────────────────────────────────


    private fun resolveCompDefaultValue(
        defnForm: DefnForm,
        defnComp: DefnCompSeal,
        mutableFormValue: MutableFormValue,
        formValue: FormValueData?,
        resolvedSet: MutableSet<MetaIdComp>
    ): Any? {
        val compId = FormPlus.getCompMetaId(defnComp) ?: return null

        // Cycle guard — already processing this component → return null
        if (!resolvedSet.add(compId)) return null

        // Existing value wins — decode and return it
        val existingJson = mutableFormValue.getValue(compId)
        if (existingJson != null) {
            return fnJsonElementFieldValue(defnComp.type, existingJson)
        }

        // this method will be reUse for grid row
        val existingJsonInFormValue = formValue?.valueMap[compId]
        if (existingJsonInFormValue != null) {
            return fnJsonElementFieldValue(defnComp.type, existingJsonInFormValue)
        }

        val fieldValue: Any? = when (defnComp.type) {
            // ── Text ────────────────────────────────────────
            EnumDefnCompType.text,
            EnumDefnCompType.password ->
                resolverEditableText(defnForm, defnComp, mutableFormValue, formValue, resolvedSet)

            // ── Paragraph ──────────────────────────────────────────────
            EnumDefnCompType.paragraph ->
                resolverParagraph(defnForm, defnComp, mutableFormValue, formValue, resolvedSet)

            // ── Info ───────────────────────────────────────────────────
            EnumDefnCompType.info ->
                resolveInfo(defnForm, defnComp, mutableFormValue, formValue, resolvedSet)

            // ── Other types — no-op for now ────────────────────────────
            else -> null
        }

        // Convert @Serializable field-value to JsonElement and store in valueMap

        return fieldValue
    }


    // region factory
    private fun resolverEditableText(
        defnForm: DefnForm,
        defnComp: DefnCompSeal,
        mutableFormValue: MutableFormValue,
        formValue: FormValueData?,
        resolvedSet: MutableSet<MetaIdComp>
    ): Any? {
        val field = defnComp as? DefnFieldEditableText ?: return null

        val rawValue: String? = when {
            field.defaultValue != null -> {
                field.defaultValue
            }

            field.defaultVar != null -> {
                ArgValueResolver.resolveArgForFieldVal(defnForm, formValue, field.defaultVar)
            }

            field.defaultFieldId != null -> {
                resolveDefaultFieldIdVal(
                    defnForm,
                    defnComp,
                    field.defaultFieldId!!,
                    mutableFormValue,
                    formValue,
                    resolvedSet
                )
            }

            else -> null
        }

        return rawValue?.let { fnRawValueToFieldValue(defnComp.type, it) }
    }


    private fun resolverParagraph(
        defnForm: DefnForm,
        defnComp: DefnCompSeal,
        mutableFormValue: MutableFormValue,
        formValue: FormValueData?,
        resolvedSet: MutableSet<MetaIdComp>
    ): Any? {
        val field = defnComp as? DefnFieldParagraph ?: return null

        val rawValue: String? = when {
            field.defaultValue != null -> {
                field.defaultValue
            }

            field.defaultVar != null -> {
                ArgValueResolver.resolveArgForFieldVal(defnForm, formValue, field.defaultVar)
            }

            field.defaultFieldId != null -> {
                resolveDefaultFieldIdVal(
                    defnForm,
                    defnComp,
                    field.defaultFieldId!!,
                    mutableFormValue,
                    formValue,
                    resolvedSet
                )
            }

            else -> null
        }

        return rawValue?.let { fnRawValueToFieldValue(defnComp.type, it) }
    }


    private fun resolveInfo(
        defnForm: DefnForm,
        defnComp: DefnCompSeal,
        mutableFormValue: MutableFormValue,
        formValue: FormValueData?,
        resolvedSet: MutableSet<MetaIdComp>
    ): Any? {
        val field = defnComp as? DefnFieldInfo ?: return null

        val rawValue: String? = when {
            field.defaultValue != null -> {
                field.defaultValue
            }

            field.defaultVar != null -> {
                ArgValueResolver.resolveArgForFieldVal(defnForm, formValue, field.defaultVar)
            }

            field.defaultFieldId != null -> {
                resolveDefaultFieldIdVal(
                    defnForm,
                    defnComp,
                    field.defaultFieldId!!,
                    mutableFormValue,
                    formValue,
                    resolvedSet
                )
            }

            else -> null
        }

        return rawValue?.let { fnRawValueToFieldValue(defnComp.type, it) }
    }

    //endregion

    // ── Shared helpers ─────────────────────────────────────────────────


    private fun resolveDefaultFieldIdVal(
        defnForm: DefnForm,
        currentComp: DefnCompSeal,
        defaultFieldId: Types.MetaIdField,
        mutableFormValue: MutableFormValue,
        formValue: FormValueData?,
        resolvedSet: MutableSet<MetaIdComp>
    ): String? {

        val defaultFieldComp = defnForm.compMap[defaultFieldId] as? DefnCompSeal ?: return null

        // Recursively resolve — returns the typed field-value or null (cycle)
        val refFieldValue =
            resolveCompDefaultValue(defnForm, defaultFieldComp, mutableFormValue, formValue, resolvedSet)

        // Convert the typed field-value back to a raw string
        return fnFieldValueToRawValue(defaultFieldComp.type, refFieldValue) as? String
    }
}

// ── MutableFormValue ───────────────────────────────────────────────────

internal class MutableFormValue(
    rowId: RowId? = null,
    var createdBy: EntUserId? = null,
    var updatedBy: EntUserId? = null,
    var createdOn: String? = null,
    var updatedOn: String? = null,
    var rowOrder: String? = null,
    existingValueMap: Map<MetaIdComp, JsonElement>? = null,
    defaultValue: Map<MetaIdComp, JsonElement> = emptyMap()
) {
    var rowId: RowId = rowId
        ?: SysId.nextId(RowId::class.java)

    /**
     * Mutable value map seeded with [defaultValue] first, then overlaid with
     * existing [existingValueMap] entries so persisted data always wins over defaults.
     */
    val valueMap: MutableMap<MetaIdComp, JsonElement> =
        mutableMapOf<MetaIdComp, JsonElement>().apply {
            putAll(defaultValue)
            existingValueMap?.let { putAll(it) }
        }

    // ── valueMap CRUD helpers ──────────────────────────────────────────

    /** Insert or update a single entry. */
    fun putValue(compId: MetaIdComp, value: JsonElement) {
        valueMap[compId] = value
    }

    /** Remove an entry and return its previous value, or null if absent. */
    fun removeValue(compId: MetaIdComp): JsonElement? {
        return valueMap.remove(compId)
    }

    /** Get the value for [compId], or null if absent. */
    fun getValue(compId: MetaIdComp): JsonElement? {
        return valueMap[compId]
    }

    /** Check whether [compId] exists in the map. */
    fun hasValue(compId: MetaIdComp): Boolean {
        return valueMap.containsKey(compId)
    }

    // ── Snapshot ───────────────────────────────────────────────────────

    /** Produce an immutable [FormValueData] from the current mutable state. */
    fun toFormValueData(): FormValueData {
        return FormValueData(
            rowId = rowId,
            createdBy = createdBy,
            updatedBy = updatedBy,
            createdOn = createdOn,
            updatedOn = updatedOn,
            rowOrder = rowOrder,
            valueMap = valueMap.toMap()
        )
    }

    fun toFieldDtoGridRowData(): FieldDtoGridRowData {
        return FieldDtoGridRowData(
            rowId = rowId,
            createdBy = createdBy,
            updatedBy = updatedBy,
            createdOn = createdOn,
            updatedOn = updatedOn,
            rowOrder = rowOrder,
            valueMap = valueMap.toMap() as MutableMap<Types.MetaIdField, JsonElement>
        )
    }
}
