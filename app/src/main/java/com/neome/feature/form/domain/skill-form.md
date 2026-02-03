# skill:defnForm

## Metadata

- **Version**: 1.0.0
- **Last Updated**: 2026-01-30
- **Scope**: Android Form Component Architecture
- **Path**: `app/src/main/java/com/neome/feature/form/`
- **Update Trigger**: Any modification to form component files must update this skill

---

## Quick Reference

```kotlin
// Usage pattern
using skill : defnForm do [instruction]

// Examples:
// - Add new field type X
// - Implement cross-field validation
// - Add formula calculation support
// - Fix validation bug in FieldNumber
// - Add async validation support
```

---

## Architecture Overview

### Pattern: MVI + UDF (Unidirectional Data Flow)

```
┌─────────────────────────────────────────────────────────────────────────────┐
│                              FORM ARCHITECTURE                               │
├─────────────────────────────────────────────────────────────────────────────┤
│                                                                              │
│   ┌──────────────┐    FormIntent     ┌──────────────┐                        │
│   │   Parent     │◄──────────────────│    Form      │                        │
│   │  (Screen/VM) │                   │  Component   │                        │
│   └──────┬───────┘                   └──────┬───────┘                        │
│          │                                  │                                │
│          │ FormRef API                      │ FormEvent                      │
│          │ (imperative)                     │ (reactive)                     │
│          ▼                                  ▼                                │
│   ┌──────────────┐                   ┌──────────────┐                        │
│   │   FormRef    │                   │ FormReducer  │                        │
│   │   (read/write│                   │   (pure fn)  │                        │
│   │   operations)│                   └──────┬───────┘                        │
│   └──────────────┘                          │                                │
│          ▲                                  │                                │
│          │                                  ▼                                │
│   ┌──────┴───────┐                   ┌──────────────┐                        │
│   │   FormCtx    │◄──────────────────│  FormState   │                        │
│   │ (field access│                   │ (single src) │                        │
│   │  & triggering)                   └──────────────┘                        │
│   └──────────────┘                                                           │
│          ▲                                                                   │
│          │ FieldEvent                                                        │
│   ┌──────┴───────┐                                                           │
│   │ Field Comps  │                                                           │
│   │ (Text/Number/│                                                           │
│   │  Date/etc.)  │                                                           │
│   └──────────────┘                                                           │
│                                                                              │
└─────────────────────────────────────────────────────────────────────────────┘
```

### Core Principles

1. **Single Source of Truth**: All state in `FormState` (immutable data class)
2. **Pure Reducer**: `FormReducer.reduce()` is side-effect free
3. **Reactive Updates**: StateFlow for UI observation
4. **Imperative API**: `FormRef` for parent control
5. **Context API**: `FormCtx` for field-to-field communication

---

## State Definitions

### FormState

```kotlin
@Immutable
data class FormState(
    val defnForm: DefnFormData? = null,           // Form definition (schema)
    val initialFormValue: FormValueRawData? = null,
    val fieldStates: Map<MetaIdComp, FieldState> = emptyMap(),
    val errors: Map<MetaIdComp, FieldError> = emptyMap(),
    val fieldDependencies: FieldDependencyMap = FieldDependencyMap(),
    val disabled: Boolean = false,
    val readOnly: Boolean = false,
    val isSubmitting: Boolean = false,
    val formError: String? = null,
    val isInitialized: Boolean = false
) {
    val hasErrors: Boolean get() = errors.isNotEmpty()
    val isDirty: Boolean get() = fieldStates.values.any { it.isDirty }
    val isValid: Boolean
        get() = !hasErrors && fieldStates.values.none {
            it.fieldProperties.required && it.value == null
        }
}
```

### FieldState

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

### FieldDependencyMap

```kotlin
@Immutable
data class FieldDependencyMap(
    val dependents: Map<MetaIdComp, Set<MetaIdComp>> = emptyMap()
    // Map: sourceFieldId -> set of fields that depend on it
)
```

---

## Event Taxonomy

### FormEvent (Internal Events)

| Event               | Purpose                                  | Handler                                               |
|---------------------|------------------------------------------|-------------------------------------------------------|
| `Initialize`        | Build dependency map, set initial values | `FormInitializer.initializeFormState()`               |
| `FieldValueChanged` | Update value, trigger dependents         | `handleFieldValueChanged()` → emits `Watch` intent    |
| `FieldFocused`      | Mark field focused                       | `handleFieldFocused()`                                |
| `FieldBlurred`      | Mark field touched+unfocused             | `handleFieldBlurred()`                                |
| `FieldTouched`      | Mark field touched                       | `handleFieldTouched()`                                |
| `TriggerField`      | Recalculate field properties             | `handleTriggerField()` → uses `FieldPropertyResolver` |
| `ValidateField`     | Validate single field                    | `handleValidateField()` → emits `ValidationResult`    |
| `ValidationResult`  | Apply validation result                  | `handleValidationResult()`                            |
| `ValidateAll`       | Validate all fields                      | `handleValidateAll()`                                 |
| `SetFieldError`     | Set custom error                         | `handleSetFieldError()`                               |
| `ClearFieldError`   | Clear field error                        | `handleClearFieldError()`                             |
| `ClearAllErrors`    | Clear all errors                         | `handleClearAllErrors()`                              |
| `Submit`            | Validate + submit if valid               | `handleSubmit()` → emits `Submit` intent              |
| `Reset`             | Reset to initial values                  | `handleReset()`                                       |
| `SetValues`         | Bulk value update                        | `handleSetValues()`                                   |

### FormIntent (External Communication)

| Intent                   | Direction     | Payload                                  |
|--------------------------|---------------|------------------------------------------|
| `Submit`                 | Form → Parent | `valueMap: Map<MetaIdComp, JsonElement>` |
| `Watch`                  | Form → Parent | `fieldId, fieldValue, valueMap`          |
| `ValidationStateChanged` | Form → Parent | `isValid, hasErrors`                     |

### FieldEvent (Field → Form)

| Event          | Emitted When             |
|----------------|--------------------------|
| `ValueChanged` | User changes field value |
| `Focused`      | Field gains focus        |
| `Blurred`      | Field loses focus        |

---

## API Surface

### FormRef (External API for Parents)

```kotlin
interface FormRef {
    // Read
    fun getValue(fieldId: MetaIdComp): JsonElement?
    fun getValues(): FormValueRawData?
    fun getValueMap(): Map<MetaIdComp, JsonElement>
    fun getFieldState(fieldId: MetaIdComp): FieldState?

    // Write
    fun setValue(fieldId: MetaIdComp, value: JsonElement?, shouldValidate: Boolean = true)
    fun setValues(valueMap: Map<MetaIdComp, JsonElement>, shouldValidate: Boolean = true)

    // Validation
    fun validate(fieldId: MetaIdComp? = null): Boolean
    fun setError(fieldId: MetaIdComp, error: String)
    fun clearErrors(fieldId: MetaIdComp? = null)

    // Operations
    fun submit()
    fun reset(valueMap: Map<MetaIdComp, JsonElement>? = null)

    // State Queries
    fun isDirty(fieldId: MetaIdComp? = null): Boolean
    fun isValid(fieldId: MetaIdComp? = null): Boolean
    fun isTouched(fieldId: MetaIdComp? = null): Boolean

    // Reactive
    fun watchFieldState(fieldId: MetaIdComp): StateFlow<FieldState?>
    fun watchFormState(): StateFlow<FormState>
}
```

### FormCtx (Internal API for Fields)

```kotlin
interface FormCtx {
    // Trigger dependent recalculation
    fun trigger(fieldId: MetaIdComp)

    // Value access
    fun getValues(): Map<MetaIdComp, JsonElement>
    fun getValue(fieldId: MetaIdComp): JsonElement?
    fun getFieldState(fieldId: MetaIdComp): FieldState?
    fun getError(fieldId: MetaIdComp): FieldError?
    fun hasField(fieldId: MetaIdComp): Boolean
    fun getDefnForm(): DefnFormData?

    // Validation
    fun validate(fieldId: MetaIdComp? = null): Boolean

    // Reactive
    fun watchFieldState(fieldId: MetaIdComp): StateFlow<FieldState?>
    fun watchFieldError(fieldId: MetaIdComp): StateFlow<FieldError?>
    fun watchFormState(): StateFlow<FormState>
}
```

### FieldController (Field Component Helper)

```kotlin
@Immutable
data class FieldController<T>(
    val fieldId: MetaIdField?,
    val fieldState: FieldState?,
    val fieldValue: T?,              // Deserialized typed value
    val error: FieldError?,
    val fieldProperties: FieldProperties,
    val fieldPropertiesFlow: StateFlow<FieldProperties>,
    val fieldStateFlow: StateFlow<FieldState?>,
    val onChange: (T?) -> Unit
)

@Composable
inline fun <reified T> rememberFieldController(
    defnComp: DefnCompSeal,
    onFieldEvent: (FieldEvent) -> Unit,
    formCtx: FormCtx
): FieldController<T>
```

---

## Component Hierarchy

```
Form (root Composable)
├── FormContent
│   └── FieldFactory (root component - typically Tab)
│       ├── FieldTab (composite)
│       │   └── FieldFactory (per tab)
│       │       └── FieldSection (composite)
│       │           └── FieldFactory (per child)
│       │               ├── FieldText (leaf)
│       │               ├── FieldNumber (leaf)
│       │               ├── FieldEmail (leaf)
│       │               ├── FieldDate (leaf)
│       │               ├── FieldDateTime (leaf)
│       │               ├── FieldDecimal (leaf)
│       │               └── FieldParagraph (leaf)
│       └── FieldSection (composite - direct child of tab)
│           └── [same as above]
```

### Composite Types (No FieldState)

- `grid`, `section`, `tab`, `wizard`, `spreadsheetRef`

### Leaf Field Types (Have FieldState)

- `text`, `email`, `number`, `decimal`, `date`, `dateTime`, `paragraph`, `bool`, `pickText`

---

## Business Logic

### Property Resolution (FieldPropertyResolver)

Properties resolved in priority order:

1. `*FieldId` - Value from another field (dynamic)
2. `*Var` - Variable resolution (static/config)
3. Direct value from `defnComp.*`

```kotlin
object FieldPropertyResolver {
    fun resolveFieldProperties(
        defnComp: DefnComp,
        defnForm: DefnFormData,
        getFieldValue: (MetaIdComp) -> JsonElement?
    ): FieldProperties

    fun buildDependencyMap(compMap: Map<MetaIdComp, DefnComp>): FieldDependencyMap
}
```

### Dependency Tracking

When FieldA changes:

1. `FormReducer.handleFieldValueChanged()` called
2. Gets dependents: `state.fieldDependencies.getDependents(FieldA.id)`
3. Calls `triggerDependentFields()` - batches all updates
4. Each dependent's properties recalculated via `FieldPropertyResolver`
5. Single state update with all changes

### Validation Flow

```
1. FormEvent.ValidateField → handleValidateField()
2. Mark field as validating
3. Call validateField() - returns error String? or null
4. Emit FormEvent.ValidationResult
5. handleValidationResult() updates errors map
6. Clear isValidating flag
```

Current validation rules:

- Required check: `fieldProperties.required && value == null`
- Returns: `"This field is required"` or null

### Value Conversion (FieldValueResolver)

```kotlin
object FieldValueResolver {
    fun fnRawValueToFieldValue(compType: EnumDefnCompType, value: Any?): Any?
    fun fnFieldValueToRawValue(compType: EnumDefnCompType, value: Any?): Any?
}
```

Supports: text, email, date, paragraph, number, decimal

---

## Threading Model

| Component               | Threading                                              |
|-------------------------|--------------------------------------------------------|
| `FormReducer`           | Main thread (pure function, fast)                      |
| `FormRefImpl`           | Main thread (delegates to events)                      |
| `FormCtxImpl`           | Main thread (StateFlow operations)                     |
| StateFlow subscriptions | `Dispatchers.Default` for mapping, UI collects on Main |
| `watchFieldState()`     | `SharingStarted.WhileSubscribed(5000)`                 |

---

## Extension Points

### Adding New Field Type

1. Create `FieldX.kt` in `presentation/components/field/`
2. Add case in `FieldFactory.kt` when `defnComp.type == EnumDefnCompType.x`
3. Implement using `rememberFieldController<XValueData>()`
4. Add value conversion in `FieldValueResolver`
5. Update COMPOSITE_TYPES in `FormInitializer` if container type

### Adding Validation Rule

1. Modify `FormReducer.validateField()`
2. Add rule based on `defnComp.type` or custom property
3. Return error message or null

### Adding Property Resolution

1. Add property to `FieldProperties`
2. Add resolver in `FieldPropertyResolver`
3. Add `*FieldId` extraction in `extractFieldIdReferences()`
4. Update dependent triggering if dynamic

### Custom Form Behavior

Extend `FormReducer.reduce()` with new `FormEvent` subtype:

```kotlin
// 1. Add to FormEvent sealed interface
data class CustomAction(val data: X) : FormEvent

// 2. Add handler in FormReducer
private fun handleCustomAction(state: FormState, event: CustomAction): FormReducerResult

// 3. Add case in reduce() when expression
```

---

## Error Handling

### Error Types

```kotlin
data class FieldError(
    val message: String,
    val type: ErrorType = ErrorType.Validation
)

enum class ErrorType { Validation, Custom, Server }
```

### Error Flow

1. Validation errors: Auto-cleared on value change
2. Custom errors: Set via `FormRef.setError()`, cleared via `clearErrors()`
3. Server errors: Set via `FormRef.setError()` after API failure

### Error Display

Fields access errors via `fieldController.error` and display in UI.

---

## File Structure

```
app/src/main/java/com/neome/feature/form/
├── domain/
│   ├── ctx/
│   │   ├── FormCtx.kt           # Interface
│   │   └── FormCtxImpl.kt       # Implementation
│   ├── reducer/
│   │   ├── FormReducer.kt       # Pure state reducer
│   │   └── FormInitializer.kt   # Initial state builder
│   ├── ref/
│   │   ├── FormRef.kt           # External API interface
│   │   └── FormRefImpl.kt       # External API implementation
│   └── util/
│       ├── FieldPropertyResolver.kt  # Dynamic property resolution
│       ├── FieldValueResolver.kt     # Type conversion
│       └── CalcFormula.kt            # Formula calculation (stub)
├── presentation/
│   ├── components/
│   │   ├── Form.kt              # Root form Composable
│   │   ├── base/
│   │   │   ├── FieldBase.kt     # Common field wrapper
│   │   │   ├── FieldController.kt   # Field helper
│   │   │   └── FieldFactory.kt      # Type-based routing
│   │   ├── composite/
│   │   │   ├── FieldSection.kt      # Section container
│   │   │   └── FieldTab.kt          # Tab container
│   │   └── field/
│   │       ├── FieldText.kt
│   │       ├── FieldNumber.kt
│   │       ├── FieldEmail.kt
│   │       ├── FieldDate.kt
│   │       ├── FieldDateTime.kt
│   │       ├── FieldDecimal.kt
│   │       └── FieldParagraph.kt
│   ├── screen/
│   │   ├── FormScreen.kt
│   │   └── FormScreenViewModel.kt
│   ├── sample/
│   │   └── FormSampleDataFactory.kt
│   └── state/
│       ├── FormState.kt
│       ├── FieldState.kt
│       ├── FormEvent.kt
│       ├── FormIntent.kt
│       ├── FieldEvent.kt
│       └── FieldError.kt
└── .ai/
    └── skill-form.md            # THIS FILE
```

---

## Modification Protocol

When modifying form component:

1. **Update this skill file** if:
    - New field type added
    - New validation rule added
    - New property resolution added
    - State structure changed
    - API signature changed
    - Event/Intent added

2. **Version bump**:
    - Patch (1.0.x): Bug fixes, internal refactoring
    - Minor (1.x.0): New field types, new features
    - Major (x.0.0): Breaking API changes

3. **Update Last Updated** date

4. **Add to changelog**:

```markdown
### v1.0.1 (2026-01-30)

- Added: [feature]
- Fixed: [bug]
- Changed: [modification]
```

---

## Common Patterns

### Adding Async Validation

```kotlin
// 1. Add to FormState
val validatingFields: Set<MetaIdComp> = emptySet()

// 2. In FormReducer, emit side effect for async validation
// 3. Parent calls formRef.setError() or formRef.validate(fieldId) when done
```

### Cross-Field Validation

```kotlin
// In FormReducer.validateField():
when (defnComp.type) {
    EnumDefnCompType.passwordConfirm -> {
        val password = state.getValue(passwordFieldId)
        val confirm = fieldState.value
        if (password != confirm) "Passwords don't match" else null
    }
}
```

### Conditional Visibility

```kotlin
// In FieldX composable:
val properties by fieldController.fieldPropertiesFlow.collectAsStateWithLifecycle()
if (properties.hidden) return  // Early return = not rendered
```

### Formula Fields

```kotlin
// Extend FieldPropertyResolver.resolveFieldProperties():
val formulaValue = defnComp.formula?.let { formula ->
    CalcFormula.eval(formula, getFieldValue)
}
```

---

## Dependencies

### External

- `kotlinx.coroutines.flow.StateFlow`
- `kotlinx.serialization.json.JsonElement`
- Jetpack Compose
- Material3

### Internal (Neome)

- `DefnFormData`, `DefnComp`, `DefnCompSeal`
- `MetaIdComp`, `MetaIdField`
- `FieldValueXData` types
- `FormValueRawData`

---

## Changelog

### v1.0.0 (2026-01-30)

- Initial skill documentation
- Core architecture: MVI + UDF
- Supported field types: text, email, number, decimal, date, dateTime, paragraph
- Composite types: section, tab
- Property resolution: direct, var, field reference
- Validation: required check
- Dependency tracking for dynamic properties
