# components — Form Component Layer

## Purpose

Contains the top-level `Form` composable (the public embedding API for the form feature), the shared `resolveThemeColor` utility, and all child sub-packages (`base/`, `composite/`, `field/`, `raw/picker/`). `Form.kt` is the single entry point for host screens that embed a form; `Utils.kt` provides a color resolution helper used across field and picker components.

## Responsibilities

- `Form` — the public `@Composable` embedding API: creates and remembers `FormCtxImpl`, provides it via `CompositionLocalProvider(LocalFormCtx)`, converts `FieldEvent`s from children to `FormEvent`s via `dispatch`, emits `FormIntent`s to the host via `onIntent`, exposes `FormRef` via `formRef: MutableState<FormRef?>`
- `FormContent` (private) — stateless inner composable: guards `state.isInitialized`, resolves `defnForm.displayCompositeId` to the root component, and calls `FieldFactory` to kick off the recursive render tree
- `resolveThemeColor(color: DefnDtoColorData?): Color` — `@Composable` function mapping `EnumDefnThemeColor` values to Material3 `colorScheme` tokens or hardcoded ARGB `Color` constants; fallback is `colorScheme.onSurface`

## Flow

1. **Host screen** provides `defnForm: DefnFormUi`, `initialValue: FormValueData?`, `formRef: MutableState<FormRef?>`, and `onIntent: (FormIntent) -> Unit` to `Form(...)`.
2. **Form creation** — `remember(defnForm, initialValue)` creates `FormCtxImpl` once, immediately initializing `FormState` and emitting the initial `SendBtnStateChanged` intent.
3. **CompositionLocal provision** — `CompositionLocalProvider(LocalFormCtx provides formCtx)` makes the context available to all descendant field composables.
4. **FormRef exposure** — `formCtx.createFormRef()` is called once per `formCtx` instance; `LaunchedEffect(formRefImpl)` sets `formRef.value`; `DisposableEffect` clears it on dispose.
5. **FieldEvent bridge** — The `onFieldEvent` lambda (stable via `remember(formCtx)`) converts each `FieldEvent` variant to its corresponding `FormEvent` and calls `formCtx.dispatch(...)`.
6. **Render tree** — `FormContent` looks up `defnForm.compMap[displayCompositeId]` and passes the root component to `FieldFactory`, which recursively renders all composites and leaf fields.
7. **Color resolution** — Field components and picker components call `resolveThemeColor(defnDtoColorData)` to get a Compose `Color` for option text colors, button backgrounds, etc.

## Key Entry Points

| File | Symbol | Role |
|------|--------|------|
| `Form.kt` | `Form` | Public `@Composable` — params: `defnForm: DefnFormUi`, `initialValue: FormValueData?`, `formRef: MutableState<FormRef?>`, `onIntent: (FormIntent) -> Unit`, `modifier: Modifier` |
| `Form.kt` | `FormContent` | Private `@Composable` — stateless rendering; guards init state; calls `FieldFactory` on root component |
| `Utils.kt` | `resolveThemeColor` | `@Composable fun resolveThemeColor(color: DefnDtoColorData?): Color` — maps 40+ `EnumDefnThemeColor` values to Compose `Color` |

## Dependencies

- `androidx.compose.runtime.CompositionLocalProvider` — provides `LocalFormCtx` to descendant tree
- `androidx.compose.runtime.MutableState` — type of `formRef` parameter; updated via `LaunchedEffect`
- `com.neome.feature.form.domain.ctx.FormCtxImpl` — created inside `Form`; owns `FormState` and `dispatch`
- `com.neome.feature.form.domain.ctx.LocalFormCtx` — the `staticCompositionLocalOf` provided by `Form`
- `com.neome.feature.form.domain.ref.FormRef` — type returned by `formCtx.createFormRef()` and exposed via `formRef`
- `com.neome.feature.form.domain.DefnFormUi` — input form definition
- `com.neome.feature.form.presentation.components.base.FieldFactory` — called from `FormContent` to render root component
- `com.neome.feature.form.presentation.state.FieldEvent`, `FormEvent`, `FormIntent`, `FormState` — event/state types bridged by `Form`
- `com.neome.api.meta.base.Types.EnumDefnThemeColor` — color enum used in `resolveThemeColor`
- `com.neome.core.common.serializer.api.meta.base.dto.DefnDtoColorData`, `FormValueData` — input types

## Related READMEs

- **Children**: `base/README.md` (FieldFactory, FieldController, FieldBase)
- **Children**: `composite/README.md` (FieldSection, FieldTab)
- **Children**: `field/README.md` (all leaf Field* composables)
- **Children**: `raw/picker/README.md` (RawPickerSingleSelect, RawPickerMultiSelect)
- **Parent**: `../README.md` (presentation layer root)
- **Context provider**: `../../domain/ctx/README.md` (FormCtxImpl, LocalFormCtx)
- **State types**: `../state/README.md` (FormState, FormEvent, FormIntent, FieldEvent)
- **Form root**: `../../form.md` (full form feature documentation)

## Change Notes

- Initial documentation created from source analysis (2026-02-22)
- 2 source files at root: `Form.kt`, `Utils.kt` + 4 child packages (`base/`, `composite/`, `field/`, `raw/`)
- `Form` is stateful (creates `FormCtxImpl`) but `FormContent` is intentionally stateless — separation allows isolated recomposition testing
- `rememberUpdatedState(onIntent)` is used so the latest `onIntent` lambda is captured without recreating `formCtx`
- `formRef.value` is set via `LaunchedEffect` (not synchronously) to avoid state mutation during composition
- `resolveThemeColor` covers all 40 `EnumDefnThemeColor` entries; `shade` property of `DefnDtoColorData` is not currently used
