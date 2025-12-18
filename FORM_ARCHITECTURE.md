# Form Architecture - Android Compose MVI

## Quick Reference

**Purpose:** Centralized form state management with dynamic JSON-driven rendering (DefnForm)

**Key Classes:**

- `DefnForm` - Form structure definition (JSON-driven)
- `FormValueRaw` - Form data/values
- `FormState` - Centralized state container
- `FormRef` - Imperative API for external access
- `ComponentRendererFactory` - Factory pattern for rendering

**Location:**

- DefnForm: `app/src/main/java/com/neome/api/meta/base/dto/DefnForm.java`
- DefnComp: `app/src/main/java/com/neome/api/meta/base/dto/DefnComp.java`
- Form Feature: `app/src/main/java/com/neome/feature/form/`

**Implementation Status:**

- ✅ Core MVI architecture (State, Event, Effect)
- ✅ FormRef imperative API
- ✅ Validation framework
- ✅ Factory pattern rendering
- ✅ 7 field types (TEXT, EMAIL, PHONE, NUMBER, BOOL, PICK_TEXT, DATE)
- ✅ 2 composite types (TAB, SECTION)
- ✅ JSON parsing utilities
- ✅ Integrated in MainActivity
- ⏳ GRID renderer (pending)
- ⏳ Additional field types (URL, CURRENCY)

---

## Core Patterns

### 1. StateFlow (State Container)

- Single source of truth for all form data
- Thread-safe, survives config changes
- Holds: values, errors, isDirty, isValid, isSubmitting

### 2. Channel (One-Time Effects)

- Navigation, toasts, dialogs
- Consumed exactly once
- No duplicate events on rotation

### 3. Sealed Events (User Actions)

- Type-safe user interactions
- Single entry point: `onEvent(FormEvent)`

### 4. Sealed Effects (Side Effects)

- ShowToast, NavigateBack, ShowDialog
- Separate from state

### 5. Validation Use Cases

- Reusable validation logic
- Testable in isolation

### 6. Factory Pattern (Rendering)

- `ComponentRendererFactory` creates renderers
- Easy to add new field types
- Each renderer implements `ComponentRenderer`

---

## Data Structures

### FormState

```kotlin
data class FormState(
    val fields: Map<String, FieldState<*>> = emptyMap(),
    val errors: Map<String, String?> = emptyMap(),
    val isDirty: Boolean = false,
    val isValid: Boolean = false,
    val isSubmitting: Boolean = false,
    val touchedFields: Set<String> = emptySet(),
    val dependencies: Map<String, List<String>> = emptyMap()
)
```

### FieldState

```kotlin
data class FieldState<T>(
    val value: T,
    val defaultValue: T,
    val isRequired: Boolean = false,
    val isDisabled: Boolean = false,
    val isTouched: Boolean = false,
    val isDirty: Boolean = false,
    val validationRules: List<ValidationRule<T>> = emptyList(),
    val dependsOn: List<String> = emptyList()
)
```

### FormEvent

```kotlin
sealed interface FormEvent {
    data class UpdateField<T>(val fieldId: String, val value: T) : FormEvent
    data class BlurField(val fieldId: String) : FormEvent
    data class ValidateField(val fieldId: String) : FormEvent
    data object ValidateAll : FormEvent
    data object Submit : FormEvent
    data object Reset : FormEvent
}
```

### FormEffect

```kotlin
sealed interface FormEffect {
    data class NavigateToDetail(val id: String) : FormEffect
    data class ShowSnackbar(val message: String) : FormEffect
    data object NavigateBack : FormEffect
}
```

---

## DefnForm (JSON-Driven Forms)

### Structure Overview

**Important**: DefnForm is created from JSON **outside** the form component. The component receives
an already-parsed DefnForm instance.

**DefnForm** (Structure Definition)

- `compMap: Map<MetaIdComp, DefnComp>` - Component registry
- `displayCompositeId: MetaIdComposite` - Root component ID
- Defines layout hierarchy
- **Source**: Parsed from JSON externally, passed to component as object

**DefnComp** (Component Base)

- `name: Symbol` - Component name
- `type: EnumDefnCompType` - Component type
- `disabled: Boolean?` - Disabled state
- `hidden: Boolean?` - Visibility
- `label: String?` - Display label
- `permissionMatrix: DefnDtoPermissionMatrix`
- Padding: `pt, pb, pl, pr`

**FormValueRaw** (Actual Data)

- `valueMap: Map<MetaIdComp, JsonElement>` - Field values
- `rowId: RowId` - Unique form submission ID
- Audit: `createdOn`, `createdBy`, `updatedOn`, `updatedBy`

**FieldValueGrid** (Grid Data)

- `keys: RowId[]` - Ordered row IDs
- `map: Map<RowId, FieldDtoGridRow>` - Row data

**FieldDtoGridRow** (Single Row)

- `valueMap: Map<MetaIdField, Object>` - Field values in row
- `rowId: RowId` - Row ID
- Audit fields

### Component Types

**Composites (Containers):**

- ✅ `TAB` - Tab container (`tabIdSet`) - **IMPLEMENTED**
- ✅ `SECTION` - Vertical section (`fieldIdSet`) - **IMPLEMENTED**
- ⏳ `GRID` - Repeatable rows (`fieldIdSet`) - TODO

**Fields:**

- ✅ `TEXT` - Single line text input - **IMPLEMENTED**
- ✅ `EMAIL` - Email input with validation - **IMPLEMENTED**
- ✅ `PHONE` - Phone number input - **IMPLEMENTED**
- ⏳ `URL` - URL input - TODO
- ✅ `NUMBER` - Numeric input - **IMPLEMENTED**
- ⏳ `CURRENCY` - Currency input with formatting - TODO
- ✅ `BOOL` - Toggle/Switch - **IMPLEMENTED**
- ✅ `PICK_TEXT` - Dropdown select - **IMPLEMENTED**
- ✅ `DATE` - Date picker - **IMPLEMENTED** (basic)

### Rendering Algorithm

```
1. Start at compMap[displayCompositeId]
2. Get renderer from ComponentRendererFactory.getRenderer(type)
3. renderer.Render(defnComp, defnForm, formRef)
4. For composites: recursively render children using factory
5. For fields: render input component with FormRef
```

---

## FormRef (Imperative API)

### Purpose

External access to form state (like React Hook Form's ref)

### Key Methods

```kotlin
interface FormRef {
    fun <T> getValue(fieldId: String): T?
    fun getValues(): Map<String, Any?>
    fun <T> setValue(fieldId: String, value: T, shouldValidate: Boolean = true)
    fun setValues(values: Map<String, Any?>, shouldValidate: Boolean = true)
    fun trigger(fieldId: String? = null): Boolean
    fun reset(values: Map<String, Any?>? = null)
    fun clearErrors(fieldId: String? = null)
    fun setError(fieldId: String, error: String)
    fun <T> watch(fieldId: String): StateFlow<T?>
    fun isDirty(fieldId: String? = null): Boolean
    fun isValid(fieldId: String? = null): Boolean
}
```

### Usage

```kotlin
val formRef = viewModel.formRef

// Get value
val email = formRef.getValue<String>("email")

// Set values (prefill)
formRef.setValues(mapOf("email" to "user@example.com"))

// Validate
val isValid = formRef.trigger()

// Watch changes
val country by formRef.watch<String>("country").collectAsStateWithLifecycle()
```

---

## Factory Pattern Implementation

### ComponentRendererFactory

```kotlin
object ComponentRendererFactory {
    @Composable
    fun render(
        defnComp: DefnComp,
        defnForm: DefnForm,
        formRef: FormRef,
        modifier: Modifier = Modifier
    ) {
        if (defnComp.hidden == true || defnComp.invisible == true) return

        val renderer = getRenderer(defnComp.type)
        renderer.Render(defnComp, defnForm, formRef, modifier)
    }

    private fun getRenderer(type: EnumDefnCompType): ComponentRenderer {
        return when (type) {
            EnumDefnCompType.TAB -> TabRenderer
            EnumDefnCompType.SECTION -> SectionRenderer
            EnumDefnCompType.GRID -> GridRenderer
            EnumDefnCompType.TEXT -> TextFieldRenderer
            EnumDefnCompType.BOOL -> BoolFieldRenderer
            EnumDefnCompType.NUMBER -> NumberFieldRenderer
            EnumDefnCompType.PICK_TEXT -> PickTextFieldRenderer
            EnumDefnCompType.DATE -> DateFieldRenderer
            EnumDefnCompType.EMAIL -> EmailFieldRenderer
            else -> UnsupportedRenderer
        }
    }
}
```

### ComponentRenderer Interface

```kotlin
interface ComponentRenderer {
    @Composable
    fun Render(
        defnComp: DefnComp,
        defnForm: DefnForm,
        formRef: FormRef,
        modifier: Modifier = Modifier
    )
}
```

### Adding New Field Type

```kotlin
// 1. Create renderer
object CurrencyFieldRenderer : ComponentRenderer {
    @Composable
    override fun Render(defnComp: DefnComp, defnForm: DefnForm, formRef: FormRef, modifier: Modifier) {
        val fieldId = defnComp.name.value
        val value by formRef.watch<Double>(fieldId).collectAsStateWithLifecycle()

        OutlinedTextField(
            value = formatCurrency(value),
            onValueChange = { formRef.setValue(fieldId, parseCurrency(it)) },
            label = { Text(defnComp.label ?: defnComp.name.value) },
            prefix = { Text("$") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal)
        )
    }
}

// 2. Add to factory
EnumDefnCompType.CURRENCY -> CurrencyFieldRenderer
```

---

## Naming Conventions

### File Naming Rules

All form-related files follow strict naming conventions for consistency and clarity:

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

**Examples:**

```kotlin
// ✅ CORRECT
FieldText.kt
FieldEmail.kt
FieldBool.kt

// ❌ WRONG
TextField.kt         // Too generic
TextFieldComponent.kt  // Redundant suffix
InputField.kt        // Missing type
```

#### Composite Components (Containers)

**Pattern**: `Field{Type}.kt` (same as fields for consistency)

- `FieldTab.kt` - Tab container component
- `FieldSection.kt` - Section container component
- `FieldGrid.kt` - Grid/repeatable rows component

**Examples:**

```kotlin
// ✅ CORRECT
FieldTab.kt
FieldSection.kt
FieldGrid.kt

// ❌ WRONG
TabRenderer.kt      // Use Field prefix
SectionComponent.kt // Use Field prefix
GridContainer.kt    // Use Field prefix
```

#### Main Form Components

**Pattern**: `Form{Purpose}.kt` or `Form.kt` for main screen

- `Form.kt` - Main dynamic form screen
- `FormRef.kt` - FormRef interface
- `FormRefImpl.kt` - FormRef implementation
- `FormState.kt` - Form state data class
- `FormEvent.kt` - Form events sealed interface
- `FormEffect.kt` - Form effects sealed interface
- `FormViewModel.kt` - Form view model

**Examples:**

```kotlin
// ✅ CORRECT
Form.kt             // Main form screen
FormRef.kt
FormState.kt
FormViewModel.kt

// ❌ WRONG
DynamicForm.kt      // Type should be prefix
FormScreen.kt       // Redundant suffix
```

#### Utility/Helper Files

**Pattern**: `Plus{FeatureName}.kt`

- `PlusDefnForm.kt` - DefnForm extension functions
- `PlusFormValueRaw.kt` - FormValueRaw extension functions
- `PlusValidation.kt` - Validation utilities
- `PlusFormMapper.kt` - Mapping utilities
- `PlusFormParser.kt` - JSON parsing utilities
- `PlusFieldExtractor.kt` - Field extraction utilities

**Examples:**

```kotlin
// ✅ CORRECT
PlusDefnForm.kt
PlusValidation.kt
PlusFormMapper.kt

// ❌ WRONG
DefnFormUtils.kt      // Use Plus prefix
FormExtensions.kt     // Use Plus prefix
ValidationHelper.kt   // Use Plus prefix
FormMapperUtil.kt     // Use Plus prefix
```

### Package Structure Example

```
feature/form/
├── presentation/
│   ├── components/
│   │   ├── field/
│   │   │   ├── FieldText.kt
│   │   │   ├── FieldEmail.kt
│   │   │   ├── FieldPhone.kt
│   │   │   ├── FieldNumber.kt
│   │   │   ├── FieldBool.kt
│   │   │   ├── FieldPickText.kt
│   │   │   ├── FieldDate.kt
│   │   │   ├── FieldCurrency.kt
│   │   │   └── FieldUrl.kt
│   │   ├── composite/
│   │   │   ├── FieldTab.kt
│   │   │   ├── FieldSection.kt
│   │   │   └── FieldGrid.kt
│   │   └── factory/
│   │       └── ComponentRendererFactory.kt
│   ├── screen/
│   │   └── Form.kt
│   ├── state/
│   │   ├── FormState.kt
│   │   ├── FormEvent.kt
│   │   └── FormEffect.kt
│   ├── viewmodel/
│   │   └── FormViewModel.kt
│   └── ref/
│       ├── FormRef.kt
│       └── FormRefImpl.kt
├── domain/
│   ├── model/
│   │   └── ValidationRule.kt
│   └── usecase/
│       └── ValidateFieldUseCase.kt
└── util/
    ├── PlusDefnForm.kt
    ├── PlusFormValueRaw.kt
    ├── PlusValidation.kt
    ├── PlusFormMapper.kt
    └── PlusFormParser.kt
```

### Naming Benefits

1. **Consistency** - All field components use `Field{Type}` pattern
2. **Clarity** - File purpose is immediately clear from name
3. **Grouping** - Files naturally group by prefix (Field*, Form*, Plus*)
4. **Searchability** - Easy to find all fields, forms, or utilities
5. **Scalability** - Pattern extends to new field types seamlessly

---

## ViewModel Pattern

```kotlin
@HiltViewModel
class DynamicFormViewModel @Inject constructor(
    private val submitFormUseCase: SubmitFormUseCase
) : ViewModel() {

    private val _formState = MutableStateFlow(FormState())
    val formState = _formState.asStateFlow()

    private val _effect = Channel<FormEffect>()
    val effect = _effect.receiveAsFlow()

    val formRef: FormRef by lazy { FormRefImpl(this) }

    fun initializeFromDefnForm(defnForm: DefnForm, formValueRaw: FormValueRaw? = null) {
        _formState.value = defnForm.toFormState(formValueRaw)
    }

    fun onEvent(event: FormEvent) {
        when (event) {
            is FormEvent.UpdateField<*> -> handleUpdateField(event)
            is FormEvent.ValidateField -> validateField(event.fieldId)
            is FormEvent.Submit -> submitForm()
            // ... other events
        }
    }

    private fun submitForm() {
        validateAllFields()
        if (!_formState.value.isValid) return

        viewModelScope.launch {
            _formState.update { it.copy(isSubmitting = true) }

            when (val result = submitFormUseCase(formState.value.toFormValueRaw())) {
                is Resource.Success -> _effect.send(FormEffect.NavigateBack)
                is Resource.Error -> _formState.update { it.copy(submitError = result.message) }
            }
        }
    }
}
```

---

## Screen Pattern

```kotlin
@Composable
fun Form(
    defnForm: DefnForm,  // Already parsed outside component
    formValueRaw: FormValueRaw? = null,  // Already parsed outside component
    viewModel: FormViewModel = hiltViewModel()
) {
    LaunchedEffect(defnForm) {
        viewModel.initializeFromDefnForm(defnForm, formValueRaw)
    }

    val formState by viewModel.formState.collectAsStateWithLifecycle()
    val formRef = viewModel.formRef

    LaunchedEffect(Unit) {
        viewModel.effect.collect { effect ->
            when (effect) {
                is FormEffect.NavigateBack -> onNavigateBack()
                is FormEffect.ShowSnackbar -> showSnackbar(effect.message)
            }
        }
    }

    Scaffold(
        bottomBar = {
            Button(
                onClick = { viewModel.onEvent(FormEvent.Submit) },
                enabled = formState.isValid && !formState.isSubmitting
            ) {
                Text("Submit")
            }
        }
    ) { padding ->
        ComponentRendererFactory.render(
            defnComp = defnForm.compMap[defnForm.displayCompositeId]!!,
            defnForm = defnForm,
            formRef = formRef,
            modifier = Modifier.padding(padding)
        )
    }
}
```

---

## Grid Rendering

### Concept

Grids store `FieldValueGrid` with multiple rows. Each row has own `valueMap`.

### Implementation

```kotlin
object GridRenderer : ComponentRenderer {
    @Composable
    override fun Render(defnComp: DefnComp, defnForm: DefnForm, formRef: FormRef, modifier: Modifier) {
        val gridId = defnComp.name.value
        val gridValue by formRef.watch<FieldValueGrid>(gridId).collectAsStateWithLifecycle()
        val fieldIdSet = extractFieldIdSet(defnComp)

        Column {
            gridValue?.keys?.forEach { rowId ->
                val rowData = gridValue.map[rowId]

                Card {
                    fieldIdSet.forEach { fieldId ->
                        val cellValue = rowData?.valueMap?.get(fieldId)
                        RenderGridCell(
                            defnComp = defnForm.compMap[fieldId]!!,
                            cellValue = cellValue,
                            onValueChange = { newValue ->
                                updateGridCell(formRef, gridId, rowId, fieldId, newValue)
                            }
                        )
                    }
                }
            }

            Button(onClick = { addGridRow(formRef, gridId) }) {
                Text("Add Row")
            }
        }
    }
}
```

---

## Validation Rules

```kotlin
sealed interface ValidationRule<T> {
    fun validate(value: T, allFields: Map<String, FieldState<*>>): ValidationResult

    data class Required<T>(val message: String = "Required") : ValidationRule<T>
    data class MinLength(val min: Int) : ValidationRule<String>
    data class Email(val message: String = "Invalid email") : ValidationRule<String>
    data class MatchesField<T>(val otherFieldId: String, val message: String) : ValidationRule<T>
    data class Custom<T>(val message: String, val validator: (T) -> Boolean) : ValidationRule<T>
}

sealed interface ValidationResult {
    data object Success : ValidationResult
    data class Error(val message: String) : ValidationResult
}
```

---

## Field Dependencies

### Concept

Fields can depend on other fields for validation/visibility.

### Implementation

```kotlin
// In FormState
data class FormState(
    val dependencies: Map<String, List<String>> = emptyMap()
    // "password" -> ["confirmPassword"] means confirmPassword depends on password
)

// When password changes, re-validate confirmPassword
private fun handleUpdateField(event: FormEvent.UpdateField<*>) {
    // ... update field

    // Re-validate dependent fields
    formState.value.dependencies[event.fieldId]?.forEach { dependentField ->
        validateField(dependentField)
    }
}
```

---

## Data Flow

```
JSON (External)                    DefnForm (Parsed Outside)
    ↓                                      ↓
    Parse (Outside Component)      →   Component receives
    ↓                                      ↓
DefnForm (Structure)               FormValueRaw (Data)
├─ displayCompositeId          →   ├─ valueMap
├─ compMap                          │  ├─ "email": "user@example.com"
   ├─ "email": DefnComp             │  ├─ "age": 25
   │  └─ type: TEXT                 │  └─ "phones": FieldValueGrid
   ├─ "age": DefnComp               │     ├─ keys: ["row1", "row2"]
   │  └─ type: NUMBER               │     └─ map:
   └─ "phones": DefnComp            │        ├─ row1: {phone: "555-1234"}
      └─ type: GRID                 │        └─ row2: {phone: "555-5678"}
         └─ fieldIdSet: ["phone"]
            ↓
      Passed to Component
            ↓
User Input → FormEvent → ViewModel → FormState → UI Recompose
                                   → FormRef (external access)
```

---

## Key Principles

1. **Unidirectional Flow** - UI → Event → ViewModel → State → UI
2. **Single Source of Truth** - FormState holds everything
3. **Separation of Concerns** - Validation in use cases, rendering in factory
4. **Type Safety** - Sealed classes, generics
5. **Immutability** - State never mutated, always copied
6. **Lifecycle Awareness** - collectAsStateWithLifecycle
7. **Factory Pattern** - Easy to extend with new field types
8. **JSON-Driven** - Forms defined by DefnForm, no code changes needed

---

## When to Use

✅ **Use this architecture for:**

- Dynamic forms from server (DefnForm)
- Complex multi-step forms
- Forms with 5+ fields
- Field dependencies
- Grid/repeatable fields
- Async validation
- Draft saving

❌ **Don't use for:**

- Simple 1-2 field forms (use basic MVVM)
- Static forms (hardcode Composables)
- Display-only screens

---

## AI Implementation Checklist

### Setup

- [ ] Create FormState, FieldState data classes
- [ ] Create FormEvent sealed interface
- [ ] Create FormEffect sealed interface
- [ ] Create FormRef interface + implementation
- [ ] Create ValidationRule sealed interface

### Factory Pattern

- [ ] Create ComponentRenderer interface
- [ ] Create ComponentRendererFactory object
- [ ] Create renderer for each field type (TAB, SECTION, GRID, TEXT, BOOL, etc.)
- [ ] Add getRenderer mapping in factory

### ViewModel

- [ ] Create ViewModel with StateFlow<FormState>
- [ ] Create Channel<FormEffect>
- [ ] Expose FormRef
- [ ] Implement onEvent() handler
- [ ] Implement validation logic
- [ ] Implement submit logic

### Screen

- [ ] Receive DefnForm and FormValueRaw as parameters (already parsed)
- [ ] Initialize ViewModel with DefnForm + FormValueRaw in LaunchedEffect
- [ ] Collect state with collectAsStateWithLifecycle
- [ ] Collect effects with LaunchedEffect
- [ ] Call ComponentRendererFactory.render() with root component

### Testing

- [ ] Test individual renderers
- [ ] Test validation rules
- [ ] Test FormRef methods
- [ ] Test ViewModel event handling

---

## Common Patterns

### Prefill Form

```kotlin
LaunchedEffect(userId) {
    val user = loadUser(userId)
    formRef.setValues(mapOf(
        "name" to user.name,
        "email" to user.email
    ), shouldValidate = false)
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

### Unsaved Changes Warning

```kotlin
BackHandler {
    if (formRef.isDirty()) {
        showUnsavedDialog = true
    } else {
        onNavigateBack()
    }
}
```

### Auto-save Draft

```kotlin
LaunchedEffect(Unit) {
    while (true) {
        delay(30_000)
        if (formRef.isDirty()) {
            saveDraft(formRef.getValues())
        }
    }
}
```

---

## End of Document
