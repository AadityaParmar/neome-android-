package com.neome.feature.form.presentation.state

import com.neome.api.meta.base.dto.DefnForm
import com.neome.api.meta.base.dto.FormValueRaw

/**
 * Form state container with all runtime state
 */

interface FormBase {
    val defnForm: DefnForm?
    val initialFormValue: FormValueRaw?
}

data class FormProps(
    // Configuration
    override val defnForm: DefnForm? = null,
    override val initialFormValue: FormValueRaw? = null,
) : FormBase

data class FormState(
    override val defnForm: DefnForm? = null,
    override val initialFormValue: FormValueRaw? = null,

    // Runtime state
    val formValueRaw: FormValueRaw? = null,
    val fields: Map<String, FieldState<*>> = emptyMap(),
    val errors: Map<String, String?> = emptyMap(),
    val isDirty: Boolean = false,
    val isValid: Boolean = false,
    val isSubmitting: Boolean = false,
    val touchedFields: Set<String> = emptySet(),
    val dependencies: Map<String, List<String>> = emptyMap(),
    val submitError: String? = null
) : FormBase
