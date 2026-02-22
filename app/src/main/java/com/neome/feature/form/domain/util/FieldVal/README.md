# FieldVal — Field Value Type Conversion and Default Resolution

## Purpose

Provides the central value-handling layer for the form engine: converting between raw values, typed field-value DTOs, and JSON elements, plus resolving default values for fields at form initialization. `FieldValueResolver` is the single entry point — a Kotlin `object` that mixes in `Converter` and `DefaultValue` interfaces.

## Responsibilities

- Convert raw values (primitives, JsonElements) to typed field-value DTOs per component type (`fnRawValueToFieldValue`)
- Convert typed field-value DTOs back to raw values (`fnFieldValueToRawValue`)
- Round-trip JsonElement to typed field-value via decode-then-encode (`fnJsonElementFieldValue`)
- Serialize any field-value DTO to JsonElement using KSerializer reflection (`fnFieldValueToJsonElement`)
- Resolve numeric values from heterogeneous inputs to Long or Double (`fnResolveNumericValue`, `fnResolveNumericDecimalValue`)
- Stringify field values for display (`fnResolveFieldValueToSting`)
- Resolve default values for fields at form initialization, including recursive cross-field defaults and grid row defaults (`fnEnsureInit`, `fnEnsureInitGridRow`)
- Provide a mutable value accumulator (`MutableFormValue`) used during initialization to build the value map incrementally

## Flow

1. **Conversion** — Callers (schemas, event executor, field controllers) invoke `FieldValueResolver.fnRawValueToFieldValue(compType, rawValue)` to wrap a primitive into the correct `FieldValue*Data` DTO. The reverse path uses `fnFieldValueToRawValue`. JSON round-trips go through `fnJsonElementFieldValue` (decode → re-encode) or `fnFieldValueToJsonElement` (serialize via KSerializer).
2. **Default resolution** — At form init, `fnEnsureInit(defnForm, formValue, defaultValue)` iterates every component via `FormPlus.loopDefnForm`. For each field in a section, it calls `resolveCompDefaultValue` which checks: existing value → form-level default → field-specific default (literal, arg string via `ArgValueResolver`, or recursive reference to another field). Grid fields are handled separately by `fnEnsureInitGrid` / `fnEnsureInitGridRow`.
3. **Cycle guard** — `resolveCompDefaultValue` tracks resolved component IDs in a `resolvedSet` to prevent infinite recursion when fields reference each other.
4. **MutableFormValue** — During initialization, values are accumulated in `MutableFormValue`, which is seeded with caller-provided defaults overlaid by existing persisted values. Once complete, `toFormValueData()` produces an immutable `FormValueData` snapshot.

## Key Entry Points

| File | Symbol | Role |
|------|--------|------|
| `FieldValueResolver.kt` | `FieldValueResolver` (object) | Singleton facade; implements both `Converter` and `DefaultValue` |
| `Converter.kt` | `Converter.fnRawValueToFieldValue` | Raw value → typed FieldValue*Data DTO (routes by `EnumDefnCompType`) |
| `Converter.kt` | `Converter.fnFieldValueToRawValue` | Typed FieldValue*Data DTO → raw value (routes by `EnumDefnCompType`) |
| `Converter.kt` | `Converter.fnJsonElementFieldValue` | JsonElement → typed field-value round-trip |
| `Converter.kt` | `Converter.fnFieldValueToJsonElement` | Any field-value DTO → JsonElement via KSerializer |
| `Converter.kt` | `Converter.fnResolveNumericValue` | Heterogeneous input → Long (for number/decimal/counter) |
| `Converter.kt` | `Converter.fnResolveNumericDecimalValue` | Heterogeneous input → Double |
| `Converter.kt` | `Converter.fnResolveFieldValueToSting` | Field value → display string |
| `DefaultValue.kt` | `DefaultValue.fnEnsureInit` | Initialize form value map with defaults for all fields |
| `DefaultValue.kt` | `DefaultValue.fnEnsureInitGridRow` | Initialize a single grid row with defaults |
| `DefaultValue.kt` | `MutableFormValue` | Mutable accumulator for building value maps during initialization |
| `DefaultValue.kt` | `MutableFormValue.toFormValueData` | Snapshot mutable state to immutable `FormValueData` |
| `DefaultValue.kt` | `MutableFormValue.toFieldDtoGridRowData` | Snapshot mutable state to immutable `FieldDtoGridRowData` |

## Dependencies

- `com.neome.api.meta.base.Types` — `EnumDefnCompType`, `MetaIdComp`, `RowId`, `EntUserId`, and other ID types
- `com.neome.api.meta.base.SysId` — ID generation for new rows
- `com.neome.api.meta.base.dto.DefnFieldEditableText`, `DefnFieldParagraph`, `DefnFieldInfo`, `DefnFieldPickText`, `DefnFieldSetOfText` — field definition DTOs with default value properties
- `com.neome.core.common.serializer.api.meta.base.dto.*` — All `FieldValue*Data` and `FieldSet*Data` typed value wrappers, `DefnCompSeal`, `DefnGridData`, `FormValueData`, `FieldDtoGridRowData`
- `com.neome.core.logging.AppLogger` — Error logging for conversion failures
- `com.neome.feature.utils.JsonParser` — kotlinx.serialization JSON instance
- `com.neome.feature.form.domain.util.ArgValueResolver` — Resolves arg strings (`defaultVar`) to concrete values
- `com.neome.feature.form.domain.util.FormPlus` — Form iteration helpers (`loopDefnForm`, `getCompMetaId`)

## Related READMEs

- **Parent**: `../README.md` (util package — utilities for field resolution, conditions, formulas)
- **Consumers**: `../../ctx/helper/schema/README.md` (schemas use `fnJsonElementFieldValue` for validation)
- **Consumers**: `../../ctx/helper/events/README.md` (event executor uses converter methods for setValue actions)
- **Form root**: `../../../../form.md` (full form feature documentation)

## Change Notes

- Initial documentation created from source analysis (2026-02-22)
- 3 files: `FieldValueResolver.kt` (facade), `Converter.kt` (type conversion), `DefaultValue.kt` (default resolution + `MutableFormValue`)
- `fnRawValueToFieldValue` returns null for `pickText` complex types (handled via KSerializer in FieldController)
- Default resolution currently supports: text, paragraph, info, pickText, setOfText. Other field types return null defaults.
