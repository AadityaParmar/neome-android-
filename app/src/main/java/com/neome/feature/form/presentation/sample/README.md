# presentation/sample

## Purpose

Provides hardcoded sample data for `FormScreen` development, preview, and debugging. Eliminates the need for a live backend when iterating on form UI.

## Responsibilities

- Load and cache a sample `SigEntCallerData` from a bundled JSON resource (`SigEntCaller.json`).
- Derive a sample form definition ID from the caller entity's `formMap`.
- Construct a `DefnFormUi` ready for rendering by running `FilterForm.prepareUiForm` on the sample data.
- Expose a single entry point (`createTextForm`) that returns a fully prepared `DefnFormUi`.

## Flow

1. `createTextForm` is called (e.g. from a preview or debug screen).
2. `getSampleCallerEnt` reads and deserializes `SigEntCaller.json` via the classloader, caching the raw string in `callerEntStr`.
3. `createSampleDefnForm` extracts the first form ID from `SigEntCallerData.formMap`.
4. Both the `DefnFormData` (from `createSampleDefnForm`) and `SigEntCallerData` (from `getSampleCallerEnt`) are passed to `FilterForm.prepareUiForm`.
5. The resulting `DefnFormUi` is returned to the caller.

## Key Entry Points

- `presentation/sample/FormSampleDataFactory.kt` — `FormSampleDataFactory` (object)
  - `createTextForm(): DefnFormUi` — primary entry point; returns a render-ready form
  - `getSampleCallerEnt(): SigEntCallerData` — loads/caches and deserializes `SigEntCaller.json`
  - `createSampleDefnForm(): String` — extracts a form definition ID from the cached caller entity
  - `createSampleCallerEnt(): String` — reads raw JSON from classloader resources

## Dependencies / Relationships

- `FilterForm` — applies field-level filtering/preparation to produce `DefnFormUi`
- `JsonParser` — deserializes JSON strings into `DefnFormData` and `SigEntCallerData`
- `DefnFormUi`, `DefnFormData` — domain form definition types (see `domain/README.md`)
- `SigEntCallerData` — caller entity type carrying `formMap`
- `SysId`, `Types` — shared constants/type enums used during form construction
- Bundled resource `SigEntCaller.json` — loaded via `ClassLoader.getResourceAsStream`

## Related READMEs

- Parent: `presentation/README.md`
- Sibling: `presentation/screen/README.md` — the screen that consumes `DefnFormUi` at runtime
- Domain: `domain/README.md` — defines `DefnFormUi`, `DefnFormData`, and related types

## Change Notes

- Initial README created as part of the form-feature readme-init initiative.
