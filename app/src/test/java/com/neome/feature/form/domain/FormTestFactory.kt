package com.neome.feature.form.domain

import com.neome.api.meta.base.AnyValue
import com.neome.api.meta.base.SysId
import com.neome.api.meta.base.Symbol
import com.neome.api.meta.base.Types
import com.neome.core.common.serializer.api.meta.base.dto.*
import com.neome.feature.form.domain.ctx.helper.FormCtxInitHelper
import com.neome.feature.form.presentation.state.*
import com.neome.feature.utils.JsonParser
import kotlinx.serialization.json.JsonElement

/**
 * Test factory for creating form test data.
 * Provides helper functions to create field definitions, values, and form state.
 */
object FormTestFactory {

    // ===================== IDs =====================
    fun fieldId(id: String): Types.MetaIdField = SysId.create<Types.MetaIdField>("mfd-$id")!!
    fun formId(id: String): Types.MetaIdForm = SysId.create<Types.MetaIdForm>("mf-$id")!!
    fun compositeId(id: String): Types.MetaIdComposite = SysId.create<Types.MetaIdComposite>("msc-$id")!!
    fun sectionId(id: String): Types.MetaIdSection = SysId.create<Types.MetaIdSection>("ms-$id")!!
    fun rowId(id: String): Types.RowId = SysId.create<Types.RowId>("r-$id")!!
    fun symbol(name: String): Symbol = AnyValue.create(name, Symbol::class.java)!!

    // ===================== Field Values =====================
    fun textValue(text: String): JsonElement =
        JsonParser.json.encodeToJsonElement(FieldValueTextData.serializer(), FieldValueTextData(text))

    fun numberValue(num: Long): JsonElement =
        JsonParser.json.encodeToJsonElement(FieldValueNumberData.serializer(), FieldValueNumberData(num))

    fun decimalValue(num: Double): JsonElement =
        JsonParser.json.encodeToJsonElement(FieldValueDecimalData.serializer(), FieldValueDecimalData(num))

    // ===================== Field Definitions =====================
    fun defnText(
        id: String,
        name: String = "Field_$id",
        required: Boolean? = null,
        disabled: Boolean? = null,
        hidden: Boolean? = null,
        invisible: Boolean? = null,
        readOnly: Boolean? = null,
        label: String? = null,
        labelFieldId: String? = null,
        helperText: String? = null,
        helperTextFieldId: String? = null,
        placeHolder: String? = null,
        placeHolderFieldId: String? = null,
        disabledFieldId: String? = null,
        requiredFieldId: String? = null
    ): DefnFieldTextData = DefnFieldTextData(
        metaId = fieldId(id),
        name = symbol(name),
        type = Types.EnumDefnCompType.text,
        required = required,
        disabled = disabled,
        hidden = hidden,
        invisible = invisible,
        readOnly = readOnly,
        label = label,
        labelFieldId = labelFieldId?.let { fieldId(it) },
        helperText = helperText,
        helperTextFieldId = helperTextFieldId?.let { fieldId(it) },
        placeHolder = placeHolder,
        placeHolderFieldId = placeHolderFieldId?.let { fieldId(it) },
        disabledFieldId = disabledFieldId?.let { fieldId(it) },
        requiredFieldId = requiredFieldId?.let { fieldId(it) }
    )

    fun defnNumber(
        id: String,
        name: String = "Number_$id",
        required: Boolean? = null,
        disabled: Boolean? = null,
        hidden: Boolean? = null,
        label: String? = null,
        labelFieldId: String? = null,
        min: Long? = null,
        max: Long? = null,
        defaultValue: Long? = null,
        disabledFieldId: String? = null
    ): DefnFieldNumberData = DefnFieldNumberData(
        metaId = fieldId(id),
        name = symbol(name),
        type = Types.EnumDefnCompType.number,
        required = required,
        disabled = disabled,
        hidden = hidden,
        label = label,
        labelFieldId = labelFieldId?.let { fieldId(it) },
        min = min,
        max = max,
        defaultValue = defaultValue,
        disabledFieldId = disabledFieldId?.let { fieldId(it) }
    )

    fun defnDecimal(
        id: String,
        name: String = "Decimal_$id",
        required: Boolean? = null,
        disabled: Boolean? = null,
        hidden: Boolean? = null,
        label: String? = null,
        labelFieldId: String? = null,
        min: Double? = null,
        max: Double? = null,
        defaultValue: Double? = null,
        minFieldId: String? = null,
        maxFieldId: String? = null,
        disabledFieldId: String? = null
    ): DefnFieldDecimalData = DefnFieldDecimalData(
        metaId = fieldId(id),
        name = symbol(name),
        type = Types.EnumDefnCompType.decimal,
        required = required,
        disabled = disabled,
        hidden = hidden,
        label = label,
        labelFieldId = labelFieldId?.let { fieldId(it) },
        min = min,
        max = max,
        defaultValue = defaultValue,
        minFieldId = minFieldId?.let { fieldId(it) },
        maxFieldId = maxFieldId?.let { fieldId(it) },
        disabledFieldId = disabledFieldId?.let { fieldId(it) }
    )

    fun defnSwitch(
        id: String,
        name: String = "Switch_$id",
        disabledFieldId: String? = null
    ): DefnFieldSwitchData = DefnFieldSwitchData(
        metaId = fieldId(id),
        name = symbol(name),
        type = Types.EnumDefnCompType.bool,
        disabledFieldId = disabledFieldId?.let { fieldId(it) }
    )

    fun defnSection(id: String, name: String = "Section_$id"): DefnSectionData =
        DefnSectionData(
            metaId = sectionId(id),
            name = symbol(name),
            type = Types.EnumDefnCompType.section
        )

    // ===================== Form Definition =====================
    fun defnForm(id: String = "testForm01", compMap: Map<Types.MetaIdComp, DefnCompSeal>): DefnFormData =
        DefnFormData(
            metaId = formId(id),
            name = symbol("TestForm"),
            compMap = compMap,
            displayCompositeId = compositeId("testComposite01")
        )

    // ===================== Initialized FormState =====================
    fun initializedState(
        compMap: Map<Types.MetaIdComp, DefnCompSeal>,
        initialValues: Map<Types.MetaIdComp, JsonElement> = emptyMap()
    ): FormState {
        val form = defnForm(compMap = compMap)
        val formValue = if (initialValues.isNotEmpty()) {
            FormValueRawData(rowId = rowId("testRow00000000000000000001"), valueMap = initialValues)
        } else null
        return FormCtxInitHelper.initializeFormState(form, formValue)
    }

    // ===================== Assertion Helpers =====================
    fun FormState.fieldState(id: String): FieldState =
        fieldStates[fieldId(id)] ?: error("FieldState not found for mfd-$id")

    fun FormState.fieldError(id: String): FieldError? = errors[fieldId(id)]
    fun FormState.hasFieldError(id: String): Boolean = errors.containsKey(fieldId(id))
}
