# Form Component Architecture - MVI Pattern

## Overview

A production-ready, type-safe MVI (Model-View-Intent) form component for Android with Jetpack
Compose. This provides a reusable, embedded form component driven by `DefnFormData` with
centralized state management, event-based field communication, and external API via `FormRef`.

## Architecture Diagram

```
┌─────────────────────────────────────────────────────────────────┐
│                     PARENT (SCREEN/COMPONENT)                    │
│  ┌─────────────┐    ┌─────────────┐    ┌─────────────────────┐  │
│  │  ViewModel  │───▶│ DefnFormData│───▶│     FormRef         │  │
│  │             │    │ initialValue│    │  (External API)     │  │
│  └─────────────┘    └─────────────┘    └─────────────────────┘  │
│         │                  │                      │              │
│         │                  │ props                │ formRef      │
│         ▼                  ▼                      ▼              │
│  ┌──────────────────────────────────────────────────────────────┤
│  │                   FORM COMPONENT (Pure MVI)                  ││
│  │  ┌──────────┐   ┌──────────┐   ┌──────────┐   ┌──────────┐ ││
│  │  │FormState │──▶│ FormCtx  │──▶│Renderer  │──▶│  Field   │ ││
│  │  │(Central) │   │(Internal)│   │ Factory  │   │Components│ ││
│  │  └──────────┘   └──────────┘   └──────────┘   └──────────┘ ││
│  │        │              │                            │        ││
│  │        │              │                            ▼        ││
│  │        │              │                      ┌──────────┐   ││
│  │        └──────────────┴─────────────────────▶│FormIntent│   ││
│  │              FormEvent (internal)            │(external)│   ││
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
│   │   ├── FormState.kt               # Centralized state
│   │   ├── FormEvent.kt               # Internal events
│   │   ├── FormIntent.kt              # External intents (to parent)
│   │   ├── FieldState.kt              # Field state with FieldProperties
│   │   ├── FieldProps.kt              # Simplified field props
│   │   └── FieldEvent.kt              # Events emitted by fields
│   ├── ctx/
│   │   ├── FormCtx.kt                 # Internal context interface
│   │   └── FormCtxImpl.kt             # FormCtx implementation
│   ├── ref/
│   │   ├── FormRef.kt                 # External API interface
│   │   └── FormRefImpl.kt             # FormRef implementation
│   ├── util/
│   │   └── PropertyResolver.kt        # Resolve field properties
│   └── components/
│       ├── field/
│       │   ├── FieldText.kt
│       │   ├── FieldEmail.kt
│       │   ├── FieldNumber.kt
│       │   └── ...
│       ├── composite/
│       │   ├── FieldTab.kt
│       │   ├── FieldSection.kt
│       │   └── FieldGrid.kt
│       └── factory/
│           └── ComponentRendererFactory.kt
└── domain/
    └── model/
        └── ValidationRule.kt
```

---

## 1. Component Props (Form.kt)

The Form component receives configuration and callbacks from parent:

```kotlin
@Composable
fun Form(
    // Configuration
    defnForm: DefnFormData,
    initialValue: FormValueRawData? = null,
    
    // External API
    formRef: MutableState<FormRef?>,  // Exposed for parent to call
    
    // Callbacks to parent
    onIntent: (FormIntent) -> Unit,   // Submit, Watch events
    
    // Optional customization
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    readOnly: Boolean = false
)
```

---

## 2. Centralized State (FormState.kt)

All runtime data is held in FormState:

```kotlin
@Immutable
data class FormState(
    // Configuration (from parent)
    val defnForm: DefnFormData? = null,
    val initialFormValue: FormValueRawData? = null,
    
    // Runtime state (centralized)
    val fieldStates: Map<MetaIdComp, FieldState> = emptyMap(),
    
    // Dependency tracking for property recalculation
    val fieldDependencies: FieldDependencyMap = FieldDependencyMap(),
    
    // Form-level state
    val isSubmitting: Boolean = false,
    val formError: String? = null,
    val isInitialized: Boolean = false
)
```

---

## 3. Field State (FieldState.kt)

Each field's runtime state including computed properties:

```kotlin
@Immutable
data class FieldState(
    // Values
    val value: JsonElement? = null,
    val defaultValue: JsonElement? = null,  // Set on init from initialValue

    // Interaction state
    val error: String? = null,
    val isTouched: Boolean = false,
    val isDirty: Boolean = false,
    val isFocused: Boolean = false,
    val isValidating: Boolean = false,

    // Computed properties (recalculated on trigger)
    val fieldProperties: FieldProperties = FieldProperties()
)

/**
 * Computed field properties.
 * Recalculated when field is triggered (on init or when dependent field changes).
 *
 * Properties can be resolved from DefnComp in 3 ways:
 * 1. Direct value: defnComp.placeHolder (String)
 * 2. Variable: defnComp.placeHolderVar (DefnDtoText) -> resolveArgValue()
 * 3. Field reference: defnComp.placeHolderFieldId -> get value from another field
 */
@Immutable
data class FieldProperties(
    val required: Boolean = false,
    val disabled: Boolean = false,
    val readOnly: Boolean = false,
    val hidden: Boolean = false,
    val helperText: String? = null,
    val placeholder: String? = null,
    val label: String? = null
)
```

---

## 4. Internal Events (FormEvent.kt)

Events that modify FormState internally:

```kotlin
sealed interface FormEvent : UiEvent {
    // Field value changes
    data class FieldValueChanged(
        val fieldId: MetaIdComp,
        val value: JsonElement?,
        val shouldValidate: Boolean = true
    ) : FormEvent
    
    // Field interaction events
    data class FieldFocused(val fieldId: MetaIdComp) : FormEvent
    data class FieldBlurred(val fieldId: MetaIdComp) : FormEvent
    data class FieldTouched(val fieldId: MetaIdComp) : FormEvent
    
    // Field trigger - recalculates fieldProperties
    data class TriggerField(val fieldId: MetaIdComp) : FormEvent
    
    // Validation events
    data class ValidateField(val fieldId: MetaIdComp) : FormEvent
    data class ValidationResult(val fieldId: MetaIdComp, val error: String?) : FormEvent
    data object ValidateAll : FormEvent
    
    // Form-level events
    data object Submit : FormEvent
    data class Reset(val valueMap: Map<MetaIdComp, JsonElement>? = null) : FormEvent
    data class SetFieldError(val fieldId: MetaIdComp, val error: String) : FormEvent
    data class ClearFieldError(val fieldId: MetaIdComp) : FormEvent
    data object ClearAllErrors : FormEvent
    
    // Bulk operations
    data class SetValues(
        val valueMap: Map<MetaIdComp, JsonElement>, 
        val shouldValidate: Boolean = true
    ) : FormEvent
    
    // Initialize form
    data object Initialize : FormEvent
}
```

---

## 5. External Intents (FormIntent.kt)

Intents emitted FROM the Form component TO the parent:

```kotlin
sealed interface FormIntent : UiEvent {
    /**
     * Form submission with complete form data.
     */
    @Immutable
    data class Submit(val valueMap: Map<MetaIdComp, JsonElement>) : FormIntent
    
    /**
     * Field change notification.
     */
    @Immutable
    data class Watch(
        val fieldId: MetaIdComp,
        val fieldValue: JsonElement?,
        val valueMap: Map<MetaIdComp, JsonElement>
    ) : FormIntent
    
    /**
     * Form validation state changed.
     */
    @Immutable
    data class ValidationStateChanged(
        val isValid: Boolean,
        val hasErrors: Boolean
    ) : FormIntent
}
```

---

## 6. Field Props and Events

### FieldProps (Simplified)

Props passed to each field renderer:

```kotlin
@Immutable
data class FieldProps(
    val defnComp: DefnComp,
    val fieldState: FieldState
)
```

### FieldEvent

Events emitted FROM fields:

```kotlin
sealed interface FieldEvent {
    val fieldId: MetaIdComp
    
    data class ValueChanged(override val fieldId: MetaIdComp, val value: JsonElement?) : FieldEvent
    data class Focused(override val fieldId: MetaIdComp) : FieldEvent
    data class Blurred(override val fieldId: MetaIdComp) : FieldEvent
}
```

---

## 7. FormCtx (Internal Context)

Internal context passed to all fields for form operations:

```kotlin
interface FormCtx {
    // Trigger field to recalculate fieldProperties
    fun trigger(fieldId: MetaIdComp)
    
    // Get current form values
    fun getValues(): Map<MetaIdComp, JsonElement>
    
    // Get specific field state
    fun getFieldState(fieldId: MetaIdComp): FieldState?
    
    // Get field value (convenience)
    fun getFieldValue(fieldId: MetaIdComp): JsonElement?
    
    // Check if field exists
    fun hasField(fieldId: MetaIdComp): Boolean
    
    // Get DefnForm data
    fun getDefnForm(): DefnFormData?
}
```

---

## 8. FormRef (External API)

API for parent screens to interact with form:

```kotlin
interface FormRef {
    // Read operations
    fun getFieldValue(fieldId: MetaIdComp): JsonElement?
    fun getValues(): FormValueRawData?
    fun getValueMap(): Map<MetaIdComp, JsonElement>
    fun getFieldState(fieldId: MetaIdComp): FieldState?
    
    // Write operations
    fun setValue(fieldId: MetaIdComp, value: JsonElement?, shouldValidate: Boolean = true)
    fun setValues(valueMap: Map<MetaIdComp, JsonElement>, shouldValidate: Boolean = true)
    
    // Validation
    fun validate(fieldId: MetaIdComp? = null): Boolean
    fun setError(fieldId: MetaIdComp, error: String)
    fun clearErrors(fieldId: MetaIdComp? = null)
    
    // Form operations
    fun submit()
    fun reset(valueMap: Map<MetaIdComp, JsonElement>? = null)
    
    // State queries
    fun isDirty(fieldId: MetaIdComp? = null): Boolean
    fun isValid(fieldId: MetaIdComp? = null): Boolean
    fun isTouched(fieldId: MetaIdComp? = null): Boolean
    
    // Reactive streams
    fun watchFieldState(fieldId: MetaIdComp): StateFlow<FieldState?>
    fun watchFormState(): StateFlow<FormState>
}
```

---

## 9. Dependency Tracking

Track field dependencies for property recalculation:

```kotlin
/**
 * Example: If FieldB.placeHolderFieldId = FieldA.id
 * Then dependents[FieldA.id] = setOf(FieldB.id)
 * 
 * When FieldA value changes -> trigger FieldB to recalculate properties
 */
@Immutable
data class FieldDependencyMap(
    val dependents: Map<MetaIdComp, Set<MetaIdComp>> = emptyMap()
)
```

### Property Resolution Flow

```
Form Init / Field Value Change
        │
        ▼
┌─────────────────────────────┐
│  Build Dependency Map       │
│  (scan DefnComp for *FieldId│
│   properties)               │
└─────────────────────────────┘
        │
        ▼
┌─────────────────────────────┐
│  For each field, calculate  │
│  FieldProperties:           │
│                             │
│  placeholder = resolve(     │
│    placeHolder,             │  ← Direct string
│    placeHolderVar,          │  ← resolveArgValue()
│    placeHolderFieldId       │  ← getFieldValue()
│  )                          │
└─────────────────────────────┘
        │
        ▼
┌─────────────────────────────┐
│  On field value change:     │
│  1. Update fieldState.value │
│  2. Get dependents from map │
│  3. Trigger each dependent  │
│     to recalculate props    │
└─────────────────────────────┘
```

---

## Parent Usage Pattern

### Example: Using Form in a Screen

```kotlin
@Composable
fun MyFormScreen(
    defnForm: DefnFormData,
    initialValue: FormValueRawData? = null,
    onSubmit: (Map<MetaIdComp, JsonElement>) -> Unit,
    onNavigateBack: () -> Unit
) {
    // FormRef holder
    val formRef = remember { mutableStateOf<FormRef?>(null) }
    
    // Render Form component
    Form(
        defnForm = defnForm,
        initialValue = initialValue,
        formRef = formRef,
        onIntent = { intent ->
            when (intent) {
                is FormIntent.Submit -> {
                    onSubmit(intent.valueMap)
                }
                is FormIntent.Watch -> {
                    // Handle field changes (optional)
                    Log.d("Form", "Field ${intent.fieldId} changed")
                }
                is FormIntent.ValidationStateChanged -> {
                    // Handle validation state changes
                }
            }
        }
    )
    
    // Use formRef for programmatic operations
    Button(onClick = { formRef.value?.submit() }) {
        Text("Submit")
    }
}
```

---

## Data Flow Summary

```
Parent Screen                Form Component               Field Renderer
    │                              │                            │
    │── defnForm, initialValue ──▶ │                            │
    │                              │── FieldProps(defnComp, ──▶ │
    │                              │    fieldState)             │
    │                              │◀── FieldEvent.ValueChanged │
    │                              │                            │
    │                              │ (reduce to FormState)      │
    │                              │                            │
    │◀── FormIntent.Watch ─────────│                            │
    │◀── FormIntent.Submit ────────│                            │
    │                              │                            │
    │── formRef.getValue() ──────▶ │                            │
    │◀── value ────────────────────│                            │
```

---

## Key Principles

1. **Centralized State** - All field values, errors, touched states in FormState
2. **Event-Based Communication** - Fields emit events, Form handles them
3. **Computed Properties** - FieldProperties recalculated on trigger
4. **Dependency Tracking** - Automatic property recalculation when dependent fields change
5. **Dual API** - FormCtx for internal use, FormRef for external access
6. **Type Safety** - MetaIdComp for field IDs, JsonElement for values
7. **Immutability** - All state classes are immutable
8. **Separation of Concerns** - Events vs Intents (internal vs external)

---

## Best Practices Summary

1. **Use DefnFormData/FormValueRawData** - Serializable data types
2. **Access FormRef via MutableState** - Parent controls lifecycle
3. **Handle FormIntent.Watch** - For field change reactions
4. **Use FormCtx in field renderers** - For accessing other fields
5. **Implement PropertyResolver** - For dynamic property calculation
6. **Track dependencies** - For efficient property recalculation
7. **Validate on blur** - Better UX than validate on change

---

## End of Document
