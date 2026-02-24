package com.neome.feature.form.presentation.components.composite.grid

import com.neome.api.meta.base.Types.MetaIdComp
import com.neome.api.meta.base.Types.RowId
import com.neome.core.common.serializer.api.meta.base.dto.DefnGridData
import com.neome.core.common.serializer.api.meta.base.dto.FieldDtoGridRowData
import com.neome.feature.form.domain.DefnFormUi
import com.neome.feature.form.domain.ctx.base.schema.CompSchemaFactory
import com.neome.feature.form.domain.util.FieldPropertyResolver
import com.neome.feature.form.presentation.state.FieldState
import com.neome.feature.form.presentation.state.GridCtx
import kotlinx.serialization.json.JsonElement

/**
 * Initializes [GridCtx] for the centralized grid row editing context.
 *
 * Builds field states, value map, dependencies, and validation schemas
 * scoped to the grid's child fields only (from [DefnGridData.fieldIdSet]).
 *
 * Two initialization paths:
 * - **Add**: [existingRowData] is null → empty valueMap, default field states
 * - **Edit**: [existingRowData] is populated → valueMap and defaultValues from row data
 */
object GridRowInitHelper {

    /**
     * Build a [GridCtx] for the centralized grid row editing context.
     *
     * @param defnGrid The grid component definition containing [fieldIdSet]
     * @param defnForm The parent form definition (contains child field defs in [compMap])
     * @param gridId The grid field's MetaIdComp
     * @param rowId The row being edited (generated for new, existing for edit)
     * @param isNewRow true if adding new row, false if editing existing
     * @param existingRowData Existing row data for edit mode; null for add mode
     * @return Initialized [GridCtx] ready for FormState.gridCtx
     */
    fun initializeGridCtx(
        defnGrid: DefnGridData,
        defnForm: DefnFormUi,
        gridId: MetaIdComp,
        rowId: RowId,
        isNewRow: Boolean,
        existingRowData: FieldDtoGridRowData?
    ): GridCtx {
        val fieldIdSet = defnGrid.fieldIdSet ?: emptyList()
        val fieldIdSetAsSet = fieldIdSet.map { it as MetaIdComp }.toSet()

        val childCompMap = defnForm.compMap.filterKeys { it in fieldIdSetAsSet }

        val initialValueMap: Map<MetaIdComp, JsonElement> =
            existingRowData?.valueMap
                ?.mapKeys { (key, _) -> key as MetaIdComp }
                ?: emptyMap()

        val fieldStates = childCompMap.mapValues { (fieldId, defnComp) ->
            val defaultValue = initialValueMap[fieldId]
            val fieldProperties = FieldPropertyResolver.resolveFieldProperties(
                defnComp = defnComp,
                defnForm = defnForm,
                getFieldValue = { id -> initialValueMap[id] }
            )
            FieldState(
                defaultValue = defaultValue,
                fieldProperties = fieldProperties
            )
        }

        val fieldDependencies = FieldPropertyResolver.buildDependencyMap(childCompMap)
        val allSchemas = CompSchemaFactory.buildFormSchemas(defnForm)
        val compSchemaMap = allSchemas.filterKeys { it in fieldIdSetAsSet }

        return GridCtx(
            gridId = gridId,
            rowId = rowId,
            isNewRow = isNewRow,
            fieldIdSet = fieldIdSetAsSet,
            fieldStates = fieldStates,
            valueMap = initialValueMap,
            errors = emptyMap(),
            fieldDependencies = fieldDependencies,
            compSchemaMap = compSchemaMap,
            formEventPropsMap = emptyMap()
        )
    }
}
