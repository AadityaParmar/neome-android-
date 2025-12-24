package com.neome.feature.form.presentation.state

import androidx.compose.runtime.Immutable
import com.neome.api.meta.base.dto.DefnForm
import com.neome.api.meta.base.dto.FormValueRaw
import com.neome.core.mvi.UiState

/**
 * Form configuration state.
 * Contains ONLY configuration data (defnForm, initialFormValue).
 * All runtime state (field values, errors, validation) managed by FormRef.
 */
@Immutable
data class FormState(
    val defnForm: DefnForm? = null,
    val initialFormValue: FormValueRaw? = null
) : UiState
