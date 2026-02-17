# RawPicker Components — AI Context Document

## Overview

This directory contains two stateless, reusable picker components for Jetpack Compose + Material3:

- **`RawPickerSingleSelect`** — Pick one option from a list
- **`RawPickerMultiSelect`** — Pick multiple options from a list (chips UI)

Both follow the `Raw*` naming convention: they are **stateless sub-components** with no form/domain/ViewModel dependencies. All state is controlled by the caller via parameters and callbacks.

---

## File Map

```
feature/form/presentation/components/
├── Utils.kt                          # resolveThemeColor() shared utility
└── raw/
    ├── RAW_PICKER.md                 # This file
    ├── RawPickerSingleSelect.kt      # Single-select picker component
    └── RawPickerMultiSelect.kt       # Multi-select picker component
```

### Related files outside this directory

| File | Purpose |
|------|---------|
| `feature/componentshowcase/presentation/components/RawShowcase.kt` | Showcase/demo for both components (must be updated when signatures change) |
| `core/common/serializer/api/meta/base/dto/DefnStudioMapOfDtoOptionData.kt` | Option map data class |
| `core/common/serializer/api/meta/base/dto/DefnDtoOptionData.kt` | Individual option data class |
| `core/common/serializer/api/meta/base/dto/DefnDtoColorData.kt` | Color data class (value + shade) |
| `api/meta/base/Types.kt` | `EnumDefnThemeColor` enum (line ~1974+) |

---

## Data Classes

### DefnStudioMapOfDtoOptionData
```kotlin
// Ordered map of options. `keys` defines display order; `map` holds option data by metaId.
data class DefnStudioMapOfDtoOptionData(
    val keys: List<String>,           // Ordered list of metaIds
    val map: Map<String, DefnDtoOptionData>  // metaId -> option data
)
```

### DefnDtoOptionData
```kotlin
data class DefnDtoOptionData(
    val metaId: String,               // Unique identifier
    val value: String,                // Display text
    val color: DefnDtoColorData?,     // Optional text color
    val disabled: Boolean?,           // Whether option is disabled
    val isRemoved: Boolean?,          // Removed options get errorContainer background
    val hint: String?                 // Optional hint text (not currently rendered)
)
```

### DefnDtoColorData
```kotlin
data class DefnDtoColorData(
    val value: EnumDefnThemeColor?,          // Color enum value
    val shade: EnumDefnThemeColorShade?      // Shade variant (not currently used in resolveThemeColor)
)
```

---

## Component Signatures

### RawPickerSingleSelect

```kotlin
@Composable
fun RawPickerSingleSelect(
    optionMap: DefnStudioMapOfDtoOptionData?,   // Direct options (null triggers async fetch)
    selectedOption: String?,                     // Currently selected metaId (null = no selection)
    onChange: (option: DefnDtoOptionData?) -> Unit, // Fires with option on select, null on clear
    cbGetOptionMap: ((cb: (DefnStudioMapOfDtoOptionData?) -> Unit) -> Unit)? = null, // Async fetch
    label: String? = null,
    placeholder: String? = null,
    helperText: String? = null,
    isError: Boolean = false,
    enabled: Boolean = true,
    readOnly: Boolean = false,
    modifier: Modifier = Modifier
)
```

### RawPickerMultiSelect

```kotlin
@Composable
fun RawPickerMultiSelect(
    optionMap: DefnStudioMapOfDtoOptionData?,   // Direct options (null triggers async fetch)
    selectedOptions: List<String>?,              // Currently selected metaIds (null = no selection)
    onChange: (options: List<DefnDtoOptionData>?) -> Unit, // Fires on "Done" press or clear, null when empty
    cbGetOptionMap: ((cb: (DefnStudioMapOfDtoOptionData?) -> Unit) -> Unit)? = null, // Async fetch
    label: String? = null,
    placeholder: String? = null,
    helperText: String? = null,
    isError: Boolean = false,
    enabled: Boolean = true,
    readOnly: Boolean = false,
    modifier: Modifier = Modifier
)
```

---

## Feature Breakdown

### Features common to both components

| Feature | How it works |
|---------|-------------|
| **OutlinedTextField appearance** | Read-only field with dropdown arrow icon. Clicking opens a ModalBottomSheet. |
| **Click-to-open** | Uses `MutableInteractionSource` + `PressInteraction.Release` in a `LaunchedEffect` (same pattern as `FieldDate.kt`). |
| **Bottom sheet** | `ModalBottomSheet` with `rememberModalBottomSheetState(skipPartiallyExpanded = true)`. Height: `fillMaxHeight(0.75f)`. |
| **Animated close** | `scope.launch { sheetState.hide() }.invokeOnCompletion { showSheet = false }`. |
| **Search bar** | `TextField` at top of sheet with search icon. Filters options by case-insensitive `contains` match on `option.value`. Immediate filtering (no debounce). |
| **Lazy option loading** | `cbGetOptionMap` async callback. Fetched eagerly on composition via `LaunchedEffect`. Shows "Loading..." display text and `CircularProgressIndicator` in sheet while fetching. |
| **Not-found detection** | If `selectedOption`/`selectedOptions` contain metaIds missing from the resolved map, shows "Not Found" text + error border. Suppressed during loading. |
| **Clear button** | `IconButton` with `Icons.Default.Clear`. Calls `onChange(null)` + `focusManager.clearFocus()`. |
| **Option text color** | Resolved via `resolveThemeColor(option.color)` from `Utils.kt`. |
| **Removed options** | Options with `isRemoved == true` get `errorContainer` background. |
| **isInteractive guard** | `enabled && !readOnly` — disables click, clear, and dropdown when false. |

### SingleSelect-specific

| Feature | Detail |
|---------|--------|
| **Display** | Standard `OutlinedTextField` showing selected option's `value` text. |
| **Selection** | Tapping an option in the list immediately fires `onChange(option)` and animates close. |
| **Highlight** | Selected option row has `primaryContainer` background in the sheet. |

### MultiSelect-specific

| Feature | Detail |
|---------|--------|
| **Display** | `BasicTextField` + `OutlinedTextFieldDefaults.DecorationBox` with `FlowRow` of `InputChip`s. Chips wrap to multiple lines. |
| **Chip removal** | Each chip has a close (`Icons.Default.Close`) icon. Clicking it **immediately** calls `onChange` with the remaining options (live removal, no "Done" needed). |
| **Not-found chips** | Chips for missing metaIds are styled with `errorContainer` colors via `InputChipDefaults.inputChipColors`. |
| **Checkboxes** | Each option row in the sheet has a `Checkbox` on the left. |
| **Local selection state** | Sheet maintains a `mutableStateListOf` initialized from `selectedOptions`. Changes are **not committed** until "Done" is pressed. |
| **Footer** | `HorizontalDivider` + Row with "Select All"/"Deselect All" toggle + "Done" button. |
| **Select/Deselect All** | Operates on **filtered options only** (respects search query). Button text toggles based on whether all filtered options are selected. |
| **Label float** | Controlled by the `value` parameter of `DecorationBox` (not `BasicTextField`). A non-empty `displayText` keeps the label floated. Uses `VisualTransformation.None`. |

---

## resolveThemeColor() — Utils.kt

Maps `DefnDtoColorData` to a Compose `Color`. Located at:
`feature/form/presentation/components/Utils.kt`

```kotlin
@Composable
fun resolveThemeColor(color: DefnDtoColorData?): Color
```

- **null input** -> `MaterialTheme.colorScheme.onSurface` (default text color)
- **Semantic colors**: primary, secondary, error, info (tertiary), success (#4CAF50), warning (#FF9800)
- **Text variants**: textPrimary (onSurface), textSecondary (onSurfaceVariant), textDisabled (onSurface @ 0.38), textInverse
- **Light/Dark variants**: primaryLight (primaryContainer), errorLight (errorContainer), etc.
- **Named colors**: red, blue, green, amber, cyan, deepOrange, deepPurple, grey, indigo, lightBlue, lightGreen, lime, orange, pink, purple, teal, yellow, black, white
- **transparent**: Color.Transparent

> **Note**: `shade` property from `DefnDtoColorData` is not currently used by this function.

---

## Key Implementation Patterns & Gotchas

### 1. Click-to-open (MutableInteractionSource pattern)
```kotlin
val interactionSource = remember { MutableInteractionSource() }
LaunchedEffect(interactionSource, isInteractive) {
    if (isInteractive) {
        interactionSource.interactions.collect { interaction ->
            if (interaction is PressInteraction.Release) {
                showSheet = true
            }
        }
    }
}
// Pass interactionSource to the OutlinedTextField/BasicTextField
```
This is the same pattern used by `FieldDate.kt`. Do NOT use `Modifier.clickable` on the text field.

### 2. Label float bug fix
When using `OutlinedTextField` with `readOnly = true`, focus persists after icon button clicks (like clear), keeping the label floated even when value is empty. Fix: call `focusManager.clearFocus()` after clearing.

### 3. Chips in text field (MultiSelect)
`OutlinedTextField` cannot render custom content inside it. The workaround:
- Use `BasicTextField` with **empty value** (`value = ""`)
- Wrap with `OutlinedTextFieldDefaults.DecorationBox`
- The `value` parameter of **DecorationBox** (not BasicTextField) controls label float animation
- The `innerTextField` slot renders the `FlowRow` of chips (or the real `innerTextField` when empty)
- Requires `VisualTransformation.None` parameter

### 4. Animated bottom sheet close
```kotlin
scope.launch { sheetState.hide() }.invokeOnCompletion { showSheet = false }
```
Always hide the sheet state first (animation), then set showSheet = false on completion.

### 5. Local selection in MultiSelect sheet
The sheet uses `mutableStateListOf` initialized from `selectedOptions` when the sheet opens:
```kotlin
val localSelectedSet = remember(showSheet) {
    mutableStateListOf(*(selectedOptions?.toTypedArray() ?: emptyArray()))
}
```
This ensures changes in the sheet are **not committed** until "Done". The `remember(showSheet)` key re-initializes when the sheet reopens.

### 6. Search filtering operates on keys
Filtering uses `resolvedOptionMap?.keys` and checks `option.value.contains(searchQuery, ignoreCase = true)`. The filtered keys list is used for both the LazyColumn items and the "Select All" logic.

---

## How to Make Changes

### Adding a new parameter to both components
1. Add the parameter to `RawPickerSingleSelect` signature
2. Add the parameter to `RawPickerMultiSelect` signature
3. Implement the behavior in both components
4. Update `RawShowcase.kt` to pass the new parameter in demo usage
5. Run `./gradlew :app:compileDebugKotlin` to verify

### Modifying the bottom sheet UI
- Sheet content is inside `ModalBottomSheet > Column(fillMaxHeight(0.75f))`
- Loading state: `CircularProgressIndicator` centered in a `Box`
- Loaded state: Search bar `TextField` + `LazyColumn(weight(1f))` + footer (MultiSelect only)
- Bottom spacing: `Spacer(height = 32.dp)` for nav bar insets

### Modifying option item rendering
- SingleSelect: `SingleSelectOptionItem` private composable (no checkbox, plain text row)
- MultiSelect: `MultiSelectOptionItem` private composable (checkbox + text row)
- Both use `resolveThemeColor(option.color)` for text color
- Both use `errorContainer` background for `isRemoved` options

### Adding new color mappings
Edit `Utils.kt` > `resolveThemeColor()`. Add a new `EnumDefnThemeColor.xxx ->` case in the `when` block. The enum is defined in `api/meta/base/Types.kt`.

### Integrating into a form-level Field* component
These Raw components would be wrapped by a `Field*` composable that:
1. Gets state from a ViewModel/form controller
2. Resolves `optionMap` from form definition
3. Maps `onChange` callback to update form state
4. Passes `isError`, `helperText`, `enabled`, `readOnly` from field validation/permissions

---

## Build & Verify

```bash
./gradlew :app:compileDebugKotlin
```

Run this after every change. All warnings in the output are pre-existing and unrelated to these components.

---

## Showcase / Testing

`RawShowcase.kt` at `feature/componentshowcase/presentation/components/RawShowcase.kt` contains live demos:

- **SingleSelect demo**: Pre-selects `"z"` (a metaId not in the option map) to demonstrate "Not Found" error state
- **MultiSelect demo**: Pre-selects `["a", "z"]` to demonstrate both a valid chip and a "Not Found" chip

The demo uses a hardcoded `optionMap` with keys `"a"` through `"j"` and values `"AAAAA"` through `"JJJJJ"`.

Update `RawShowcase.kt` whenever component signatures change.

---

## Dependencies & Imports

### Compose/Material3
- `ModalBottomSheet`, `rememberModalBottomSheetState` — `@ExperimentalMaterial3Api`
- `FlowRow` — `@ExperimentalLayoutApi` (from `androidx.compose.foundation.layout`)
- `InputChip`, `InputChipDefaults` — Material3
- `BasicTextField` — `androidx.compose.foundation.text`
- `OutlinedTextFieldDefaults.DecorationBox` — Material3
- `Checkbox`, `HorizontalDivider`, `TextButton` — Material3

### Project
- `DefnStudioMapOfDtoOptionData` — `com.neome.core.common.serializer.api.meta.base.dto`
- `DefnDtoOptionData` — `com.neome.core.common.serializer.api.meta.base.dto`
- `resolveThemeColor` — `com.neome.feature.form.presentation.components`

### Experimental opt-ins required
```kotlin
@OptIn(ExperimentalMaterial3Api::class)                    // Both components
@OptIn(ExperimentalLayoutApi::class)                       // MultiSelect only (FlowRow)
```
