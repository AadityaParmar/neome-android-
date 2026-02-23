# helper — Form State Orchestration Layer

## Purpose

Coordinates all pure-state transformations for the form engine: initialization, field event handling, and validation. This package is the stateless orchestration hub that takes `FormState` in and returns `FormState` (or `FormReducerResult`) out, delegating to child packages for schema-based validation and event execution.

## Responsibilities

- Initialize a complete `FormState` from a form definition and optional initial values
- Handle all field-level events (value changed, focus, blur, touch, trigger, click, submit, reset, set values)
- Process cascading field value changes with dependency tracking and recursion guarding
- Validate individual fields and entire forms against component schemas
- Manage error state (set, clear, custom vs validation errors) with preservation semantics
- Synchronize send button state flags (`Invalid`) with current error state
- Wrap state transitions with optional `FormIntent` side effects via `FormReducerResult`

## Flow

1. **Initialization** — `FormCtxInitHelper.initializeFormState` receives `DefnFormUi` and optional `FormValueData`. It resolves default values via `FieldValueResolver.fnEnsureInit`, builds per-field `FieldState` with resolved properties via `FieldPropertyResolver`, constructs the validation schema map via `CompSchemaFactory.buildFormSchemas`, computes the field dependency map, and initializes form events via `FormCtxFormEvents.initEvents`. Returns a fully populated `FormState`.
2. **Event dispatch** — `FormCtxEventHelper` handles each `FormEvent` variant. For `FieldValueChanged`, it updates the valueMap, calls `processFieldValueChanged` (isDirty, trigger field + dependents, onChange cascade), syncs the Invalid flag, and returns a `FormReducerResult` with a `Watch` intent. Focus/blur/touch events update field state flags. `Click` executes onClickButton events. `Submit` validates all fields, runs onSubmitForm events, and returns a `Submit` intent. `Reset` restores initial values. `SetValues` batch-updates with per-field triggering.
3. **Field triggering** — `triggerField` recalculates field properties from the definition via `FieldPropertyResolver.resolveFieldProperties`, then validates the field against its `CompSchema`. `triggerDependentFields` iterates all dependents from `FieldDependencyMap`.
4. **Validation** — `FormCtxValidationHelper` handles single-field and full-form validation. `updateFieldError` applies error-type-aware semantics: validation errors are set/cleared freely; custom/server errors are preserved when clearing validation errors.
5. **Send button sync** — Both `FormCtxEventHelper.syncInvalidFlag` and `FormCtxValidationHelper.updateInvalidFlag` maintain the `SendBtnStateFlag.Invalid` flag. The EventHelper variant does simple sync; the ValidationHelper variant also emits `SendBtnStateChanged` intents on transitions.

## Key Entry Points

| File | Symbol | Role |
|------|--------|------|
| `FormReducerResult.kt` | `FormReducerResult` | Data class wrapping `FormState` + optional `FormIntent`; return type for all event handlers |
| `FormCtxInitHelper.kt` | `FormCtxInitHelper.initializeFormState` | Builds initial `FormState` from definition and initial values |
| `FormCtxInitHelper.kt` | `FormCtxInitHelper.isCompositeType` | Checks if a component type is composite (grid, section, tab, wizard, spreadsheetRef) |
| `FormCtxEventHelper.kt` | `FormCtxEventHelper.handleFieldValueChanged` | Processes field value changes with cascade and Watch intent |
| `FormCtxEventHelper.kt` | `FormCtxEventHelper.processFieldValueChanged` | Core pure-state cascade: isDirty → trigger → dependents → onChange events |
| `FormCtxEventHelper.kt` | `FormCtxEventHelper.handleSubmit` | Validates all → runs onSubmitForm events → returns Submit intent |
| `FormCtxEventHelper.kt` | `FormCtxEventHelper.handleReset` | Resets to initial values, clears errors and flags |
| `FormCtxEventHelper.kt` | `FormCtxEventHelper.handleSetValues` | Batch value update with per-field triggering and dependency cascade |
| `FormCtxEventHelper.kt` | `FormCtxEventHelper.handleFieldFocused` / `handleFieldBlurred` / `handleFieldTouched` | Field interaction state updates |
| `FormCtxEventHelper.kt` | `FormCtxEventHelper.handleClick` | Executes onClickButton events |
| `FormCtxEventHelper.kt` | `FormCtxEventHelper.handleTriggerField` | Manually trigger recalculation for a single field |
| `FormCtxValidationHelper.kt` | `FormCtxValidationHelper.handleValidateField` | Validates a single field against its schema |
| `FormCtxValidationHelper.kt` | `FormCtxValidationHelper.handleValidateAll` | Validates all fields with schemas |
| `FormCtxValidationHelper.kt` | `FormCtxValidationHelper.updateFieldError` | Shared error map updater (used by both ValidationHelper and EventHelper) |
| `FormCtxValidationHelper.kt` | `FormCtxValidationHelper.handleSetFieldError` / `handleClearFieldError` / `handleClearAllErrors` | Custom error management |

## Dependencies

- `com.neome.feature.form.domain.DefnFormUi` — Form definition (compMap, eventMap)
- `com.neome.feature.form.domain.util.FieldPropertyResolver` — Resolves field properties and builds dependency map
- `com.neome.feature.form.domain.util.FieldVal.FieldValueResolver` — Resolves default/initial values
- `com.neome.feature.form.domain.ctx.helper.schema.CompSchemaFactory` — Builds validation schemas
- `com.neome.feature.form.domain.ctx.helper.events.FormCtxFormEvents` — Event categorization and execution
- `com.neome.feature.form.presentation.state.FormState` — Immutable form state
- `com.neome.feature.form.presentation.state.FieldState`, `FieldError`, `FieldProperties` — Per-field state types
- `com.neome.feature.form.presentation.state.FormEvent` — Sealed interface for all form events
- `com.neome.feature.form.presentation.state.FormIntent` — Side effect intents (Watch, Submit, SendBtnStateChanged)
- `com.neome.feature.form.presentation.state.SendBtnStateFlag` — Send button state flag enum
- `com.neome.feature.form.presentation.state.FormEventProps` — Event-driven property overrides

## Related READMEs

- **Children**: `events/README.md` (event execution engine), `schema/README.md` (validation schema registry)
- **Parent**: `../README.md` (ctx package — FormCtx facade)
- **Siblings**: `../../util/README.md` (property/condition/arg resolution utilities)
- **Form root**: `../../../form.md` (full form feature documentation)

## Change Notes

- Initial documentation created from source analysis (2026-02-22)
- 4 source files + 2 child packages (events/, schema/)
- `FormCtxEventHelper.TriggerResult` is an internal data class for trigger operations
- Event props merging is handled centrally by `FormCtxFormEvents.mergeEventPropsIntoFieldStates` after event execution; `triggerField` only recalculates definition-level properties
