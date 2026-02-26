# state — Form Presentation State Types

## Purpose

Defines all immutable state, event, and intent types for the form feature's presentation layer. This package is the single source of truth for what the form looks like, what events it accepts, and what it communicates outward — consumed by `FormCtxImpl`, helper packages, field composables, and parent screens.

## Responsibilities

- Define `FormState` — the centralized, immutable snapshot of all form runtime data
- Define `FieldState` — per-field interaction state (touched, dirty, focused, validating, computed properties)
- Define `FieldProperties` — all dynamically-resolved display and validation properties for a field
- Define `FormEventProps` — event-action overrides (hidden, invisible, disabled, highlight, blink, shake) stored per component
- Define `FieldDependencyMap` — tracks which fields must be re-triggered when a given field changes value
- Define `FormEvent` — sealed interface of all internal events that mutate `FormState`
- Define `FieldEvent` — sealed interface of events emitted by field composables (converted to `FormEvent` by the form)
- Define `FieldEventHandler` — functional interface for field-to-form event delivery
- Define `FormIntent` — sealed interface of one-time signals the form emits to its parent
- Define `FieldError` — validation error with type classification (Validation, Custom, Server)
- Define `SendBtnStateFlag` — sealed interface of flags that collectively control send-button enabled/invisible state

## Flow

1. **Initialization** — `FormCtxImpl` constructs an initial `FormState` (via `FormCtxInitHelper`) with `defnForm`, `initialFormValue`, empty `fieldStates`/`valueMap`/`errors`, and pre-built `fieldDependencies` + `compSchemaMap`.
2. **Field rendering** — Composables read `FormCtx` (backed by `FormState`) via `LocalFormCtx`. Each field reads its own `FieldState`, current value from `valueMap`, and error from `errors`.
3. **Field events** — User interaction produces a `FieldEvent` (ValueChanged, Focused, Blurred, Click). `FieldEventHandler` converts this to a `FormEvent` and calls `FormCtxImpl.dispatch`.
4. **State mutation** — `dispatch(FormEvent)` routes to the appropriate helper (event/validation/init) which computes a new `FormState` immutably and writes it to `mutableStateOf<FormState>`.
5. **Cascade** — When a field value changes, `FieldDependencyMap.getDependents` is used to fire `TriggerField` events for all dependent fields, causing their `FieldProperties` to be re-resolved.
6. **Intent emission** — After state update, `FormCtxImpl` forwards any `FormIntent` (Submit, Watch, ValidationStateChanged, SendBtnStateChanged) via the `onIntent` callback to the parent screen.
7. **Send button** — `sendBtnStateFlags` is a `Set<SendBtnStateFlag>`. Non-empty = disabled. `Invisible` flag hides the button. Other flags (Invalid, Uploading, Processing, Validating, Disabled, Custom) disable it.

## Key Entry Points

| File            | Symbol                                                           | Role                                                                                                                                                                           |
|-----------------|------------------------------------------------------------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| `FormState.kt`  | `FormState`                                                      | Central immutable state: `defnForm`, `fieldStates`, `valueMap`, `errors`, `compSchemaMap`, `formEventPropsMap`, `sendBtnStateFlags`, form-level flags                          |
| `FormState.kt`  | `FormState.hasErrors` / `isDirty` / `isValid`                    | Derived boolean properties computed from state                                                                                                                                 |
| `FormState.kt`  | `FormState.getFieldState` / `getValue` / `getError` / `hasError` | State accessor methods                                                                                                                                                         |
| `FormState.kt`  | `FormState.isSendBtnEnabled` / `isSendBtnInvisible`              | Send button state queries                                                                                                                                                      |
| `FormState.kt`  | `SendBtnStateFlag`                                               | Sealed interface: `Invalid`, `Uploading`, `Processing`, `Validating`, `Invisible`, `Disabled`, `Custom(key)`                                                                   |
| `FormState.kt`  | `FieldDependencyMap`                                             | Maps `MetaIdComp` → dependents set; `getDependents`, `addDependency`                                                                                                           |
| `FieldState.kt` | `FieldState`                                                     | Per-field: `defaultValue`, `isTouched`, `isDirty`, `isFocused`, `isValidating`, `fieldProperties`                                                                              |
| `FieldState.kt` | `FieldState.computeIsDirty`                                      | Compares current value against `defaultValue`                                                                                                                                  |
| `FieldState.kt` | `FieldProperties`                                                | 30+ resolved display/validation properties: `required`, `disabled`, `readOnly`, `hidden`, `label`, `placeholder`, `helperText`, min/max constraints, media/button/layout props |
| `FieldState.kt` | `FormEventProps`                                                 | Event-action override flags per component: `hidden`, `invisible`, `disabled`, `highlight`, `blink`, `shake`                                                                    |
| `FieldError.kt` | `FieldError`                                                     | `message: String`, `type: ErrorType` (Validation, Custom, Server)                                                                                                              |
| `FormEvent.kt`  | `FormEvent`                                                      | Sealed interface — all internal reducer events                                                                                                                                 |
| `FormEvent.kt`  | `FormEvent.FieldValueChanged`                                    | Value change with `fieldId`, `value`, `depth` (cascade guard)                                                                                                                  |
| `FormEvent.kt`  | `FormEvent.TriggerField`                                         | Re-resolve field properties for dependent cascade                                                                                                                              |
| `FormEvent.kt`  | `FormEvent.ValidateField` / `ValidateAll`                        | Validation triggers                                                                                                                                                            |
| `FormEvent.kt`  | `FormEvent.Submit` / `Reset`                                     | Form-level lifecycle events                                                                                                                                                    |
| `FormEvent.kt`  | `FormEvent.SetValues`                                            | Bulk field value assignment                                                                                                                                                    |
| `FormEvent.kt`  | `FormEvent.AddSendBtnStateFlag` / `RemoveSendBtnStateFlag`       | Send button flag management                                                                                                                                                    |
| `FormEvent.kt`  | `FormEvent.Click`                                                | Button component click → triggers `onClickButton` form events                                                                                                                  |
| `FieldEvent.kt` | `FieldEvent`                                                     | Sealed interface emitted by composables: `ValueChanged`, `Focused`, `Blurred`, `Click`                                                                                         |
| `FieldEvent.kt` | `FieldEventHandler`                                              | `fun interface` with `onFieldEvent(FieldEvent)` — passed to each field composable                                                                                              |
| `FormIntent.kt` | `FormIntent`                                                     | Sealed interface for parent communication: `Submit`, `Watch`, `ValidationStateChanged`, `SendBtnStateChanged`                                                                  |
| `FormIntent.kt` | `FormIntent.Submit`                                              | Carries `valueMap: Map<MetaIdComp, JsonElement>` on successful validation                                                                                                      |
| `FormIntent.kt` | `FormIntent.Watch`                                               | Per-field change notification: `fieldId`, `fieldValue`, `valueMap` snapshot                                                                                                    |

## Dependencies

- `androidx.compose.runtime.Immutable` — Marks state classes as structurally immutable for Compose stability
- `com.neome.api.meta.base.Types.MetaIdComp` — Component/field ID type (keys in all maps)
- `com.neome.core.mvi.UiEvent` — Base interface for `FormEvent` and `FormIntent`
- `com.neome.feature.form.domain.model.DefnFormUi` — Form definition stored in `FormState.defnForm`
- `com.neome.feature.form.domain.ctx.helper.events.FormCtxFormEvents.CategorizedEvents` — Pre-categorized event map stored in `FormState.categorizedEvents`
- `com.neome.feature.form.domain.ctx.helper.schema.CompSchema` — Validation schema type stored in `FormState.compSchemaMap`
- `com.neome.core.common.serializer.api.meta.base.dto.FormValueData` — Initial values stored in `FormState.initialFormValue`
- `com.neome.core.common.serializer.api.meta.base.dto.DefnDtoColorData` — Color type in `FieldProperties.bgColor`
- `kotlinx.serialization.json.JsonElement` — Field value type in `valueMap` and `FieldEvent.ValueChanged`
- `kotlinx.serialization.Serializable` — Applied to `FieldState`, `FieldProperties`, `FormEventProps`

## Related READMEs

- **Parent**: `../README.md` (presentation layer root)
- **Consumer**: `../../domain/ctx/README.md` (FormCtxImpl owns FormState, dispatches FormEvent)
- **Consumer**: `../../domain/ctx/helper/README.md` (helpers read/write FormState via FormReducerResult)
- **Consumer**: `../../domain/ref/README.md` (FormRefImpl reads FormState, dispatches FormEvent)
- **Consumer**: `../components/base/README.md` (field components receive FieldState, dispatch FieldEvent)
- **Consumer**: `../screen/README.md` (FormScreen receives FormIntent via onIntent callback)
- **Form root**: `../../form.md` (full form feature documentation)

## Change Notes

- Initial documentation created from source analysis (2026-02-22)
- 6 source files: `FormState.kt`, `FieldState.kt`, `FieldError.kt`, `FormEvent.kt`, `FieldEvent.kt`, `FormIntent.kt`
- `FieldState.defaultValue` is set once on init and never changes — used to compute `isDirty`
- Field values are NOT in `FieldState` — stored separately in `FormState.valueMap` for isolated recomposition
- `FormEvent.FieldValueChanged.depth` guards against infinite cascade (A→B→C→A loops); max depth enforced by helpers
- `FormState.categorizedEvents` caches pre-parsed event map from `DefnFormUi` to avoid repeated parsing
