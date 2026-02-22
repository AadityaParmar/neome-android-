# ref — External Form API (React Hook Form–style)

## Purpose

Provides an imperative, synchronous API for parent screens to interact with the form component. Inspired by React Hook Form's ref pattern, this package exposes read, write, validation, submission, and state-query operations without requiring direct access to form internals.

## Responsibilities

- Expose a clean `FormRef` interface for parent screens to read field values and form data
- Allow setting single or multiple field values programmatically
- Provide validation control (validate, set custom errors, clear errors)
- Enable form-level operations (submit, reset)
- Offer state queries (isDirty, isValid, isTouched) for individual fields or the entire form
- Control send button visibility and enabled state via state flags
- Bridge imperative calls to the internal `FormEvent` dispatch system

## Flow

1. **Construction** — `FormRefImpl` is created with two function references: `getFormState` (reads current `FormState` snapshot) and `dispatchEvent` (sends `FormEvent` into the form reducer).
2. **Read operations** — `getValue`, `getValues`, `getValueMap`, `getFieldState` directly read from the current `FormState` snapshot via `getFormState()`.
3. **Write operations** — `setValue` dispatches `FormEvent.FieldValueChanged`; `setValues` dispatches `FormEvent.SetValues`. The form reducer processes these events synchronously.
4. **Validation** — `validate` dispatches `FormEvent.ValidateField` or `FormEvent.ValidateAll`. `setError`/`clearErrors` dispatch the corresponding error events.
5. **Form operations** — `submit` dispatches `FormEvent.Submit` (triggers full validation then submission). `reset` dispatches `FormEvent.Reset` with optional new values.
6. **State queries** — `isDirty`, `isValid`, `isTouched` read directly from `FormState` and `FieldState` properties.
7. **Send button** — `addSendBtnStateFlag`/`removeSendBtnStateFlag` dispatch events to toggle send button flags. `isSendBtnEnabled`/`isSendBtnInvisible` read from state.

## Key Entry Points

| File | Symbol | Role |
|------|--------|------|
| `FormRef.kt` | `FormRef` (interface) | Public contract — all operations parent screens can perform |
| `FormRef.kt` | `FormRef.getValue` | Read single field value |
| `FormRef.kt` | `FormRef.getValues` | Read complete form data as `FormValueRawData` |
| `FormRef.kt` | `FormRef.setValue` | Set single field value |
| `FormRef.kt` | `FormRef.setValues` | Set multiple field values |
| `FormRef.kt` | `FormRef.validate` | Validate specific field or entire form |
| `FormRef.kt` | `FormRef.setError` / `clearErrors` | Custom error management |
| `FormRef.kt` | `FormRef.submit` / `reset` | Form-level operations |
| `FormRef.kt` | `FormRef.isDirty` / `isValid` / `isTouched` | State queries |
| `FormRef.kt` | `FormRef.addSendBtnStateFlag` / `removeSendBtnStateFlag` | Send button control |
| `FormRefImpl.kt` | `FormRefImpl` (class) | Implementation; bridges to `getFormState` + `dispatchEvent` |

## Dependencies

- `com.neome.api.meta.base.Types.MetaIdComp` — Component ID type
- `com.neome.core.common.serializer.api.meta.base.dto.FormValueRawData` — Raw form value data for API submission
- `com.neome.feature.form.presentation.state.FormState` — Immutable form state (read by impl)
- `com.neome.feature.form.presentation.state.FieldState` — Per-field state (read by impl)
- `com.neome.feature.form.presentation.state.FormEvent` — Event sealed interface (dispatched by impl)
- `com.neome.feature.form.presentation.state.SendBtnStateFlag` — Send button state flags

## Related READMEs

- **Parent**: `../README.md` (domain package)
- **State**: `../../presentation/state/README.md` (FormState, FormEvent, FieldState definitions)
- **Form root**: `../../../form.md` (full form feature documentation)

## Change Notes

- Initial documentation created from source analysis (2026-02-22)
- 2 files: `FormRef.kt` (interface, 174 lines), `FormRefImpl.kt` (implementation, 116 lines)
- All operations are synchronous — state is updated immediately via dispatch
