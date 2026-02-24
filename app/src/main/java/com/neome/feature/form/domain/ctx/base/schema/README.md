# schema — Field Validation Schema Registry

## Purpose

Encapsulates all field-type-specific validation logic as reusable, stateless schema objects. This package bridges the form definition layer with validation execution, providing a single schema instance per field that validates field values against dynamic constraints (e.g., `minCharCount`, `maxCharCount`, `required`) extracted from `FieldProperties`.

## Responsibilities

- Define an abstract `CompSchema` base contract with a pure `validate(fieldValue, fieldState): String?` method that returns an error message or null
- Implement 38+ concrete schema classes, one per field type, each encapsulating validation rules specific to that type
- Provide `CompSchemaFactory` to instantiate schemas once per form, mapping each field component type to its corresponding schema implementation
- Return null-entry schemas for composite, display-only, and reference types that do not require validation
- Enable form-wide validation by building a `Map<MetaIdComp, CompSchema>` during initialization

## Flow

1. **Schema factory instantiation** — At form initialization (via `FormCtxInitHelper`), `CompSchemaFactory.buildFormSchemas` is called once with the form definition. The factory iterates all component definitions, routes each `EnumDefnCompType` to its schema implementation, and returns a schema map. Fields that do not need validation (sections, tabs, labels, dividers, references, spreadsheetRefs, composite containers) receive null entries.

2. **Schema reuse** — The schema map is stored in `FormState` and reused for the entire form lifetime. Each time a field must be validated, its corresponding schema from the map is retrieved.

3. **Validation call** — `CompSchema.validate(fieldValue, fieldState)` is invoked from `FormCtxValidationHelper`. The schema accesses dynamic constraints via `fieldState.properties` and validates the field value immutably. It returns:
   - A non-null error message string if validation fails
   - Null if validation passes

4. **Error propagation** — The error string (or null) is passed to `FormCtxValidationHelper.updateFieldError` for error state management and UI reflection.

## Key Entry Points

| File | Symbol | Role |
|------|--------|------|
| `CompSchemaFactory.kt` | `CompSchemaFactory.buildFormSchemas` | Builds schema map from form definition; called once at init |
| `CompSchema.kt` | `CompSchema.validate` | Pure validation method; returns error message or null |
| `CompSchema.kt` | `CompSchema.isRequired` | Protected helper; checks required constraint from properties |

## Field Type Coverage

The package implements validation schemas for the following field type categories:

| Category | Field Types |
|----------|------------|
| **Text** | Text, Paragraph, Hyperlink, Symbol, Handle |
| **Contact** | Email, Mobile Number, OTP |
| **Numeric** | Number, Decimal |
| **DateTime** | Date, Time, DateTime, DateRange |
| **Primitives** | Duration, Boolean, Color, Slider, ScanCode |
| **Pickers** | PickText, Currency, PickTree, PickUser, PickRole, PickGridRow |
| **Sets** | SetOfText, SetOfUser, SetOfRole, SetOfDocument |
| **ChipSet** | ChipSet (covers chipSet, chipSetDate, chipSetDateTime, chipSetDay, chipSetTime, device variants) |
| **Media** | Image, Camera, Video, Audio, Voice, Document, Signature |
| **Composite** | Grid |
| **Location** | Location |
| **No-op (null)** | Section, Tab, Label, Divider, Reference, SpreadsheetReference |

Each schema implementation validates against constraints defined in `FieldProperties` (e.g., `minCharCount`, `maxCharCount`, `minValue`, `maxValue`, `pattern`, `required`).

## Design Pattern

Schemas are instantiated once at form initialization and reused for every validation call. This approach:
- Avoids repeated object creation
- Maintains a centralized, type-safe validation registry
- Keeps validation logic isolated from state management

Each schema is stateless and pure; all constraint data is passed in via `fieldState.properties` and the field value itself.

## Dependencies

- `com.neome.feature.form.domain.DefnForm` — Form definition containing component types
- `com.neome.api.meta.base.Types.EnumDefnCompType` — Component type enum for routing
- `com.neome.feature.form.presentation.state.FieldState` — Contains field value and properties
- `com.neome.feature.form.presentation.state.FieldProperties` — Contains dynamic constraints (minCharCount, maxCharCount, required, etc.)
- `com.neome.api.meta.base.dto.DefnField*` — Per-field definition DTOs (patterns, bounds, validation config)

## Related READMEs

- **Parent**: `../README.md` (base package — form state orchestration, initialization, event handling)
- **Sibling**: `../events/README.md` (event execution engine)
- **Grandparent**: `../../README.md` (ctx package — FormCtx facade)
- **Form root**: `../../../../form.md` (full form feature documentation)

## Change Notes

- Initial documentation created from source analysis (2026-02-22)
- 40 source files: 1 abstract base, 1 factory, 38 schema implementations
- All schemas implement the `CompSchema` contract and are instantiated by `CompSchemaFactory`
- Null entries in the schema map represent fields that do not require validation
