# skill:defnForm

## Metadata

| Property           | Value                                       |
|--------------------|---------------------------------------------|
| **Version**        | 1.2.0                                       |
| **Last Updated**   | 2026-02-03                                  |
| **Scope**          | Android Form Component Architecture         |
| **Path**           | `app/src/main/java/com/neome/feature/form/` |
| **Update Trigger** | Any modification to form component files    |

---

## Table of Contents

1. [Quick Reference](#quick-reference)
2. [Architecture Overview](#architecture-overview)
3. [Core Concepts](#core-concepts)
4. [API Reference](#api-reference)
5. [Component Hierarchy](#component-hierarchy)
6. [How-To Guides](#how-to-guides)
7. [Best Practices](#best-practices)
8. [Anti-Patterns](#anti-patterns)
9. [Troubleshooting](#troubleshooting)
10. [File Structure](#file-structure)
11. [Modification Protocol](#modification-protocol)
12. [Changelog](#changelog)

---

## Quick Reference

### Usage Pattern

```kotlin
using skill : defnForm do [instruction]
```

### Common Instructions

| Task                       | Example Instruction                      |
|----------------------------|------------------------------------------|
| Add new field type         | `Add new field type FieldPhone`          |
| Add validation rule        | `Add email format validation`            |
| Add cross-field validation | `Validate password confirmation matches` |
| Add formula support        | `Implement formula calculation for X`    |
| Fix field bug              | `Fix validation bug in FieldNumber`      |
| Add async validation       | `Add async username availability check`  |
| Add conditional visibility | `Hide field Y when X is empty`           |

### Key Files (Quick Access)

| Purpose          | File                                              |
|------------------|---------------------------------------------------|
| Root Composable  | `presentation/components/Form.kt`                 |
| State Reducer    | `domain/reducer/FormReducer.kt`                   |
| Field Factory    | `presentation/components/base/FieldFactory.kt`    |
| External API     | `domain/ref/FormRef.kt`                           |
| Internal Context | `domain/ctx/FormCtx.kt`                           |
| Field Controller | `presentation/components/base/FieldController.kt` |

---

## Architecture Overview

### Pattern: MVI + UDF + CompositionLocal

```
                              FORM ARCHITECTURE
================================================================================

  Parent (Screen/ViewModel)
         │
         │ FormRef (imperative API)
         ▼
  ┌──────────────────────────────────────────────────────────────────────────┐
  │                              Form Component                               │
  │                                                                          │
  │   ┌─────────────┐         ┌─────────────┐         ┌─────────────┐       │
  │   │  FormState  │◄────────│ FormReducer │◄────────│  FormEvent  │       │
  │   │ (immutable) │  pure   │  (pure fn)  │         │  (sealed)   │       │
  │   └──────┬──────┘  update └─────────────┘         └──────▲──────┘       │
  │          │                                               │              │
  │          │ StateFlow                                     │              │
  │          ▼                                               │              │
  │   ┌─────────────┐                                        │              │
  │   │   FormCtx   │ ─────► LocalFormCtx (CompositionLocal) │              │
  │   │  (stable)   │                                        │              │
  │   └──────┬──────┘                                        │              │
  │          │                                               │              │
  │          ▼                                               │              │
  │   ┌─────────────────────────────────────────────────────┴─────────┐    │
  │   │                      Field Components                          │    │
  │   │  FieldText │ FieldNumber │ FieldDate │ FieldSection │ ...     │    │
  │   │          (use rememberFieldController + LocalFormCtx)          │    │
  │   └────────────────────────────────────────────────────────────────┘    │
  │                                                                          │
  └──────────────────────────────────────────────────────────────────────────┘
         │
         │ FormIntent (Submit, Watch, ValidationStateChanged)
         ▼
  Parent (Screen/ViewModel)
```

### Core Principles

| Principle              | Implementation                                     |
|------------------------|----------------------------------------------------|
| Single Source of Truth | All state in immutable `FormState`                 |
| Pure Reducer           | `FormReducer.reduce()` has no side effects         |
| Reactive Updates       | StateFlow for UI observation                       |
| Imperative API         | `FormRef` for parent control                       |
| Stable Context         | `FormCtx` never recreated after Form init          |
| No Prop Drilling       | `LocalFormCtx` provides context to all descendants |

---

## Core Concepts

### State Definitions

#### FormState

```kotlin
@Immutable
data class FormState(
    // Schema & Initial Data
    val defnForm: DefnFormData? = null,
    val initialFormValue: FormValueRawData? = null,

    // Field Data
    val fieldStates: Map<MetaIdComp, FieldState> = emptyMap(),
    val errors: Map<MetaIdComp, FieldError> = emptyMap(),
    val fieldDependencies: FieldDependencyMap = FieldDependencyMap(),

    // Form-level State
    val disabled: Boolean = false,
    val readOnly: Boolean = false,
    val isSubmitting: Boolean = false,
    val formError: String? = null,
    val isInitialized: Boolean = false
) {
    // Computed Properties
    val hasErrors: Boolean get() = errors.isNotEmpty()
    val isDirty: Boolean get() = fieldStates.values.any { it.isDirty }
    val isValid: Boolean
        get() = !hasErrors && fieldStates.values.none {
            it.fieldProperties.required && it.value == null
        }
}
```

#### FieldState

```kotlin
@Immutable
@Serializable
data class FieldState(
    val value: JsonElement? = null,
    val defaultValue: JsonElement? = null,
    val isTouched: Boolean = false,
    val isDirty: Boolean = false,
    val isFocused: Boolean = false,
    val isValidating: Boolean = false,
    val fieldProperties: FieldProperties = FieldProperties()
)

@Immutable
@Serializable
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

#### FieldDependencyMap

```kotlin
@Immutable
data class FieldDependencyMap(
    // Map: sourceFieldId -> set of fields that depend on it
    val dependents: Map<MetaIdComp, Set<MetaIdComp>> = emptyMap()
)
```

### Event System

#### FormEvent (Internal)

| Event               | Purpose                          | Triggers                     |
|---------------------|----------------------------------|------------------------------|
| `Initialize`        | Build deps, set initial values   | Form mount                   |
| `FieldValueChanged` | Update value, trigger dependents | User input                   |
| `FieldFocused`      | Mark field focused               | Field gains focus            |
| `FieldBlurred`      | Mark touched + unfocused         | Field loses focus            |
| `FieldTouched`      | Mark field touched               | Any interaction              |
| `TriggerField`      | Recalculate field properties     | Dependency change            |
| `ValidateField`     | Validate single field            | Blur, submit, manual         |
| `ValidationResult`  | Apply validation result          | After validation             |
| `ValidateAll`       | Validate all fields              | Submit                       |
| `SetFieldError`     | Set custom error                 | API error, custom validation |
| `ClearFieldError`   | Clear field error                | Manual clear                 |
| `ClearAllErrors`    | Clear all errors                 | Form reset                   |
| `Submit`            | Validate + submit if valid       | Submit button                |
| `Reset`             | Reset to initial values          | Reset button                 |
| `SetValues`         | Bulk value update                | External data load           |

#### FormIntent (External)

| Intent                   | Direction     | Purpose                         |
|--------------------------|---------------|---------------------------------|
| `Submit`                 | Form → Parent | Deliver validated form data     |
| `Watch`                  | Form → Parent | Notify field value changes      |
| `ValidationStateChanged` | Form → Parent | Notify validation state changes |

#### FieldEvent (Field → Form)

| Event          | Emitted When             |
|----------------|--------------------------|
| `ValueChanged` | User changes field value |
| `Focused`      | Field gains focus        |
| `Blurred`      | Field loses focus        |

### Error Handling

```kotlin
data class FieldError(
    val message: String,
    val type: ErrorType = ErrorType.Validation
)

enum class ErrorType {
    Validation,  // Auto-cleared on value change
    Custom,      // Set via FormRef.setError()
    Server       // Set via FormRef.setError() after API failure
}
```

**Error Lifecycle:**

1. **Validation errors** - Auto-cleared when field value changes
2. **Custom/Server errors** - Persist until manually cleared via `clearErrors()`

---

## API Reference

### FormRef (External API for Parents)

Use this interface to control the form from parent components.

```kotlin
interface FormRef {
    // ═══════════════════════════════════════════════════════════════════
    // READ OPERATIONS
    // ═══════════════════════════════════════════════════════════════════

    /** Get single field value */
    fun getValue(fieldId: MetaIdComp): JsonElement?

    /** Get all values as FormValueRawData */
    fun getValues(): FormValueRawData?

    /** Get all values as Map */
    fun getValueMap(): Map<MetaIdComp, JsonElement>

    /** Get field state (value, touched, dirty, etc.) */
    fun getFieldState(fieldId: MetaIdComp): FieldState?

    // ═══════════════════════════════════════════════════════════════════
    // WRITE OPERATIONS
    // ═══════════════════════════════════════════════════════════════════

    /** Set single field value */
    fun setValue(
        fieldId: MetaIdComp,
        value: JsonElement?,
        shouldValidate: Boolean = true
    )

    /** Set multiple field values */
    fun setValues(
        valueMap: Map<MetaIdComp, JsonElement>,
        shouldValidate: Boolean = true
    )

    // ═══════════════════════════════════════════════════════════════════
    // VALIDATION
    // ═══════════════════════════════════════════════════════════════════

    /** Validate single field or all fields (if fieldId is null) */
    fun validate(fieldId: MetaIdComp? = null): Boolean

    /** Set custom error on field */
    fun setError(fieldId: MetaIdComp, error: String)

    /** Clear errors (single field or all if fieldId is null) */
    fun clearErrors(fieldId: MetaIdComp? = null)

    // ═══════════════════════════════════════════════════════════════════
    // FORM OPERATIONS
    // ═══════════════════════════════════════════════════════════════════

    /** Submit form (validates first) */
    fun submit()

    /** Reset form to initial or provided values */
    fun reset(valueMap: Map<MetaIdComp, JsonElement>? = null)

    // ═══════════════════════════════════════════════════════════════════
    // STATE QUERIES
    // ═══════════════════════════════════════════════════════════════════

    /** Check if field/form is dirty */
    fun isDirty(fieldId: MetaIdComp? = null): Boolean

    /** Check if field/form is valid */
    fun isValid(fieldId: MetaIdComp? = null): Boolean

    /** Check if field/form is touched */
    fun isTouched(fieldId: MetaIdComp? = null): Boolean

    // ═══════════════════════════════════════════════════════════════════
    // REACTIVE SUBSCRIPTIONS
    // ═══════════════════════════════════════════════════════════════════

    /** Watch specific field state changes */
    fun watchFieldState(fieldId: MetaIdComp): StateFlow<FieldState?>

    /** Watch entire form state changes */
    fun watchFormState(): StateFlow<FormState>
}
```

### FormCtx (Internal API for Fields)

Used internally by field components via `LocalFormCtx.current`.

```kotlin
interface FormCtx {
    /** Trigger dependent field recalculation */
    fun trigger(fieldId: MetaIdComp)

    /** Get all values as Map */
    fun getValues(): Map<MetaIdComp, JsonElement>

    /** Get single field value */
    fun getValue(fieldId: MetaIdComp): JsonElement?

    /** Get field state */
    fun getFieldState(fieldId: MetaIdComp): FieldState?

    /** Get field error */
    fun getError(fieldId: MetaIdComp): FieldError?

    /** Check if field exists */
    fun hasField(fieldId: MetaIdComp): Boolean

    /** Get form definition */
    fun getDefnForm(): DefnFormData?

    /** Validate field or all */
    fun validate(fieldId: MetaIdComp? = null): Boolean

    /** Reactive subscriptions */
    fun watchFieldState(fieldId: MetaIdComp): StateFlow<FieldState?>
    fun watchFieldError(fieldId: MetaIdComp): StateFlow<FieldError?>
    fun watchFormState(): StateFlow<FormState>
}
```

### LocalFormCtx (CompositionLocal)

```kotlin
val LocalFormCtx = staticCompositionLocalOf<FormCtx> {
    error("FormCtx not provided. Ensure Form composable is in the composition tree.")
}

// Usage in any composable within Form hierarchy:
@Composable
fun MyComponent() {
    val formCtx = LocalFormCtx.current
    val fieldState = formCtx.getFieldState(fieldId)
    // ...
}
```

### FieldController

Helper for field components to interact with form state.

```kotlin
@Immutable
data class FieldController<T>(
    val fieldId: MetaIdField?,
    val fieldState: FieldState?,
    val fieldValue: T?,                              // Deserialized typed value
    val error: FieldError?,
    val fieldProperties: FieldProperties,
    val fieldPropertiesFlow: StateFlow<FieldProperties>,
    val fieldStateFlow: StateFlow<FieldState?>,
    val onChange: (T?) -> Unit
)

// Usage:
@Composable
inline fun <reified T> rememberFieldController(
    defnComp: DefnCompSeal,
    onFieldEvent: (FieldEvent) -> Unit
): FieldController<T>
```

---

## Component Hierarchy

### Visual Structure

```
Form (provides LocalFormCtx)
└── FormContent
    └── FieldFactory (routes by type)
        │
        ├── COMPOSITE TYPES (no FieldState)
        │   ├── FieldTab
        │   │   └── FieldFactory (per tab content)
        │   ├── FieldSection
        │   │   └── FieldFactory (per child)
        │   ├── grid
        │   ├── wizard
        │   └── spreadsheetRef
        │
        └── LEAF TYPES (have FieldState)
            ├── FieldText
            ├── FieldNumber
            ├── FieldDecimal
            ├── FieldEmail
            ├── FieldDate
            ├── FieldDateTime
            ├── FieldParagraph
            ├── FieldBool
            └── FieldPickText
```

### Field Type Classification

| Type             | Category  | Has FieldState | Component File      |
|------------------|-----------|----------------|---------------------|
| `text`           | Leaf      | Yes            | `FieldText.kt`      |
| `email`          | Leaf      | Yes            | `FieldEmail.kt`     |
| `number`         | Leaf      | Yes            | `FieldNumber.kt`    |
| `decimal`        | Leaf      | Yes            | `FieldDecimal.kt`   |
| `date`           | Leaf      | Yes            | `FieldDate.kt`      |
| `dateTime`       | Leaf      | Yes            | `FieldDateTime.kt`  |
| `paragraph`      | Leaf      | Yes            | `FieldParagraph.kt` |
| `bool`           | Leaf      | Yes            | `FieldBool.kt`      |
| `pickText`       | Leaf      | Yes            | `FieldPickText.kt`  |
| `section`        | Composite | No             | `FieldSection.kt`   |
| `tab`            | Composite | No             | `FieldTab.kt`       |
| `grid`           | Composite | No             | -                   |
| `wizard`         | Composite | No             | -                   |
| `spreadsheetRef` | Composite | No             | -                   |

---

## How-To Guides

### Adding a New Field Type

**Step 1: Create Field Component**

```kotlin
// presentation/components/field/FieldPhone.kt
@Composable
fun FieldPhone(
    defnComp: DefnCompSeal,
    modifier: Modifier = Modifier,
    onFieldEvent: (FieldEvent) -> Unit
) {
    val fieldController = rememberFieldController<FieldValueTextData>(
        defnComp = defnComp,
        onFieldEvent = onFieldEvent
    )

    val properties = fieldController.fieldProperties
    if (properties.hidden) return

    FieldBase(
        label = properties.label ?: defnComp.name,
        error = fieldController.error?.message,
        required = properties.required,
        helperText = properties.helperText,
        modifier = modifier
    ) {
        OutlinedTextField(
            value = fieldController.fieldValue?.value ?: "",
            onValueChange = { newValue ->
                fieldController.onChange(FieldValueTextData(value = newValue))
            },
            enabled = !properties.disabled,
            readOnly = properties.readOnly,
            placeholder = properties.placeholder?.let { { Text(it) } },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
            // ... other TextField props
        )
    }
}
```

**Step 2: Register in FieldFactory**

```kotlin
// presentation/components/base/FieldFactory.kt
@Composable
fun FieldFactory(defnComp: DefnCompSeal, ...) {
    when (defnComp.type) {
        EnumDefnCompType.phone -> FieldPhone(defnComp, modifier, onFieldEvent)
        // ... existing cases
    }
}
```

**Step 3: Add Value Conversion (if needed)**

```kotlin
// domain/util/FieldValueResolver.kt
object FieldValueResolver {
    fun fnRawValueToFieldValue(compType: EnumDefnCompType, value: Any?): Any? {
        return when (compType) {
            EnumDefnCompType.phone -> value?.let { FieldValueTextData(it.toString()) }
            // ... existing cases
        }
    }
}
```

**Step 4: Update FormInitializer (if composite)**

```kotlin
// domain/reducer/FormInitializer.kt
private val COMPOSITE_TYPES = setOf(
    EnumDefnCompType.section,
    EnumDefnCompType.tab,
    // Add new composite type here if applicable
)
```

### Adding a Validation Rule

**Simple Field Validation:**

```kotlin
// domain/reducer/FormReducer.kt
private fun validateField(
    fieldId: MetaIdComp,
    fieldState: FieldState,
    defnComp: DefnComp,
    state: FormState
): String? {
    val value = fieldState.value
    val props = fieldState.fieldProperties

    // Required check
    if (props.required && value == null) {
        return "This field is required"
    }

    // Type-specific validation
    return when (defnComp.type) {
        EnumDefnCompType.email -> validateEmail(value)
        EnumDefnCompType.phone -> validatePhone(value)
        EnumDefnCompType.number -> validateNumber(value, defnComp)
        else -> null
    }
}

private fun validateEmail(value: JsonElement?): String? {
    val email = value?.jsonPrimitive?.contentOrNull ?: return null
    val emailPattern = Patterns.EMAIL_ADDRESS
    return if (!emailPattern.matcher(email).matches()) {
        "Invalid email format"
    } else null
}

private fun validatePhone(value: JsonElement?): String? {
    val phone = value?.jsonPrimitive?.contentOrNull ?: return null
    return if (!phone.matches(Regex("^\\+?[0-9]{10,15}$"))) {
        "Invalid phone number"
    } else null
}
```

### Adding Cross-Field Validation

```kotlin
// domain/reducer/FormReducer.kt
private fun validateField(...): String? {
    // ... existing validation

    // Cross-field validation
    return when (defnComp.type) {
        EnumDefnCompType.passwordConfirm -> {
            val passwordFieldId = defnComp.passwordFieldId ?: return null
            val password = state.fieldStates[passwordFieldId]?.value
            val confirm = fieldState.value

            if (password != null && confirm != null && password != confirm) {
                "Passwords do not match"
            } else null
        }

        EnumDefnCompType.endDate -> {
            val startFieldId = defnComp.startDateFieldId ?: return null
            val startDate = state.fieldStates[startFieldId]?.value
            val endDate = fieldState.value

            if (startDate != null && endDate != null) {
                val start = parseDate(startDate)
                val end = parseDate(endDate)
                if (end.isBefore(start)) "End date must be after start date" else null
            } else null
        }

        else -> null
    }
}
```

### Adding Async Validation

```kotlin
// 1. Add state tracking
@Immutable
data class FormState(
    // ... existing fields
    val asyncValidatingFields: Set<MetaIdComp> = emptySet()
)

// 2. Add events
sealed interface FormEvent {
    // ... existing events
    data class AsyncValidateField(val fieldId: MetaIdComp) : FormEvent
    data class AsyncValidationComplete(
        val fieldId: MetaIdComp,
        val error: String?
    ) : FormEvent
}

// 3. In parent ViewModel, handle async validation
class FormScreenViewModel @Inject constructor(
    private val validateUsernameUseCase: ValidateUsernameUseCase
) : ViewModel() {

    fun onFormIntent(intent: FormIntent) {
        when (intent) {
            is FormIntent.Watch -> {
                if (intent.fieldId == usernameFieldId) {
                    validateUsernameAsync(intent.fieldValue)
                }
            }
            // ...
        }
    }

    private fun validateUsernameAsync(value: JsonElement?) {
        viewModelScope.launch {
            val username = value?.jsonPrimitive?.contentOrNull ?: return@launch
            val isAvailable = validateUsernameUseCase(username)
            if (!isAvailable) {
                formRef.setError(usernameFieldId, "Username already taken")
            }
        }
    }
}
```

### Adding Property Resolution

```kotlin
// 1. Add property to FieldProperties
@Immutable
data class FieldProperties(
    // ... existing
    val minValue: Int? = null,
    val maxValue: Int? = null
)

// 2. Add resolver in FieldPropertyResolver
object FieldPropertyResolver {
    fun resolveFieldProperties(
        defnComp: DefnComp,
        defnForm: DefnFormData,
        getFieldValue: (MetaIdComp) -> JsonElement?
    ): FieldProperties {
        return FieldProperties(
            // ... existing resolution
            minValue = resolveIntProperty(
                fieldId = defnComp.minValueFieldId,
                varName = defnComp.minValueVar,
                directValue = defnComp.minValue,
                defnForm = defnForm,
                getFieldValue = getFieldValue
            ),
            maxValue = resolveIntProperty(
                fieldId = defnComp.maxValueFieldId,
                varName = defnComp.maxValueVar,
                directValue = defnComp.maxValue,
                defnForm = defnForm,
                getFieldValue = getFieldValue
            )
        )
    }

    // 3. Add to dependency extraction
    fun extractFieldIdReferences(defnComp: DefnComp): Set<MetaIdComp> {
        return setOfNotNull(
            // ... existing
            defnComp.minValueFieldId,
            defnComp.maxValueFieldId
        )
    }
}
```

### Implementing Conditional Visibility

```kotlin
// In any field composable:
@Composable
fun FieldConditional(
    defnComp: DefnCompSeal,
    modifier: Modifier = Modifier,
    onFieldEvent: (FieldEvent) -> Unit
) {
    val fieldController = rememberFieldController<FieldValueTextData>(
        defnComp = defnComp,
        onFieldEvent = onFieldEvent
    )

    // Reactively observe properties for conditional rendering
    val properties by fieldController.fieldPropertiesFlow.collectAsStateWithLifecycle()

    // Early return if hidden - component not rendered
    if (properties.hidden) return

    // Render field normally
    FieldBase(...) {
        // ...
    }
}
```

### Implementing Formula Fields

```kotlin
// domain/util/CalcFormula.kt
object CalcFormula {
    fun eval(
        formula: String,
        getFieldValue: (MetaIdComp) -> JsonElement?
    ): JsonElement? {
        // Parse formula and evaluate
        // Example: "{field1} + {field2}"
        val result = parseAndEvaluate(formula, getFieldValue)
        return result?.let { JsonPrimitive(it) }
    }
}

// In FieldPropertyResolver
fun resolveFieldProperties(...): FieldProperties {
    val formulaValue = defnComp.formula?.let { formula ->
        CalcFormula.eval(formula, getFieldValue)
    }

    return FieldProperties(
        // ... if formula field, value is computed
    )
}
```

---

## Best Practices

### State Management

```kotlin
// CORRECT: Use copy() for immutable updates
_state.update { it.copy(isLoading = true) }

// CORRECT: Batch related updates
_state.update { state ->
    state.copy(
        fieldStates = state.fieldStates + (fieldId to newFieldState),
        errors = state.errors - fieldId
    )
}

// WRONG: Multiple separate updates
_state.update { it.copy(isLoading = true) }
_state.update { it.copy(error = null) }  // Causes extra recomposition
```

### Field Component Design

```kotlin
// CORRECT: Stateless field component
@Composable
fun FieldText(
    defnComp: DefnCompSeal,
    modifier: Modifier = Modifier,
    onFieldEvent: (FieldEvent) -> Unit
) {
    val fieldController = rememberFieldController<FieldValueTextData>(...)
    // UI only, no local state for value
}

// CORRECT: Use FieldBase for consistent styling
FieldBase(
    label = properties.label,
    error = fieldController.error?.message,
    required = properties.required,
    helperText = properties.helperText
) {
    // Field input
}

// CORRECT: Early return for hidden fields
if (properties.hidden) return
```

### Event Handling

```kotlin
// CORRECT: Single event handler pattern
fun onEvent(event: FormEvent) {
    when (event) {
        is FormEvent.FieldValueChanged -> handleFieldValueChanged(event)
        // ...
    }
}

// CORRECT: Emit intent for parent communication
private fun handleSubmit(state: FormState): FormReducerResult {
    return if (state.isValid) {
        FormReducerResult(
            state = state.copy(isSubmitting = true),
            intents = listOf(FormIntent.Submit(state.getValueMap()))
        )
    } else {
        FormReducerResult(state = state)
    }
}
```

### Performance

```kotlin
// CORRECT: Use derivedStateOf for computed values
val isFormValid by remember {
    derivedStateOf { formState.isValid }
}

// CORRECT: Use remember with keys for expensive operations
val filteredFields = remember(formState.fieldStates, filter) {
    formState.fieldStates.filter { it.matches(filter) }
}

// CORRECT: Collect with lifecycle awareness
val state by viewModel.state.collectAsStateWithLifecycle()
```

---

## Anti-Patterns

### State Anti-Patterns

```kotlin
// WRONG: Mutable state in FormState
data class FormState(
    var fieldStates: MutableMap<MetaIdComp, FieldState>  // Should be immutable
)

// WRONG: Side effects in reducer
fun reduce(state: FormState, event: FormEvent): FormState {
    api.logEvent(event)  // NO! Reducer must be pure
    return state.copy(...)
}

// WRONG: Storing derived state
data class FormState(
    val fieldStates: Map<MetaIdComp, FieldState>,
    val fieldCount: Int  // Derived from fieldStates.size - don't store
)
```

### Component Anti-Patterns

```kotlin
// WRONG: Local state for field value
@Composable
fun FieldText(...) {
    var text by remember { mutableStateOf("") }  // NO! Use fieldController
    // ...
}

// WRONG: Direct context access without null check
@Composable
fun FieldText(...) {
    val formCtx = LocalFormCtx.current  // Crashes if not in Form tree
}

// WRONG: Heavy computation in composable
@Composable
fun FieldWithValidation(...) {
    val isValid = expensiveValidation(value)  // Should be in ViewModel/reducer
}
```

### Event Anti-Patterns

```kotlin
// WRONG: Bypassing event system
class FormRefImpl {
    fun setValue(fieldId: MetaIdComp, value: JsonElement?) {
        _state.value = _state.value.copy(...)  // NO! Use events
    }
}

// CORRECT: Use events
fun setValue(fieldId: MetaIdComp, value: JsonElement?) {
    dispatch(FormEvent.FieldValueChanged(fieldId, value))
}

// WRONG: Circular event dispatch
fun handleFieldChanged(event: FieldValueChanged) {
    dispatch(FieldValueChanged(...))  // Infinite loop risk
}
```

---

## Troubleshooting

### Common Issues

| Issue                  | Cause                                   | Solution                                                     |
|------------------------|-----------------------------------------|--------------------------------------------------------------|
| Field not updating     | Missing dependency registration         | Check `extractFieldIdReferences()` includes the source field |
| Validation not running | `shouldValidate = false`                | Ensure `shouldValidate` parameter is true                    |
| FormCtx not found      | Field outside Form tree                 | Wrap component in Form or check hierarchy                    |
| Stale field state      | Not using `collectAsStateWithLifecycle` | Replace `collectAsState` with lifecycle-aware version        |
| Infinite recomposition | Unstable lambda/object in composable    | Use `remember` or move to ViewModel                          |
| Field not rendering    | `hidden = true` in properties           | Check property resolution logic                              |

### Debugging Tips

```kotlin
// 1. Log state changes
LaunchedEffect(formState) {
    Log.d("Form", "State: $formState")
}

// 2. Log events
fun dispatch(event: FormEvent) {
    Log.d("Form", "Event: $event")
    // ... actual dispatch
}

// 3. Inspect field dependencies
Log.d("Form", "Dependencies: ${formState.fieldDependencies}")

// 4. Check property resolution
val resolved = FieldPropertyResolver.resolveFieldProperties(
    defnComp, defnForm, ::getFieldValue
)
Log.d("Form", "Resolved properties for ${defnComp.metaId}: $resolved")
```

---

## File Structure

```
app/src/main/java/com/neome/feature/form/
│
├── domain/
│   ├── ctx/
│   │   ├── FormCtx.kt                 # Internal API interface
│   │   └── FormCtxImpl.kt             # Implementation
│   │
│   ├── reducer/
│   │   ├── FormReducer.kt             # Pure state reducer
│   │   └── FormInitializer.kt         # Initial state builder
│   │
│   ├── ref/
│   │   ├── FormRef.kt                 # External API interface
│   │   └── FormRefImpl.kt             # Implementation
│   │
│   └── util/
│       ├── FieldPropertyResolver.kt   # Dynamic property resolution
│       ├── FieldValueResolver.kt      # Type conversion
│       └── CalcFormula.kt             # Formula calculation
│
├── presentation/
│   ├── components/
│   │   ├── Form.kt                    # Root composable (provides LocalFormCtx)
│   │   │
│   │   ├── base/
│   │   │   ├── FieldBase.kt           # Common field wrapper
│   │   │   ├── FieldController.kt     # Field helper + rememberFieldController
│   │   │   └── FieldFactory.kt        # Type-based routing
│   │   │
│   │   ├── composite/
│   │   │   ├── FieldSection.kt        # Section container
│   │   │   └── FieldTab.kt            # Tab container
│   │   │
│   │   └── field/
│   │       ├── FieldText.kt
│   │       ├── FieldNumber.kt
│   │       ├── FieldDecimal.kt
│   │       ├── FieldEmail.kt
│   │       ├── FieldDate.kt
│   │       ├── FieldDateTime.kt
│   │       ├── FieldParagraph.kt
│   │       ├── FieldBool.kt
│   │       └── FieldPickText.kt
│   │
│   ├── screen/
│   │   ├── FormScreen.kt
│   │   └── FormScreenViewModel.kt
│   │
│   ├── sample/
│   │   └── FormSampleDataFactory.kt
│   │
│   └── state/
│       ├── FormState.kt
│       ├── FieldState.kt
│       ├── FormEvent.kt
│       ├── FormIntent.kt
│       ├── FieldEvent.kt
│       └── FieldError.kt
│
└── form.md                            # THIS FILE (skill documentation)
```

---

## Modification Protocol

### When to Update This File

Update this skill file when:

- New field type added
- New validation rule added
- New property resolution added
- State structure changed
- API signature changed
- Event/Intent added or modified
- New pattern/best practice discovered

### Version Bump Rules

| Change Type                      | Version Bump  |
|----------------------------------|---------------|
| Bug fixes, typos, clarifications | Patch (1.0.x) |
| New field types, new features    | Minor (1.x.0) |
| Breaking API changes             | Major (x.0.0) |

### Update Checklist

- [ ] Update relevant section(s)
- [ ] Update version number in Metadata
- [ ] Update Last Updated date
- [ ] Add changelog entry
- [ ] Verify code examples compile
- [ ] Update file structure if changed

---

## Dependencies

### External Libraries

| Library                      | Purpose                     |
|------------------------------|-----------------------------|
| `kotlinx.coroutines.flow`    | StateFlow, reactive streams |
| `kotlinx.serialization.json` | JsonElement, serialization  |
| Jetpack Compose              | UI framework                |
| Material3                    | Design components           |

### Internal (Neome)

| Type                        | Purpose                    |
|-----------------------------|----------------------------|
| `DefnFormData`              | Form schema definition     |
| `DefnComp`, `DefnCompSeal`  | Component definitions      |
| `MetaIdComp`, `MetaIdField` | Field identifiers          |
| `FieldValueXData`           | Typed field value wrappers |
| `FormValueRawData`          | Raw form data container    |

---

## Changelog

### v1.2.0 (2026-02-03)

- **Docs**: Complete restructure for improved readability and navigation
- **Added**: Table of Contents for quick navigation
- **Added**: Best Practices section with code examples
- **Added**: Anti-Patterns section with common mistakes
- **Added**: Troubleshooting section with solutions
- **Added**: How-To Guides for common tasks
- **Improved**: API Reference with grouped operations
- **Improved**: Code examples with more practical patterns
- **Improved**: Tables for better scanability

### v1.1.0 (2026-02-03)

- **BREAKING**: FormCtx now provided via `LocalFormCtx` CompositionLocal
- **BREAKING**: `rememberFieldController()` no longer takes `formCtx` parameter
- **BREAKING**: All field components no longer take `formCtx` parameter
- **Feature**: FormCtx is now a stable pointer (never recreated after Form init)
- **Feature**: FormCtx accessible from anywhere via `LocalFormCtx.current`
- **Internal**: Form.kt uses `rememberUpdatedState` pattern for stable dispatchEvent
- **Internal**: FieldController now reads formCtx from CompositionLocal internally

### v1.0.0 (2026-01-30)

- Initial skill documentation
- Core architecture: MVI + UDF
- Supported field types: text, email, number, decimal, date, dateTime, paragraph
- Composite types: section, tab
- Property resolution: direct, var, field reference
- Validation: required check
- Dependency tracking for dynamic properties
