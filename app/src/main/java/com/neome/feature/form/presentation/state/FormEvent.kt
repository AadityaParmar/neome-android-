package com.neome.feature.form.presentation.state

import com.neome.api.meta.base.dto.FormValueRaw

/**
 * Sealed interface for all user actions on the form
 * Type-safe user interactions with single entry point
 */
sealed interface FormEvent {
    data class UpdateField<T>(val fieldId: String, val value: T) : FormEvent
    data class SetValues(val formValueRaw: FormValueRaw) : FormEvent
    data class BlurField(val fieldId: String) : FormEvent
    data object Submit : FormEvent
    data class Reset(val formValueRaw: FormValueRaw? = null) : FormEvent
    data class SetError(val fieldId: String, val error: String) : FormEvent
    data class ClearErrors(val fieldId: String? = null) : FormEvent
}
