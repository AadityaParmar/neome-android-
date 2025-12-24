package com.neome.feature.componentshowcase.presentation.testing

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.neome.api.meta.base.Symbol
import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.DefnComp
import com.neome.api.meta.base.dto.DefnForm
import com.neome.api.meta.base.dto.FormValueRaw
import com.neome.feature.form.presentation.ref.FormRef
import com.neome.feature.form.presentation.ref.FormRefImpl
import com.neome.feature.form.presentation.state.FormIntent
import com.neome.feature.form.presentation.state.FormState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class ComponentTestingViewModel @Inject constructor() : ViewModel() {

    private val _formState = MutableStateFlow(FormState())
    val formState = _formState.asStateFlow()

    val formRef: FormRef by lazy { FormRefImpl(viewModelScope) }

    init {
        // Initialize with a sample form for testing
        initializeTestForm()
    }

    /**
     * Initialize form with sample DefnForm for testing.
     */
    private fun initializeTestForm() {
        // Create sample components
        val nameField = DefnComp().apply {
            name = Symbol().apply { value = "name" }
            label = "Full Name"
            type = Types.EnumDefnCompType.text
            disabled = false
            readOnly = false
            hidden = false
        }

        val emailField = DefnComp().apply {
            name = Symbol().apply { value = "email" }
            label = "Email Address"
            type = Types.EnumDefnCompType.text
            disabled = false
            readOnly = false
            hidden = false
        }

        val phoneField = DefnComp().apply {
            name = Symbol().apply { value = "phone" }
            label = "Phone Number"
            type = Types.EnumDefnCompType.text
            disabled = false
            readOnly = false
            hidden = false
        }

        // Create DefnForm
        val defnForm = DefnForm().apply {
            metaId = Types.MetaIdForm()
            name = Symbol().apply { value = "testForm" }
            label = "Test Form - Pure MVI"
            displayCompositeId = Types.MetaIdComposite()

            // Create component map with Symbol keys (since MetaIdComp needs proper initialization)
            compMap = java.util.HashMap<Types.MetaIdComp, DefnComp>().apply {
                // For now, use simple placeholders - proper ID generation would use SysId.nextId()
                val nameId = Types.MetaIdComp()
                val emailId = Types.MetaIdComp()
                val phoneId = Types.MetaIdComp()

                put(nameId, nameField)
                put(emailId, emailField)
                put(phoneId, phoneField)
            } as java.util.Map<Types.MetaIdComp, DefnComp>
        }

        // Create initial form values (skip for now - FormValueRaw has constructor issues)
        val initialFormValue: FormValueRaw? = null

        // Update state
        _formState.update {
            it.copy(
                defnForm = defnForm,
                initialFormValue = initialFormValue
            )
        }

        // Initialize FormRef
        (formRef as? FormRefImpl)?.initialize(defnForm, initialFormValue)
    }

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
