# Form Context Events Package

**Domain Layer | Clean Architecture | MVI Pattern**

## Purpose

The events package implements form event orchestration—categorizing, evaluating, and executing declarative events defined in form metadata. Events include user interactions (field changes, button clicks, form submission) and initialization routines. The package transforms raw event definitions into concrete state mutations, field value changes, visibility/disabled overrides, and cascading effects.

## Responsibilities

### Event Categorization & Initialization
- **`FormCtxInitEvents.initEvents()`** — Scans form metadata for all event definitions, categorizes them by kind (`onChange`, `onSubmitForm`, `onClickButton`, `onInitForm`), and immediately executes any `onInitForm` events at form load time. Stores categorized events in form state for later dispatch.

### Event Execution Engine
- **`FormCtxFormEvents.executeEvents()`** — Main entry point for executing multiple events. Resets event props overrides at the start of each execution cycle, processes each event sequentially, evaluates conditions, dispatches actions, and merges event props into field states at the end.
- **`FormCtxFormEvents.executeEventInternal()`** — Handles individual event execution: guards against infinite recursion (max depth = 5 for onChange cascades), evaluates condition maps with negation support, routes action execution via `FormCtxActionExecutor`, and optionally triggers `processFieldValueChanged` for value-mutating actions.

### Action Execution & Field State Updates
- **`FormCtxActionExecutor.executeAction()`** — Routes actions to target type (field / component / send button). Field actions include `setValue`, `clear`, `visible`, `invisible`, `hidden`, `enable`, `disable`, `highlight`, `blink`, `shake`. Component actions clear sections or grids. Send button actions control visibility and disabled state.
- **`FormCtxActionExecutor.resolveSourceValue()`** — Resolves literal values (text, numbers, dates, booleans), field reference values, and system ID values (single or array) for `setValue` actions.
- **`FormCtxActionExecutor.resolveAffectedFieldIds()`** — Expands component-level actions (section clear) to their constituent leaf field IDs for cascading value-change logic.

### Event Props Merging
- **`FormCtxEventPropsHelper.mergeEventPropsIntoFieldStates()`** — Merges transient event-driven overrides (`hidden`, `disabled`, `highlight`, `blink`, `shake`) from `formEventPropsMap` into each field's `FieldState.fieldProperties`. Hidden is OR'd with invisible; disabled is OR'd independently.
- **`FormCtxEventPropsHelper.updateFormEventProps()`** — Applies update lambdas to event props for a set of component IDs, building a new immutable props map.

## Flow: Event → Condition → Action → Props → Cascade

```
1. Event Categorization
   FormCtxInitEvents.initEvents()
   └─ Scan form.eventMap for all events
   └─ Group by kind: onChange, onSubmitForm, onClickButton, onInitForm
   └─ Execute onInitForm immediately
   └─ Store categorized events in state

2. Event Dispatch (onChange, onClickButton, onSubmitForm)
   FormCtxFormEvents.executeEvents(eventIds)
   └─ Reset formEventPropsMap to clear stale overrides
   └─ For each event ID:
      FormCtxFormEvents.executeEventInternal()
      ├─ Guard: depth < MAX_CASCADE_DEPTH (5)
      ├─ Condition Evaluation
      │  └─ Resolve condition map with ConditionResolver
      │  └─ Apply notCondition flag (invert if true)
      │  └─ Skip action if condition false or unresolvable
      ├─ Action Execution
      │  FormCtxActionExecutor.executeAction()
      │  ├─ Route to field / component / sendButton handler
      │  ├─ Field mutations: setValue, clear, visibility, disabled, animations
      │  ├─ Component mutations: section/grid clear
      │  └─ SendButton mutations: visibility, disabled via SendBtnStateFlag
      ├─ Value Change Cascade (only for setValue/clear)
      │  └─ Call FormCtxEventHelper.processFieldValueChanged()
      │     └─ Mark isDirty, run validation, trigger dependent onChange events
      │     └─ Recursively process dependent fields (depth + 1)
      └─ Merge event props once after all events complete

3. Props Merge
   FormCtxEventPropsHelper.mergeEventPropsIntoFieldStates()
   └─ For each component in formEventPropsMap:
      └─ Merge hidden, disabled, highlight, blink, shake into FieldState
      └─ Update field state only if props changed
```

## Key Entry Points

| Symbol | File | Purpose |
|--------|------|---------|
| `FormCtxInitEvents.initEvents()` | `FormCtxInitEvents.kt` | Initialize form events at load time, categorize by kind, execute onInitForm |
| `FormCtxFormEvents.executeEvents()` | `FormCtxFormEvents.kt` | Execute multiple events with condition evaluation and cascade depth guard |
| `FormCtxFormEvents.executeEvent()` | `FormCtxFormEvents.kt` | Execute single event without triggering value-change cascade (used by onInitForm) |
| `FormCtxFormEvents.executeEventInternal()` | `FormCtxFormEvents.kt` | Core event execution: condition eval, action dispatch, cascade depth guard |
| `FormCtxActionExecutor.executeAction()` | `FormCtxActionExecutor.kt` | Route action to field/component/sendButton handler, execute mutations |
| `FormCtxActionExecutor.resolveSourceValue()` | `FormCtxActionExecutor.kt` | Resolve source values (literal, field reference, sysId) for setValue actions |
| `FormCtxActionExecutor.resolveAffectedFieldIds()` | `FormCtxActionExecutor.kt` | Expand component actions to leaf field IDs |
| `FormCtxEventPropsHelper.mergeEventPropsIntoFieldStates()` | `FormCtxEventPropsHelper.kt` | Merge event props (hidden, disabled, etc.) into FieldState |
| `FormCtxEventPropsHelper.updateFormEventProps()` | `FormCtxEventPropsHelper.kt` | Update formEventPropsMap with lambdas per component |

## Dependencies & Relationships

### Inbound Dependencies
- **`FormCtxInitHelper.kt`** (parent `base/`) — Calls `FormCtxInitEvents.initEvents()` during form initialization
- **`FormCtxEventHelper.kt`** (parent `base/`) — Calls `FormCtxFormEvents.executeEvents()` for onChange, onClickButton, onSubmitForm dispatch
- **`ConditionResolver`** (`util/`) — Evaluates condition maps with field references
- **`FieldValueResolver`** (`util/`) — Converts between FieldValue, raw values, and JsonElement
- **`FormStateAccessor`** (presentation state) — Provides getValue, setValue, getState, updateState, etc.

### Outbound Dependencies
- **`FormStateAccessor`** — Reads/writes form state, field values, event props, send button flags
- **`FormCtxEventHelper.processFieldValueChanged()`** (parent `base/`) — Triggered by setValue/clear actions to cascade field changes, isDirty, validation
- **`FormEventProps`** (presentation state) — Immutable props container (hidden, disabled, highlight, blink, shake)
- **`SendBtnStateFlag`** (presentation state) — Flags for send button visibility/disabled state

### State Structures
- **`FormCtxFormEvents.CategorizedEvents`** — Data class holding `onChangeMap`, `onSubmitFormList`, `onClickButtonMap`
- **`FormEventProps`** — Holds event-driven overrides (hidden, invisible, disabled, highlight, blink, shake)
- **`FieldState`** — Contains `fieldProperties` (hidden, disabled) merged from base definition and events

## Key Design Patterns

### Immutable State Updates
- Event props and field states are updated immutably via `copy()` and `+` (map union) operations.
- `formEventPropsMap` is reset and rebuilt per event execution cycle to prevent stale overrides.

### Condition Evaluation with Negation
- Conditions are resolved via `ConditionResolver` against current form state.
- The `notCondition` flag inverts the result, allowing both positive and negative conditions.
- Actions are skipped if condition is false or unresolvable.

### Cascade Depth Guard
- `MAX_CASCADE_DEPTH = 5` prevents infinite recursion in onChange cascades (e.g., A→B→C→A).
- Depth increments as `processFieldValueChanged` triggers dependent onChange events.

### Value Change Tracking
- `setValue` and `clear` actions save old values before mutation and compare with new values.
- Only fields with actual value changes trigger `processFieldValueChanged`, avoiding redundant cascades.

### Target Polymorphism
- Actions can target fields, components (sections/grids), or the send button.
- Field targets mutate values; component targets expand to constituent fields; send button targets mutate flags.

## Related Documentation

- **Parent Package**: [`base/README.md`](../README.md) — Form context architecture, helpers, and state accessor
- **Util Package**: `util/` — Condition resolution, field value conversion, validation
- **Presentation State**: `presentation/state/` — FieldState, FormEventProps, SendBtnStateFlag
- **Clean Architecture Rules**: See project `CLAUDE.md` for MVI/MVVM patterns and layer separation

## Anti-Patterns

❌ **Do not** mutate state directly in event handlers — always use `accessor.updateState()` or `accessor.setFormEventPropsMap()`.

❌ **Do not** call `processFieldValueChanged()` without checking if value actually changed — this causes unnecessary cascades.

❌ **Do not** exceed `MAX_CASCADE_DEPTH` — if you see warnings, the event configuration has a cycle that needs fixing.

❌ **Do not** merge event props before all events complete — wait until the end of `executeEvents()` to batch props updates.

❌ **Do not** resolve field references without checking the field exists in `compMap` — use defensive null checks.

## Testing

Test vectors should cover:
- **Event categorization**: Verify all event kinds are grouped correctly
- **Condition evaluation**: Both true, false, and unresolvable conditions
- **Negation**: Verify `notCondition=true` inverts results
- **Action execution**: Field setValue/clear, visibility, disabled, send button mutations
- **Value change cascade**: onChange events triggered by dependent field mutations (depth < 5)
- **Cascade termination**: Verify `MAX_CASCADE_DEPTH` stops runaway cascades
- **Props merging**: Verify hidden/disabled/animations are merged into FieldState
- **Stale props cleanup**: Verify `formEventPropsMap` is reset each cycle

## Implementation Notes

- **Logging**: `FormCtxFormEvents` (tag `FormCtxFormEvents`) logs event execution and action dispatch with condition status. `FormCtxActionExecutor` (tag `FormCtxActionExecutor`) logs action kind, actionOn, and resolved target names from compMap for debugging.
- **Not Yet Implemented**: Actions `executeAction`, `executeFormula`, `click` are logged as TODOs.
- **Future Work**: `resolveSourceValue()` should resolve `valueText` as an arg string via `ArgValueResolver`.

