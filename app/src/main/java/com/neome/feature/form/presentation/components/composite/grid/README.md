# grid — Grid Field Component (Centralized Row Editing)

## Purpose

Renders a grid field (`DefnGridData`) as a list of rows with add/edit/remove capabilities. Row editing state is **centralized in `FormState.gridCtx`**, managed by the MVI reducer. The grid composable is a pure event emitter with zero local state — sheet visibility, row values, errors, and field states are all derived from `FormState.gridCtx`.

## Architecture

Grid row editing follows the same reducer pattern as the parent form:

- `FieldGrid` emits `FieldEvent.GridAdd`/`GridEdit` → `Form.kt` maps to `FormEvent.GridOpen`
- Reducer (`FormCtxGridHelper.handleGridOpen`) initializes `FormState.gridCtx` via `GridRowInitHelper.initializeGridCtx`
- `ReducerFormGridStateAccessor` wraps the parent accessor and routes field read/write based on `fieldId ∈ gridCtx.fieldIdSet`
- `GridFormCtx` provides a derived `FormState` from `gridCtx` so child fields in the sheet use standard `rememberFieldController` transparently
- Submit: `FieldEvent.GridSubmit` → `FormEvent.GridSubmit` → reducer validates, merges row into parent `FieldValueGridData`, clears `gridCtx`
- Dismiss: `FieldEvent.GridClose` → `FormEvent.GridClose` → reducer clears `gridCtx` → sheet disappears
- `gridCtx != null` means the grid bottom sheet is open; `gridCtx == null` means closed

## Responsibilities

- `FieldGrid` — top-level composable for the grid field; reads `FieldValueGridData` via `rememberFieldController`; renders the row list and Add button via stateless `FieldGridContent`; derives sheet visibility from `formState.gridCtx?.gridId == fieldId`; emits `FieldEvent.GridAdd`, `GridEdit`, `GridRemove`, `GridSubmit`, `GridClose` to parent; creates `GridFormCtx` for the sheet when active
- `GridRowSheet` — `ModalBottomSheet` rendering child fields inside `CompositionLocalProvider(LocalFormCtx provides gridFormCtx)`; iterates `DefnGridData.fieldIdSet` and calls `FieldFactory` per child; forwards `FieldEvent`s from children to parent via `onFieldEvent`; calls `onSubmit`/`onDismiss` for submit/cancel actions
- `GridFormCtx` — read-only `FormCtx` that derives `FormState` from `FormState.gridCtx` using `derivedStateOf`; child fields see grid row field states, values, and errors without touching parent form state; returns empty `FormState(isInitialized = false)` when `gridCtx` is null
- `GridRowInitHelper` — builds `GridCtx` for the MVI reducer; resolves field states, value map, dependencies, and validation schemas scoped to the grid's child fields; supports add (empty) and edit (pre-populated from existing `FieldDtoGridRowData`) paths

## Flow

1. **Dispatch** — `FieldFactory` matches `EnumDefnCompType.grid` and calls `FieldGrid` with `defnComp`, `defnForm`, `onFieldEvent`, and `modifier`.
2. **Row list rendering** — `FieldGrid` reads `FieldValueGridData` via `rememberFieldController`, extracts row keys, and renders `FieldGridContent` (a stateless `Column` of clickable rows with delete icons plus an Add button). Respects `disabled`/`readOnly` properties.
3. **Add flow** — user taps Add → `FieldGrid` emits `FieldEvent.GridAdd(fieldId)` → `Form.kt` maps to `FormEvent.GridOpen(gridId, rowId=null)` → `FormCtxGridHelper.handleGridOpen` generates `RowId`, calls `GridRowInitHelper.initializeGridCtx` for empty state → `FormState.gridCtx` populated → sheet opens.
4. **Edit flow** — user taps a row → `FieldGrid` emits `FieldEvent.GridEdit(fieldId, rowId)` → `Form.kt` maps to `FormEvent.GridOpen(gridId, rowId)` → `FormCtxGridHelper.handleGridOpen` retrieves existing `FieldDtoGridRowData` from parent grid value → `GridRowInitHelper.initializeGridCtx` builds pre-populated state → `FormState.gridCtx` populated → sheet opens.
5. **Sheet rendering** — `FieldGrid` detects `formState.gridCtx?.gridId == fieldId`, creates `GridFormCtx` wrapping parent `FormCtx` → `GridRowSheet` provides it as `LocalFormCtx` → `FieldFactory` renders child fields → children read/write via `GridFormCtx` which derives from `gridCtx`.
6. **Event flow in sheet** — child field emits `FieldEvent.ValueChanged`/`Focused`/`Blurred` → flows up through `onFieldEvent` → `Form.kt` maps to `FormEvent.FieldValueChanged` etc. → reducer uses `ReducerFormGridStateAccessor` to route mutations to `gridCtx` state for grid fields.
7. **Submit** — user taps Save/Add → `FieldGrid` emits `FieldEvent.GridSubmit(fieldId)` → `Form.kt` maps to `FormEvent.GridSubmit` → `FormCtxGridHelper.handleGridSubmit` validates all grid fields via schema → if valid, collects row values, builds updated `FieldValueGridData`, writes to parent via `parentAccessor`, clears `gridCtx` → sheet closes. If invalid, `gridCtx` stays open with errors populated inline.
8. **Remove flow** — user taps delete icon → `FieldGrid` emits `FieldEvent.GridRemove(fieldId, rowId)` → `Form.kt` maps to `FormEvent.GridRemove` → `FormCtxGridHelper.handleGridRemove` removes the row from `FieldValueGridData`.
9. **Dismiss** — user cancels or swipes sheet → `FieldGrid` emits `FieldEvent.GridClose(fieldId)` → reducer clears `gridCtx` → sheet disappears, no changes emitted.

## Key Entry Points

| File                   | Symbol                                | Role                                                                                                       |
|------------------------|---------------------------------------|------------------------------------------------------------------------------------------------------------|
| `FieldGrid.kt`         | `FieldGrid`                           | `@Composable` — pure event emitter; reads grid value and `gridCtx` from `FormState`; emits all grid events |
| `FieldGrid.kt`         | `FieldGridContent`                    | `@Composable private` — stateless row list with Add button and per-row delete                              |
| `GridRowSheet.kt`      | `GridRowSheet`                        | `@Composable` — `ModalBottomSheet` rendering child fields via `GridFormCtx` as `LocalFormCtx`              |
| `GridFormCtx.kt`       | `GridFormCtx`                         | `FormCtx` implementation — derives `FormState` from `FormState.gridCtx` via `derivedStateOf`               |
| `GridRowInitHelper.kt` | `GridRowInitHelper.initializeGridCtx` | Builds `GridCtx` for add or edit mode; resolves field states, values, dependencies, schemas                |

## Dependencies

- `androidx.compose.material3.ModalBottomSheet`, `rememberModalBottomSheetState` — bottom sheet UI
- `androidx.compose.runtime.CompositionLocalProvider` — provides `GridFormCtx` as `LocalFormCtx`
- `androidx.compose.runtime.derivedStateOf` — efficient recomposition scoped to `gridCtx` changes
- `com.neome.api.meta.base.Types.MetaIdComp`, `MetaIdField`, `RowId` — ID types
- `com.neome.core.common.serializer.api.meta.base.dto.DefnGridData` — grid definition with `fieldIdSet`
- `com.neome.core.common.serializer.api.meta.base.dto.FieldDtoGridRowData` — per-row value container
- `com.neome.core.common.serializer.api.meta.base.dto.FieldValueGridData` — grid field value (keys + map of rows)
- `com.neome.feature.form.domain.model.DefnFormUi` — parent form definition (`compMap`, `theme`)
- `com.neome.feature.form.domain.ctx.FormCtx` — interface implemented by `GridFormCtx`
- `com.neome.feature.form.domain.ctx.LocalFormCtx` — `CompositionLocal` overridden inside the sheet
- `com.neome.feature.form.domain.ctx.base.schema.CompSchemaFactory` — `buildFormSchemas` for validation schemas
- `com.neome.feature.form.domain.util.FieldPropertyResolver` — resolves field properties and builds dependency maps
- `com.neome.feature.form.presentation.components.base.FieldBase` — wrapper composable for field chrome
- `com.neome.feature.form.presentation.components.base.FieldFactory` — recursive child field renderer (used inside sheet)
- `com.neome.feature.form.presentation.components.base.rememberFieldController` — reads field state/value from `FormCtx`
- `com.neome.feature.form.presentation.state.FieldEvent` — parent form event contract
- `com.neome.feature.form.presentation.state.FormState`, `GridCtx` — centralized state types

## Related READMEs

- **Parent**: `../README.md` (composite components — FieldSection, FieldTab, and grid)
- **Dispatcher**: `../../base/README.md` (FieldFactory dispatches to FieldGrid; FieldBase and rememberFieldController used by grid)
- **Reducer helpers**: `../../../../domain/ctx/base/README.md` (ReducerFormGridStateAccessor, FormCtxGridHelper — grid event handlers and state routing)
- **State types**: `../../../state/README.md` (FormState, GridCtx, FieldState, FieldError, FieldProperties, FieldDependencyMap)
- **FormCtx contract**: `../../../../domain/ctx/README.md` (FormCtx interface, LocalFormCtx, FormCtxImpl event routing)
- **Children rendered**: `../../field/README.md` (leaf field composables rendered by FieldFactory inside the sheet)
- **Form root**: `../../../../form.md` (full form feature documentation)

## Change Notes

- Initial documentation created from source analysis (2026-02-23)
- **Architecture rewrite (2026-02-24)**: Centralized grid row editing state into `FormState.gridCtx` via MVI reducer. Deleted `GridRowCtxImpl`, `GridRowCtx.kt` (GridRowState/GridRowEvent), and `GridRowEventHelper` — all local state eliminated. Added `GridFormCtx` (derived FormCtx) and `GridRowInitHelper.initializeGridCtx` (builds `GridCtx` for reducer). `FieldGrid` is now a pure event emitter with zero local `mutableStateOf`. Grid event handling moved to `FormCtxGridHelper` (`handleGridOpen`/`handleGridClose`/`handleGridSubmit`/`handleGridRemove`). Field read/write routing handled by `ReducerFormGridStateAccessor` in domain layer.
- 4 source files: `FieldGrid.kt`, `GridRowSheet.kt`, `GridFormCtx.kt`, `GridRowInitHelper.kt`
- `GridRowSheet` uses `@OptIn(ExperimentalMaterial3Api::class)` for `ModalBottomSheet` and `rememberModalBottomSheetState`
- `FieldGridContent` renders rows via `Column` (not `LazyColumn`) to avoid nested scroll conflicts with the parent form's `verticalScroll`
- Row display currently shows `rowId.toString()` — no row summary/label resolution yet
