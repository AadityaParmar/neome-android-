package com.neome.feature.form.domain.ctx.base

import com.neome.api.meta.base.SysId
import com.neome.api.meta.base.Types
import com.neome.core.common.serializer.api.meta.base.dto.DefnGridData
import com.neome.core.common.serializer.api.meta.base.dto.FieldDtoGridRowData
import com.neome.core.common.serializer.api.meta.base.dto.FieldValueGridData
import com.neome.feature.form.domain.model.DefnFormUi
import com.neome.feature.form.domain.ctx.FormStateAccessor
import com.neome.feature.form.presentation.components.composite.grid.GridRowInitHelper
import com.neome.feature.form.presentation.state.FieldError
import com.neome.feature.form.presentation.state.FormEvent
import com.neome.feature.utils.JsonParser
import kotlinx.serialization.json.Json

/**
 * Handles grid lifecycle events: open, close, submit, remove.
 *
 * **GridOpen**: Initializes FormState.gridCtx with row state (new or existing).
 * **GridClose**: Clears gridCtx (discard edits, close sheet).
 * **GridSubmit**: Validates grid row fields → merges into parent FieldValueGridData → clears gridCtx.
 * **GridRemove**: Removes row from parent grid value (unchanged from before).
 */
object FormCtxGridHelper {

    /**
     * Initialize gridCtx for adding a new row or editing an existing row.
     */
    fun handleGridOpen(
        accessor: ReducerFormStateAccessor,
        event: FormEvent.GridOpen,
        defnForm: DefnFormUi
    ) {
        val defnGrid = defnForm.compMap[event.gridId] as? DefnGridData ?: return

        val rowId = event.rowId ?: SysId.nextId(Types.RowId::class.java)
        val isNewRow = event.rowId == null

        // For edit mode, get existing row data from parent grid value
        val existingRowData: FieldDtoGridRowData? = if (!isNewRow) {
            val gridJsonValue = accessor.getValue(event.gridId) ?: return
            val gridData = try {
                JsonParser.json.decodeFromJsonElement(FieldValueGridData.serializer(), gridJsonValue)
            } catch (_: Exception) {
                return
            }
            gridData.map[rowId]
        } else null

        val gridCtx = GridRowInitHelper.initializeGridCtx(
            defnGrid = defnGrid,
            defnForm = defnForm,
            gridId = event.gridId,
            rowId = rowId,
            isNewRow = isNewRow,
            existingRowData = existingRowData
        )

        accessor.updateState { it.copy(gridCtx = gridCtx) }
    }

    /**
     * Close grid editor without saving. Clears gridCtx.
     */
    fun handleGridClose(
        accessor: ReducerFormStateAccessor,
        event: FormEvent.GridClose
    ) {
        accessor.updateState { it.copy(gridCtx = null) }
    }

    /**
     * Submit grid row: validate all fields, merge into parent grid value,
     * clear gridCtx.
     *
     * If validation fails, gridCtx stays open with errors populated.
     */
    fun handleGridSubmit(
        accessor: ReducerFormGridStateAccessor,
        event: FormEvent.GridSubmit,
        defnForm: DefnFormUi
    ) {
        // 1. Validate all grid row fields
        val gridSchemaMap = accessor.getGridCompSchemaMap()
        var hasErrors = false
        gridSchemaMap.forEach { (fieldId, schema) ->
            val value = accessor.getValue(fieldId)
            val fieldState = accessor.getFieldState(fieldId)
            val error = schema.validate(value, fieldState)
            if (error != null) {
                accessor.setError(
                    fieldId, FieldError(
                        message = error,
                        type = FieldError.ErrorType.Validation
                    )
                )
                hasErrors = true
            } else {
                accessor.clearError(fieldId)
            }
        }

        if (hasErrors) {
            // Keep gridCtx open — errors shown inline
            return
        }

        // 2. Collect row values
        val rowValueMap = accessor.getGridValueMap()
            .mapKeys { (key, _) -> key as Types.MetaIdField }

        val rowId = accessor.getRowId()
        val rowData = FieldDtoGridRowData(
            rowId = rowId,
            valueMap = rowValueMap.ifEmpty { null }
        )

        // 3. Build updated FieldValueGridData
        val parentAccessor = accessor.getParentReducerFormStateAccessor()
        val gridId = accessor.getGridId()
        val gridJsonValue = parentAccessor.getValue(gridId)
        val currentGridData = gridJsonValue?.let {
            try {
                JsonParser.json.decodeFromJsonElement(FieldValueGridData.serializer(), it)
            } catch (_: Exception) {
                null
            }
        }

        val currentKeys = currentGridData?.keys ?: emptyList()
        val currentMap = currentGridData?.map ?: emptyMap()

        val isEditing = !accessor.isNewRow()
        val updatedKeys = if (isEditing) currentKeys else currentKeys + rowId
        val updatedMap = currentMap + (rowId to rowData)

        val updatedGridData = FieldValueGridData(
            keys = updatedKeys,
            map = updatedMap
        )

        val updatedJsonValue = Json.encodeToJsonElement(
            FieldValueGridData.serializer(),
            updatedGridData
        )

        // 4. Write updated grid value to parent
        parentAccessor.setValue(gridId, updatedJsonValue)

        // 5. Clear gridCtx (close sheet)
        parentAccessor.updateState { it.copy(gridCtx = null) }
    }

    /**
     * Remove a row from the grid. Unchanged from before.
     */
    fun handleGridRemove(
        accessor: FormStateAccessor,
        event: FormEvent.GridRemove,
        defnForm: DefnFormUi
    ) {
        val gridValue = accessor.getValue(event.gridId) ?: return

        val currentGridData = try {
            JsonParser.json.decodeFromJsonElement(FieldValueGridData.serializer(), gridValue)
        } catch (_: Exception) {
            return
        }

        val updatedKeys = currentGridData.keys.filter { it != event.rowId }
        val updatedMap = currentGridData.map.filterKeys { it != event.rowId }
        val updatedGridData = currentGridData.copy(keys = updatedKeys, map = updatedMap)

        val updatedJsonValue = Json.encodeToJsonElement(FieldValueGridData.serializer(), updatedGridData)
        accessor.setValue(event.gridId, updatedJsonValue)
    }
}
