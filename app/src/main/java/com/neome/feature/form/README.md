# Form Feature

## Purpose

Dynamic, schema-driven form rendering and data capture system for Android applications using Jetpack Compose. Provides role-based permissions, field validation, computed properties, and a composable component library for flexible form UI.

## Responsibilities

- Define and manage form lifecycle, state, and data flow using MVI pattern with unidirectional data flow
- Provide schema-driven form rendering with 40+ field types (text, number, date, picker, media, etc.)
- Handle role-based permissions, field visibility, and validation rules
- Support computed properties, conditional logic, and formula-based calculations
- Deliver external form API (`FormRef`) for imperative access from parent screens
- Maintain clean architecture separation: presentation (UI) → domain (business logic) ← data

## Flow

1. **Form definition ingestion** — Raw `DefnFormData` from API is transformed into `DefnFormUi` with computed permissions, parent maps, and managerial relationships
2. **Context initialization** — `FormCtx` receives `DefnFormUi` and initializes form state via helpers in `domain/ctx/helper/`
3. **UI interaction** — Composable field components access `FormCtx` via `LocalFormCtx` to read state and dispatch events through `dispatch(FormEvent)`
4. **Event processing** — Events flow through pure-state helpers (`ctx/helper/events/`) that update `FormState` immutably
5. **Submission and external access** — Form data is submitted via `FormRef` API; parent screens can imperatively access form state and operations

## Key Entry Points

| File | Symbol | Role |
|------|--------|------|
| `presentation/screen/FormScreen.kt` | `FormScreen` | Composable UI entry point for form display |
| `presentation/screen/FormScreenViewModel.kt` | `FormScreenViewModel` | Manages `FormState` and processes `FormIntent` |
| `domain/ref/FormRef.kt` | `FormRef` | External API for imperative form operations (setValue, validate, submit) |
| `domain/ctx/FormCtx.kt` | `FormCtx` | Internal context for state access and event dispatch |
| `presentation/components/Form.kt` | `Form` | Root composable component that renders form fields |

## Dependencies / Relationships

### External
- Jetpack Compose + Material3 — UI framework
- Kotlin Coroutines + Flow — Async operations
- Kotlinx Serialization — JSON serialization/deserialization
- Hilt — Dependency injection

### Internal
- `com.neome.api.meta.base.*` — Base form definition interfaces and DTOs
- `com.neome.core.*` — Shared utilities, DI modules, resource wrappers

## Related READMEs

- **Full Documentation**: `form.md` — Complete API reference, architecture details, data flows, how-to guides, and troubleshooting
- **Module Index**: `MODULES.md` — Package path index of all modules and classes
- **Domain Layer**: `domain/README.md` — DefnFormUi, role-based permissions, form context (`ctx/`), external API (`ref/`), utilities (`util/`)
- **Presentation Layer**: `presentation/README.md` — UI state definitions, composable component library, screen and ViewModel, sample data

## Change Notes

- Initial root README created as final step of form-feature readme-init initiative (2026-02-22)
- All 16 child package READMEs created (domain and presentation layers)
- Total scope: ~98 files, ~7500 LOC across domain and presentation packages
- Architecture: MVI + UDF + CompositionLocal pattern
