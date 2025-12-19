package com.neome.feature.form.presentation.ref

import androidx.lifecycle.viewModelScope
import com.neome.feature.form.presentation.form.FormViewModel
import com.neome.feature.form.presentation.state.FormEvent
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

/**
 * Implementation of FormRef interface
 * Provides imperative API to access and manage form state through ViewModel
 */
class FormRefImpl(
    private val viewModel: FormViewModel
) : FormRef {

    // Cache for field watchers to avoid creating multiple StateFlows for the same field
    private val fieldWatchers = mutableMapOf<String, StateFlow<Any?>>()

    @Suppress("UNCHECKED_CAST")
    override fun <T> getValue(fieldId: String): T? {
        return viewModel.formState.value.fields[fieldId]?.value as? T
    }

    override fun getValues(): com.neome.api.meta.base.dto.FormValueRaw? {
        return viewModel.formState.value.formValueRaw
    }

    override fun <T> setValue(fieldId: String, value: T, shouldValidate: Boolean) {
        viewModel.onEvent(FormEvent.UpdateField(fieldId, value))
    }

    override fun setValues(
        formValueRaw: com.neome.api.meta.base.dto.FormValueRaw,
        shouldValidate: Boolean
    ) {
        viewModel.onEvent(FormEvent.SetValues(formValueRaw))
    }

    override fun trigger(fieldId: String?): Boolean {
        // No validation for now - always return true
        return true
    }

    override fun reset(formValueRaw: com.neome.api.meta.base.dto.FormValueRaw?) {
        viewModel.onEvent(FormEvent.Reset(formValueRaw))
    }

    override fun clearErrors(fieldId: String?) {
        viewModel.onEvent(FormEvent.ClearErrors(fieldId))
    }

    override fun setError(fieldId: String, error: String) {
        viewModel.onEvent(FormEvent.SetError(fieldId, error))
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T> watch(fieldId: String): StateFlow<T?> {
        // Return cached watcher if it exists
        if (fieldWatchers.containsKey(fieldId)) {
            return fieldWatchers[fieldId] as StateFlow<T?>
        }

        // Create new StateFlow from formState mapping
        val watcher = viewModel.formState
            .map { state -> state.fields[fieldId]?.value as? T }
            .stateIn(
                scope = viewModel.viewModelScope,
                started = SharingStarted.WhileSubscribed(5000),
                initialValue = getValue<T>(fieldId)
            )

        // Cache it
        fieldWatchers[fieldId] = watcher as StateFlow<Any?>

        return watcher
    }

    override fun isDirty(fieldId: String?): Boolean {
        return if (fieldId != null) {
            viewModel.formState.value.fields[fieldId]?.isDirty ?: false
        } else {
            viewModel.formState.value.isDirty
        }
    }

    override fun isValid(fieldId: String?): Boolean {
        // No validation for now - always return true
        return true
    }
}
