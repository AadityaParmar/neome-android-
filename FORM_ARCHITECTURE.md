# Form Architecture - Android Compose MVI

## Quick Reference

**Purpose:** Pure MVI form component with dynamic JSON-driven rendering (DefnForm)

**Key Classes:**

- `DefnForm` - Form structure definition (JSON-driven)
- `FormValueRaw` - Form data/values
- `FormState` - Configuration state (defnForm, initialFormValue only)
- `FormIntent` - Two intents: Submit and Watch
- `FormRef` - Imperative API for field operations
- `ComponentRendererFactory` - Factory pattern for rendering

**Core features:**

- ✅ Pure MVI architecture (State, Intent)
- ✅ Simplified state (configuration only)
- ✅ Two intents for external communication
- ✅ FormRef imperative API for field operations
- ✅ No ViewModel dependency in Form component
- ✅ Factory pattern rendering

---

## Core Patterns

### 1. Pure MVI Architecture

- **State**: FormState with only configuration (defnForm, initialFormValue)
- **View**: Form as pure function of state
- **Intent**: Two intents (Submit, Watch) for external communication
- No ViewModel dependency in Form component

### 2. Simplified State Management

- FormState holds ONLY configuration data
- All runtime state (field values, errors, validation) managed by FormRef
- Single source of truth: Parent component manages state

### 3. FormIntent (User Actions)

- Only two intents for external communication:
    - `Submit(FormValueRaw)` - Form submission with complete data
    - `Watch(fieldId, fieldValue, formValue)` - Field change notifications
- All field operations go through FormRef imperative API

### 4. FormRef Imperative API

- Provides field operations: getValue, setValue, getValues, setValues
- Manages runtime state internally (not in FormState)
- Used by component renderers for field access

### 5. Factory Pattern (Rendering)

- `ComponentRendererFactory` creates renderers
- Easy to add new field types
- Each renderer implements `ComponentRenderer`

---

## Data Structures

### FormState (Simplified - Pure MVI)

```kotlin
data class FormState(
    val defnForm: DefnForm? = null,
    val initialFormValue: FormValueRaw? = null
)
```

**Philosophy**: FormState contains ONLY configuration data (form structure and initial values). All
runtime state (field values, errors, validation, dirty state) is managed by FormRef, which provides
an imperative API.

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

### FormIntent (Simplified - Pure MVI)

```kotlin
sealed interface FormIntent {
    data class Submit(val formValue: FormValueRaw) : FormIntent
    data class Watch(
        val fieldId: String,
        val fieldValue: Any?,
        val formValue: FormValueRaw
    ) : FormIntent
}
```

**Philosophy**: Only two intents for external communication:

- `Submit`: Called when form is submitted with complete form data
- `Watch`: Called when field changes, providing field ID, field value, and complete form data

All other operations (field updates, validation, etc.) are handled through FormRef imperative API.

### FormEvent (Deprecated - Used internally by FormRef)

```kotlin
sealed interface FormEvent {
    data class UpdateField<T>(val fieldId: String, val value: T) : FormEvent
    data class SetValues(val formValueRaw: FormValueRaw) : FormEvent
    data class BlurField(val fieldId: String) : FormEvent
    data class ValidateField(val fieldId: String) : FormEvent
    data object ValidateAll : FormEvent
    data object Submit : FormEvent
    data object Reset : FormEvent
    data class SetError(val fieldId: String, val error: String) : FormEvent
    data class ClearErrors(val fieldId: String? = null) : FormEvent
}
```

**Note**: FormEvent is kept for internal use by FormRef but is not exposed in the public Form API.

---

## DefnForm

### Structure Overview

**DefnForm** (Structure Definition)

- `compMap: Map<MetaIdComp, DefnComp>` - Component registry
- `displayCompositeId: MetaIdComposite` - Root component ID
- Defines layout hierarchy
- **Source**: Parsed from JSON externally, passed to component as object

**DefnComp** (Component Base)

- `name: Symbol` - Component name
- `type: EnumDefnCompType` - Component type
- `metaId MetaIdField` - Component Unique Id

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
    fun getValues(): FormValueRaw?
    fun <T> setValue(fieldId: String, value: T, shouldValidate: Boolean = true)
    fun setValues(formValueRaw: FormValueRaw, shouldValidate: Boolean = true)
    fun trigger(fieldId: String? = null): Boolean
    fun reset(formValueRaw: FormValueRaw? = null)
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

// Get single field value
val email = formRef.getValue<String>("email")

// Get all form values as FormValueRaw
val formValueRaw = formRef.getValues()
// formValueRaw.valueMap contains Map<MetaIdComp, JsonElement>

// Set values from FormValueRaw (prefill)
formRef.setValues(existingFormValueRaw)

// Validate
val isValid = formRef.trigger()

// Watch field changes
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
    override fun Render(
        defnComp: DefnComp,
        defnForm: DefnForm,
        formRef: FormRef,
        modifier: Modifier
    ) {
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

## ViewModel Pattern (Simplified - Pure MVI)

```kotlin
class FormViewModel : ViewModel() {

    private val _formState = MutableStateFlow(FormState())
    val formState = _formState.asStateFlow()

    val formRef: FormRef by lazy { FormRefImpl(this) }

    /**
     * Initialize form with DefnForm and optional initial value
     */
    fun initializeFromDefnForm(defnForm: DefnForm, formValueRaw: FormValueRaw? = null) {
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
     * Create initial FormValueRaw with default values from DefnForm
     */
    private fun createInitialFormValueRaw(defnForm: DefnForm): FormValueRaw {
        val valueMap = mutableMapOf<MetaIdComp, JsonElement>()

        defnForm.compMap.forEach { (compId, defnComp) ->
            val defaultValue = getDefaultValueForType(defnComp.type.name)
            valueMap[compId] = convertValueToJson(defaultValue)
        }

        return FormValueRaw().apply {
            this.rowId = ApiPlus.nextRowId()
            this.valueMap = valueMap
        }
    }

    private fun getDefaultValueForType(typeName: String): Any? {
        return when (typeName.uppercase()) {
            "TEXT", "EMAIL", "PHONE", "URL", "PICK_TEXT" -> ""
            "NUMBER", "CURRENCY" -> 0.0
            "BOOL" -> false
            "DATE" -> null
            else -> null
        }
    }

    private fun convertValueToJson(value: Any?): JsonElement {
        return when (value) {
            is String -> JsonPrimitive(value)
            is Number -> JsonPrimitive(value)
            is Boolean -> JsonPrimitive(value)
            null -> JsonNull.INSTANCE
            else -> JsonPrimitive(value.toString())
        }
    }
}
```

**Key Changes**:

- ViewModel only manages configuration state (defnForm, initialFormValue)
- All runtime state managed by FormRef
- No event handling in ViewModel (events handled by parent component)
- Simplified initialization logic

---

## Screen Pattern (Pure MVI Architecture)

### Pure MVI Components

1. **Model (State)**: `FormState` - Configuration only (defnForm, initialFormValue)
2. **View**: `Form` - Pure function of state
3. **Intent**: `FormIntent` - Two intents: Submit and Watch

### Form Screen (Pure MVI)

**Pure MVI Composable Signature:**

1. state: FormState - Single source of truth
2. onIntent: (FormIntent) -> Unit - Single intent handler
3. modifier: Modifier - Standard

**Responsibilities:**

- Receives state from parent
- Dispatches intents to parent
- No ViewModel dependency
- Fully testable and previewable

```kotlin
@Composable
fun Form(
    state: FormState,
    onIntent: (FormIntent) -> Unit,
    modifier: Modifier = Modifier
) {
    // Form renders based purely on state
    // All logic handled by parent through state/intent
    FormContent(
        state = state,
        onIntent = onIntent,
        modifier = modifier
    )
}
```

### FormContent (Stateless)

**Responsibilities:**

- Pure presentation
- Render UI based on state
- Dispatch intents through onIntent callback

```kotlin
@Composable
private fun FormContent(
    state: FormState,
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
            // TODO: ComponentRendererFactory will need FormRef
            // This needs to be provided by the parent component
            Text(
                text = "Form rendering: ${defnForm.name.name}",
                modifier = Modifier.padding(16.dp)
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

### Parent Component Usage

The parent component manages the ViewModel and handles intents:

```kotlin
@Composable
fun FormScreen(
    defnForm: DefnForm,
    viewModel: FormViewModel = viewModel()
) {
    // Initialize form
    LaunchedEffect(defnForm) {
        viewModel.initializeFromDefnForm(defnForm)
    }

    // Collect state
    val state by viewModel.formState.collectAsStateWithLifecycle()
    val formRef = viewModel.formRef

    // Render pure Form
    Form(
        state = state,
        onIntent = { intent ->
            when (intent) {
                is FormIntent.Submit -> {
                    // Handle form submission
                    submitToApi(intent.formValue)
                }
                is FormIntent.Watch -> {
                    // Handle field changes
                    logFieldChange(intent.fieldId, intent.fieldValue)
                }
            }
        }
    )
}
```

### Pure MVI Best Practices

1. **State over Callbacks**: Pass single `state` object, not individual properties
2. **Single Intent Handler**: Use `onIntent: (FormIntent) -> Unit` for all user actions
3. **Stateless Components**: No `remember`, `LaunchedEffect`, or ViewModel in Form
4. **Parent Handles Logic**: All business logic in parent component, not in Form
5. **Immutable State**: FormState always copied, never mutated
6. **FormRef for Imperative API**: Use FormRef for field operations, not state/intents

### Pure MVI Parameter Ordering

**Pure MVI Composable Signature:**

```kotlin
@Composable
fun ComponentName(
    // 1. State (single source of truth)
    state: ComponentState,

    // 2. Intent handler (all user actions)
    onIntent: (ComponentIntent) -> Unit,

    // 3. Modifier (standard convention)
    modifier: Modifier = Modifier
)
```

**Why this order?**

- **State first**: Most important parameter, single source of truth
- **Intent second**: Single entry point for all user actions
- **Modifier last**: Standard Android convention

**Example:**

```kotlin
// ✅ CORRECT - Pure MVI signature
Form(
    state = formState,
    onIntent = { intent ->
        when (intent) {
            is FormIntent.Submit -> handleSubmit(intent.formValue)
            is FormIntent.Watch -> logFieldChange(intent.fieldId)
        }
    }
)

// ❌ WRONG - Not pure MVI (has ViewModel, callbacks)
Form(
    defnForm = myDefnForm,
    onFormRefReady = { ref -> ... },
    viewModel = viewModel()
)
```

---

## Grid Rendering

### Concept

Grids store `FieldValueGrid` with multiple rows. Each row has own `valueMap`.

### Implementation

```kotlin
object GridRenderer : ComponentRenderer {
    @Composable
    override fun Render(
        defnComp: DefnComp,
        defnForm: DefnForm,
        formRef: FormRef,
        modifier: Modifier
    ) {
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
User Input → FormEvent.UpdateField → ViewModel
                                   ↓
                    Updates BOTH FormValueRaw.valueMap AND FieldState
                                   ↓
                              FormState → UI Recompose
                                   ↓
                    FormRef.getValues() → Returns FormValueRaw
                                   ↓
                            Submit to API
```

### FormValueRaw Integration

1. **FormValueRaw is the primary data container**: Always stored in FormState
2. **Bidirectional sync**:
    - `UpdateField` → updates both FieldState and FormValueRaw.valueMap
    - `SetValues(FormValueRaw)` → updates both FormValueRaw and all FieldStates
3. **FormRef exposes FormValueRaw**: `getValues()` returns the complete FormValueRaw ready for API
   submission
4. **Type conversions**: ViewModel handles conversions between Kotlin types and JsonElement

---

## Key Principles

1. **Unidirectional Flow** - UI → Intent → Parent → State → UI
2. **Simplified State** - FormState holds only configuration (defnForm, initialFormValue)
3. **Pure MVI** - Form component is pure function of state, no ViewModel dependency
4. **Two Intents** - Only Submit and Watch intents for external communication
5. **FormRef Imperative API** - All field operations through FormRef (getValue, setValue, etc.)
6. **Separation of Concerns** - Form renders, parent handles logic, FormRef manages fields
7. **Type Safety** - Sealed classes, generics
8. **Immutability** - State never mutated, always copied
9. **Lifecycle Awareness** - collectAsStateWithLifecycle in parent component
10. **Factory Pattern** - Easy to extend with new field types
11. **JSON-Driven** - Forms defined by DefnForm, no code changes needed

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
    formRef.setValues(
        mapOf(
            "name" to user.name,
            "email" to user.email
        ), shouldValidate = false
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
