# RawPicker Components — AI Context Document

## Overview

This directory contains two stateless, reusable picker components for Jetpack Compose + Material3:

- **`RawPickerSingleSelect`** — Pick one option from a list
- **`RawPickerMultiSelect`** — Pick multiple options from a list (chips UI)

Both follow the `Raw*` naming convention: they are **purely prop-driven, stateless sub-components** with no form/domain/ViewModel dependencies. All state (including option data) is controlled by the caller via parameters and callbacks. Async option fetching is the parent's responsibility — these components only render what they're given.

---

## Architecture: Raw vs Field Layer

```
FieldPickText / FieldSetOfText   (form-aware, handles async fetch via FormApiContext)
        │
        ▼
RawPickerSingleSelect / RawPickerMultiSelect   (stateless, prop-driven, no form deps)
```

- **Raw layer**: Receives `optionMap`, `isLoading`, `selectedOption(s)`, `onChange` — renders UI only
- **Field layer**: Accesses `FormCtx` / `FormApiContext`, resolves `defn.optionMap` vs async fetch, manages loading state, passes resolved data down to Raw

---

## File Map

```
feature/form/presentation/components/
├── Utils.kt                              # resolveThemeColor() shared utility
├── field/
│   ├── FieldPickText.kt                  # Form-level single-select (uses RawPickerSingleSelect)
│   └── FieldSetOfText.kt                 # Form-level multi-select (uses RawPickerMultiSelect)
└── raw/picker/
    ├── RAW_PICKER.md                     # This file
    ├── RawPickerSingleSelect.kt          # Single-select picker component
    └── RawPickerMultiSelect.kt           # Multi-select picker component
```

### Related files outside this directory

| File                                                                       | Purpose                                                                        |
|----------------------------------------------------------------------------|--------------------------------------------------------------------------------|
| `feature/componentshowcase/presentation/components/RawShowcase.kt`         | Showcase/demo for both Raw components (must be updated when signatures change) |
| `feature/form/domain/ctx/FormCtx.kt`                                       | Form context interface with `getApiCtx()` method                               |
| `feature/form/domain/ctx/FormApiContext.kt`                                | API context interface with `onGetFieldOptions()`                               |
| `core/common/serializer/api/meta/base/dto/DefnStudioMapOfDtoOptionData.kt` | Option map data class                                                          |
| `core/common/serializer/api/meta/base/dto/DefnDtoOptionData.kt`            | Individual option data class                                                   |
| `core/common/serializer/api/meta/base/dto/DefnDtoColorData.kt`             | Color data class (value + shade)                                               |
| `core/common/serializer/api/meta/base/dto/DefnFieldPickTextData.kt`        | PickText field definition (has `optionMap` and `pluginApi`)                    |
| `core/common/serializer/api/meta/base/dto/DefnFieldSetOfTextData.kt`       | SetOfText field definition (has `optionMap` and `pluginApi`)                   |
| `api/meta/base/Types.kt`                                                   | `EnumDefnThemeColor` enum (line ~1974+), `MetaIdField` type                    |

---

## Data Classes

### DefnStudioMapOfDtoOptionData

```kotlin
// Ordered map of options. `keys` defines display order; `map` holds option data by metaId.
// Implements DefnStudioMapOfDtoOption interface.
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
    optionMap: DefnStudioMapOfDtoOptionData?,   // Options to display (null = no options available yet)
    selectedOption: String?,                     // Currently selected metaId (null = no selection)
    onChange: (option: DefnDtoOptionData?) -> Unit, // Fires with option on select, null on clear
    isLoading: Boolean = false,                  // True = show "Loading…" text + spinner in sheet
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
    optionMap: DefnStudioMapOfDtoOptionData?,   // Options to display (null = no options available yet)
    selectedOptions: List<String>?,              // Currently selected metaIds (null = no selection)
    onChange: (options: List<DefnDtoOptionData>?) -> Unit, // Fires on "Done" press or clear, null when empty
    isLoading: Boolean = false,                  // True = show "Loading…" text + spinner in sheet
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

| Feature                          | How it works                                                                                                                                               |
|----------------------------------|------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **OutlinedTextField appearance** | Read-only field with dropdown arrow icon. Clicking opens a ModalBottomSheet.                                                                               |
| **Click-to-open**                | Uses `MutableInteractionSource` + `PressInteraction.Release` in a `LaunchedEffect` (same pattern as `FieldDate.kt`).                                       |
| **Bottom sheet**                 | `ModalBottomSheet` with `rememberModalBottomSheetState(skipPartiallyExpanded = true)`. Height: `fillMaxHeight(0.75f)`.                                     |
| **Animated close**               | `scope.launch { sheetState.hide() }.invokeOnCompletion { showSheet = false }`.                                                                             |
| **Search bar**                   | `TextField` at top of sheet with search icon. Filters options by case-insensitive `contains` match on `option.value`. Immediate filtering (no debounce).   |
| **Loading state**                | When `isLoading = true`: field shows "Loading…" text, bottom sheet shows `CircularProgressIndicator`. Not-found detection is suppressed during loading.    |
| **Not-found detection**          | If `selectedOption`/`selectedOptions` contain metaIds missing from `optionMap`, shows "Not Found" text + error border. Suppressed when `isLoading = true`. |
| **Clear button**                 | `IconButton` with `Icons.Default.Clear`. Calls `onChange(null)` + `focusManager.clearFocus()`.                                                             |
| **Option text color**            | Resolved via `resolveThemeColor(option.color)` from `Utils.kt`.                                                                                            |
| **Removed options**              | Options with `isRemoved == true` get `errorContainer` background.                                                                                          |
| **isInteractive guard**          | `enabled && !readOnly` — disables click, clear, and dropdown when false.                                                                                   |

### SingleSelect-specific

| Feature       | Detail                                                                                 |
|---------------|----------------------------------------------------------------------------------------|
| **Display**   | Standard `OutlinedTextField` showing selected option's `value` text.                   |
| **Selection** | Tapping an option in the list immediately fires `onChange(option)` and animates close. |
| **Highlight** | Selected option row has `primaryContainer` background in the sheet.                    |

### MultiSelect-specific

| Feature                   | Detail                                                                                                                                                              |
|---------------------------|---------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **Display**               | `BasicTextField` + `OutlinedTextFieldDefaults.DecorationBox` with `FlowRow` of `InputChip`s. Chips wrap to multiple lines.                                          |
| **Chip removal**          | Each chip has a close (`Icons.Default.Close`) icon. Clicking it **immediately** calls `onChange` with the remaining options (live removal, no "Done" needed).       |
| **Not-found chips**       | Chips for missing metaIds are styled with `errorContainer` colors via `InputChipDefaults.inputChipColors`.                                                          |
| **Checkboxes**            | Each option row in the sheet has a `Checkbox` on the left.                                                                                                          |
| **Local selection state** | Sheet maintains a `mutableStateListOf` initialized from `selectedOptions`. Changes are **not committed** until "Done" is pressed.                                   |
| **Footer**                | `HorizontalDivider` + Row with "Select All"/"Deselect All" toggle + "Done" button.                                                                                  |
| **Select/Deselect All**   | Operates on **filtered options only** (respects search query). Button text toggles based on whether all filtered options are selected.                              |
| **Label float**           | Controlled by the `value` parameter of `DecorationBox` (not `BasicTextField`). A non-empty `displayText` keeps the label floated. Uses `VisualTransformation.None`. |

---

## Async Option Fetching (Field Layer)

The Raw components are purely prop-driven — they do NOT fetch options themselves. Async option fetching is handled by the **Field layer** (`FieldPickText` / `FieldSetOfText`).

### How it works

```
defn.optionMap != null  →  Use static options directly
defn.optionMap == null && defn.pluginApi != null  →  Fetch via FormApiContext
```

### Implementation pattern (in FieldPickText / FieldSetOfText)

```kotlin
val formCtx = LocalFormCtx.current
var fetchedOptionMap by remember { mutableStateOf<DefnStudioMapOfDtoOptionData?>(null) }
var isFetchingOptions by remember { mutableStateOf(false) }

LaunchedEffect(defn.optionMap, defn.pluginApi) {
    if (defn.optionMap == null && defn.pluginApi != null) {
        val apiCtx = formCtx.getApiCtx()
        if (apiCtx != null) {
            val fieldId = fieldController.fieldId as? MetaIdField ?: return@LaunchedEffect
            isFetchingOptions = true
            fetchedOptionMap = null
            apiCtx.onGetFieldOptions(fieldId) { options ->
                fetchedOptionMap = options as? DefnStudioMapOfDtoOptionData
                isFetchingOptions = false
            }
        }
    }
}

val resolvedOptionMap = defn.optionMap ?: fetchedOptionMap
```

Then pass to Raw component:

```kotlin
RawPickerSingleSelect(
    optionMap = resolvedOptionMap,
    isLoading = isFetchingOptions,
    ...
)
```

### Key types involved

| Type                               | Location                                          | Purpose                                              |
|------------------------------------|---------------------------------------------------|------------------------------------------------------|
| `FormCtx`                          | `feature/form/domain/ctx/FormCtx.kt`              | Form context, accessed via `LocalFormCtx.current`    |
| `FormApiContext`                   | `feature/form/domain/ctx/FormApiContext.kt`       | API context with `onGetFieldOptions(fieldId, cb)`    |
| `MetaIdField`                      | `api/meta/base/Types.kt`                          | Field ID type (extends `MetaIdComp`)                 |
| `DefnStudioMapOfDtoOption`         | `api/meta/base/dto/DefnStudioMapOfDtoOption.kt`   | Interface returned by `onGetFieldOptions` callback   |
| `DefnStudioMapOfDtoOptionData`     | `core/common/.../DefnStudioMapOfDtoOptionData.kt` | Concrete data class (implements the interface above) |
| `DefnFieldPickTextData.pluginApi`  | `core/common/.../DefnFieldPickTextData.kt`        | Plugin API reference (type: `DefnDtoPluginApiData?`) |
| `DefnFieldSetOfTextData.pluginApi` | `core/common/.../DefnFieldSetOfTextData.kt`       | Plugin API reference (type: `DefnDtoPluginApiData?`) |

### Type cast note

`FormApiContext.onGetFieldOptions` callback returns `DefnStudioMapOfDtoOption?` (interface), but the Raw components accept `DefnStudioMapOfDtoOptionData?` (concrete class). The Field layer does a safe cast: `options as? DefnStudioMapOfDtoOptionData`. This works because `DefnStudioMapOfDtoOptionData` is the only implementation of the interface in the codebase.

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

Filtering uses `optionMap?.keys` and checks `option.value.contains(searchQuery, ignoreCase = true)`. The filtered keys list is used for both the LazyColumn items and the "Select All" logic.

---

## How to Make Changes

### Adding a new parameter to both Raw components

1. Add the parameter to `RawPickerSingleSelect` signature
2. Add the parameter to `RawPickerMultiSelect` signature
3. Implement the behavior in both components
4. Update `FieldPickTextContent` and `FieldSetOfTextContent` to pass the new parameter
5. Update `RawShowcase.kt` to pass the new parameter in demo usage
6. Run `./gradlew :app:compileDebugKotlin` to verify

### Modifying the bottom sheet UI

- Sheet content is inside `ModalBottomSheet > Column(fillMaxHeight(0.75f))`
- Loading state: `CircularProgressIndicator` centered in a `Box` (shown when `isLoading = true`)
- Loaded state: Search bar `TextField` + `LazyColumn(weight(1f))` + footer (MultiSelect only)
- Bottom spacing: `Spacer(height = 32.dp)` for nav bar insets

### Modifying option item rendering

- SingleSelect: `SingleSelectOptionItem` private composable (no checkbox, plain text row)
- MultiSelect: `MultiSelectOptionItem` private composable (checkbox + text row)
- Both use `resolveThemeColor(option.color)` for text color
- Both use `errorContainer` background for `isRemoved` options

### Adding new color mappings

Edit `Utils.kt` > `resolveThemeColor()`. Add a new `EnumDefnThemeColor.xxx ->` case in the `when` block. The enum is defined in `api/meta/base/Types.kt`.

### Modifying async option fetching behavior

Edit `FieldPickText.kt` or `FieldSetOfText.kt`. The fetch logic is in a `LaunchedEffect` block that checks `defn.optionMap == null && defn.pluginApi != null`. The Raw components know nothing about fetching — they just receive `optionMap` and `isLoading`.

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

Update `RawShowcase.kt` whenever Raw component signatures change.

---

## Dependencies & Imports

### Compose/Material3 (Raw components)

- `ModalBottomSheet`, `rememberModalBottomSheetState` — `@ExperimentalMaterial3Api`
- `FlowRow` — `@ExperimentalLayoutApi` (from `androidx.compose.foundation.layout`)
- `InputChip`, `InputChipDefaults` — Material3
- `BasicTextField` — `androidx.compose.foundation.text`
- `OutlinedTextFieldDefaults.DecorationBox` — Material3
- `Checkbox`, `HorizontalDivider`, `TextButton` — Material3

### Project (Raw components)

- `DefnStudioMapOfDtoOptionData` — `com.neome.core.common.serializer.api.meta.base.dto`
- `DefnDtoOptionData` — `com.neome.core.common.serializer.api.meta.base.dto`
- `resolveThemeColor` — `com.neome.feature.form.presentation.components`

### Project (Field components — additional)

- `LocalFormCtx` — `com.neome.feature.form.domain.ctx`
- `FormApiContext` — `com.neome.feature.form.domain.ctx`
- `MetaIdField` — `com.neome.api.meta.base.Types`
- `rememberFieldController` — `com.neome.feature.form.presentation.components.base`

### Experimental opt-ins required

```kotlin
@OptIn(ExperimentalMaterial3Api::class)                    // Both Raw components
@OptIn(ExperimentalLayoutApi::class)                       // RawPickerMultiSelect only (FlowRow)
```
