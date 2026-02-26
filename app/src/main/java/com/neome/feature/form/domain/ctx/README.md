# ctx — Form Context Facade & State Management

## Purpose

Provides the central context for form rendering in Compose: state ownership, event dispatch, and CompositionLocal injection. The `FormCtx` interface is the Compose-facing API that coordinates all form interactions, while `FormCtxImpl` couples state mutations with delegated helpers for field events, validation, grid operations, and send button synchronization.

## Responsibilities

- Own and manage mutable `FormState` via `State<FormState>` reactive property
- Provide single event dispatch entry point that routes to pure-state helpers in `base/`
- Implement `FormStateAccessor` interface for safe read/write mutations during reducer cycles
- Provide Compose CompositionLocal (`LocalFormCtx`) for dependency injection within the form tree
- Inject `FormCtxImpl` state management into field composables via `LocalFormCtx.current`
- Create `FormRef` instances for imperative form control from parent screens
- Initialize form state from definition and optional initial values via `FormCtxInitHelper`
- Coordinate side-effect intents (Watch, Submit, SendBtnStateChanged) back to the ViewModel

## Flow

1. **Context creation** — Parent composable instantiates `FormCtxImpl(defnForm: DefnFormUi, initialValue: FormValueData?, onIntent: (FormIntent) -> Unit)`. Constructor initializes form state via `FormCtxInitHelper.initializeFormState` and emits initial `SendBtnStateChanged` intent via `onIntent` callback.

2. **Compose integration** — Parent composable provides `FormCtx` instance to the tree via `CompositionLocalProvider(LocalFormCtx provides formCtx) { Form(formCtx) }`. Child field composables access it via `val ctx = LocalFormCtx.current`.

3. **Event dispatch** — Field composables call `dispatch(event: FormEvent)` (internal, accessed via FormRef or ViewModel callback). Dispatcher routes to helpers:
    - Field events (FieldValueChanged, FieldFocused, FieldBlurred, FieldTouched, TriggerField, Click) → `FormCtxEventHelper`
    - Validation events (ValidateField, ValidateAll, SetFieldError, ClearFieldError, ClearAllErrors) → `FormCtxValidationHelper`
    - Grid operations (GridAdd, GridEdit, GridRemove) → `FormCtxGridHelper`
    - Send button state (AddSendBtnStateFlag, RemoveSendBtnStateFlag) → `FormCtxSendBtnStateHelper`
    - Form-level events (Submit, Reset, SetValues) → `FormCtxEventHelper`

4. **State mutation** — Each helper receives `ReducerFormStateAccessor` (implementation of `FormStateAccessor`) and produces `FormReducerResult(state: FormState, intents: List<FormIntent>)`. Dispatcher updates `_formState.value` and calls `onIntent(intent)` for each intent.

5. **Reactive recomposition** — Compose recomposes observing components when `_formState.value` changes. Components read from `formState: State<FormState>` via `collectAsStateWithLifecycle()`.

6. **Imperative access** — Parent screens call `FormRef.getFormState()` and `FormRef.dispatchEvent(event)` (returned from `createFormRef()`) to validate, submit, or reset programmatically.

## Key Entry Points

| File             | Symbol                                   | Role                                                                                                             |
|------------------|------------------------------------------|------------------------------------------------------------------------------------------------------------------|
| `FormCtx.kt`     | `FormStateAccessor`                      | Interface defining read/write mutations for field/error/flag state during reducer cycles                         |
| `FormCtx.kt`     | `FormCtx`                                | Interface providing `formState: State<FormState>`, `getFieldState(fieldId)`, `getApiCtx()`, `getDefnFormTheme()` |
| `FormCtx.kt`     | `LocalFormCtx`                           | CompositionLocal (`staticCompositionLocalOf<FormCtx>`) for dependency injection in Compose tree                  |
| `FormCtxImpl.kt` | `FormCtxImpl`                            | Concrete FormCtx implementation; owns `_formState`, coordinates all event dispatch                               |
| `FormCtxImpl.kt` | `FormCtxImpl.dispatch(event)`            | Internal event dispatcher routing to `base/` helpers                                                             |
| `FormCtxImpl.kt` | `FormCtxImpl.processEvent(state, event)` | Pure-state reducer applying helpers to state snapshot                                                            |
| `FormCtxImpl.kt` | `FormCtxImpl.createFormRef()`            | Factory returning `FormRefImpl` for imperative access                                                            |
| `FormCtxImpl.kt` | `FormCtxImpl.getFieldState(fieldId)`     | Accessor for per-field state snapshot                                                                            |
| `FormCtxImpl.kt` | `FormCtxImpl.getDefnFormTheme()`         | Accessor for form-level theme configuration                                                                      |

## Dependencies

- `com.neome.feature.form.domain.model.DefnFormUi` — Form definition (compMap, eventMap, theme)
- `com.neome.feature.form.domain.ctx.base.FormCtxInitHelper` — Initializes FormState from definition
- `com.neome.feature.form.domain.ctx.base.FormCtxEventHelper` — Handles field/form events
- `com.neome.feature.form.domain.ctx.base.FormCtxValidationHelper` — Handles validation events
- `com.neome.feature.form.domain.ctx.base.FormCtxGridHelper` — Handles grid operations
- `com.neome.feature.form.domain.ctx.base.FormCtxSendBtnStateHelper` — Synchronizes send button state
- `com.neome.feature.form.domain.ctx.base.FormReducerResult` — Return type for event handlers
- `com.neome.feature.form.domain.ctx.base.ReducerFormStateAccessor` — Implementation of FormStateAccessor
- `com.neome.feature.form.domain.ref.FormRef`, `FormRefImpl` — Imperative form control API
- `com.neome.feature.form.presentation.state.FormState`, `FieldState`, `FormEvent`, `FormIntent`, `SendBtnStateFlag` — State types (presentation layer)
- `com.neome.core.common.serializer.api.meta.base.dto.FormValueData`, `DefnDtoFormThemeData` — Data transfer objects
- `androidx.compose.runtime.State`, `mutableStateOf`, `staticCompositionLocalOf` — Compose runtime

## Related READMEs

- **Parent**: `../README.md` (form domain layer — context, definitions, permissions, utilities)
- **Child**: `base/README.md` (state orchestration helpers — initialization, event dispatch, validation)
- **Sibling**: `../ref/README.md` (FormRef — external/imperative form API for parent screens)
- **Sibling**: `../util/README.md` (property/condition/argument resolution utilities)
- **Form root**: `../../form.md` (full form feature documentation)

## Change Notes

- Documentation updated from source analysis (2026-02-24)
- 2 source files (`FormCtx.kt`, `FormCtxImpl.kt`) + 1 child package (`base/`)
- `FormCtxImpl` constructor takes `onIntent: (FormIntent) -> Unit` callback for ViewModel integration
- `dispatch(event)` is internal; external access via `FormRef` or ViewModel-provided callback
- `ReducerFormStateAccessor` implements `FormStateAccessor` for safe mutation during reducer cycles
