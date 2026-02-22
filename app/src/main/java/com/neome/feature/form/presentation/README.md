# presentation

## Purpose

Contains all UI-layer code for the form feature: state definitions, composable components, the form screen with its ViewModel, and sample/preview data factories.

## Responsibilities

- Define the complete UI state model and user intent/event types for form rendering.
- Provide a library of composable field components, sections, and utility helpers.
- Host `FormScreen` and `FormScreenViewModel` as the primary runtime entry point for form display and interaction.
- Supply `FormSampleDataFactory` for preview and debug use without a live backend.

## Flow

State and event types (`state/`) are consumed by `FormScreenViewModel` (`screen/`), which drives `FormScreen`. The screen delegates field rendering to the component library (`components/`). Sample data (`sample/`) feeds the screen in preview or debug builds via `FormSampleDataFactory.createTextForm`.

## Key Entry Points

- `presentation/screen/FormScreen.kt` — `FormScreen` composable; top-level runtime entry point
- `presentation/screen/FormScreenViewModel.kt` — `FormScreenViewModel`; manages `FormState` and processes `FormIntent`
- `presentation/state/` — `FormState`, `FieldState`, `FormEvent`, `FormIntent`, `FieldEvent`, `FieldError`
- `presentation/components/Form.kt` — `Form` composable; root component rendered by `FormScreen`
- `presentation/sample/FormSampleDataFactory.kt` — `FormSampleDataFactory`; `createTextForm()` for previews

## Dependencies / Relationships

- `domain/` — all domain types (`DefnFormUi`, `FieldState` source types, `FormCtx`, etc.) consumed here
- `core/` — shared utilities, resource wrappers, and DI infrastructure

## Related READMEs

- Parent: `../README.md` (form feature root)
- Children:
  - `state/README.md` — UI state and event/intent types
  - `components/README.md` — composable component library
  - `screen/README.md` — `FormScreen` and `FormScreenViewModel`
  - `sample/README.md` — `FormSampleDataFactory` for preview/debug

## Change Notes

- Initial README created as part of the form-feature readme-init initiative.
