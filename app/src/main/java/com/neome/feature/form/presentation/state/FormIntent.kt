package com.neome.feature.form.presentation.state

import androidx.compose.runtime.Immutable
import com.neome.api.meta.base.dto.FormValueRaw
import com.neome.core.mvi.UiEvent

/**
 * Form intents (user actions).
 * Only two intents for external communication with parent.
 */
sealed interface FormIntent : UiEvent {

    /**
     * Form submission with complete form data.
     * Emitted when user triggers form submission.
     */
    @Immutable
    data class Submit(val formValue: FormValueRaw) : FormIntent

    /**
     * Field change notification.
     * Emitted when a field value changes (optional - parent can opt-in).
     *
     * @param fieldId The field identifier
     * @param fieldValue The new field value
     * @param formValue Complete form data snapshot
     */
    @Immutable
    data class Watch(
        val fieldId: String,
        val fieldValue: Any?,
        val formValue: FormValueRaw
    ) : FormIntent
}
