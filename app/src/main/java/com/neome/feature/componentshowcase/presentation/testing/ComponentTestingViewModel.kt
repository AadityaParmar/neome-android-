package com.neome.feature.componentshowcase.presentation.testing

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.neome.api.meta.base.dto.FormValueRaw
import com.neome.feature.form.presentation.ref.FormRef
import com.neome.feature.form.presentation.ref.FormRefImpl
import com.neome.feature.form.presentation.state.FormIntent
import com.neome.feature.form.presentation.state.FormState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class ComponentTestingViewModel @Inject constructor() : ViewModel() {

    private val _formState = MutableStateFlow(FormState())
    val formState = _formState.asStateFlow()

    val formRef: FormRef by lazy { FormRefImpl(viewModelScope) }

    init {
        // Initialize with a sample form for testing

    }

    /**
     * Initialize form with sample DefnForm for testing.
     */


    /**
     * Handle form intents from Form component.
     */
    fun onFormIntent(intent: FormIntent) {
        when (intent) {
            is FormIntent.Submit -> {
                // Handle form submission
                handleFormSubmit(intent.formValue)
            }

            is FormIntent.Watch -> {
                // Handle field value changes (optional - for real-time validation, etc.)
                handleFieldWatch(intent.fieldId, intent.fieldValue)
            }
        }
    }

    private fun handleFormSubmit(formValue: FormValueRaw) {
        // Validate form
        if (!formRef.isValid()) {
            // Show validation errors
            return
        }

        // Process form submission
        // TODO: Implement actual submission logic
        println("Form submitted with values: $formValue")
    }

    private fun handleFieldWatch(fieldId: String, fieldValue: Any?) {
        // Optional: React to field changes
        // e.g., dependent field updates, analytics, etc.
        println("Field $fieldId changed to: $fieldValue")
    }
}
