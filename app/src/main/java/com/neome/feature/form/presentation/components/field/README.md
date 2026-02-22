# field — Leaf Field Composables

## Purpose

Contains all leaf-level form field composables — one per `EnumDefnCompType` — plus shared sub-components, dialog helpers, and utilities. Each `Field*` composable is a stateful wrapper that calls `rememberFieldController<T>` for reactive state access and delegates rendering to a private stateless `*Content` composable for optimal recomposition. `FieldFactory` (in `base/`) dispatches to these composables based on `defnComp.type`.

## Responsibilities

- One `Field*` composable per supported field type: reads reactive state via `FieldController`, guards visibility, wraps content in `FieldBase`, and dispatches `FieldEvent`s
- Stateless inner `*Content` composables (private) that only recompose when their props change
- `MuiIconMapper` (`muiIconToImageVector`) — maps MUI icon name strings to Compose `ImageVector`s for `FieldButton`
- `RawCounter` — stateless `[-][input][+]` counter UI used by `FieldCounter` and `FieldLogCounter`
- `RawCaptureExtraProperties` — stateless composable for rendering captured time, user, and location metadata rows (used by `FieldSignature`, `FieldCamera`, `FieldDocument`)
- `ImagePreviewDialog` — full-screen `AlertDialog` with pinch-to-zoom/pan; accepts `Uri` or `ByteArray`; used by `FieldImage` and `FieldCamera`
- `SignatureDrawDialog` — full-screen freeform signature `Canvas` dialog; used by `FieldSignature`
- `resolveThemeColor` helper (in parent `components/Utils.kt`) — used by `FieldButton` and picker components for color resolution

## Field Components by Type

### Text / String inputs
| Composable | `EnumDefnCompType` | Value type | Notes |
|---|---|---|---|
| `FieldText` | `text` | `FieldValueTextData` | `OutlinedTextField`, single-line |
| `FieldEmail` | `email` | `FieldValueTextData` | Email keyboard type |
| `FieldHandle` | `handle` | `FieldValueTextData` | Handle/username input |
| `FieldHyperlink` | `hyperlink` | `FieldValueTextData` | URL input |
| `FieldMobileNumber` | `mobileNumber` | `FieldValueTextData` | Phone keyboard; rendered as `FieldMobile` internally |
| `FIeldParagraph` | `paragraph` | `FieldValueTextData` | Multi-line; `lineCount` from properties |
| `FieldIdentifier` | `identifier` | `FieldValueTextData` | Read-only system identifier display |

### Numeric inputs
| Composable | `EnumDefnCompType` | Value type | Notes |
|---|---|---|---|
| `FieldNumber` | `number` | `FieldValueNumberData` | Integer; `OutlinedTextField` with numeric keyboard |
| `FieldDecimal` | `decimal` | `FieldValueDecimalData` | Decimal; `OutlinedTextField` with decimal keyboard |
| `FieldCounter` | `counter` | `FieldValueNumberData` | `[-][input][+]` via `RawCounter`; min/max/step from properties |
| `FieldLogCounter` | `logCounter` | `FieldValueNumberData` | Log-style counter via `RawCounter` |

### Date / Time
| Composable | `EnumDefnCompType` | Value type | Notes |
|---|---|---|---|
| `FieldDate` | `date` | `FieldValueDateData` | Material3 `DatePickerDialog`; ISO `yyyy-MM-dd` storage, `dd/MM/yyyy` display |
| `FieldDateTime` | `dateTime` | `FieldValueDateTimeData` | Combined date+time picker |
| `FieldDateRange` | `dateRange` | `FieldValueDateRangeData` | Start + end date picker |
| `FieldDateTimeRange` | `dateTimeRange` | `FieldValueDateTimeRangeData` | Start + end date+time picker |
| `FieldTime` | `time` | `FieldValueTimeData` | Time picker dialog; `showSecond` from properties |

### Selection / Pick
| Composable | `EnumDefnCompType` | Value type | Notes |
|---|---|---|---|
| `FieldPickText` | `pickText` | `FieldValueOptionIdData` | Single-select via `RawPickerSingleSelect`; async fetch via `FormApiContext` when `defn.optionMap == null && defn.pluginApi != null` |
| `FieldSetOfText` | `setOfText` | `FieldValueSetOfOptionIdData` | Multi-select via `RawPickerMultiSelect`; async fetch same pattern |
| `FieldSwitch` | `bool` | `FieldValueBoolData` | Material3 `Switch`; `showAsCheckbox` property renders `Checkbox` instead |

### Media / Capture
| Composable | `EnumDefnCompType` | Value type | Notes |
|---|---|---|---|
| `FieldImage` | `image` | `FieldValueImageData` | File picker (IMAGE mode); preview via `ImagePreviewDialog(ByteArray)`; size validation against `maxSize` |
| `FieldCamera` | `camera` | `FieldValueImageData` | Camera capture; preview via `ImagePreviewDialog`; capture metadata via `RawCaptureExtraProperties` |
| `FieldDocument` | `document` | `FieldValueDocumentData` | File picker (ALL mode); `maxSize` validation; capture metadata |
| `FieldSignature` | `signature` | `FieldValueSignatureData` | Tap-to-draw via `SignatureDrawDialog`; capture metadata via `RawCaptureExtraProperties`; bitmap export is TODO |

### Action
| Composable | `EnumDefnCompType` | Value type | Notes |
|---|---|---|---|
| `FieldButton` | `button` | `Unit?` (no stored value) | 4 variants: `contained`, `outlined`, `text`, `icon` (via `EnumDefnThemeButtonVariant`); icon via `muiIconToImageVector`; dispatches `FieldEvent.Click` |

### Sub-components (not Field* wrappers)
| File | Symbol | Used by |
|---|---|---|
| `MuiIconMapper.kt` | `muiIconToImageVector(iconName: String?): ImageVector?` | `FieldButton` — maps MUI camelCase icon names to `Icons.Filled.*` / `Icons.AutoMirrored.Filled.*` |
| `RawCounter.kt` | `RawCounter` | `FieldCounter`, `FieldLogCounter` — `[-][input][+]` row with `BasicTextField` + `IconButton`s |
| `RawCaptureExtraProperties.kt` | `RawCaptureExtraProperties` | `FieldSignature`, `FieldCamera`, `FieldDocument` — shows captured time, user, location rows |
| `ImagePreviewDialog.kt` | `ImagePreviewDialog(uri, fileName, onDismiss)` | `FieldCamera` — pinch-to-zoom `AlertDialog` from URI |
| `ImagePreviewDialog.kt` | `ImagePreviewDialog(byteArray, fileName, onDismiss)` | `FieldImage` — same dialog from ByteArray |
| `ImagePreviewDialog.kt` | `ImagePreviewState` | State holder for zoom/pan; created via `rememberImagePreviewState()` |
| `SignatureDrawDialog.kt` | `SignatureDrawDialog(onDismiss, onConfirm)` | `FieldSignature` — full-screen `Canvas` for freeform drawing |

## Flow (per field composable)

1. Call `rememberFieldController<T>(defnComp, onFieldEvent)` → get `FieldController<T>`
2. Guard: `if (fieldController.fieldId == null) return`
3. Read `fieldController.value.value` (deserialized `T?`) and `fieldController.field.value` (destructure `properties`, `error`)
4. Guard: `if (properties.hidden) return`
5. Wrap content in `FieldBase(properties = properties)` for layout and visibility
6. Render stateless `*Content` composable with current value, properties, error
7. On user input: call `fieldController.onChange(newValue)` which encodes `T?` → `JsonElement` and dispatches `FieldEvent.ValueChanged`
8. For focus/blur/click: dispatch `FieldEvent.Focused(fieldId)` / `FieldEvent.Blurred(fieldId)` / `FieldEvent.Click(fieldId)` directly via `onFieldEvent`

**Picker fields additionally:** manage `isFetchingOptions` state + `LaunchedEffect` for async `FormApiContext.onGetFieldOptions`

**Media/capture fields additionally:** integrate `rememberFilePicker` or camera launcher, validate file size, create media metadata

## Key Entry Points

| File | Symbol | Role |
|------|--------|------|
| `FieldText.kt` | `FieldText` | Text input — pattern reference for all simple `OutlinedTextField` fields |
| `FieldButton.kt` | `FieldButton` / `FieldButtonContent` | Button with 4 variants, icon support, custom bg color |
| `FieldDate.kt` | `FieldDate` | Date picker — reference pattern for `MutableInteractionSource` + `PressInteraction.Release` click-to-open |
| `FieldPickText.kt` | `FieldPickText` | Single-select with async fetch — reference for `FormApiContext` usage pattern |
| `FieldImage.kt` | `FieldImage` | Image picker with preview — reference for `rememberFilePicker` + `ImagePreviewDialog` |
| `FieldSignature.kt` | `FieldSignature` | Signature with capture metadata — reference for `RawCaptureExtraProperties` + `SignatureDrawDialog` |
| `MuiIconMapper.kt` | `muiIconToImageVector` | Top-level fun mapping 60+ MUI icon name strings to Compose `ImageVector?` |
| `RawCounter.kt` | `RawCounter` | Stateless `[-][input][+]` counter; params: `value: Long?`, `onValueChange: (Long?) -> Unit`, `min`, `max`, `step`, `enabled`, `readOnly`, `isError` |
| `RawCaptureExtraProperties.kt` | `RawCaptureExtraProperties` | Stateless capture metadata rows; shows time/user/location from field value |
| `ImagePreviewDialog.kt` | `ImagePreviewDialog` (both overloads) | Full-screen zoom+pan image dialog (URI and ByteArray variants) |
| `SignatureDrawDialog.kt` | `SignatureDrawDialog` | Full-screen signature drawing dialog; bitmap export is TODO |

## Dependencies

- `androidx.compose.material3` — `OutlinedTextField`, `DatePickerDialog`, `TimePicker`, `ModalBottomSheet`, `Switch`, `Checkbox`, `Button`, `OutlinedButton`, `TextButton`, `IconButton`, `AlertDialog`
- `androidx.compose.foundation` — `Canvas`, `detectDragGestures`, `detectTransformGestures`, `LazyColumn`, `BasicTextField`
- `com.neome.feature.form.presentation.components.base` — `rememberFieldController`, `FieldBase` (used by every field)
- `com.neome.feature.form.presentation.components.raw.picker` — `RawPickerSingleSelect` (FieldPickText), `RawPickerMultiSelect` (FieldSetOfText)
- `com.neome.feature.form.presentation.components.resolveThemeColor` — color resolution for `FieldButton`
- `com.neome.feature.form.presentation.state` — `FieldEvent`, `FieldError`, `FieldProperties`
- `com.neome.feature.form.domain.ctx.LocalFormCtx` — accessed in `rememberFieldController` and picker fields for `getApiCtx()`
- `com.neome.feature.filepicker.presentation.rememberFilePicker` — file picker launcher for `FieldImage`, `FieldDocument`
- `com.neome.feature.utils.MediaFieldUtil` — image compression/metadata extraction for `FieldImage`
- `com.neome.core.common.serializer.api.meta.base.dto.*` — `FieldValue*Data` types, `DefnField*Data` cast targets
- `com.neome.api.meta.base.Types.EnumDefnCompType`, `EnumDefnThemeButtonVariant` — type enums

## Related READMEs

- **Parent**: `../README.md` (presentation/components root — Form.kt, Utils.kt)
- **Base**: `../base/README.md` (FieldFactory dispatches to these; rememberFieldController + FieldBase defined here)
- **Picker sub-components**: `../raw/picker/README.md` (RawPickerSingleSelect, RawPickerMultiSelect)
- **Composites that render these**: `../composite/README.md` (FieldSection, FieldTab)
- **State types**: `../../state/README.md` (FieldEvent, FieldProperties, FieldError, FieldController)
- **Async API context**: `../../../domain/ctx/README.md` (FormApiContext.onGetFieldOptions)
- **Form root**: `../../../form.md` (full form feature documentation)

## Change Notes

- Initial documentation created from source analysis (2026-02-22)
- 29 source files: 24 `Field*` composables + `MuiIconMapper`, `RawCounter`, `RawCaptureExtraProperties`, `ImagePreviewDialog`, `SignatureDrawDialog`
- `FieldSignature` bitmap export (actual signature data persistence) is a TODO — dialog opens but confirms with no-op
- `FieldFactory` (in `base/`) has a TODO for `EnumDefnCompType.grid` — not implemented in `field/`
- Click-to-open pattern (date, image, signature, camera): `MutableInteractionSource` + `PressInteraction.Release` in `LaunchedEffect` — do NOT use `Modifier.clickable`
- `FieldButton` stores no value (`Unit?`); `rememberFieldController<Unit?>` is used purely for `FieldProperties` access
- `ImagePreviewDialog` has two overloads: `(Uri, …)` for camera/document, `(ByteArray, …)` for freshly-captured/compressed images
- `FIeldParagraph.kt` has a typo in the filename (capital `I`) — matches the actual file on disk
