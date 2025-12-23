# Form Component Architecture - MVI Pattern

## Overview

A production-ready, type-safe MVI (Model-View-Intent) form component for Android with Jetpack
Compose. This provides a reusable, dynamic form component driven by JSON (`DefnForm`) with
field-level operations via imperative API (`FormRef`).

## Architecture Diagram

```
┌─────────────────────────────────────────────────────────────────┐
│                     PARENT (SCREEN/COMPONENT)                    │
│  ┌─────────────┐    ┌─────────────┐    ┌─────────────────────┐  │
│  │  ViewModel  │───▶│  FormState  │───▶│     FormRef         │  │
│  │             │    │   (Config)  │    │  (Field Ops)        │  │
│  └─────────────┘    └─────────────┘    └─────────────────────┘  │
│         │                  │                      │              │
│         │ state            │ formRef              │              │
│         ▼                  ▼                      ▼              │
│  ┌──────────────────────────────────────────────────────────────┤
│  │                   FORM COMPONENT (Pure MVI)                  ││
│  │  ┌──────────┐   ┌──────────┐   ┌──────────┐   ┌──────────┐ ││
│  │  │FormState │──▶│ FormRef  │──▶│Renderer  │──▶│  Field   │ ││
│  │  │          │   │          │   │ Factory  │   │Components│ ││
│  │  └──────────┘   └──────────┘   └──────────┘   └──────────┘ ││
│  │        │                                            │        ││
│  │        │                                            ▼        ││
│  │        │                                      ┌──────────┐   ││
│  │        └─────────────────────────────────────▶│FormIntent│   ││
│  │              user actions                     │(onIntent)│   ││
│  │                                               └──────────┘   ││
│  └──────────────────────────────────────────────────────────────┘│
└─────────────────────────────────────────────────────────────────┘
                              │
                              ▼
┌─────────────────────────────────────────────────────────────────┐
│                    COMPONENT RENDERERS                           │
│  ┌─────────────┐    ┌─────────────┐    ┌─────────────────────┐  │
│  │  FieldText  │    │ FieldEmail  │    │   FieldNumber       │  │
│  │  FieldBool  │    │ FieldDate   │    │   FieldPickText     │  │
│  │  FieldTab   │    │FieldSection │    │   FieldGrid         │  │
│  └─────────────┘    └─────────────┘    └─────────────────────┘  │
└─────────────────────────────────────────────────────────────────┘
```

## File Structure

```
feature/form/
├── presentation/
│   ├── component/
│   │   └── Form.kt                    # Main form component (Pure MVI)
│   ├── state/
│   │   ├── FormState.kt               # State marker interface
│   │   └── FormIntent.kt              # Intent sealed interface
│   ├── ref/
│   │   ├── FormRef.kt                 # FormRef interface
│   │   └── FormRefImpl.kt             # FormRef implementation
│   └── components/
│       ├── field/
│       │   ├── FieldText.kt
│       │   ├── FieldEmail.kt
│       │   ├── FieldPhone.kt
│       │   ├── FieldNumber.kt
│       │   ├── FieldBool.kt
│       │   ├── FieldPickText.kt
│       │   ├── FieldDate.kt
│       │   ├── FieldCurrency.kt
│       │   └── FieldUrl.kt
│       ├── composite/
│       │   ├── FieldTab.kt
│       │   ├── FieldSection.kt
│       │   └── FieldGrid.kt
│       └── factory/
│           └── ComponentRendererFactory.kt
├── domain/
│   └── model/
│       └── ValidationRule.kt
└── util/
    ├── PlusDefnForm.kt
    ├── PlusFormValueRaw.kt
    ├── PlusValidation.kt
    └── PlusFormMapper.kt
```

---

## Core Contracts

### File: `presentation/state/FormState.kt`

```kotlin
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
```

### File: `presentation/state/FormIntent.kt`

```kotlin
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
```

---

## FormRef Interface

### File: `presentation/ref/FormRef.kt`

```kotlin
package com.neome.feature.form.presentation.ref

import com.neome.api.meta.base.dto.FormValueRaw
import kotlinx.coroutines.flow.StateFlow

/**
 * Imperative API for form field operations.
 * Inspired by React Hook Form's ref pattern.
 *
 * FormRef manages all runtime state internally (not in FormState):
 * - Field values
 * - Validation errors
 * - Dirty state
 * - Touched state
 */
interface FormRef {

    /**
     * Get single field value by ID.
     * @return Field value or null if field doesn't exist
     */
    fun <T> getValue(fieldId: String): T?

    /**
     * Get all form values as FormValueRaw.
     * @return Complete form data ready for API submission
     */
    fun getValues(): FormValueRaw?

    /**
     * Set single field value.
     * @param fieldId Field identifier
     * @param value New value
     * @param shouldValidate Whether to validate after setting (default: true)
     */
    fun <T> setValue(fieldId: String, value: T, shouldValidate: Boolean = true)

    /**
     * Set multiple field values from FormValueRaw.
     * Useful for prefilling form with existing data.
     * @param formValueRaw Form data to populate
     * @param shouldValidate Whether to validate after setting (default: true)
     */
    fun setValues(formValueRaw: FormValueRaw, shouldValidate: Boolean = true)

    /**
     * Trigger validation for specific field or entire form.
     * @param fieldId Field to validate, or null for entire form
     * @return true if validation passed
     */
    fun trigger(fieldId: String? = null): Boolean

    /**
     * Reset form to initial values or provided values.
     * @param formValueRaw Optional new initial values
     */
    fun reset(formValueRaw: FormValueRaw? = null)

    /**
     * Clear validation errors.
     * @param fieldId Field to clear errors for, or null for all fields
     */
    fun clearErrors(fieldId: String? = null)

    /**
     * Set custom validation error for a field.
     * @param fieldId Field identifier
     * @param error Error message
     */
    fun setError(fieldId: String, error: String)

    /**
     * Watch field value changes as StateFlow.
     * Use in Composables with collectAsStateWithLifecycle().
     *
     * @param fieldId Field identifier
     * @return StateFlow of field value
     */
    fun <T> watch(fieldId: String): StateFlow<T?>

    /**
     * Check if field or form is dirty (modified from initial value).
     * @param fieldId Field to check, or null for entire form
     * @return true if dirty
     */
    fun isDirty(fieldId: String? = null): Boolean

    /**
     * Check if field or form is valid.
     * @param fieldId Field to check, or null for entire form
     * @return true if valid
     */
    fun isValid(fieldId: String? = null): Boolean
}
```

---

## Component Renderer Pattern

### File: `presentation/components/factory/ComponentRendererFactory.kt`

```kotlin
package com.neome.feature.form.presentation.components.factory

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.neome.api.meta.base.EnumDefnCompType
import com.neome.api.meta.base.dto.DefnComp
import com.neome.api.meta.base.dto.DefnForm
import com.neome.feature.form.presentation.components.composite.*
import com.neome.feature.form.presentation.components.field.*
import com.neome.feature.form.presentation.ref.FormRef

/**
 * Factory pattern for rendering form components.
 * Maps DefnComp types to corresponding renderers.
 */
object ComponentRendererFactory {

    /**
     * Render a component based on its type.
     *
     * @param defnComp Component definition from DefnForm
     * @param defnForm Complete form definition (for context)
     * @param formRef FormRef for field operations
     * @param modifier Modifier for customization
     */
    @Composable
    fun render(
        defnComp: DefnComp,
        defnForm: DefnForm,
        formRef: FormRef,
        modifier: Modifier = Modifier
    ) {
        // Skip rendering if hidden or invisible
        if (defnComp.hidden == true || defnComp.invisible == true) return

        val renderer = getRenderer(defnComp.type)
        renderer.Render(defnComp, defnForm, formRef, modifier)
    }

    /**
     * Get renderer for component type.
     * Extendable by adding new entries.
     */
    private fun getRenderer(type: EnumDefnCompType): ComponentRenderer {
        return when (type) {
            // Composite components (containers)
            EnumDefnCompType.TAB -> FieldTab
            EnumDefnCompType.SECTION -> FieldSection
            EnumDefnCompType.GRID -> FieldGrid

            // Field components (inputs)
            EnumDefnCompType.TEXT -> FieldText
            EnumDefnCompType.EMAIL -> FieldEmail
            EnumDefnCompType.PHONE -> FieldPhone
            EnumDefnCompType.NUMBER -> FieldNumber
            EnumDefnCompType.BOOL -> FieldBool
            EnumDefnCompType.PICK_TEXT -> FieldPickText
            EnumDefnCompType.DATE -> FieldDate
            EnumDefnCompType.CURRENCY -> FieldCurrency
            EnumDefnCompType.URL -> FieldUrl

            else -> UnsupportedRenderer
        }
    }
}

/**
 * Base interface for all component renderers.
 */
interface ComponentRenderer {
    @Composable
    fun Render(
        defnComp: DefnComp,
        defnForm: DefnForm,
        formRef: FormRef,
        modifier: Modifier = Modifier
    )
}

/**
 * Fallback renderer for unsupported component types.
 */
private object UnsupportedRenderer : ComponentRenderer {
    @Composable
    override fun Render(
        defnComp: DefnComp,
        defnForm: DefnForm,
        formRef: FormRef,
        modifier: Modifier
    ) {
        Text(
            text = "Unsupported component type: ${defnComp.type.name}",
            color = MaterialTheme.colorScheme.error,
            modifier = modifier
        )
    }
}
```

### Example Field Renderer

### File: `presentation/components/field/FieldText.kt`

```kotlin
package com.neome.feature.form.presentation.components.field

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.neome.api.meta.base.dto.DefnComp
import com.neome.api.meta.base.dto.DefnForm
import com.neome.feature.form.presentation.components.factory.ComponentRenderer
import com.neome.feature.form.presentation.ref.FormRef

/**
 * Text field renderer.
 * Renders a simple text input field.
 */
object FieldText : ComponentRenderer {

    @Composable
    override fun Render(
        defnComp: DefnComp,
        defnForm: DefnForm,
        formRef: FormRef,
        modifier: Modifier
    ) {
        val fieldId = defnComp.name.value
        val value by formRef.watch<String>(fieldId).collectAsStateWithLifecycle()

        OutlinedTextField(
            value = value ?: "",
            onValueChange = { newValue ->
                formRef.setValue(fieldId, newValue)
            },
            label = {
                Text(defnComp.label ?: defnComp.name.value)
            },
            modifier = modifier.fillMaxWidth(),
            enabled = defnComp.isDisabled != true,
            singleLine = true
        )
    }
}
```

---

## Form Component Implementation

### File: `presentation/component/Form.kt`

```kotlin
package com.neome.feature.form.presentation.component

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.neome.feature.form.presentation.components.factory.ComponentRendererFactory
import com.neome.feature.form.presentation.ref.FormRef
import com.neome.feature.form.presentation.state.FormIntent
import com.neome.feature.form.presentation.state.FormState

/**
 * Pure MVI Form Component.
 *
 * Responsibilities:
 * - Receives state from parent (screen/component)
 * - Receives formRef from parent for field operations
 * - Dispatches intents to parent
 * - No ViewModel dependency in component
 * - Fully testable and previewable
 *
 * Pure MVI Signature:
 * 1. state: FormState - Single source of truth (configuration)
 * 2. formRef: FormRef - Imperative API for field operations
 * 3. onIntent: (FormIntent) -> Unit - Single intent handler
 * 4. modifier: Modifier - Standard convention
 */
@Composable
fun Form(
    state: FormState,
    formRef: FormRef,
    onIntent: (FormIntent) -> Unit,
    modifier: Modifier = Modifier
) {
    FormContent(
        state = state,
        formRef = formRef,
        onIntent = onIntent,
        modifier = modifier
    )
}

/**
 * Stateless form content.
 * Pure presentation logic.
 */
@Composable
private fun FormContent(
    state: FormState,
    formRef: FormRef,
    onIntent: (FormIntent) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
    ) {
        val defnForm = state.defnForm
        val rootComponent = defnForm?.compMap?.get(defnForm.displayCompositeId)

        if (rootComponent != null && defnForm != null) {
            // Render root component using factory
            ComponentRendererFactory.render(
                defnComp = rootComponent,
                defnForm = defnForm,
                formRef = formRef,
                modifier = Modifier
            )
        } else {
            Text(
                text = "Error: Root component not found",
                color = MaterialTheme.colorScheme.error,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(16.dp)
            )
        }
    }
}
```

---

## Parent Usage Pattern

### Example: Using Form in a Screen

```kotlin
package com.neome.feature.myscreen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.neome.api.meta.base.dto.DefnForm
import com.neome.api.meta.base.dto.FormValueRaw
import com.neome.feature.form.presentation.component.Form
import com.neome.feature.form.presentation.state.FormIntent

/**
 * Screen that uses Form component.
 * Manages ViewModel and handles form intents.
 */
@Composable
fun MyFormScreen(
    defnForm: DefnForm,
    initialValue: FormValueRaw? = null,
    viewModel: MyFormViewModel = hiltViewModel(),
    onNavigateBack: () -> Unit
) {
    // Initialize form
    LaunchedEffect(defnForm) {
        viewModel.initializeForm(defnForm, initialValue)
    }

    // Collect state
    val formState by viewModel.formState.collectAsStateWithLifecycle()
    val formRef = viewModel.formRef

    // Render Form component
    Form(
        state = formState,
        formRef = formRef,
        onIntent = { intent ->
            when (intent) {
                is FormIntent.Submit -> {
                    // Handle form submission
                    viewModel.submitForm(intent.formValue)
                }
                is FormIntent.Watch -> {
                    // Handle field changes (optional)
                    viewModel.handleFieldChange(
                        intent.fieldId,
                        intent.fieldValue
                    )
                }
            }
        }
    )
}
```

### Example ViewModel

```kotlin
package com.neome.feature.myscreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.neome.api.meta.base.dto.DefnForm
import com.neome.api.meta.base.dto.FormValueRaw
import com.neome.feature.form.presentation.ref.FormRef
import com.neome.feature.form.presentation.ref.FormRefImpl
import com.neome.feature.form.presentation.state.FormState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class MyFormViewModel @Inject constructor() : ViewModel() {

    private val _formState = MutableStateFlow(FormState())
    val formState = _formState.asStateFlow()

    val formRef: FormRef by lazy { FormRefImpl(viewModelScope) }

    /**
     * Initialize form with DefnForm and optional initial value.
     */
    fun initializeForm(defnForm: DefnForm, formValueRaw: FormValueRaw? = null) {
        // Create initial FormValueRaw if not provided
        val initialValue = formValueRaw ?: createInitialFormValueRaw(defnForm)

        _formState.update {
            it.copy(
                defnForm = defnForm,
                initialFormValue = initialValue
            )
        }

        // Initialize FormRef with the form
        (formRef as? FormRefImpl)?.initialize(defnForm, initialValue)
    }

    /**
     * Handle form submission.
     */
    fun submitForm(formValue: FormValueRaw) {
        viewModelScope.launch {
            // Validate
            if (!formRef.isValid()) {
                // Show validation errors
                return@launch
            }

            // Submit to API
            // repository.submitForm(formValue)
        }
    }

    /**
     * Handle field changes (optional - for real-time validation, etc.)
     */
    fun handleFieldChange(fieldId: String, fieldValue: Any?) {
        // Optional: React to field changes
        // e.g., dependent field updates, analytics, etc.
    }

    private fun createInitialFormValueRaw(defnForm: DefnForm): FormValueRaw {
        // Create initial values from DefnForm
        // Implementation details...
        return FormValueRaw()
    }
}
```

---

## Validation Rules

### File: `domain/model/ValidationRule.kt`

```kotlin
package com.neome.feature.form.domain.model

/**
 * Validation rule interface.
 * Pure functions for field validation.
 */
sealed interface ValidationRule<T> {
    fun validate(value: T, allFields: Map<String, FieldState<*>>): ValidationResult

    data class Required<T>(val message: String = "Required") : ValidationRule<T> {
        override fun validate(value: T, allFields: Map<String, FieldState<*>>): ValidationResult {
            return when {
                value == null -> ValidationResult.Error(message)
                value is String && value.isBlank() -> ValidationResult.Error(message)
                else -> ValidationResult.Success
            }
        }
    }

    data class MinLength(
        val min: Int,
        val message: String = "Minimum $min characters required"
    ) : ValidationRule<String> {
        override fun validate(value: String, allFields: Map<String, FieldState<*>>): ValidationResult {
            return if (value.length < min) {
                ValidationResult.Error(message)
            } else {
                ValidationResult.Success
            }
        }
    }

    data class Email(
        val message: String = "Invalid email format"
    ) : ValidationRule<String> {
        override fun validate(value: String, allFields: Map<String, FieldState<*>>): ValidationResult {
            val emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$".toRegex()
            return if (emailRegex.matches(value)) {
                ValidationResult.Success
            } else {
                ValidationResult.Error(message)
            }
        }
    }

    data class Custom<T>(
        val message: String,
        val validator: (T) -> Boolean
    ) : ValidationRule<T> {
        override fun validate(value: T, allFields: Map<String, FieldState<*>>): ValidationResult {
            return if (validator(value)) {
                ValidationResult.Success
            } else {
                ValidationResult.Error(message)
            }
        }
    }
}

/**
 * Validation result.
 */
sealed interface ValidationResult {
    data object Success : ValidationResult
    data class Error(val message: String) : ValidationResult
}

/**
 * Internal field state managed by FormRef.
 */
data class FieldState<T>(
    val value: T,
    val defaultValue: T,
    val isRequired: Boolean = false,
    val isDisabled: Boolean = false,
    val isTouched: Boolean = false,
    val isDirty: Boolean = false,
    val validationRules: List<ValidationRule<T>> = emptyList(),
    val errors: List<String> = emptyList()
)
```

---

## Naming Conventions

### File Naming Rules

All form-related files follow strict naming conventions:

#### Field Components (Input Fields)

**Pattern**: `Field{Type}.kt`

- `FieldText.kt` - Text input field
- `FieldEmail.kt` - Email input field
- `FieldPhone.kt` - Phone number input field
- `FieldNumber.kt` - Numeric input field
- `FieldBool.kt` - Boolean toggle/switch field
- `FieldPickText.kt` - Dropdown/select field
- `FieldDate.kt` - Date picker field
- `FieldCurrency.kt` - Currency input field
- `FieldUrl.kt` - URL input field

#### Composite Components (Containers)

**Pattern**: `Field{Type}.kt`

- `FieldTab.kt` - Tab container component
- `FieldSection.kt` - Section container component
- `FieldGrid.kt` - Grid/repeatable rows component

#### Main Form Components

**Pattern**: `Form{Purpose}.kt` or `Form.kt`

- `Form.kt` - Main dynamic form component
- `FormRef.kt` - FormRef interface
- `FormRefImpl.kt` - FormRef implementation
- `FormState.kt` - Form state data class
- `FormIntent.kt` - Form intents sealed interface

#### Utility/Helper Files

**Pattern**: `Plus{FeatureName}.kt`

- `PlusDefnForm.kt` - DefnForm extension functions
- `PlusFormValueRaw.kt` - FormValueRaw extension functions
- `PlusValidation.kt` - Validation utilities
- `PlusFormMapper.kt` - Mapping utilities

---

## Key Principles

1. **Pure MVI Component** - Form component is pure function of state, no ViewModel dependency
2. **Simplified State** - FormState holds only configuration (defnForm, initialFormValue)
3. **Two Intents** - Only Submit and Watch intents for external communication
4. **FormRef Imperative API** - All field operations through FormRef (getValue, setValue, etc.)
5. **Separation of Concerns** - Form component renders, parent handles logic, FormRef manages fields
6. **Type Safety** - Sealed interfaces, immutable data classes
7. **Immutability** - State never mutated, always copied
8. **Lifecycle Awareness** - collectAsStateWithLifecycle in parent (screen/component)
9. **Factory Pattern** - Easy to extend with new field types
10. **Testability** - Stateless components are fully previewable and testable

---

## Common Patterns

### Prefill Form

```kotlin
LaunchedEffect(userId) {
    val user = loadUser(userId)
    formRef.setValues(
        FormValueRaw().apply {
            valueMap = mapOf(
                "name" to JsonPrimitive(user.name),
                "email" to JsonPrimitive(user.email)
            )
        },
        shouldValidate = false
    )
}
```

### Watch Field Changes

```kotlin
val country by formRef.watch<String>("country").collectAsStateWithLifecycle()

LaunchedEffect(country) {
    when (country) {
        "USA" -> formRef.setValue("state", "")
        "Canada" -> formRef.setValue("province", "")
    }
}
```

### Field Dependencies

```kotlin
@Composable
fun DependentFieldExample(formRef: FormRef) {
    val password by formRef.watch<String>("password").collectAsStateWithLifecycle()

    LaunchedEffect(password) {
        // When password changes, re-validate confirmPassword
        formRef.trigger("confirmPassword")
    }
}
```

---

## Best Practices Summary

1. **State is configuration only** - Runtime state in FormRef
2. **Component is stateless** - No ViewModel, no remember, no LaunchedEffect
3. **Intents for external communication** - Submit and Watch only
4. **FormRef for field operations** - getValue, setValue, watch, trigger
5. **Factory pattern for rendering** - Easy to add new field types
6. **Immutable state** - Use `@Immutable` and `data class` with `copy()`
7. **Lifecycle-aware** - Use `collectAsStateWithLifecycle()` in parent
8. **Preview-friendly** - Stateless components are fully previewable

---

## End of Document
