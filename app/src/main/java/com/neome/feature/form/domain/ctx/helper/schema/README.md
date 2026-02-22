# schema — Component Validation Schema Registry

## Purpose

Provides per-field-type validation logic for the form engine. Each field type has a concrete `CompSchema` subclass that implements pure, side-effect-free validation. Schemas are instantiated once at form initialization via `CompSchemaFactory` and reused for the form lifetime.

## Responsibilities

- Define the abstract validation contract (`CompSchema.validate`) returning an error message or null
- Route each `EnumDefnCompType` to its corresponding schema implementation via `CompSchemaFactory`
- Validate field values against dynamic constraints from `FieldProperties` (required, min/max bounds, patterns)
- Use Konform library for type-safe, declarative validation rule composition
- Provide a shared `isRequired` helper for the common required-field check
- Return null (no schema) for composite types, display-only fields, reference fields, and studio/admin fields that do not need validation

## Flow

1. **Build** — `CompSchemaFactory.buildFormSchemas(defnForm)` iterates `defnForm.compMap`, calls `create()` for each component, and collects non-null schemas into `Map<MetaIdComp, CompSchema>`.
2. **Route** — `CompSchemaFactory.create()` matches `defnComp.type` against `EnumDefnCompType` and returns the corresponding `Field*Schema` instance or null.
3. **Validate** — Callers (e.g. `FormCtxValidationHelper`, `FormCtxEventHelper`) invoke `schema.validate(fieldValue, fieldState)`. Each schema casts the value to its typed DTO, reads constraints from `FieldProperties` and/or `DefnField*`, builds a Konform `Validation`, and returns the first error message or null.

## Key Entry Points

| File | Symbol | Role |
|------|--------|------|
| `CompSchema.kt` | `CompSchema` (abstract class) | Base class; declares `validate(JsonElement?, FieldState?) -> String?` and `isRequired()` helper |
| `CompSchemaFactory.kt` | `CompSchemaFactory.buildFormSchemas` | Builds the full `Map<MetaIdComp, CompSchema>` from form definition |
| `CompSchemaFactory.kt` | `CompSchemaFactory.create` | Routes a single `DefnCompSeal` to its `Field*Schema` or null |

### Field Schema classes (grouped by category)

**Text-based** — `FieldTextSchema`, `FieldParagraphSchema`, `FieldHyperlinkSchema`, `FieldSymbolSchema`, `FieldHandleSchema`
- Validates: required, minCharCount, maxCharCount, validationPattern (aadhaar/gstin/pan/custom regex)

**Email / Mobile / OTP** — `FieldEmailSchema`, `FieldMobileNumberSchema`, `FieldOtpSchema`
- Validates: required, format-specific constraints

**Numeric** — `FieldNumberSchema`, `FieldDecimalSchema`
- Validates: required, minNumber, maxNumber

**Date/Time** — `FieldDateSchema`, `FieldTimeSchema`, `FieldDateTimeSchema`, `FieldDateRangeSchema`
- Validates: required (min/max date noted as TODO)

**Duration** — `FieldDurationSchema`
- Validates: required

**Boolean** — `FieldBoolSchema`
- Validates: required

**Pick/Selection** — `FieldPickTextSchema`, `FieldPickTreeSchema`, `FieldPickUserSchema`, `FieldPickRoleSchema`, `FieldPickGridRowSchema`
- Validates: required (optionId/selection must be present)

**Set** — `FieldSetOfTextSchema`, `FieldSetOfUserSchema`, `FieldSetOfRoleSchema`, `FieldSetOfDocumentSchema`
- Validates: required

**ChipSet** — `FieldChipSetSchema`
- Handles 7 chipSet variants (chipSet, chipSetDate, chipSetDateTime, chipSetDay, chipSetTime, chipSetDeviceSize, chipSetDeviceType)

**Media** — `FieldImageSchema`, `FieldCameraSchema`, `FieldVideoSchema`, `FieldAudioSchema`, `FieldVoiceSchema`, `FieldDocumentSchema`, `FieldSignatureSchema`
- Validates: required, maxSize (file size in MB)

**Other** — `FieldLocationSchema`, `FieldColorSchema`, `FieldSliderSchema`, `FieldScanCodeSchema`, `FieldGridSchema`
- Grid validates: minRows, maxRows (from `DefnGrid`)

## Dependencies

- `com.neome.api.meta.base.Types.EnumDefnCompType` — field type enumeration used for routing
- `com.neome.api.meta.base.dto.DefnField*` — per-field definition DTOs (constraints, patterns, config)
- `com.neome.core.common.serializer.api.meta.base.dto.DefnCompSeal` — base component definition
- `com.neome.core.common.serializer.api.meta.base.dto.FieldValue*Data` — typed value wrappers for each field type
- `com.neome.feature.form.domain.DefnFormUi` — form definition (provides `compMap`)
- `com.neome.feature.form.domain.util.FieldVal.FieldValueResolver` — converts `JsonElement` to typed field values
- `com.neome.feature.form.presentation.state.FieldState`, `FieldProperties` — runtime field state and resolved properties
- `io.konform.validation` — Konform library for declarative validation rule building
- `com.neome.feature.utils.JsonParser` — kotlinx.serialization JSON instance for deserialization

## Related READMEs

- **Parent**: `../README.md` (helper package — orchestrates init, events, validation)
- **Sibling**: `../events/README.md` (event execution engine, consumes schema validation results)
- **Form root**: `../../../../form.md` (full form feature documentation)
- **FieldVal**: `../../../util/FieldVal/README.md` (value resolution used by schemas)

## Change Notes

- Initial documentation created from source analysis (2026-02-22)
- 40 files: 1 abstract base, 1 factory, 38 field schema implementations
- Min/max date validation noted as TODO in `FieldDateSchema`
