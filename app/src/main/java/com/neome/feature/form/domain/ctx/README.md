# ctx — Form Context and State Management Facade

## Purpose

Provides the central form context (`FormCtx`) that field components use to read state, dispatch events, and trigger validation. `FormCtxImpl` is the concrete implementation that owns the Compose `mutableStateOf<FormState>`, routes all `FormEvent` variants to the pure-state helper functions, and emits `FormIntent` side effects. `FormApiContext` extends the context with optional external API capabilities.

## Responsibilities

- Define the `FormCtx` interface for field component access (read state, trigger, validate, manage errors and send button flags)
- Provide `LocalFormCtx` as a `staticCompositionLocalOf` for CompositionLocal-based dependency injection
- Initialize form state via `FormCtxInitHelper.initializeFormState` in the `FormCtxImpl` constructor
- Route all `FormEvent` variants to the appropriate helper handler (event, validation, send button flag)
- Apply state updates synchronously via `mutableStateOf` and emit intents via the `onIntent` callback
- Create `FormRef` instances for external API access via `createFormRef`
- Define the `FormApiContext` interface for optional external data fetching (field options)

## Flow

1. **Construction** — `FormCtxImpl` receives `DefnFormUi`, optional `FormValueData`, and an `onIntent` callback. It immediately initializes `FormState` via `FormCtxInitHelper.initializeFormState` and stores it in a Compose `mutableStateOf`. The init block emits an initial `SendBtnStateChanged` intent.
2. **Event dispatch** — `dispatch(event)` calls `processEvent` which pattern-matches the `FormEvent` variant and delegates to the appropriate helper: `FormCtxEventHelper` for value/focus/blur/touch/trigger/click/submit/reset/setValues, `FormCtxValidationHelper` for validate/setError/clearError, and local handlers for send button flag management. Each handler returns a `FormReducerResult` containing the new state and optional intent.
3. **State update** — After `processEvent`, the new state is written to `_formState.value` (triggering Compose recomposition), and any intent is forwarded via `onIntent`.
4. **FormCtx reads** — Field composables access `FormCtx` via `LocalFormCtx.current`. Read methods (`getValues`, `getFieldState`, `getValue`, `getError`, `hasField`, `getDefnForm`) delegate directly to `currentState`. Mutation methods (`trigger`, `validate`, `setError`, `clearError`, `addSendBtnStateFlag`, `removeSendBtnStateFlag`) wrap the operation in a `FormEvent` and call `dispatch`.
5. **FormRef creation** — `createFormRef()` returns a `FormRefImpl` backed by lambdas pointing to `currentState` and `dispatch`, providing React Hook Form–style API to parent screens.

## Key Entry Points

| File | Symbol | Role |
|------|--------|------|
| `FormCtx.kt` | `FormCtx` (interface) | Internal form context for field components — state reads, trigger, validate, error/send button management |
| `FormCtx.kt` | `LocalFormCtx` | `staticCompositionLocalOf<FormCtx>` — CompositionLocal provider |
| `FormCtxImpl.kt` | `FormCtxImpl` (class) | Concrete implementation owning `mutableStateOf<FormState>`, event dispatch, and intent emission |
| `FormCtxImpl.kt` | `FormCtxImpl.dispatch` | Central event dispatch — routes `FormEvent` to helpers and applies state update |
| `FormCtxImpl.kt` | `FormCtxImpl.createFormRef` | Creates `FormRefImpl` for external API access |
| `FormApiContext.kt` | `FormApiContext` (interface) | Optional API context for external data fetching (field options) |
| `FormApiContext.kt` | `FormApiContext.onGetFieldOptions` | Callback-based API to fetch options for a field |

## Dependencies

- `androidx.compose.runtime.State`, `mutableStateOf`, `staticCompositionLocalOf` — Compose state primitives
- `com.neome.feature.form.domain.DefnFormUi` — Form definition
- `com.neome.feature.form.domain.ctx.helper.FormCtxInitHelper` — Form state initialization
- `com.neome.feature.form.domain.ctx.helper.FormCtxEventHelper` — Event handling (value changes, focus, submit, reset, etc.)
- `com.neome.feature.form.domain.ctx.helper.FormCtxValidationHelper` — Validation handling
- `com.neome.feature.form.domain.ctx.helper.FormReducerResult` — State + intent wrapper
- `com.neome.feature.form.domain.ref.FormRef`, `FormRefImpl` — External API interface and implementation
- `com.neome.feature.form.presentation.state.FormState`, `FormEvent`, `FormIntent`, `FieldState`, `FieldError`, `SendBtnStateFlag` — State and event types
- `com.neome.core.common.serializer.api.meta.base.dto.FormValueData` — Initial form value data
- `com.neome.api.meta.base.Types.MetaIdComp`, `MetaIdField` — ID types
- `com.neome.api.meta.base.dto.DefnStudioMapOfDtoOption` — Option map DTO for `FormApiContext`

## Related READMEs

- **Child**: `helper/README.md` (pure-state orchestration — init, events, validation helpers)
- **Parent**: `../README.md` (domain package root)
- **Sibling**: `../ref/README.md` (FormRef — external API for parent screens, created by `FormCtxImpl.createFormRef`)
- **Sibling**: `../util/README.md` (utilities used by helpers)
- **Form root**: `../../form.md` (full form feature documentation)

## Change Notes

- Initial documentation created from source analysis (2026-02-22)
- 3 source files + 1 child package (helper/)
- `FormCtxImpl.dispatch` is `internal` — only accessible within the module
- `FormApiContext` is currently optional (`getApiCtx()` returns null by default); no concrete implementation in this package
- Send button flag management (`AddSendBtnStateFlag`, `RemoveSendBtnStateFlag`) is handled directly in `FormCtxImpl` rather than delegated to helpers
