package com.neome.feature.form.domain.ctx.base

import com.neome.api.meta.base.Types.MetaIdComp
import com.neome.api.meta.base.Types.RowId
import com.neome.feature.form.domain.ctx.FormStateAccessor
import com.neome.feature.form.domain.ctx.base.schema.CompSchema
import com.neome.feature.form.presentation.state.*
import kotlinx.serialization.json.JsonElement

/**
 * FormStateAccessor that routes read/write operations to either the
 * grid row state (for fields in [gridFieldIdSet]) or the parent form state.
 *
 * Created by the reducer when [FormState.gridCtx] is non-null.
 * Wraps the parent [ReducerFormStateAccessor] and maintains its own
 * hot-path mutable collections for grid row fields.
 *
 * Call [syncBack] before reading final state to merge
 * grid row state back into FormState.gridCtx.
 */
class ReducerFormGridStateAccessor(
    private val parentAccessor: ReducerFormStateAccessor,
    gridCtx: GridCtx
) : FormStateAccessor {

    private val gridId = gridCtx.gridId
    private val rowId = gridCtx.rowId
    private val isNewRow = gridCtx.isNewRow
    val gridFieldIdSet: Set<MetaIdComp> = gridCtx.fieldIdSet

    // ── Grid row hot-path mutable collections ──
    private val _gridValueMap = gridCtx.valueMap.toMutableMap()
    private val _gridFieldStates = gridCtx.fieldStates.toMutableMap()
    private val _gridErrors = gridCtx.errors.toMutableMap()

    // Immutable grid-scoped data
    private val gridFieldDependencies = gridCtx.fieldDependencies
    private val gridCompSchemaMap = gridCtx.compSchemaMap
    private var gridFormEventPropsMap = gridCtx.formEventPropsMap

    fun getParentReducerFormStateAccessor(): ReducerFormStateAccessor = parentAccessor

    private fun isGridField(fieldId: MetaIdComp): Boolean = fieldId in gridFieldIdSet

    // ==================== Read ====================

    override fun getState(): FormState {
        syncBack()
        return parentAccessor.getState()
    }

    override fun getValue(fieldId: MetaIdComp): JsonElement? =
        if (isGridField(fieldId)) _gridValueMap[fieldId]
        else parentAccessor.getValue(fieldId)

    override fun getFieldState(fieldId: MetaIdComp): FieldState? =
        if (isGridField(fieldId)) _gridFieldStates[fieldId]
        else parentAccessor.getFieldState(fieldId)

    override fun getValueMap(): Map<MetaIdComp, JsonElement> =
        parentAccessor.getValueMap() + _gridValueMap.toMap()

    override fun getFieldProperties(fieldId: MetaIdComp): FieldProperties? =
        if (isGridField(fieldId)) _gridFieldStates[fieldId]?.fieldProperties
        else parentAccessor.getFieldProperties(fieldId)

    // ==================== Write ====================

    override fun setValue(fieldId: MetaIdComp, value: JsonElement?) {
        if (isGridField(fieldId)) {
            if (value != null) _gridValueMap[fieldId] = value
            else _gridValueMap.remove(fieldId)
        } else {
            parentAccessor.setValue(fieldId, value)
        }
    }

    override fun removeValue(fieldId: MetaIdComp) {
        if (isGridField(fieldId)) _gridValueMap.remove(fieldId)
        else parentAccessor.removeValue(fieldId)
    }

    override fun setFieldState(fieldId: MetaIdComp, fieldState: FieldState) {
        if (isGridField(fieldId)) _gridFieldStates[fieldId] = fieldState
        else parentAccessor.setFieldState(fieldId, fieldState)
    }

    override fun updateFieldStates(fieldStates: Map<MetaIdComp, FieldState>) {
        val (gridStates, parentStates) = fieldStates.entries.partition { isGridField(it.key) }
        _gridFieldStates.putAll(gridStates.associate { it.key to it.value })
        if (parentStates.isNotEmpty()) {
            parentAccessor.updateFieldStates(parentStates.associate { it.key to it.value })
        }
    }

    override fun setError(fieldId: MetaIdComp, error: FieldError?) {
        if (isGridField(fieldId)) {
            if (error != null) _gridErrors[fieldId] = error
            else _gridErrors.remove(fieldId)
        } else {
            parentAccessor.setError(fieldId, error)
        }
    }

    override fun clearError(fieldId: MetaIdComp) {
        if (isGridField(fieldId)) _gridErrors.remove(fieldId)
        else parentAccessor.clearError(fieldId)
    }

    override fun updateErrors(errors: Map<MetaIdComp, FieldError>) {
        val (gridErrors, parentErrors) = errors.entries.partition { isGridField(it.key) }
        _gridErrors.putAll(gridErrors.associate { it.key to it.value })
        if (parentErrors.isNotEmpty()) {
            parentAccessor.updateErrors(parentErrors.associate { it.key to it.value })
        }
    }

    override fun clearAllErrors() {
        _gridErrors.clear()
        parentAccessor.clearAllErrors()
    }

    override fun setFormEventPropsMap(map: Map<MetaIdComp, FormEventProps>) {
        val (gridProps, parentProps) = map.entries.partition { isGridField(it.key) }
        gridFormEventPropsMap = gridProps.associate { it.key to it.value }
        parentAccessor.setFormEventPropsMap(parentProps.associate { it.key to it.value })
    }

    override fun setSendBtnStateFlags(flags: Set<SendBtnStateFlag>) {
        parentAccessor.setSendBtnStateFlags(flags)
    }

    override fun setIsSubmitting(value: Boolean) {
        parentAccessor.setIsSubmitting(value)
    }

    override fun updateState(transform: (FormState) -> FormState) {
        syncBack()
        parentAccessor.updateState(transform)
        val newGridCtx = parentAccessor.getState().gridCtx
        if (newGridCtx != null) {
            resyncFromGridCtx(newGridCtx)
        }
    }

    // ==================== Intent ====================

    override fun emitIntent(intent: FormIntent) {
        parentAccessor.emitIntent(intent)
    }

    // ==================== Grid-Specific ====================

    fun getGridValueMap(): Map<MetaIdComp, JsonElement> = _gridValueMap.toMap()
    fun getGridErrors(): Map<MetaIdComp, FieldError> = _gridErrors.toMap()
    fun getGridFieldStates(): Map<MetaIdComp, FieldState> = _gridFieldStates.toMap()
    fun getGridCompSchemaMap(): Map<MetaIdComp, CompSchema> = gridCompSchemaMap
    fun getGridFieldDependencies(): FieldDependencyMap = gridFieldDependencies
    fun getGridId(): MetaIdComp = gridId
    fun getRowId(): RowId = rowId
    fun isNewRow(): Boolean = isNewRow

    /**
     * Merge grid row hot-path collections back into FormState.gridCtx.
     * MUST be called before reading final state.
     */
    fun syncBack() {
        val currentGridCtx = parentAccessor.getState().gridCtx ?: return
        val updatedGridCtx = currentGridCtx.copy(
            fieldStates = _gridFieldStates.toMap(),
            valueMap = _gridValueMap.toMap(),
            errors = _gridErrors.toMap(),
            formEventPropsMap = gridFormEventPropsMap
        )
        parentAccessor.updateState { it.copy(gridCtx = updatedGridCtx) }
    }

    fun result(): FormReducerResult {
        syncBack()
        return parentAccessor.result()
    }

    // ==================== Internal ====================

    private fun resyncFromGridCtx(gridCtx: GridCtx) {
        _gridValueMap.clear()
        _gridValueMap.putAll(gridCtx.valueMap)
        _gridFieldStates.clear()
        _gridFieldStates.putAll(gridCtx.fieldStates)
        _gridErrors.clear()
        _gridErrors.putAll(gridCtx.errors)
        gridFormEventPropsMap = gridCtx.formEventPropsMap
    }
}
