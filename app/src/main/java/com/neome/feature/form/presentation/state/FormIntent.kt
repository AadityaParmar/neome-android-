package com.neome.feature.form.presentation.state

import com.neome.api.meta.base.dto.FormValueRaw

/**
 * Simplified Form Intents
 * Only two intents as per MVI simplification
 */
sealed interface FormIntent {
    /**
     * Submit form with current values
     * @param formValue Complete current form data
     */
    data class Submit(val formValue: FormValueRaw) : FormIntent

    /**
     * Watch field changes
     * @param fieldId ID of the field that changed
     * @param fieldValue New value of the field
     * @param formValue Complete current form data
     */
    data class Watch(
        val fieldId: String,
        val fieldValue: Any?,
        val formValue: FormValueRaw
    ) : FormIntent
}
