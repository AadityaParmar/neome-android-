# events — Form Event Execution Engine

## Purpose

Handles the initialization, categorization, and execution of form-level events (onChange, onInitForm, onSubmitForm, onClickButton). This package is the runtime engine that evaluates event conditions, dispatches actions against form state, and manages cascading side effects from value changes.

## Responsibilities

- Categorize form events by kind during initialization (onChange, onSubmitForm, onClickButton, onInitForm)
- Execute onInitForm events immediately at form load and accumulate their state changes
- Evaluate event action bindings with condition checks before executing actions
- Execute actions on fields (setValue, clear, visibility, enable/disable, animations)
- Execute actions on components (sections, grids) with field expansion for clears
- Execute actions on the send button (visibility, enable/disable)
- Resolve source values from multiple value types (field references, text/long/double/boolean/date literals, sysId, sysIdArray, sysIdSet, textArray)
- Manage event property overrides (hidden, invisible, disabled, highlight, blink, shake)
- Merge event-driven property overrides into field states
- Guard against infinite onChange cascading with a configurable depth limit

## Flow

1. **Initialization** — `FormCtxInitEvents.initEvents` iterates all events in the form definition. It categorizes onChange/onSubmitForm/onClickButton events into lookup maps and immediately executes onInitForm events via `FormCtxFormEvents.executeEvent`.
2. **Event execution** — `FormCtxFormEvents.executeEvents` resets the event props map, then iterates each event ID through `executeEventInternal`. For each event, it walks the action binding map in order, evaluates optional conditions (with negation support), and dispatches the resolved action to `FormCtxActionExecutor.executeAction`.
3. **Action dispatch** — `FormCtxActionExecutor.executeAction` routes by `actionOn` (field, component, sendButton) and then by action kind. Field/component setValue and clear mutate the valueMap. Visibility/disability/animation actions delegate to `FormCtxEventPropsHelper.updateFormEventProps` to accumulate overrides.
4. **Value change cascading** — When `triggerValueChanged` is true and a setValue/clear action modifies a field value, the executor resolves affected field IDs, compares old vs new values, and calls `FormCtxEventHelper.processFieldValueChanged` for each changed field. This triggers isDirty updates, dependent field recalculation, validation, and further onChange cascading (depth-guarded at 5 levels).
5. **Props merge** — After all events complete, `FormCtxEventPropsHelper.mergeEventPropsIntoFieldStates` folds event property overrides into field states, combining base properties with event-driven hidden/disabled flags.

## Key Entry Points

| File | Symbol | Role |
|------|--------|------|
| `FormCtxInitEvents.kt` | `FormCtxInitEvents.initEvents` | Categorizes events and executes onInitForm; returns `CategorizedEvents` + updated state |
| `FormCtxFormEvents.kt` | `FormCtxFormEvents.executeEvents` | Executes a list of event IDs with optional value-change cascading |
| `FormCtxFormEvents.kt` | `FormCtxFormEvents.initEvents` | Delegate to `FormCtxInitEvents.initEvents`; convenience entry point for callers |
| `FormCtxFormEvents.kt` | `FormCtxFormEvents.executeEvent` | Executes a single event ID |
| `FormCtxFormEvents.kt` | `FormCtxFormEvents.CategorizedEvents` | Data class holding onChangeMap, onSubmitFormList, onClickButtonMap |
| `FormCtxFormEvents.kt` | `FormCtxFormEvents.mergeEventPropsIntoFieldStates` | Delegates to helper for props merge |
| `FormCtxActionExecutor.kt` | `FormCtxActionExecutor.executeAction` | Routes and executes a single action by actionOn and kind |
| `FormCtxActionExecutor.kt` | `FormCtxActionExecutor.resolveSourceValue` | Resolves action source to a value (field reference or literal) |
| `FormCtxActionExecutor.kt` | `FormCtxActionExecutor.resolveAffectedFieldIds` | Expands component IDs to leaf field IDs for cascade tracking |
| `FormCtxEventPropsHelper.kt` | `FormCtxEventPropsHelper.updateFormEventProps` | Applies a property update lambda to a set of component IDs |
| `FormCtxEventPropsHelper.kt` | `FormCtxEventPropsHelper.mergeEventPropsIntoFieldStates` | Merges event overrides into field states |

## Dependencies

- `com.neome.api.meta.base.Types` — MetaId types, enum definitions for event kinds and action kinds
- `com.neome.api.meta.base.dto.DefnEventAction`, `DefnSection`, `FieldDtoArg` — Action/section/arg DTOs
- `com.neome.feature.form.domain.DefnFormUi` — Form definition (compMap, eventMap)
- `com.neome.feature.form.domain.util.ConditionResolver` — Evaluates conditions for action bindings
- `com.neome.feature.form.domain.util.FieldVal.FieldValueResolver` — Converts between raw values, field values, and JSON elements
- `com.neome.feature.form.presentation.state.FormState` — Immutable form state (valueMap, fieldStates, formEventPropsMap, etc.)
- `com.neome.feature.form.presentation.state.FormEventProps` — Per-component event property overrides
- `com.neome.feature.form.presentation.state.SendBtnStateFlag` — Send button state flags
- `com.neome.feature.form.domain.ctx.helper.FormCtxEventHelper` — Parent helper; `processFieldValueChanged` drives cascading from this package

## Related READMEs

- **Parent**: `../README.md` (helper package — orchestrates event handling, validation, initialization)
- **Sibling**: `../schema/README.md` (component schema resolution)
- **Form root**: `../../../../form.md` (full form feature documentation)

## Change Notes

- Initial documentation created from source analysis (2026-02-22)
- Not-yet-implemented actions: `executeAction`, `executeFormula`, `click` (logged as TODOs in `FormCtxActionExecutor`)
- TODO: `resolveSourceValue` does not yet resolve `valueText` as an arg string via `ArgValueResolver`
- Verified against latest source (2026-02-22): all entry points, dependencies, and flow descriptions confirmed accurate
