package com.neome.feature.form.domain.ref

import com.neome.api.meta.base.Types.MetaIdComp
import com.neome.core.common.serializer.api.meta.base.dto.FormValueRawData
import com.neome.feature.form.presentation.state.FieldState
import com.neome.feature.form.presentation.state.FormEvent
import com.neome.feature.form.presentation.state.FormState
import com.neome.feature.form.presentation.state.SendBtnStateFlag
import kotlinx.serialization.json.JsonElement

/**
 * Implementation of FormRef that provides external API for form operations.
 * All operations are synchronous — state is updated immediately after each call.
 *
 * @param getFormState Function to get the current FormState snapshot
 * @param dispatchEvent Function to dispatch FormEvent for processing
 */
class FormRefImpl(
    private val getFormState: () -> FormState,
    private val dispatchEvent: (FormEvent) -> Unit
) : FormRef {

    private val currentState: FormState get() = getFormState()

    // ==================== Read Operations ====================

    override fun getValue(fieldId: MetaIdComp): JsonElement? = currentState.getValue(fieldId)

    override fun getValues(): FormValueRawData? {
        val state = currentState
        val initialValue = state.initialFormValue ?: return null
        return FormValueRawData(
            createdBy = initialValue.createdBy,
            createdOn = initialValue.createdOn,
            rowId = initialValue.rowId,
            rowOrder = initialValue.rowOrder,
            updatedBy = initialValue.updatedBy,
            updatedOn = initialValue.updatedOn,
            valueMap = state.valueMap
        )
    }

    override fun getValueMap(): Map<MetaIdComp, JsonElement> = currentState.valueMap

    override fun getFieldState(fieldId: MetaIdComp): FieldState? = currentState.getFieldState(fieldId)

    // ==================== Write Operations ====================

    override fun setValue(fieldId: MetaIdComp, value: JsonElement?) {
        dispatchEvent(FormEvent.FieldValueChanged(fieldId, value))
    }

    override fun setValues(valueMap: Map<MetaIdComp, JsonElement>) {
        dispatchEvent(FormEvent.SetValues(valueMap))
    }

    // ==================== Validation ====================

    override fun validate(fieldId: MetaIdComp?) {
        if (fieldId != null) dispatchEvent(FormEvent.ValidateField(fieldId))
        else dispatchEvent(FormEvent.ValidateAll)
    }

    override fun setError(fieldId: MetaIdComp, error: String) {
        dispatchEvent(FormEvent.SetFieldError(fieldId, error))
    }

    override fun clearErrors(fieldId: MetaIdComp?) {
        if (fieldId != null) dispatchEvent(FormEvent.ClearFieldError(fieldId))
        else dispatchEvent(FormEvent.ClearAllErrors)
    }

    // ==================== Form Operations ====================

    override fun submit() = dispatchEvent(FormEvent.Submit)

    override fun reset(valueMap: Map<MetaIdComp, JsonElement>?) =
        dispatchEvent(FormEvent.Reset(valueMap))

    // ==================== State Queries ====================

    override fun isDirty(fieldId: MetaIdComp?): Boolean {
        val state = currentState
        return if (fieldId != null) state.getFieldState(fieldId)?.isDirty ?: false
        else state.isDirty
    }

    override fun isValid(fieldId: MetaIdComp?): Boolean {
        val state = currentState
        return if (fieldId != null) {
            !state.hasError(fieldId) && state.getFieldState(fieldId)?.let { fs ->
                !fs.fieldProperties.required || state.valueMap[fieldId] != null
            } ?: true
        } else state.isValid
    }

    override fun isTouched(fieldId: MetaIdComp?): Boolean {
        val state = currentState
        return if (fieldId != null) state.getFieldState(fieldId)?.isTouched ?: false
        else state.fieldStates.values.any { it.isTouched }
    }

    // ==================== Send Button Control ====================

    override fun addSendBtnStateFlag(flag: SendBtnStateFlag) {
        dispatchEvent(FormEvent.AddSendBtnStateFlag(flag))
    }

    override fun removeSendBtnStateFlag(flag: SendBtnStateFlag) {
        dispatchEvent(FormEvent.RemoveSendBtnStateFlag(flag))
    }

    override fun isSendBtnEnabled(): Boolean = currentState.isSendBtnEnabled

    override fun isSendBtnInvisible(): Boolean = currentState.isSendBtnInvisible
}
