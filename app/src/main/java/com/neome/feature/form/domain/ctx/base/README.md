# base — Form Reducer Helpers and State Management Primitives

## Purpose

Provides the pure-state orchestration layer for form initialization, event handling, and validation. This package contains immutable data classes, mutable state accessors for reducer cycles, and helper modules that process form events and validation rules. The base package is the runtime engine that powers the form context (`FormCtx`) by exposing stateless transformation functions that the context can invoke to compute new form state and intents.

## Responsibilities

- Define `FormReducerResult` wrapper class that combines state and intents (output of all helpers)
- Provide `FormStateAccessor` interface and `ReducerFormStateAccessor` implementation for safely mutating form state during a single reducer cycle
- Provide `ReducerFormGridStateAccessor` that wraps the parent accessor and routes field read/write to `FormState.gridCtx` for grid row fields, enabling grid fields to share the same event helpers as parent form fields
- Initialize complete `FormState` from form definition (`DefnFormUi`) and optional initial values via `FormCtxInitHelper`
- Handle all field-level events (value changes, submit, reset, focus, blur, touch, click) via `FormCtxEventHelper`
- Manage validation events and field error state via `FormCtxValidationHelper`
- Handle grid lifecycle events (open, close, submit, remove) via `FormCtxGridHelper`
- Synchronize send button state flags via `FormCtxSendBtnStateHelper`
- Orchestrate form event execution (onChange, onInitForm, onSubmitForm, onClickButton) and action dispatch in the `events/` subdirectory
- Manage field type–specific validation schemas in the `schema/` subdirectory

## Flow: Initialization → Event Handling → Validation → Send Button Sync

### 1. Initialization Phase

When a form is created, `FormCtxInitHelper.initializeFormState` is called with a `DefnFormUi` and optional `FormValueData`. This helper:

1. Resolves defaults for all fields from the form definition via `FieldValueResolver.fnEnsureInit`
2. Builds a dependency map that tracks which fields depend on which other fields
3. Resolves field properties (visibility, disabled, required flags) via `FieldPropertyResolver.resolveFieldProperties`
4. Creates `FieldState` for each leaf field and value-carrying composite fields (grids)
5. Builds the `valueMap` with initial values from the provided data or defaults
6. Builds per-field-type validation schemas via `schema/CompSchemaFactory.buildFormSchemas`
7. Initializes categorized event maps (onChange, onInitForm, onSubmitForm, onClickButton) via `events/FormCtxInitEvents.initEvents`
8. Executes immediate onInitForm events to bootstrap any initial state changes
9. Returns the fully initialized `FormState`

**Entry point**: `FormCtxInitHelper.initializeFormState`

### 2. Event Dispatch and Handler Routing

When a field component or external caller triggers an event, the form context dispatches a `FormEvent` to the appropriate handler. The context routes events as follows:

- **FieldValueChanged, Submit, Reset, SetValues, Click events** → `FormCtxEventHelper` methods
- **ValidateField, ValidateAll, SetFieldError, ClearFieldError, ClearAllErrors events** → `FormCtxValidationHelper` methods
- **GridOpen event** → `FormCtxGridHelper.handleGridOpen` (initializes `FormState.gridCtx`)
- **GridClose event** → `FormCtxGridHelper.handleGridClose` (clears `gridCtx`)
- **GridSubmit event** → `FormCtxGridHelper.handleGridSubmit` (validates, merges row, clears `gridCtx`)
- **GridRemove event** → `FormCtxGridHelper.handleGridRemove`
- **AddSendBtnStateFlag, RemoveSendBtnStateFlag events** → `FormCtxSendBtnStateHelper`

The context accesses current state via `FormStateAccessor`, which provides both read and write methods.

### 3. Event Handling and State Mutation

Each helper accepts the current `FormState` and a `FormStateAccessor` (mutable view). The helper:

1. Mutates the accessor (field values, error states, flags, event properties, field states)
2. Optionally triggers cascading effects:
   - Value changes via `FormCtxEventHelper.processFieldValueChanged` trigger:
     - Validation of the changed field
     - Recalculation of dependent fields
     - onChange form events (depth-guarded at max 5 levels)
   - Visibility/disabled updates merge into field states
3. Returns a `FormReducerResult` containing the snapshotted immutable state and optional `FormIntent`

**Entry points**: 
- `FormCtxEventHelper.processFieldValueChanged` (main cascade handler)
- `FormCtxEventHelper.processSubmit`
- `FormCtxEventHelper.processReset`
- `FormCtxValidationHelper.validateField`

### 4. Validation and Error Accumulation

When a field is validated:

1. `FormCtxValidationHelper.validateField` looks up the field's schema from the schema registry
2. The schema's `validate(fieldValue, fieldState)` method is called with the field value and its runtime properties
3. If validation fails, the error is stored in the `errors` map via the accessor
4. The `Invalid` flag is added to `sendBtnStateFlags` to disable the submit button
5. Subsequent validation calls overwrite the previous validation error for the field (but preserve custom/server errors)

**Entry point**: `FormCtxValidationHelper.validateField`

### 5. Send Button Synchronization

The `sendBtnStateFlags` set tracks conditions that should disable the submit button:

- `Invalid` — form has validation errors (set by validation helpers)
- `Submitting` — submission is in progress (set by context)
- Custom flags — application-specific disable conditions

When the flag set changes state, `FormCtxSendBtnStateHelper.onSendBtnStateFlagsChanged` detects the transition and emits a `SendBtnStateChanged` intent. The context listens for intents and forwards them to the parent screen (navigation, snackbars, side effects).

**Entry point**: `FormCtxSendBtnStateHelper.onSendBtnStateFlagsChanged`

### 6. Form Event Orchestration (events/ subdirectory)

After user events are processed, the context may trigger form-level events (onChange, onSubmitForm, onClickButton, onInitForm). The `events/` subdirectory handles this orchestration:

1. `FormCtxInitEvents.initEvents` categorizes form events during initialization
2. `FormCtxFormEvents.executeEvents` executes a list of event IDs with optional value-change cascading
3. For each event, `FormCtxActionExecutor.executeAction` evaluates conditions and dispatches actions
4. Value changes inside actions trigger cascading onChange events (depth-guarded at 5 levels)
5. Event property overrides (hidden, disabled, highlight) accumulate and merge into field states

**Entry point**: `events/FormCtxInitEvents`, `events/FormCtxFormEvents`

## Key Entry Points

| File | Symbol | Role |
|------|--------|------|
| `FormReducerResult.kt` | `FormReducerResult` | Data class holding immutable state + optional intent; return type for all helpers |
| `FormStateAccessorImpl.kt` | `ReducerFormStateAccessor` | Mutable view for form state during a reducer cycle; extracts hot-path collections to copies; `snapshot()` merges them back |
| `FormCtxInitHelper.kt` | `FormCtxInitHelper.initializeFormState` | Main entry point: initializes complete FormState from form definition and optional initial values |
| `FormCtxInitHelper.kt` | `FormCtxInitHelper.isCompositeType` | Determines if a component type is composite (section, grid, tab, wizard, spreadsheetRef) |
| `FormCtxEventHelper.kt` | `FormCtxEventHelper.processFieldValueChanged` | Handles value changes, cascades to validation and dependent fields (depth-guarded at 5 levels) |
| `FormCtxEventHelper.kt` | `FormCtxEventHelper.processSubmit` | Validates all required fields and emits FormSubmitted intent if valid |
| `FormCtxEventHelper.kt` | `FormCtxEventHelper.processReset` | Clears all field values, errors, and isDirty flags |
| `FormCtxEventHelper.kt` | `FormCtxEventHelper.processSetValues` | Bulk replaces field values from a map with per-field triggering |
| `FormCtxValidationHelper.kt` | `FormCtxValidationHelper.validateField` | Validates a single field against its schema and stores error in errors map |
| `FormCtxValidationHelper.kt` | `FormCtxValidationHelper.validateAll` | Validates all fields and accumulates errors |
| `FormCtxValidationHelper.kt` | `FormCtxValidationHelper.setFieldError` | Manually sets an error for a field (from server, for example) |
| `FormCtxValidationHelper.kt` | `FormCtxValidationHelper.clearFieldError` | Removes error for a field and clears Invalid flag if no other errors exist |
| `FormCtxValidationHelper.kt` | `FormCtxValidationHelper.clearAllErrors` | Removes all errors and clears Invalid flag |
| `FormCtxGridHelper.kt` | `FormCtxGridHelper.handleGridOpen` | Initializes `FormState.gridCtx` for adding or editing a grid row |
| `FormCtxGridHelper.kt` | `FormCtxGridHelper.handleGridClose` | Clears `gridCtx` to discard edits and close the sheet |
| `FormCtxGridHelper.kt` | `FormCtxGridHelper.handleGridSubmit` | Validates grid row fields, merges into parent `FieldValueGridData`, clears `gridCtx` |
| `FormCtxGridHelper.kt` | `FormCtxGridHelper.handleGridRemove` | Removes a row from a grid field value |
| `ReducerFormGridStateAccessor.kt` | `ReducerFormGridStateAccessor` | Grid-aware `FormStateAccessor` — routes read/write to `gridCtx` for grid fields, delegates to parent for others |
| `FormCtxSendBtnStateHelper.kt` | `FormCtxSendBtnStateHelper.onSendBtnStateFlagsChanged` | Detects flag set transitions and emits SendBtnStateChanged intent |
| `FormCtxApiCtx.kt` | `FormCtxApiCtx` | Optional interface for external data fetching (field options via onGetFieldOptions callback) |

## Dependencies / Relationships

### Incoming Dependencies (packages that use this package)

- `ctx/FormCtxImpl.kt` — Routes `FormEvent` variants to helpers and applies state updates via `mutableStateOf`
- `presentation/` — Field components read state from `FormCtx` and trigger events
- `ref/FormRefImpl.kt` — External API for parent screens, backed by `FormCtx` methods

### Internal Dependencies (within this package)

- `FormStateAccessor` interface — Abstraction over mutable state during a reducer cycle
- `FormReducerResult` — Output wrapper (state + optional intent) for all helpers
- `events/` subdirectory — Form event orchestration and action execution (separate README)
- `schema/` subdirectory — Per-field-type validation logic (separate README)

### External Dependencies

- `androidx.compose.runtime.State`, `mutableStateOf` — Compose state primitives used by `FormCtx`
- `com.neome.feature.form.domain.DefnFormUi` — Form definition (compMap, eventMap, componentDefns)
- `com.neome.feature.form.presentation.state.*` — `FormState`, `FormEvent`, `FormIntent`, `FieldState`, `FieldError`, `SendBtnStateFlag`, `FieldProperties`, `FormEventProps`
- `com.neome.feature.form.domain.util.FieldPropertyResolver` — Resolves field properties (visibility, required, disabled)
- `com.neome.feature.form.domain.util.FieldVal.FieldValueResolver` — Converts between raw values, field values, and JSON elements
- `com.neome.feature.form.domain.util.ConditionResolver` — Evaluates event action conditions
- `com.neome.api.meta.base.Types.*` — `MetaIdComp`, `MetaIdField`, `EnumDefnCompType`
- `com.neome.core.common.serializer.api.meta.base.dto.FormValueData` — Initial form value data
- `kotlinx.serialization.json.JsonElement` — JSON value wrapper

## Related READMEs

- **Parent**: `../README.md` — ctx package documentation (FormCtx interface, FormCtxImpl implementation, event dispatch entry point)
- **Child**: `events/README.md` — Form event orchestration engine (onChange, onInitForm, onSubmitForm, onClickButton event execution)
- **Child**: `schema/README.md` — Component validation schema registry (per-field-type validation logic via CompSchemaFactory)
- **Sibling**: `../ref/README.md` — FormRef external API (created by FormCtxImpl, uses base helpers indirectly)
- **Sibling**: `../util/README.md` — Utility functions for field properties and value resolution
- **Form root**: `../../form.md` — Full form feature documentation

## Architecture Notes

### FormStateAccessor Pattern: Hybrid Mutation Strategy

The `ReducerFormStateAccessor` balances safety and performance:

- **Hot-path collections** (valueMap, fieldStates, errors, sendBtnStateFlags) are extracted to mutable copies at construction for O(1) per-field mutations. These collections are synced back into the state via `snapshot()` after all mutations complete.
- **Scalar fields** (isSubmitting, isDirty, etc.) are mutated via `copy()` on the real `FormState`, ensuring new fields added to `FormState` are automatically carried forward without code changes in this class.

This design eliminates the common bug class of "forgot to add field to MutableState" while maintaining performance on hot paths. The interface allows testing with alternative implementations.

### Depth-Guarded Cascading

Value changes can trigger form events (onChange), which can trigger more value changes. To prevent infinite cascading, a depth counter limits onChange execution to a maximum of 5 levels. This allows multi-level formulas and dependent fields while preventing loops.

### Event Categorization

Form events are categorized once at initialization into lookup maps (onChange, onInitForm, onSubmitForm, onClickButton). This amortizes the cost of event routing and enables efficient filtering when executing specific event types.

### Validation Schema Registration

Field schemas are built once at form initialization and stored in a `Map<MetaIdComp, CompSchema>`. This approach:

- Enables O(1) schema lookup during validation
- Ensures schemas are immutable and reused (no allocations per validation call)
- Decouples schema implementations from validation helpers

## Change Notes

- Initial documentation created from source analysis (2026-02-24)
- 9 source files in base package + 2 child packages (`events/`, `schema/`) with separate READMEs
- **Grid centralization (2026-02-24)**: Added `ReducerFormGridStateAccessor` for grid-aware state routing. Expanded `FormCtxGridHelper` from single `removeGridRow` to full lifecycle: `handleGridOpen`, `handleGridClose`, `handleGridSubmit`, `handleGridRemove`. Grid row editing state now lives in `FormState.gridCtx` instead of presentation-layer local state.
- `FormStateAccessor` is an interface to enable testing; `ReducerFormStateAccessor` and `ReducerFormGridStateAccessor` are the two concrete implementations
- `FormCtxApiCtx` is optional; no concrete implementation in this package (feature extensions can add implementations)
- Depth guard for cascading events is hardcoded at 5 levels (configurable if needed in future)
- All helpers return `FormReducerResult` for consistency; context handles state application and intent emission
