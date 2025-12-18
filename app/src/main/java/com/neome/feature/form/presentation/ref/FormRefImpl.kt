package com.neome.feature.form.presentation.ref

import com.neome.feature.form.presentation.form.FormViewModel
import com.neome.feature.form.presentation.state.FormEvent
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map

/**
 * Implementation of FormRef interface
 * Provides imperative API to access form state
 */
class FormRefImpl(
    private val viewModel: FormViewModel
) : FormRef {

    private val fieldWatchers = mutableMapOf<String, MutableStateFlow<Any?>>()

    @Suppress("UNCHECKED_CAST")
    override fun <T> getValue(fieldId: String): T? {
        return viewModel.formState.value.fields[fieldId]?.value as? T
    }

    override fun getValues(): Map<String, Any?> {
        return viewModel.formState.value.fields.mapValues { it.value.value }
    }

    override fun <T> setValue(fieldId: String, value: T, shouldValidate: Boolean) {
        viewModel.onEvent(FormEvent.UpdateField(fieldId, value))
        if (shouldValidate) {
            viewModel.onEvent(FormEvent.ValidateField(fieldId))
        }
    }

    override fun setValues(values: Map<String, Any?>, shouldValidate: Boolean) {
        values.forEach { (fieldId, value) ->
            setValue(fieldId, value, shouldValidate = false)
        }
        if (shouldValidate) {
            viewModel.onEvent(FormEvent.ValidateAll)
        }
    }

    override fun trigger(fieldId: String?): Boolean {
        return if (fieldId != null) {
            viewModel.onEvent(FormEvent.ValidateField(fieldId))
            viewModel.formState.value.errors[fieldId] == null
        } else {
            viewModel.onEvent(FormEvent.ValidateAll)
            viewModel.formState.value.isValid
        }
    }

    override fun reset(values: Map<String, Any?>?) {
        viewModel.onEvent(FormEvent.Reset)
        if (values != null) {
            setValues(values, shouldValidate = false)
        }
    }

    override fun clearErrors(fieldId: String?) {
        viewModel.onEvent(FormEvent.ClearErrors(fieldId))
    }

    override fun setError(fieldId: String, error: String) {
        viewModel.onEvent(FormEvent.SetError(fieldId, error))
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T> watch(fieldId: String): StateFlow<T?> {
        if (!fieldWatchers.containsKey(fieldId)) {
            val initialValue = getValue<T>(fieldId)
            fieldWatchers[fieldId] = MutableStateFlow(initialValue)
        }

        // Update watcher when form state changes
        viewModel.formState.map { state ->
            state.fields[fieldId]?.value as? T
        }

        return fieldWatchers[fieldId]!!.asStateFlow() as StateFlow<T?>
    }

    override fun isDirty(fieldId: String?): Boolean {
        return if (fieldId != null) {
            viewModel.formState.value.fields[fieldId]?.isDirty ?: false
        } else {
            viewModel.formState.value.isDirty
        }
    }

    override fun isValid(fieldId: String?): Boolean {
        return if (fieldId != null) {
            viewModel.formState.value.errors[fieldId] == null
        } else {
            viewModel.formState.value.isValid
        }
    }

    /**
     * Internal method to update field watchers
     * Called by ViewModel when state changes
     */
    internal fun updateWatchers() {
        fieldWatchers.forEach { (fieldId, watcher) ->
            val newValue = getValue<Any>(fieldId)
            if (watcher.value != newValue) {
                watcher.value = newValue
            }
        }
    }
}
