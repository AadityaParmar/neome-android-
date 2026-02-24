# composite — Composite Form Components

## Purpose

Provides the two structural layout composables that contain and recursively render child form fields: `FieldSection` (a flat container supporting vertical or horizontal arrangement) and `FieldTab` (a tabbed container with a scrollable tab row). Both are dispatched by `FieldFactory` and use `LocalFormCtx` directly rather than `rememberFieldController`, since they are structural containers rather than leaf field inputs.

## Responsibilities

- `FieldSection` — renders a section definition (`DefnSection`) as a `Column` container; supports vertical/horizontal layout direction via `DefnSection.sectionDirection`; applies per-definition padding (`pl`/`pr`/`pt`/`pb`); reads column/row spacing from form theme (`DefnDtoFormThemeData.colSpacing` / `rowSpacing`); checks section visibility via `FormCtx.getFieldState`; recursively renders each child field using `FieldFactory` via private `RenderChildField`
- `FieldTab` — renders a tab definition (`DefnTab`) as a `ScrollableTabRow` with animated tab switching; reads tab labels from `defnForm.compMap`; renders the active tab's content by calling `FieldFactory` on the selected tab component via private `RenderTabContent`; wraps tab content in a `verticalScroll` column for overflow

## Flow

1. **Dispatch** — `FieldFactory` matches `EnumDefnCompType.section` or `.tab` and calls `FieldSection` / `FieldTab` with `defnComp`, `defnForm`, `onFieldEvent`, and `modifier`.
2. **Section rendering** — `FieldSection` casts `defnComp` to `DefnSection` (returns early if cast fails), reads visibility from `FormCtx.getFieldState(metaId)?.fieldProperties?.hidden`, reads theme spacing, computes padding modifier, then renders children via `Arrangement.spacedBy` in a `Row` (horizontal) or `Column` (vertical). Each child field ID is resolved via `defnForm.compMap[fieldId]` and rendered by `FieldFactory`.
3. **Tab rendering** — `FieldTab` casts `defnComp` to `DefnTab`, reads `tabIdSet`, maintains `selectedTabIndex` with `mutableIntStateOf`. Renders `ScrollableTabRow` with tab labels resolved from `defnForm.compMap`. The selected tab's composable is rendered via `RenderTabContent` → `FieldFactory`, which recursively renders the tab's child sections and fields.
4. **Recursion** — Both composites call `FieldFactory` for children, which may again call `FieldSection` or `FieldTab` for nested composites, forming a recursive render tree.

## Key Entry Points

| File | Symbol | Role |
|------|--------|------|
| `FieldSection.kt` | `FieldSection` | `@Composable` — renders `DefnSection` as directional container; reads theme spacing; calls `RenderChildField` per child |
| `FieldSection.kt` | `RenderChildField` | `@Composable private fun` — resolves `defnForm.compMap[fieldId]` and calls `FieldFactory` |
| `FieldTab.kt` | `FieldTab` | `@Composable` — renders `DefnTab` as `ScrollableTabRow` + content column with tab switching |
| `FieldTab.kt` | `RenderTabContent` | `@Composable private fun` — resolves tab component from `defnForm.compMap` and calls `FieldFactory` |

## Dependencies

- `androidx.compose.material3.ScrollableTabRow`, `Tab` — tab row UI
- `androidx.compose.foundation.layout.Arrangement.spacedBy` — spacing between child fields
- `com.neome.api.meta.base.Types.EnumDefnThemeDirection` — `vertical` / `horizontal` enum used by `FieldSection`
- `com.neome.api.meta.base.Types.MetaIdComp`, `MetaIdComposite`, `MetaIdField` — child ID types
- `com.neome.api.meta.base.dto.DefnSection` — cast target; provides `fieldIdSet`, `sectionDirection`, `pl`/`pr`/`pt`/`pb`, `metaId`
- `com.neome.api.meta.base.dto.DefnTab` — cast target; provides `tabIdSet`
- `com.neome.core.common.serializer.api.meta.base.dto.DefnCompSeal` — input opaque component definition
- `com.neome.feature.form.domain.DefnFormUi` — `compMap` for child/tab lookup; `theme` for spacing
- `com.neome.feature.form.domain.ctx.LocalFormCtx` — accessed to read visibility (`getFieldState`) and theme (`getDefnForm`)
- `com.neome.feature.form.presentation.components.base.FieldFactory` — recursive child renderer
- `com.neome.feature.form.presentation.state.FieldEvent` — passed through to children

## Related READMEs

- **Parent**: `../README.md` (presentation/components root)
- **Dispatcher**: `../base/README.md` (FieldFactory dispatches to FieldSection and FieldTab)
- **Children rendered**: `../field/README.md` (leaf field composables rendered by FieldFactory inside sections/tabs)
- **Grid sub-package**: `grid/README.md` (FieldGrid — pure event emitter for grid field; row editing state centralized in FormState.gridCtx via MVI reducer)
- **State source**: `../../state/README.md` (FieldState, FieldProperties for visibility)
- **Form root**: `../../../form.md` (full form feature documentation)

## Change Notes

- Initial documentation created from source analysis (2026-02-22)
- 2 source files: `FieldSection.kt`, `FieldTab.kt`
- `FieldSection` defers `flexGrow` / `fieldSpan` / `sectionVariant` handling to the caller via `Modifier.weight` — not implemented in the section itself
- `FieldTab` accesses `formCtx.formState.value` directly (reads `FormState`) though it does not currently use `formState` for tab visibility — tab visibility guard is not yet implemented
- Default spacing falls back to 8dp when no theme is set, matching previous hardcoded values
- `ScrollableTabRow` uses `edgePadding = 0.dp` for flush-left tab alignment
