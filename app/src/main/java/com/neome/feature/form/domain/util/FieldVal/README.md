# FieldVal Package

**Purpose:** Field value type conversion and default resolution for form initialization and runtime serialization.

This package provides the core logic to:
1. Convert raw values (strings, numbers, JSON) to strongly-typed field-value DTOs
2. Convert typed field-value DTOs back to raw values
3. Resolve field defaults during form initialization (from direct values, form-level defaults, field literals, argument variables, and cross-field references)
4. Accumulate and snapshot resolved values for immutable `FormValueData` structures

## Responsibilities

### Type Conversion (Converter)
- **Raw → Typed:** Convert `Any?` raw input (String, Int, Double, JsonElement, etc.) to type-safe field-value DTO classes (e.g., `FieldValueTextData`, `FieldValueNumberData`)
- **Typed → Raw:** Convert field-value DTOs back to raw values for persistence, transmission, or display
- **JSON Round-Trip:** Decode `JsonElement` to typed DTO, validate, and re-encode (via KSerializer)
- **Numeric Coercion:** Handle heterogeneous numeric input (String, Int, Long, Double, JsonPrimitive) → `Long` or `Double`
- **Display String:** Convert field values to user-facing strings via raw value extraction

### Default Resolution (DefaultValue)
- **Form Initialization:** Walk the form tree using `FormPlus.loopDefnForm` and resolve defaults for all fields in a single pass
- **Resolution Priority:** Existing value → form-level default → field literal default → argument variable → cross-field reference
- **Cycle Prevention:** Guard against infinite recursion in cross-field references via `resolvedSet`
- **Grid Support:** Resolve defaults for grid rows independently
- **Accumulation:** Build up resolved values in `MutableFormValue` accumulator, then snapshot to immutable `FormValueData`

### Supported Default Types
- **text** — Direct string literal or argument variable
- **paragraph** — Multi-line text via literal or argument
- **info** — Display-only field via literal or argument
- **pickText** — Single-select via direct option ID or recursive field reference
- **setOfText** — Multi-select via list of option IDs or recursive field reference

**Note:** Other types (date, time, dateTime, number, decimal, bool, set-type fields, etc.) currently return `null` for defaults (TODO: expand as needed).

## Flow

### Initialization Path

```
fnEnsureInit (entry point)
  ↓
FormPlus.loopDefnForm (tree walk via depth-first traversal)
  ↓
resolveCompDefaultValue (per-component dispatch)
  ↓
One of: resolverEditableText, resolverParagraph, resolveInfo, resolverPickText, resolverSetOfText
  ↓
Check priority: existing → form-level → literal → argument → cross-field (with cycle guard)
  ↓
fnRawValueToFieldValue (type conversion)
  ↓
MutableFormValue.putValue (accumulation)
  ↓
MutableFormValue.toFormValueData (snapshot to immutable)
```

**Grid Flow:**
- Main form resolution runs first (non-grid fields)
- Then iterate grid components and call `fnEnsureInitGridRow` per row
- Each grid row uses `MutableFormValue` as accumulator, with access to parent form context

### Runtime Path (Serialization)

```
JSON input/output
  ↓
fnFieldValueToJsonElement (field-value → JsonElement via KSerializer)
  ↓
fnJsonElementFieldValue (JsonElement → raw → field-value, round-trip validation)
  ↓
fnFieldValueToRawValue (field-value → raw for persistence)
  ↓
fnResolveNumericValue / fnResolveNumericDecimalValue (numeric coercion)
  ↓
fnResolveFieldValueToString (display string extraction)
```

## Key Entry Points

| File + Symbol | Purpose |
|---|---|
| `FieldValueResolver.kt` : `object FieldValueResolver` | Singleton facade — unified access to `Converter` and `DefaultValue` interfaces |
| `DefaultValue.kt` : `fnEnsureInit(defnForm, formValue, defaultValue)` | Main entry point for form initialization; orchestrates tree walk and default resolution |
| `DefaultValue.kt` : `fnEnsureInitGridRow(defnForm, fieldGrid, formValue, gridRow)` | Default resolution for a single grid row |
| `DefaultValue.kt` : `MutableFormValue` | Accumulator for resolved values; mutable during resolution, immutable via `toFormValueData()` snapshot |
| `Converter.kt` : `fnRawValueToFieldValue(compType, rawValue)` | Type conversion: raw → field-value DTO |
| `Converter.kt` : `fnFieldValueToRawValue(compType, fieldValue)` | Type conversion: field-value DTO → raw |
| `Converter.kt` : `fnJsonElementFieldValue(compType, jsonElement)` | Round-trip validation: JSON → raw → field-value |
| `Converter.kt` : `fnFieldValueToJsonElement(compType, fieldValue)` | Serialization: field-value → JSON via KSerializer |
| `Converter.kt` : `fnResolveNumericValue(compType, value)` | Coerce heterogeneous input → `Long` |
| `Converter.kt` : `fnResolveNumericDecimalValue(compType, value)` | Coerce heterogeneous input → `Double` |
| `Converter.kt` : `fnResolveFieldValueToString(defnComp, fieldValue)` | Display string extraction |

## Dependencies & Relationships

### Domain Layer Dependencies
- `com.neome.api.meta.base.Types` — Type enums (`EnumDefnCompType`, `EntUserId`, `RowId`, etc.)
- `com.neome.api.meta.base.dto` — Field definition classes (`DefnForm`, `DefnFieldEditableText`, `DefnFieldPickText`, etc.)
- `com.neome.core.common.serializer.api.meta.base.dto` — Field value DTOs (`FieldValueTextData`, `FieldValueNumberData`, `FormValueData`, etc.)

### Utility Dependencies
- `FormPlus` (sibling in `../util/`) — Tree traversal via `loopDefnForm(defnForm, callback)`
- `ArgValueResolver` (sibling in `../util/`) — Resolves argument variables (e.g., `$arg.fieldName`)

### External Dependencies
- `kotlinx.serialization` — JSON serialization/deserialization via `KSerializer`
- `JsonParser` (from `core.common.serializer`) — Global `Json` instance for round-trip encoding/decoding
- `AppLogger` (from `core.logging`) — Non-blocking error logging

### Data Flow Relationships

```
FormPlus.loopDefnForm
  ↓ (iterates)
FieldVal package (resolves values)
  ↓ (calls)
ArgValueResolver (resolves $arg.* variables)
  ↓ (produces)
MutableFormValue.toFormValueData (→ FormValueData)
  ↓ (used by)
Presentation layer (ViewModel, Screen composables)
```

## Related READMEs

- **Parent:** `../README.md` — `util/` package overview (FormPlus, ConditionResolver, FilterForm, etc.)
- **Siblings:**
  - `ArgValueResolver.kt` — Argument variable resolution
  - `FormPlus.kt` — Form tree navigation and utilities
  - `CalcFormula.kt` — Formula calculation for computed fields
  - `ConditionResolver.kt` — Condition evaluation for visibility/validation
