# raw/picker — Stateless Option Picker Components

## Purpose

Provides two purely prop-driven, stateless picker composables — `RawPickerSingleSelect` and `RawPickerMultiSelect` — for choosing one or multiple options from a list. These components have no form or domain dependencies; all state (options, selection, loading) is controlled by the caller. They are the UI layer beneath the form-aware `FieldPickText` and `FieldSetOfText` composables.

## Responsibilities

- `RawPickerSingleSelect` — displays an `OutlinedTextField` (read-only) showing the currently selected option; opens a `ModalBottomSheet` with a virtualized `LazyColumn` of single-selectable option rows; supports search, clear, loading state, and "not-found" detection for stale selections
- `RawPickerMultiSelect` — displays selected options as `InputChip`s inside a `BasicTextField` + `OutlinedTextFieldDefaults.DecorationBox` container (chips wrap via `FlowRow`); opens a `ModalBottomSheet` with checkboxes, search, "Select All"/"Deselect All", and a "Done" button that commits selection; live chip removal via close icon skips "Done"
- `SingleSelectOptionItem` (private) — plain text option row with `primaryContainer` highlight for selected state and `errorContainer` for removed options
- `MultiSelectOptionItem` (private) — checkbox + text option row with `errorContainer` for removed options; toggleable
- No async fetching — callers pass `optionMap` and `isLoading`; the raw components only render

## Flow

1. **Caller setup** — `FieldPickText` / `FieldSetOfText` resolve `optionMap` (static from `defn.optionMap` or async via `FormApiContext.onGetFieldOptions`) and pass it with `isLoading`, `selectedOption(s)`, and `onChange` to the raw component.
2. **Field display** — The raw component shows the selected value(s) in a read-only text field. During loading, shows "Loading…". If `selectedOption` metaId is absent from `optionMap`, shows "Not Found" with error styling.
3. **Sheet open** — Tap on field (via `MutableInteractionSource` + `PressInteraction.Release` in `LaunchedEffect`) sets `showSheet = true`. A `ModalBottomSheet` (75% height) opens with a search `TextField` and virtualized options list.
4. **Search** — `filteredKeys` is a `remember(optionKeys, searchQuery)` computed list filtered by case-insensitive `contains` on `option.value`. No debounce — immediate.
5. **Single selection commit** — Tapping a `SingleSelectOptionItem` immediately calls `onChange(option)` and animates the sheet closed via `sheetState.hide()`.
6. **Multi selection commit** — The sheet maintains a local `mutableStateListOf` (copy of `selectedOptions`). Toggles are applied locally. Pressing "Done" calls `onChange(resultOptions)` with the committed list (null if empty) and closes the sheet. Chip removal via close icon calls `onChange` immediately without opening the sheet.
7. **Clear** — Both components show an `Icons.Default.Clear` `IconButton` when `isInteractive && hasSelection`. Clicking calls `onChange(null)` + `focusManager.clearFocus()`.

## Key Entry Points

| File | Symbol | Role |
|------|--------|------|
| `RawPickerSingleSelect.kt` | `RawPickerSingleSelect` | `@Composable` — single-select picker; params: `optionMap`, `selectedOption: String?`, `onChange: (DefnDtoOptionData?) -> Unit`, `isLoading`, `label`, `placeholder`, `helperText`, `isError`, `enabled`, `readOnly`, `modifier` |
| `RawPickerMultiSelect.kt` | `RawPickerMultiSelect` | `@Composable` — multi-select picker; params: `optionMap`, `selectedOptions: List<String>?`, `onChange: (List<DefnDtoOptionData>?) -> Unit`, `isLoading`, `label`, `placeholder`, `helperText`, `isError`, `enabled`, `readOnly`, `modifier` |
| `RAW_PICKER.md` | — | Detailed developer context: architecture, data class shapes, async fetch pattern, implementation gotchas |

## Dependencies

- `androidx.compose.material3` — `OutlinedTextField`, `ModalBottomSheet`, `rememberModalBottomSheetState`, `InputChip`, `Checkbox`, `ScrollableTabRow`, `CircularProgressIndicator`
- `androidx.compose.foundation.layout.FlowRow` (`@ExperimentalLayoutApi`) — chip wrapping in multi-select
- `androidx.compose.foundation.lazy.LazyColumn` — virtualized option list in bottom sheet
- `androidx.compose.foundation.text.BasicTextField` — base for multi-select field container
- `com.neome.core.common.serializer.api.meta.base.dto.DefnDtoOptionData` — individual option: `value: String`, `color: DefnDtoColorData?`, `isRemoved: Boolean?`
- `com.neome.core.common.serializer.api.meta.base.dto.DefnStudioMapOfDtoOptionData` — ordered option map: `keys: List<String>` (display order), `map: Map<String, DefnDtoOptionData>`
- `com.neome.feature.form.presentation.components.resolveThemeColor` — maps `DefnDtoColorData` to Compose `Color` (from `Utils.kt` in parent `components/`)

## Related READMEs

- **Parent**: `../../README.md` (presentation/components root)
- **Callers**: `../field/README.md` — `FieldPickText` (single-select) and `FieldSetOfText` (multi-select) use these raw components
- **Context for async fetch**: `../../../../domain/ctx/README.md` (`FormCtx.getApiCtx()`, `FormApiContext.onGetFieldOptions`)
- **State types**: `../../../state/README.md` (FieldEvent dispatched by field callers, not raw components)
- **Form root**: `../../../../form.md` (full form feature documentation)
- **Existing context doc**: `RAW_PICKER.md` (detailed implementation notes, data class shapes, gotchas — kept as developer reference)

## Change Notes

- Initial README.md created from source analysis (2026-02-22); `RAW_PICKER.md` already existed as detailed developer context and is preserved alongside this README
- 2 source files + 1 existing context doc: `RawPickerSingleSelect.kt`, `RawPickerMultiSelect.kt`, `RAW_PICKER.md`
- Click-to-open uses `MutableInteractionSource` + `PressInteraction.Release` pattern (same as `FieldDate.kt`) — do NOT use `Modifier.clickable` on the text field
- Multi-select uses `BasicTextField` with empty value + `OutlinedTextFieldDefaults.DecorationBox`; the `value` parameter of `DecorationBox` (not `BasicTextField`) controls label float animation
- `isOptionNotFound` detection is suppressed while `isLoading = true` to prevent flashing error state during async fetch
- `onChange` receives `null` for both single and multi-select when selection is cleared or "Done" is pressed with no selection
