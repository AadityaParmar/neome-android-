# skill:defnForm

## Metadata

| Property           | Value                                       |
|--------------------|---------------------------------------------|
| **Version**        | 1.12.0                                      |
| **Last Updated**   | 2026-02-17                                  |
| **Scope**          | Android Form Component Architecture         |
| **Path**           | `app/src/main/java/com/neome/feature/form/` |
| **Update Trigger** | Any modification to form component files    |

---

## IMPORTANT: Skill Update Rule

> **MANDATORY**: After making ANY changes to files in `app/src/main/java/com/neome/feature/form/`, you MUST update this skill file (`form.md`) to reflect those changes.

### When to Update

- Added/removed/renamed files
- Changed API signatures (FormRef, FormCtx, events, state)
- Added new field types or validation schemas
- Modified architecture or data flow
- Changed file structure

### How to Update

1. Update the **Version** (patch for docs, minor for features, major for breaking)
2. Update **Last Updated** date
3. Update relevant sections (Key Files, File Structure, etc.)
4. Add entry to **Changelog**

### Why This Matters

This skill file is the source of truth for AI assistants working on the form system. Outdated documentation leads to incorrect code generation and wasted effort.

---

## Table of Contents

1. [Quick Reference](#quick-reference)
2. [Architecture Overview](#architecture-overview)
3. [Core Concepts](#core-concepts)
4. [Domain Layer Classes](#domain-layer-classes)
5. [Presentation Layer Classes](#presentation-layer-classes)
6. [Component Hierarchy](#component-hierarchy)
7. [Data Flow](#data-flow)
8. [How-To Guides](#how-to-guides)
9. [Troubleshooting](#troubleshooting)
10. [File Structure](#file-structure)
11. [Changelog](#changelog)

---

## Quick Reference

### Usage Pattern

```kotlin
using skill : defnForm do [instruction]
```

### Common Instructions

| Task                       | Example Instruction                                             |
|----------------------------|-----------------------------------------------------------------|
| Add new field type         | `using skill : defnFieldMaker do Add new field type FieldPhone` |
| Add validation rule        | `Add email format validation`                                   |
| Add cross-field validation | `Validate password confirmation matches`                        |
| Add formula support        | `Implement formula calculation for X`                           |
| Fix field bug              | `Fix validation bug in FieldNumber`                             |
| Add property resolution    | `Add maxItems property to FieldPickText`                        |
| Add conditional visibility | `Hide field Y when X is empty`                                  |

### Key Files

| Purpose               | File                                                 |
|-----------------------|------------------------------------------------------|
| Root Composable       | `presentation/components/Form.kt`                    |
| State Owner           | `domain/ctx/FormCtxImpl.kt`                          |
| Init Helper           | `domain/ctx/helper/FormCtxInitHelper.kt`             |
| Event Helper          | `domain/ctx/helper/FormCtxEventHelper.kt`            |
| Validation Helper     | `domain/ctx/helper/FormCtxValidationHelper.kt`       |
| Reducer Result        | `domain/ctx/helper/FormReducerResult.kt`             |
| Schema Factory        | `domain/ctx/helper/schema/CompSchemaFactory.kt`      |
| Schema Base           | `domain/ctx/helper/schema/CompSchema.kt`             |
| All Schemas           | `domain/ctx/helper/schema/Field*Schema.kt` (40+)     |
| Field Factory         | `presentation/components/base/FieldFactory.kt`       |
| External API          | `domain/ref/FormRef.kt`                              |
| External API Impl     | `domain/ref/FormRefImpl.kt`                          |
| Internal Context      | `domain/ctx/FormCtx.kt`                              |
| Field Controller      | `presentation/components/base/FieldController.kt`    |
| Field Base Layout     | `presentation/components/base/FieldBase.kt`          |
| State Classes         | `presentation/state/FormState.kt`                    |
| Events                | `presentation/state/FormEvent.kt`                    |
| Field State           | `presentation/state/FieldState.kt`                   |
| Field Events          | `presentation/state/FieldEvent.kt`                   |
| Field Errors          | `presentation/state/FieldError.kt`                   |
| Intents               | `presentation/state/FormIntent.kt`                   |
| Property Resolver     | `domain/util/FieldPropertyResolver.kt`               |
| Value Resolver        | `domain/util/FieldVal/FieldValueResolver.kt`         |
| Value Converter       | `domain/util/FieldVal/Converter.kt`                  |
| Default Values        | `domain/util/FieldVal/DefaultValue.kt`               |
| Form Types            | `domain/TypesForm.kt`                                |
| Permission Filter     | `domain/util/FilterForm.kt`                          |
| Form Tree Traversal   | `domain/util/FormPlus.kt`                            |
| Formula Calc (TODO)   | `domain/util/CalcFormula.kt`                         |
| Arg Resolver (TODO)   | `domain/util/ArgValueResolver.kt`                    |
| Date Utilities (TODO) | `domain/util/DatePlus.kt`                            |
| Field Maker Skill     | `field-maker.md` (step-by-step guide for new fields) |

### Related Skills

| Skill            | Purpose                                                                                                             |
|------------------|---------------------------------------------------------------------------------------------------------------------|
| `defnFieldMaker` | Step-by-step guide for adding new field types to FieldFactory. Use: `using skill : defnFieldMaker do [instruction]` |

---

## Architecture Overview

### Pattern: MVI + UDF + CompositionLocal

```
                              FORM ARCHITECTURE (v1.11.0)
===============================================================================================

  Parent (Screen/ViewModel)
         │
         │ FormRef (imperative API)
         ▼
   ┌──────────────────────────────────────────────────────────────────────────┐
   │                              Form Component                             │
   │                                                                         │
   │   ┌──────────────────────────────────────────────────────────────────┐  │
   │   │                        FormCtxImpl                               │  │
   │   │                    (Central State Owner)                         │  │
   │   │                                                                  │  │
   │   │   ┌─────────────────┐                                           │  │
   │   │   │ mutableStateOf  │ ◄─── Owned internally                     │  │
   │   │   │   <FormState>   │                                           │  │
   │   │   └────────┬────────┘                                           │  │
   │   │            │                                                    │  │
   │   │   ┌────────▼────────────────────────────────────────────────┐   │  │
   │   │   │                     dispatch(event)                      │   │  │
   │   │   │                                                          │   │  │
   │   │   │   ┌─────────────────┐  ┌─────────────────────────────┐  │   │  │
   │   │   │   │FormCtxInitHelper│  │ FormCtxEventHelper          │  │   │  │
   │   │   │   │(initialization) │  │ (value, focus, trigger)     │  │   │  │
   │   │   │   └─────────────────┘  └─────────────────────────────┘  │   │  │
   │   │   │                                                          │   │  │
   │   │   │   ┌───────────────────────┐                              │   │  │
   │   │   │   │FormCtxValidationHelper│                              │   │  │
   │   │   │   │ + CompSchema system   │                              │   │  │
   │   │   │   └───────────────────────┘                              │   │  │
   │   │   └──────────────────────────────────────────────────────────┘   │  │
   │   │                                                                  │  │
   │   │   ┌──────────────────────┐                                      │  │
   │   │   │ createFormRef()      │ ──► Returns FormRefImpl              │  │
   │   │   └──────────────────────┘                                      │  │
   │   │                                                                  │  │
   │   └──────────────────────────────────────────────────────────────────┘  │
   │          │                                                              │
   │          │ LocalFormCtx (CompositionLocal)                              │
   │          ▼                                                              │
   │   ┌─────────────────────────────────────────────────────────────────┐   │
   │   │                      Field Components                            │   │
   │   │  FieldText │ FieldNumber │ FieldDate │ FieldSection │ ...       │   │
   │   │          (use rememberFieldController + LocalFormCtx)            │   │
   │   └─────────────────────────────────────────────────────────────────┘   │
   │                                                                         │
   └──────────────────────────────────────────────────────────────────────────┘
         │
         │ FormIntent (Submit, Watch, ValidationStateChanged, SendBtnStateChanged)
         ▼
  Parent (Screen/ViewModel)
```

### Core Principles

| Principle              | Implementation                                                                     |
|------------------------|------------------------------------------------------------------------------------|
| Single Source of Truth | All state in immutable `FormState`                                                 |
| Pure Handlers          | Helper functions have no side effects                                              |
| Reactive Updates       | Compose `State<T>` for UI observation                                              |
| Imperative API         | `FormRef` for parent control                                                       |
| Stable Context         | `FormCtx` never recreated after Form init                                          |
| No Prop Drilling       | `LocalFormCtx` provides context to all descendants                                 |
| Schema Validation      | `CompSchema` for type-specific validation                                          |
| Synchronous Dispatch   | All mutations synchronous via `dispatch(FormEvent)`. No coroutines/queues/channels |

---

## Core Concepts

### State Definitions

> **Reference Files:**
> - `presentation/state/FormState.kt` - FormState, FieldDependencyMap, SendBtnDisableFlag
> - `presentation/state/FieldState.kt` - FieldState, FieldProperties
> - `presentation/state/FieldError.kt` - FieldError, ErrorType

**FormState Properties:**

| Property            | Type                           | Purpose                                   |
|---------------------|--------------------------------|-------------------------------------------|
| `defnForm`          | `DefnFormUi`                   | Form schema definition (with permissions) |
| `initialFormValue`  | `FormValueData`                | Initial values at form creation           |
| `fieldStates`       | `Map<MetaIdComp, FieldState>`  | Per-field UI state (interaction + props)  |
| `valueMap`          | `Map<MetaIdComp, JsonElement>` | Field values (isolated for performance)   |
| `errors`            | `Map<MetaIdComp, FieldError>`  | Validation errors per field               |
| `fieldDependencies` | `FieldDependencyMap`           | Dependency graph for recalculation        |
| `compSchemaMap`     | `Map<MetaIdComp, CompSchema>`  | Validation schemas built during init      |
| `disableSendBtnSet` | `Set<SendBtnDisableFlag>`      | Flags disabling send button               |
| `isInitialized`     | `Boolean`                      | Form init complete                        |
| `disabled`          | `Boolean`                      | Entire form disabled                      |
| `readOnly`          | `Boolean`                      | Entire form read-only                     |
| `isSubmitting`      | `Boolean`                      | Submit in progress                        |

**Computed Properties:** `hasErrors`, `isDirty`, `isValid`, `isSendBtnEnabled`

**FieldProperties (25+ properties):**

| Category       | Properties                                                            |
|----------------|-----------------------------------------------------------------------|
| Base           | `required`, `disabled`, `readOnly`, `hidden`                          |
| Display        | `label`, `helperText`, `placeholder`                                  |
| Text/Paragraph | `minCharCount`, `maxCharCount`, `lineCount`, `flexHeight`             |
| Number/Counter | `minNumber`, `maxNumber`, `step`, `minDisplayValue`, `justifyContent` |
| Decimal        | `minDecimal`, `maxDecimal`                                            |
| Media          | `maxSize`, `showLabel`, `showPreview`, `showSize`                     |
| UI Toggles     | `showAsCheckbox`, `showSecond`, `showAsDropdown`                      |
| Button         | `textSize`, `disableElevation`                                        |

**Property Resolution Priority (3 levels):**

1. **Direct value**: `defnComp.property` (e.g., `placeHolder`)
2. **Variable**: `defnComp.propertyVar` (e.g., `placeHolderVar`) → `ArgValueResolver`
3. **Field reference**: `defnComp.propertyFieldId` (e.g., `placeHolderFieldId`) → value from another field

**SendBtnDisableFlag Types:**

- `Invalid` - Form has validation errors (auto-managed by FormCtxValidationHelper)
- `Uploading` - File upload in progress
- `Processing` - Background processing in progress
- `Validating` - Validation in progress
- `Custom(key)` - Custom flag with unique key

**FieldState Properties:**

| Property       | Type              | Purpose                            |
|----------------|-------------------|------------------------------------|
| `isTouched`    | `Boolean`         | User has interacted with field     |
| `isDirty`      | `Boolean`         | Value differs from initial         |
| `isFocused`    | `Boolean`         | Field currently focused            |
| `isValidating` | `Boolean`         | Validation in progress             |
| `properties`   | `FieldProperties` | Computed properties (recalculated) |
| `defaultValue` | `JsonElement?`    | Initial value (immutable)          |

### Event System

> **Reference File:** `presentation/state/FormEvent.kt`

| Event                      | Purpose                          | Triggers                     |
|----------------------------|----------------------------------|------------------------------|
| `Initialize`               | Build deps, set initial values   | Form mount                   |
| `FieldValueChanged`        | Update value, trigger dependents | User input                   |
| `FieldFocused`             | Mark field focused               | Field gains focus            |
| `FieldBlurred`             | Mark touched + unfocused         | Field loses focus            |
| `FieldTouched`             | Mark field touched               | Any interaction              |
| `TriggerField`             | Recalculate field properties     | Dependency change            |
| `ValidateField`            | Validate single field            | Blur, submit, manual         |
| `ValidateAll`              | Validate all fields              | Submit                       |
| `SetFieldError`            | Set custom error                 | API error, custom validation |
| `ClearFieldError`          | Clear field error                | Manual clear                 |
| `ClearAllErrors`           | Clear all errors                 | Form reset                   |
| `Submit`                   | Validate + submit if valid       | Submit button                |
| `Reset`                    | Reset to initial values          | Reset button                 |
| `SetValues`                | Bulk value update                | External data load           |
| `AddSendBtnDisableFlag`    | Add flag to disable send btn     | Upload start, validation     |
| `RemoveSendBtnDisableFlag` | Remove flag from set             | Upload complete              |

### Intent System

> **Reference File:** `presentation/state/FormIntent.kt`

| Intent                   | Direction     | Payload                                  | Purpose                          |
|--------------------------|---------------|------------------------------------------|----------------------------------|
| `Submit`                 | Form → Parent | `valueMap: Map<MetaIdComp, JsonElement>` | Deliver validated form data      |
| `Watch`                  | Form → Parent | `fieldId`, `fieldValue`, `valueMap`      | Notify field value changes       |
| `ValidationStateChanged` | Form → Parent | `isValid`, `hasErrors`                   | Notify validation state changes  |
| `SendBtnStateChanged`    | Form → Parent | `enabled: Boolean`                       | Notify send button state changes |

### Field Event System

> **Reference File:** `presentation/state/FieldEvent.kt`

| Event          | Purpose             | Converted To                  |
|----------------|---------------------|-------------------------------|
| `ValueChanged` | Field value changed | `FormEvent.FieldValueChanged` |
| `Focused`      | Field gained focus  | `FormEvent.FieldFocused`      |
| `Blurred`      | Field lost focus    | `FormEvent.FieldBlurred`      |

**Conversion**: FieldEvents are automatically converted to FormEvents by the Form component.

### Error Handling

> **Reference File:** `presentation/state/FieldError.kt`

| Error Type   | Auto-Cleared          | Cleared By           |
|--------------|-----------------------|----------------------|
| `Validation` | Yes (on value change) | Schema validation    |
| `Custom`     | No                    | `clearErrors()` only |
| `Server`     | No                    | `clearErrors()` only |

### API Interfaces

> **Reference Files:**
> - `domain/ref/FormRef.kt` - External API for parent components
> - `domain/ref/FormRefImpl.kt` - Implementation wrapping `(getFormState, dispatchEvent)`
> - `domain/ctx/FormCtx.kt` - Internal API for field components

**FormRef** (for parents - imperative API, inspired by React Hook Form):

| Category      | Methods                                                                 |
|---------------|-------------------------------------------------------------------------|
| Read Values   | `getValue(fieldId)`, `getValues()`, `getValueMap()`                     |
| Write Values  | `setValue(fieldId, value)`, `setValues(valueMap)`                       |
| Validation    | `validate(fieldId)`, `setError(fieldId, error)`, `clearErrors(fieldId)` |
| Form Ops      | `submit()`, `reset(valueMap)`                                           |
| State Queries | `isDirty(fieldId)`, `isValid(fieldId)`, `isTouched(fieldId)`            |
| Send Button   | `addSendBtnDisableFlag`, `removeSendBtnDisableFlag`, `isSendBtnEnabled` |
| Observe       | `formState: State<FormState>`                                           |

**FormCtx** (for fields - reactive API via CompositionLocal):

| Category    | Methods                                                                                                                 |
|-------------|-------------------------------------------------------------------------------------------------------------------------|
| State       | `formState: State<FormState>`                                                                                           |
| Trigger     | `trigger(fieldId)` - Recalculate field properties                                                                       |
| Read        | `getValues()`, `getValue(fieldId)`, `getFieldState(fieldId)`, `getError(fieldId)`, `hasField(fieldId)`, `getDefnForm()` |
| Validation  | `validate(fieldId)`, `setError(fieldId, error)`, `clearError(fieldId)`                                                  |
| Send Button | `addSendBtnDisableFlag`, `removeSendBtnDisableFlag`                                                                     |

### Validation Schema System

> **Reference Files:**
> - `domain/ctx/helper/schema/CompSchema.kt` - Abstract base class
> - `domain/ctx/helper/schema/CompSchemaFactory.kt` - Factory by field type
> - `domain/ctx/helper/schema/Field*Schema.kt` - Type-specific validation (40+ schemas)

**Schema Lifecycle:**

1. `CompSchemaFactory.buildFormSchemas(defnForm)` called during form initialization
2. Schemas stored in `FormState.compSchemaMap`
3. `FormCtxValidationHelper` calls `schema.validate(fieldValue, fieldState)` during validation
4. Returns `String?` - error message or null (pure function, no side effects)

**CompSchema base class:**

```kotlin
abstract fun validate(fieldValue: JsonElement?, fieldState: FieldState?): String?
// Helper: isRequired() - common required validation logic
```

**Schema Categories (40+ schemas):**

| Category    | Schemas                                                                                                                                              |
|-------------|------------------------------------------------------------------------------------------------------------------------------------------------------|
| Text        | `FieldTextSchema` (required, min/max char, regex: aadhaar/gstin/pan/custom)                                                                          |
| Email       | `FieldEmailSchema` (required, format regex, domain whitelist/blacklist)                                                                              |
| Number      | `FieldNumberSchema` (required, min/max), `FieldDecimalSchema` (required, min/max)                                                                    |
| Date/Time   | `FieldDateSchema`, `FieldTimeSchema`, `FieldDateTimeSchema`, `FieldDateRangeSchema`                                                                  |
| Boolean     | `FieldBoolSchema` (required + capture validations: time, location, user)                                                                             |
| Pick/Select | `FieldPickTextSchema`, `FieldPickTreeSchema`, `FieldPickUserSchema`, `FieldPickRoleSchema`, `FieldPickGridRowSchema`                                 |
| Set/ChipSet | `FieldSetOfTextSchema`, `FieldSetOfUserSchema`, `FieldSetOfRoleSchema`, `FieldSetOfDocumentSchema`, `FieldChipSetSchema`                             |
| Media       | `FieldImageSchema`, `FieldVideoSchema`, `FieldAudioSchema`, `FieldDocumentSchema`, `FieldCameraSchema`, `FieldVoiceSchema`, `FieldSignatureSchema`   |
| Special     | `FieldParagraphSchema`, `FieldHandleSchema`, `FieldHyperlinkSchema`, `FieldMobileNumberSchema`, `FieldOtpSchema`                                     |
| Layout      | `FieldDurationSchema`, `FieldLocationSchema`, `FieldColorSchema`, `FieldSliderSchema`, `FieldScanCodeSchema`, `FieldGridSchema`, `FieldSymbolSchema` |

**Factory returns null for** (no validation): composite types (section, tab, grid, wizard), display-only (label, divider, html, button), reference fields (ref, refSet, refUser), studio fields.

---

## Domain Layer Classes

### FormCtxImpl - Central State Owner

> **File:** `domain/ctx/FormCtxImpl.kt`

Implements `FormCtx`. Single dispatch entry point for all state mutations.

**Architecture:**

```
FormEvent → dispatch() → processEvent() → Helpers → FormReducerResult(state, intent?)
```

- Holds `mutableStateOf(FormState)` - single source of truth
- Creates `FormRef` via `createFormRef()`
- Delegates to: `FormCtxInitHelper`, `FormCtxEventHelper`, `FormCtxValidationHelper`
- Manages `SendBtnDisableFlag` set for submit button state
- No coroutines, no CoroutineScope parameter

### FormReducerResult - Event Processing Output

> **File:** `domain/ctx/helper/FormReducerResult.kt`

```kotlin
data class FormReducerResult(
    val state: FormState,
    val intent: FormIntent? = null  // optional side effect for parent
)
```

### FormCtxInitHelper - Form Initialization

> **File:** `domain/ctx/helper/FormCtxInitHelper.kt`

Called once on form mount. Produces initial `FormState`.

**Process:**

1. `FieldValueResolver.fnEnsureInit()` - Ensure initial values with defaults
2. Build dependency map from field references
3. Create `FieldState` for each non-composite field (resolve initial properties)
4. Build `CompSchema` map via `CompSchemaFactory`
5. Return initialized `FormState`

### FormCtxEventHelper - Event Handler

> **File:** `domain/ctx/helper/FormCtxEventHelper.kt`

Handles all field-level events and cascading dependency updates.

**Key Methods:**

- `handleFieldValueChanged()` - Update value → trigger field + dependents → emit Watch intent
- `handleFieldFocused/Blurred/Touched()` - Update interaction state
- `handleTriggerField()` - Recalculate properties for single field
- `handleSubmit()` - ValidateAll → emit Submit intent if valid
- `handleReset()` - Reset to initial or provided values
- `handleSetValues()` - Batch update multiple field values
- `triggerDependentFields()` - Walk dependency graph, recalculate dependents

**Dependency Trigger Flow:**

```
Field Value Changed → Update valueMap → Trigger current field
  → Get dependents from FieldDependencyMap → Trigger each dependent
  → Emit FormIntent.Watch
```

### FormCtxValidationHelper - Validation Orchestrator

> **File:** `domain/ctx/helper/FormCtxValidationHelper.kt`

**Key Methods:**

- `handleValidateField()` - Validate single field via schema
- `handleValidateAll()` - Validate all fields with schemas
- `updateFieldError()` - Update error map (preserves custom/server errors)
- `handleSetFieldError/ClearFieldError/ClearAllErrors()` - Manual error management
- `updateInvalidFlag()` - Sync `SendBtnDisableFlag.Invalid` with error state

### TypesForm - Permission Type System

> **File:** `domain/TypesForm.kt`

UI-specific type definitions for the permission system:

| Type                           | Purpose                                   |
|--------------------------------|-------------------------------------------|
| `TypeUiPermissionRole`         | Sealed: `Role(EnumDefnRoles)` or `Caller` |
| `TypeUiFormPermission`         | Permission config per component           |
| `TypeUiFormPermissionMap`      | Wraps permission map                      |
| `TypeUiFormParentMap`          | Parent-child relationships                |
| `TypeUiManagerialRelationship` | User sets for managerial roles            |
| `DefnFormUi`                   | Extends `DefnForm` with UI-specific maps  |

**Permission Priority:** `write (6) > writeOnce (5) > writeOnInsert (4) > read (3) > invisible (2) > hide (1)`

### FilterForm - Permission Resolution

> **File:** `domain/util/FilterForm.kt`

Transforms `DefnFormData` → `DefnFormUi` with permission resolution.

```kotlin
fun prepareUiForm(form: DefnFormData, callerEnt: SigEntCaller): DefnFormUi
```

**Preparation Steps:**

1. Resolve form-level + component-level permissions from `permissionMatrix`
2. Walk component tree, inherit permissions from parent
3. Map caller roles → permissions (highest priority wins)
4. Resolve system roles: `$Manager`, `$Public`, `$Self`, etc.
5. Build parent map for parent-child relationships
6. Inject auto-values: email/handle `autoPickSelf`, date timezone, display format
7. Resolve `disabledRoleIdSet` and `requiredRoleIdSet`
8. Populate managerial relationship user sets

### FieldPropertyResolver - Dynamic Property Resolution

> **File:** `domain/util/FieldPropertyResolver.kt`

Resolves 25+ field properties with 3-level priority (direct → var → fieldId reference).

**Dependency Tracking:**

- `buildDependencyMap(defnForm)` → `FieldDependencyMap` - Scans all `*FieldId` properties
- `extractFieldIdReferences(defnComp)` → field references from `DefnComp`

**Supported Property Sources (DefnFieldEditable):**
`requiredFieldId`, `disabledFieldId`, `labelFieldId`, `helperTextFieldId`, `placeHolderFieldId`

**Field-Specific Sources:** `minCharCountFieldId`, `maxCharCountFieldId`, `minFieldId`, `maxFieldId`, `textSizeFieldId`, `disableElevationFieldId`, `maxSizeFieldId`, `showLabelFieldId`, `showPreviewFieldId`, etc.

### FieldValueResolver - Value Type System

> **File:** `domain/util/FieldVal/FieldValueResolver.kt` (combines `Converter.kt` + `DefaultValue.kt`)

**Converter** (`domain/util/FieldVal/Converter.kt`):

| Method                         | Purpose                     |
|--------------------------------|-----------------------------|
| `fnRawValueToFieldValue`       | Raw primitive → Typed value |
| `fnFieldValueToRawValue`       | Typed value → Raw primitive |
| `fnJsonElementFieldValue`      | JsonElement → Typed value   |
| `fnFieldValueToJsonElement`    | Typed value → JsonElement   |
| `fnResolveNumericValue`        | Any value → Long?           |
| `fnResolveNumericDecimalValue` | Any value → Double?         |

**Supported Value Types:**

- Text → `FieldValueTextData(String)`, Email → `FieldValueEmailData(String)`
- Number → `FieldValueNumberData(Long)`, Decimal → `FieldValueDecimalData(Double)`
- Date → `FieldValueDateData(String)`, Time → `FieldValueTimeData`, DateTime → `FieldValueDateTimeData`
- Handle, Hyperlink, Color, Paragraph, Mobile, and 20+ more

**DefaultValue** (`domain/util/FieldVal/DefaultValue.kt`):

| Method                    | Purpose                                |
|---------------------------|----------------------------------------|
| `fnEnsureInit`            | Initialize form values with defaults   |
| `fnEnsureInitGrid`        | Initialize grid field values           |
| `resolveCompDefaultValue` | Recursive default with cycle detection |

**Default Value Priority:** Existing value > `defaultValue` param > `defnField.defaultValue` > `defnField.defaultVar` (TODO) > `defnField.defaultFieldId` (recursive)

**MutableFormValue**: Builder class for constructing `FormValueData` with CRUD helpers.

### FormPlus - Tree Traversal Utilities

> **File:** `domain/util/FormPlus.kt`

| Method          | Purpose                                                         |
|-----------------|-----------------------------------------------------------------|
| `loopDefnForm`  | Recursive tree traversal (Tab, Section, Wizard, Grid, FormList) |
| `getCompMetaId` | Extract MetaIdComp from any component type                      |
| `matchAllRoles` | Check if all caller roles match target roles                    |

### Stub Utilities (TODO)

| File                              | Purpose                         | Status |
|-----------------------------------|---------------------------------|--------|
| `domain/util/CalcFormula.kt`      | Formula calculation             | TODO   |
| `domain/util/ArgValueResolver.kt` | DefnDtoText variable resolution | TODO   |
| `domain/util/DatePlus.kt`         | Date formatting/calculation     | TODO   |

---

## Presentation Layer Classes

### Form.kt - Root Composable

> **File:** `presentation/components/Form.kt`

```kotlin
@Composable
fun Form(
    defnForm: DefnFormUi,
    initialValue: FormValueData?,
    formRef: MutableState<FormRef?>,
    onIntent: (FormIntent) -> Unit,
    modifier: Modifier = Modifier
)
```

**Responsibilities:**

1. Creates `FormCtxImpl` (domain layer) for state + business logic
2. Provides `LocalFormCtx` via `CompositionLocalProvider`
3. Converts `FieldEvent` → `FormEvent` and dispatches to FormCtx
4. Renders root composite via `FieldFactory`

### FieldFactory.kt - Type Router

> **File:** `presentation/components/base/FieldFactory.kt`

Routes `defnComp.type` to correct field renderer. Supported types (24):

| Category  | Types                                                               |
|-----------|---------------------------------------------------------------------|
| Text      | `text`, `email`, `handle`, `hyperlink`, `mobileNumber`, `paragraph` |
| Date/Time | `date`, `dateTime`, `dateRange`, `dateTimeRange`, `time`            |
| Number    | `number`, `decimal`, `counter`, `logCounter`                        |
| Boolean   | `bool` (renders as Switch)                                          |
| Pick      | `pickText` (dropdown via RawPickerSingleSelect)                     |
| Media     | `image`, `document`                                                 |
| Composite | `section`, `tab`                                                    |
| TODO      | `grid`                                                              |

### FieldController.kt - Field State Access

> **File:** `presentation/components/base/FieldController.kt`

Generic controller providing stable, reactive access to field state.

```kotlin
@Composable
fun <T> rememberFieldController(serializer: KSerializer<T>): FieldController<T>
```

**Properties:**

- `fieldId: MetaIdComp?` - Field identifier
- `value: State<T?>` - Deserialized value via `derivedStateOf` (fine-grained recomposition)
- `field: State<FieldUiState>` - Properties + error via `derivedStateOf`
- `onChange: (T?) -> Unit` - Value change callback

**FieldUiState**: Combines `properties: FieldProperties` + `error: FieldError?` for single read.

### FieldBase.kt - Common Layout Wrapper

> **File:** `presentation/components/base/FieldBase.kt`

Wraps all fields with consistent `Column(fillMaxWidth)` + padding (16dp horizontal, 8dp vertical).

### Composite Components

**FieldSection** (`presentation/components/composite/FieldSection.kt`):

- Groups fields with optional label (`titleMedium`)
- Direction: Horizontal (`Row` with `weight(1f)`) or Vertical (`Column`)
- Recursive rendering via `FieldFactory`

**FieldTab** (`presentation/components/composite/FieldTab.kt`):

- Material3 `ScrollableTabRow` with local tab selection state
- Content area with `verticalScroll`
- Renders selected tab content via `FieldFactory`

### Field Implementations (22 files)

**Field Component Pattern:**

```kotlin
@Composable
fun FieldX(defnComp: DefnCompSeal, onFieldEvent: (FieldEvent) -> Unit) {
    val controller = rememberFieldController<FieldValueXData>()
    val value = controller.value.value
    val (properties, error) = controller.field.value
    if (controller.fieldId == null || properties.hidden) return

    FieldBase {
        FieldXContent(value, properties, error, controller.onChange)
    }
}
```

**Text-Based Fields:**

| Component           | Value Type                   | Special Features                                                                       |
|---------------------|------------------------------|----------------------------------------------------------------------------------------|
| `FieldText`         | `FieldValueTextData`         | Placeholder space for supporting text, stateless content                               |
| `FieldParagraph`    | `FieldValueParagraphData`    | minLines=3, maxLines=5                                                                 |
| `FieldEmail`        | `FieldValueEmailData`        | KeyboardType.Email, basic @ validation                                                 |
| `FieldHandle`       | `FieldValueEmailData`        | Dynamic keyboard (Phone if starts with +, else Email), dual regex validation           |
| `FieldHyperlink`    | `FieldValueHyperlinkData`    | URL validation, trailing link icon, auto-prefix https://                               |
| `FieldMobileNumber` | `FieldValueMobileNumberData` | Country code dropdown (140+ codes) + 10-digit input, combined format `+<code><number>` |

**Number Fields:**

| Component         | Value Type              | Special Features                                  |
|-------------------|-------------------------|---------------------------------------------------|
| `FieldNumber`     | `FieldValueNumberData`  | KeyboardType.Number, Long, allows `-`             |
| `FieldDecimal`    | `FieldValueDecimalData` | KeyboardType.Decimal, Double, allows `.` and `-.` |
| `FieldCounter`    | (Long)                  | Stepper: `[- ] [INPUT] [+ ]`, uses `RawCounter`   |
| `FieldLogCounter` | (Long)                  | Counter with hideInfo + logReadRoleSet            |

**Date/Time Fields:**

| Component            | Special Features                                       |
|----------------------|--------------------------------------------------------|
| `FieldDate`          | Read-only + DatePickerDialog, ISO storage `yyyy-MM-dd` |
| `FieldDateTime`      | Two-step: Date → Time picker, preserves existing time  |
| `FieldTime`          | AlertDialog + TimePicker, format `HH:mm`               |
| `FieldDateRange`     | Two stacked date fields, "To" min >= "From"            |
| `FieldDateTimeRange` | Most complex: constraints, snapshotFlow for validation |

**Boolean/Media Fields:**

| Component       | Special Features                                                |
|-----------------|-----------------------------------------------------------------|
| `FieldSwitch`   | Render modes: Switch/Checkbox, labelPlacement, capture metadata |
| `FieldImage`    | File picker, size validation, zoomable preview dialog           |
| `FieldDocument` | 40+ MIME types, size display, system preview via Intent         |

**Pick/Selection Fields:**

| Component       | Value Type               | Special Features                                                            |
|-----------------|--------------------------|-----------------------------------------------------------------------------|
| `FieldPickText` | `FieldValueOptionIdData` | Dropdown via `RawPickerSingleSelect`, option map from DefnFieldPickTextData |

### Raw Reusable Components

| Component                   | File                                 | Purpose                                       |
|-----------------------------|--------------------------------------|-----------------------------------------------|
| `RawCounter`                | `field/RawCounter.kt`                | Stepper UI: BasicTextField + ±buttons         |
| `RawCaptureExtraProperties` | `field/RawCaptureExtraProperties.kt` | Capture metadata display (time/user/location) |
| `RawPickerSingleSelect`     | `raw/RawPickerSingleSelect.kt`       | ModalBottomSheet single-select dropdown       |
| `RawPickerMultiSelect`      | `raw/RawPickerMultiSelect.kt`        | ModalBottomSheet multi-select with checkboxes |
| `ImagePreviewDialog`        | `field/ImagePreviewDialog.kt`        | Pinch-to-zoom (1x-4x) + pan image preview     |

### Screen Components

| File                              | Purpose                                 |
|-----------------------------------|-----------------------------------------|
| `screen/FormScreen.kt`            | Demo scaffold hosting Form + intent log |
| `screen/FormScreenViewModel.kt`   | Sample data + intent logging            |
| `sample/FormSampleDataFactory.kt` | Sample DefnFormUi for dev/test          |

---

## Component Hierarchy

```
Form (provides LocalFormCtx)
└── FormContent
    └── FieldFactory (routes by defnComp.type)
        │
        ├── COMPOSITE TYPES (no FieldState, recursive)
        │   ├── FieldTab → ScrollableTabRow → FieldFactory (per tab)
        │   ├── FieldSection → Row/Column → FieldFactory (per child)
        │   └── grid, wizard, spreadsheetRef (TODO)
        │
        └── LEAF TYPES (have FieldState, use FieldController)
            ├── Text: FieldText, FieldParagraph, FieldEmail, FieldHandle, FieldHyperlink, FieldMobileNumber
            ├── Number: FieldNumber, FieldDecimal, FieldCounter, FieldLogCounter
            ├── Date/Time: FieldDate, FieldDateTime, FieldTime, FieldDateRange, FieldDateTimeRange
            ├── Boolean: FieldSwitch
            ├── Pick: FieldPickText
            └── Media: FieldImage, FieldDocument
```

---

## Data Flow

### Initialization Flow

```
DefnFormData + SigEntCaller
  ↓ FilterForm.prepareUiForm()
DefnFormUi (with permissions, parentMap, managerialRelationships)
  ↓ FormCtxInitHelper.initializeFormState()
  │   ↓ FieldValueResolver.fnEnsureInit() → resolve defaults
  │   ↓ FieldPropertyResolver.buildDependencyMap() → dependency graph
  │   ↓ FieldPropertyResolver.resolveFieldProperties() → initial FieldProperties
  │   ↓ CompSchemaFactory.buildFormSchemas() → validation schemas
FormState (initialized with fieldStates, valueMap, compSchemaMap, dependencies)
  ↓ FormCtxImpl constructor
FormCtx (CompositionLocal) + FormRef (imperative API for parent)
```

### Value Change Flow

```
User Input
  ↓ controller.onChange(value) → FieldEvent.ValueChanged
  ↓ Form converts → FormEvent.FieldValueChanged
  ↓ FormCtxImpl.dispatch()
  ↓ FormCtxEventHelper.handleFieldValueChanged()
    1. Update valueMap[fieldId] = newValue
    2. triggerField() → recalculate properties + validate
    3. triggerDependentFields() → walk dependency graph
    4. Return FormReducerResult(newState, FormIntent.Watch)
  ↓ Update mutableStateOf
  ↓ Emit FormIntent.Watch to parent
  ↓ Compose recomposition (derivedStateOf triggers only affected fields)
```

### Validation Flow

```
formRef.validate(fieldId)
  ↓ FormEvent.ValidateField
  ↓ FormCtxValidationHelper.handleValidateField()
    1. schema.validate(fieldValue, fieldState) → error message or null
    2. updateFieldError() → preserves Custom/Server errors
    3. updateInvalidFlag() → manages SendBtnDisableFlag.Invalid
  ↓ FormReducerResult(newState with errors)
  ↓ Optional FormIntent.SendBtnStateChanged
  ↓ Recomposition → UI shows errors
```

### Submit Flow

```
formRef.submit() → FormEvent.Submit
  ↓ handleSubmit()
    1. ValidateAll → runs all schemas
    2. If valid → emit FormIntent.Submit(valueMap)
    3. If invalid → errors shown, send btn disabled
```

---

## How-To Guides

### Adding a New Field Type

1. **Create Field Component** in `presentation/components/field/Field{Name}.kt`
    - Use `rememberFieldController<FieldValue{Name}Data>()` for state
    - Wrap with `FieldBase` for consistent styling
    - Check `properties.hidden` for early return
    - Create stateless `Field{Name}Content` composable

2. **Register in FieldFactory** - Add case in `presentation/components/base/FieldFactory.kt`

3. **Add Value Conversion** in `domain/util/FieldVal/Converter.kt`
    - Add cases to `fnRawValueToFieldValue`, `fnFieldValueToRawValue`, `fnJsonElementFieldValue`, `fnFieldValueToJsonElement`

4. **Add Default Value** (if needed) in `domain/util/FieldVal/DefaultValue.kt`

5. **Add Validation Schema**:
    - Create `domain/ctx/helper/schema/Field{Name}Schema.kt` extending `CompSchema`
    - Implement `validate(fieldValue, fieldState): String?`
    - Register in `domain/ctx/helper/schema/CompSchemaFactory.kt`

6. **Add Property Resolution** (if needed):
    - Add properties to `FieldProperties` in `presentation/state/FieldState.kt`
    - Add resolver in `domain/util/FieldPropertyResolver.kt`
    - Add to `extractFieldIdReferences()` for dependency tracking

> **Example Reference:** See `FieldText.kt` + `FieldTextSchema.kt` for a complete example

### Adding a Validation Rule

1. **Create or modify Schema Class** extending `CompSchema`
    - Implement `validate(fieldValue, fieldState): String?`
    - Return error message or null (pure function, no side effects)
    - Use Konform library for declarative validation DSL

2. **Register in CompSchemaFactory** - Add/modify case for field type

> **Example Reference:** See `FieldTextSchema.kt` (regex patterns), `FieldEmailSchema.kt` (domain whitelist/blacklist)

### Adding Property Resolution

1. **Add property** to `FieldProperties` in `presentation/state/FieldState.kt`
2. **Add resolver** in `domain/util/FieldPropertyResolver.kt` (direct/var/fieldId cascade)
3. **Add to dependency extraction** in `extractFieldIdReferences()`

### Adding Cross-Field Validation

Cross-field schemas may need `FormCtx` access. Modify `CompSchemaFactory` to pass context if needed.

### Adding Permission Handling

1. **Modify FilterForm.kt** to add new permission resolution logic
2. **Update TypesForm.kt** if new permission types needed
3. Use `FormPlus.loopDefnForm()` for tree traversal

---

## Troubleshooting

| Issue                       | Cause                                | Solution                                                     |
|-----------------------------|--------------------------------------|--------------------------------------------------------------|
| Field not updating          | Missing dependency registration      | Check `extractFieldIdReferences()` includes the source field |
| Validation not running      | Schema not registered                | Check `CompSchemaFactory` returns schema for field type      |
| FormCtx not found           | Field outside Form tree              | Wrap component in Form or check hierarchy                    |
| Stale field state           | Not using derivedStateOf properly    | Ensure FieldController pattern with derivedStateOf           |
| Infinite recomposition      | Unstable lambda/object in composable | Use `remember` or move to ViewModel                          |
| Field not rendering         | `hidden = true` in properties        | Check property resolution logic in FieldPropertyResolver     |
| Send button always disabled | DisableFlag not removed              | Check `removeSendBtnDisableFlag` called after operation      |
| Permission not applied      | FilterForm not called                | Ensure `prepareUiForm()` called before passing to Form       |
| Default value not set       | Missing in DefaultValue.kt           | Add case in `resolveCompDefaultValue()` for field type       |
| Value type mismatch         | Missing Converter case               | Add case in `Converter.kt` for field type                    |

---

## File Structure

```
app/src/main/java/com/neome/feature/form/
│
├── form.md                                  # THIS FILE - canonical skill documentation
│
├── domain/
│   ├── TypesForm.kt                         # UI permission types (DefnFormUi, etc.)
│   │
│   ├── ctx/
│   │   ├── FormCtx.kt                       # Internal API interface
│   │   ├── FormCtxImpl.kt                   # Central state owner + dispatch
│   │   └── helper/
│   │       ├── FormReducerResult.kt         # Event processing result wrapper
│   │       ├── FormCtxInitHelper.kt         # Initialization logic
│   │       ├── FormCtxEventHelper.kt        # Event handlers + dependency triggers
│   │       ├── FormCtxValidationHelper.kt   # Validation logic + error management
│   │       └── schema/                      # Validation schema system (40+ files)
│   │           ├── CompSchema.kt            # Abstract base class
│   │           ├── CompSchemaFactory.kt     # Factory by field type
│   │           ├── FieldTextSchema.kt       # Text: required, min/max char, regex
│   │           ├── FieldNumberSchema.kt     # Number: required, min/max
│   │           ├── FieldDecimalSchema.kt    # Decimal: required, min/max
│   │           ├── FieldEmailSchema.kt      # Email: format, domain whitelist/blacklist
│   │           ├── FieldBoolSchema.kt       # Bool: required + capture validations
│   │           ├── FieldDateSchema.kt       # Date: required
│   │           ├── FieldTimeSchema.kt       # Time: required
│   │           ├── FieldDateTimeSchema.kt   # DateTime: required
│   │           ├── FieldDateRangeSchema.kt  # DateRange: required
│   │           ├── FieldParagraphSchema.kt  # Paragraph validation
│   │           ├── FieldHandleSchema.kt     # Handle validation
│   │           ├── FieldHyperlinkSchema.kt  # Hyperlink validation
│   │           ├── FieldMobileNumberSchema.kt # Mobile: format regex, length
│   │           ├── FieldOtpSchema.kt        # OTP validation
│   │           ├── FieldDurationSchema.kt   # Duration: min/max with unit conversion
│   │           ├── FieldLocationSchema.kt   # Location validation
│   │           ├── FieldColorSchema.kt      # Color validation
│   │           ├── FieldSliderSchema.kt     # Slider validation
│   │           ├── FieldScanCodeSchema.kt   # ScanCode validation
│   │           ├── FieldSymbolSchema.kt     # Symbol validation
│   │           ├── FieldGridSchema.kt       # Grid validation
│   │           ├── FieldChipSetSchema.kt    # ChipSet validation
│   │           ├── FieldPickTextSchema.kt   # PickText validation
│   │           ├── FieldPickTreeSchema.kt   # PickTree validation
│   │           ├── FieldPickUserSchema.kt   # PickUser validation
│   │           ├── FieldPickRoleSchema.kt   # PickRole validation
│   │           ├── FieldPickGridRowSchema.kt # PickGridRow validation
│   │           ├── FieldSetOfTextSchema.kt  # SetOfText: required, non-empty
│   │           ├── FieldSetOfUserSchema.kt  # SetOfUser validation
│   │           ├── FieldSetOfRoleSchema.kt  # SetOfRole validation
│   │           ├── FieldSetOfDocumentSchema.kt # SetOfDocument validation
│   │           ├── FieldImageSchema.kt      # Image: required, maxSize, capture
│   │           ├── FieldVideoSchema.kt      # Video: required, maxSize, capture
│   │           ├── FieldAudioSchema.kt      # Audio validation
│   │           ├── FieldCameraSchema.kt     # Camera validation
│   │           ├── FieldVoiceSchema.kt      # Voice validation
│   │           ├── FieldDocumentSchema.kt   # Document validation
│   │           └── FieldSignatureSchema.kt  # Signature validation
│   │
│   ├── ref/
│   │   ├── FormRef.kt                       # External API interface
│   │   └── FormRefImpl.kt                   # Implementation: (getFormState, dispatchEvent)
│   │
│   └── util/
│       ├── FieldPropertyResolver.kt         # Dynamic property resolution (3-level)
│       ├── FilterForm.kt                    # DefnFormData → DefnFormUi (permissions)
│       ├── FormPlus.kt                      # Tree traversal + component utilities
│       ├── CalcFormula.kt                   # Formula calculation (TODO)
│       ├── ArgValueResolver.kt              # Variable resolution (TODO)
│       ├── DatePlus.kt                      # Date utilities (TODO)
│       │
│       └── FieldVal/                        # Field value utilities
│           ├── FieldValueResolver.kt        # Object combining Converter + DefaultValue
│           ├── Converter.kt                 # Raw ↔ Typed ↔ JsonElement conversions
│           └── DefaultValue.kt              # Default value init + MutableFormValue builder
│
├── presentation/
│   ├── components/
│   │   ├── Form.kt                          # Root composable (CompositionLocalProvider)
│   │   ├── Utils.kt                         # Theme color resolver (45+ colors)
│   │   │
│   │   ├── base/
│   │   │   ├── FieldBase.kt                 # Common field wrapper (padding/layout)
│   │   │   ├── FieldController.kt           # Generic state controller (derivedStateOf)
│   │   │   └── FieldFactory.kt              # Type-based routing (24 types)
│   │   │
│   │   ├── composite/
│   │   │   ├── FieldSection.kt              # Section: label + horizontal/vertical children
│   │   │   └── FieldTab.kt                  # Tab: ScrollableTabRow + content
│   │   │
│   │   ├── field/                           # Leaf field implementations (22 files)
│   │   │   ├── FieldText.kt                 # Single-line text input
│   │   │   ├── FIeldParagraph.kt            # Multi-line text (minLines=3)
│   │   │   ├── FieldEmail.kt                # Email with KeyboardType.Email
│   │   │   ├── FieldHandle.kt               # Email OR Mobile, dynamic keyboard
│   │   │   ├── FieldHyperlink.kt            # URL with validation + open link
│   │   │   ├── FieldMobileNumber.kt         # Country code dropdown + number
│   │   │   ├── FieldNumber.kt               # Integer input (Long)
│   │   │   ├── FieldDecimal.kt              # Decimal input (Double)
│   │   │   ├── FieldCounter.kt              # Stepper with RawCounter
│   │   │   ├── FieldLogCounter.kt           # Counter + role-based log
│   │   │   ├── FieldDate.kt                 # DatePickerDialog, ISO storage
│   │   │   ├── FieldDateTime.kt             # Two-step: Date → Time picker
│   │   │   ├── FieldTime.kt                 # TimePicker, HH:mm format
│   │   │   ├── FieldDateRange.kt            # From/To date with constraints
│   │   │   ├── FieldDateTimeRange.kt        # Complex from/to datetime
│   │   │   ├── FieldSwitch.kt               # Switch/Checkbox + capture metadata
│   │   │   ├── FieldPickText.kt             # Single-select dropdown (RawPickerSingleSelect)
│   │   │   ├── FieldImage.kt                # Image picker + preview dialog
│   │   │   ├── FieldDocument.kt             # Document picker (40+ MIME types)
│   │   │   ├── ImagePreviewDialog.kt        # Pinch-to-zoom image preview
│   │   │   ├── RawCaptureExtraProperties.kt # Reusable capture metadata display
│   │   │   └── RawCounter.kt               # Reusable stepper UI component
│   │   │
│   │   └── raw/                             # Raw reusable picker components
│   │       ├── RawPickerSingleSelect.kt     # ModalBottomSheet single-select
│   │       └── RawPickerMultiSelect.kt      # ModalBottomSheet multi-select
│   │
│   ├── screen/
│   │   ├── FormScreen.kt                    # Demo screen scaffold
│   │   └── FormScreenViewModel.kt           # Demo ViewModel with sample data
│   │
│   ├── sample/
│   │   └── FormSampleDataFactory.kt         # Sample DefnFormUi for dev/test
│   │
│   └── state/
│       ├── FormState.kt                     # Central form state (@Immutable)
│       ├── FieldState.kt                    # Per-field state + FieldProperties
│       ├── FormEvent.kt                     # 16 internal mutation events
│       ├── FormIntent.kt                    # 4 parent-facing intents
│       ├── FieldEvent.kt                    # 3 field→form events
│       └── FieldError.kt                    # Error model + ErrorType enum
│
└── Total: ~98 files, ~7500 LOC
```

---

## Changelog

### v1.12.0 (2026-02-17)

- **Feature**: Added `FieldPickText` component — single-select dropdown picker field
- **Added**: `presentation/components/field/FieldPickText.kt` — uses `RawPickerSingleSelect` for dropdown UI
- **Added**: `pickText` branch in `Converter.kt` — `fnRawValueToFieldValue` (complex type, returns null) and `fnFieldValueToRawValue` (extracts `optionId` from `FieldValueOptionIdData`)
- **Added**: `EnumDefnCompType.pickText` routing in `FieldFactory.kt`
- **Note**: Schema (`FieldPickTextSchema`) and factory registration (`CompSchemaFactory`) already existed from v1.9.0
- **Value type**: `FieldValueOptionIdData(optionId: String, value: String?)` — stores selected option metaId and display text

### v1.11.0 (2026-02-17)

- **Docs**: Comprehensive documentation update after deep codebase exploration
- **Added**: Complete domain layer class documentation (TypesForm, FilterForm, FormPlus, FieldPropertyResolver internals)
- **Added**: FieldValueResolver subsystem documentation (Converter, DefaultValue, MutableFormValue)
- **Added**: Presentation layer class details (all 21 field implementations, raw components, composites)
- **Added**: Data Flow section with Initialization, Value Change, Validation, and Submit flows
- **Added**: Permission system documentation (FilterForm, TypeUiPermissionRole, permission priority)
- **Added**: Property resolution 3-level priority documentation
- **Added**: Default value resolution with cycle detection
- **Added**: FieldController pattern documentation (derivedStateOf, FieldUiState)
- **Added**: Complete file structure with all 98 files and descriptions
- **Added**: Troubleshooting entries for permission, default value, and type mismatch issues
- **Updated**: Schema count from 35+ to 40+ (all schemas now documented)
- **Updated**: Field type details with specific value types and special features
- **Updated**: Key Files table expanded with 10+ additional files

### v1.10.0 (2026-02-15)

- **Refactor**: Removed coroutines, queues, and async machinery from form architecture
- **Removed**: `FormAction.kt` - FormEvent is now the unified API for all operations
- **Removed**: `FormCtxStateHelper.kt` - Replaced with Compose `derivedStateOf` for computed states
- **Changed**: All mutations are now synchronous via `dispatch(FormEvent)` - no more coroutines, queues, or Dispatchers.Default
- **Changed**: `FormCtxImpl` no longer takes a `CoroutineScope` parameter
- **Removed**: `enqueue()` method - replaced by direct synchronous `dispatch()`
- **Removed**: `awaitIdle()` - operations are synchronous, state is always consistent after each call
- **Changed**: `MutableStateFlow<FormState>` replaced with `mutableStateOf<FormState>` (Compose runtime)
- **Changed**: `FormCtx` interface - removed `watchFieldState()`, `watchFieldValue()`, `watchFieldError()`, `watchFormState()`, `awaitIdle()`. Added `val formState: State<FormState>`
- **Changed**: `FormRef` interface - removed `watchFieldState()`, `watchFormState()`, `awaitIdle()`. Added `val formState: State<FormState>`
- **Changed**: `FormRefImpl` constructor simplified from `(formStateFlow, enqueueAction, coroutineScope, awaitIdleFn)` to `(getFormState, dispatchEvent)`
- **Changed**: `FieldController` now uses `State<T?>` and `State<FieldUiState>` with `derivedStateOf` instead of `StateFlow` + `CoroutineScope(Dispatchers.Default)` + `stateIn`
- **Changed**: Field component pattern - before: `val fieldValue by fieldController.value.collectAsStateWithLifecycle()`, after: `val fieldValue = fieldController.value.value`
- **Changed**: Field component pattern - before: `val (properties, error) = fieldController.field.collectAsStateWithLifecycle().value`, after: `val (properties, error) = fieldController.field.value`

### v1.9.0 (2026-02-06)

- **Feature**: Comprehensive validation schema implementation for all field types (35 new schemas)
- **Added**: Text-based schemas: `FieldEmailSchema`, `FieldParagraphSchema`, `FieldHyperlinkSchema`, `FieldSymbolSchema`, `FieldHandleSchema`, `FieldMobileNumberSchema`, `FieldOtpSchema`
- **Added**: Numeric schemas: `FieldDecimalSchema` (FieldNumberSchema already existed)
- **Added**: Date/Time schemas: `FieldDateSchema`, `FieldTimeSchema`, `FieldDateTimeSchema`, `FieldDateRangeSchema`
- **Added**: Pick/Select schemas: `FieldPickTextSchema`, `FieldPickTreeSchema`, `FieldPickUserSchema`, `FieldPickRoleSchema`, `FieldPickGridRowSchema`
- **Added**: SetOf/ChipSet schemas: `FieldChipSetSchema`, `FieldSetOfTextSchema`, `FieldSetOfUserSchema`, `FieldSetOfRoleSchema`, `FieldSetOfDocumentSchema`
- **Added**: Media schemas: `FieldImageSchema`, `FieldCameraSchema`, `FieldVideoSchema`, `FieldAudioSchema`, `FieldVoiceSchema`, `FieldDocumentSchema`
- **Added**: Special field schemas: `FieldBoolSchema`, `FieldSignatureSchema`, `FieldScanCodeSchema`, `FieldLocationSchema`, `FieldDurationSchema`, `FieldSliderSchema`, `FieldColorSchema`, `FieldGridSchema`
- **Added**: `FieldValueResolver` support for: mobileNumber, handle, hyperlink, color, time, dateTime, symbol, otp, slider, duration, location, signature, scanCode, audio, voice, video, camera, document, image, chipSet, setOfText, setOfUser, setOfRole, setOfDocument, pickText, pickTree, pickUser, pickRole, pickGridRow, grid, dateRange, dateTimeRange
- **Changed**: `CompSchemaFactory` now routes all field types to their respective schema implementations
- **Validation**: Media fields validate `required`, `maxSize` (MB to bytes conversion), and capture values (captureTime, captureLocation, captureUser)
- **Validation**: Pick fields validate `required` with proper value extraction from FieldValue*Data types
- **Validation**: SetOf fields validate `required` checking non-empty sets
- **Validation**: Duration fields validate `required`, `minDuration`, `maxDuration` with unit conversion (seconds, minutes, hours, days, weeks, months, quarters, years)
- **Validation**: Mobile number validates format with regex pattern `^\+[0-9]+$` and length 7-15 digits
- **Validation**: Email uses standard email regex pattern validation
- **Validation**: Decimal fields validate `required`, `minDecimal`, `maxDecimal` from FieldProperties

### v1.8.0 (2026-02-06)

- **Feature**: Comprehensive `FieldProperties` expansion with 20+ new properties
- **Added**: Text/Paragraph constraints: `minCharCount`, `maxCharCount`, `lineCount`
- **Added**: Number/Counter constraints: `minNumber`, `maxNumber`, `step`, `minDisplayValue`
- **Added**: Decimal constraints: `minDecimal`, `maxDecimal`
- **Added**: Display/UI properties: `showAsCheckbox`, `showLabel`, `showPreview`, `showSize`, `showSecond`, `showAsDropdown`
- **Added**: Media properties: `maxSize`
- **Added**: Button properties: `textSize`, `disableElevation`
- **Added**: Layout properties: `justifyContent`, `flexHeight`
- **Added**: `FieldValueResolver.fnResolveNumericValue()` for Long field value resolution
- **Added**: `FieldValueResolver.fnResolveNumericDecimalValue()` for Double field value resolution
- **Added**: `CompSchema.isRequired()` helper method for required field validation
- **Changed**: `FieldPropertyResolver` now resolves all new properties with full field/var/value cascade support
- **Changed**: `extractFieldIdReferences()` expanded to support 15+ field types (Text, Number, Decimal, Counter, Date, DateTime, Duration, Time, Paragraph, Password, Button, Audio, Document, Image, Video, Voice, PickUser, SetOfUser, ShowCode, Switch)
- **Changed**: `FieldTextSchema` validates with regex patterns: aadhaar, gstin, pan, custom
- **Changed**: `FieldNumberSchema` validates with dynamic min/max from FieldProperties
- **Fixed**: `FieldDecimal` parsing now uses `toDoubleOrNull()` instead of `toLongOrNull()`
- **Fixed**: `FieldValueResolver` decimal conversion now returns `Double` instead of `Long`

### v1.7.0 (2026-02-05)

- **Feature**: Integrated Konform validation library for type-safe, declarative validation
- **Added**: `FieldProperties.minCharCount`, `FieldProperties.maxCharCount` for text validation constraints
- **Added**: `FieldProperties.minNumber`, `FieldProperties.maxNumber` for number validation constraints
- **Changed**: `FieldTextSchema` now uses Konform DSL with dynamic constraint building
- **Changed**: `FieldNumberSchema` now uses Konform DSL with dynamic constraint building
- **Changed**: `FieldPropertyResolver` now resolves validation constraints with field reference support
- **Changed**: `extractFieldIdReferences()` now includes `minCharCountFieldId`, `maxCharCountFieldId`, `minFieldId`, `maxFieldId`
- **Validation**: Text fields support `required`, `minCharCount`, `maxCharCount`, `validationPattern` (aadhaar/gstin/pan/custom)
- **Validation**: Number fields support `required`, `minNumber`, `maxNumber`
- **Benefit**: Validation rules only applied when constraint values are not null (dynamic/conditional validation)

### v1.6.0 (2026-02-05)

- **Feature**: Added background action processing for UI responsiveness
- **Added**: `FormAction` sealed interface for all form actions (`presentation/state/FormAction.kt`)
- **Added**: `FormCtx.awaitIdle()` and `FormRef.awaitIdle()` suspend functions
- **Added**: `toFormEvent()` extension function to convert `FormAction` to `FormEvent`
- **Changed**: All state-modifying operations now processed on `Dispatchers.Default` via `enqueue()`
- **Changed**: `FormCtxImpl` tracks active jobs with `AtomicInteger` and `Mutex` for `awaitIdle()` support
- **Changed**: `FormRefImpl` constructor now takes `enqueueAction` instead of `dispatchEvent`
- **Benefit**: UI thread stays responsive during complex form operations (validations, calculations)

### v1.5.0 (2026-02-05)

- **Feature**: Added send button disable flag system
- **Added**: `SendBtnDisableFlag` sealed interface with predefined flags (`Invalid`, `Uploading`, `Processing`, `Validating`, `Custom`)
- **Added**: `FormState.disableSendBtnSet` property and `FormState.isSendBtnEnabled` computed property
- **Added**: `FormEvent.AddSendBtnDisableFlag` and `FormEvent.RemoveSendBtnDisableFlag` events
- **Added**: `FormIntent.SendBtnStateChanged(enabled: Boolean)` for parent notification on state transitions
- **Added**: `FormCtx.addSendBtnDisableFlag()` and `FormCtx.removeSendBtnDisableFlag()` methods
- **Added**: `FormRef.addSendBtnDisableFlag()`, `FormRef.removeSendBtnDisableFlag()`, `FormRef.isSendBtnEnabled()` methods
- **Changed**: `FormCtxValidationHelper` auto-manages `SendBtnDisableFlag.Invalid` based on error state
- **Changed**: Initial `SendBtnStateChanged` intent emitted on form initialization

### v1.4.2 (2026-02-04)

- **Refactor**: FieldText.kt - Extract stateless FieldTextContent for optimal recomposition control
- **Fix**: FieldText.kt - Add missing error flow observation
- **Fix**: FieldText.kt - Fixed supporting text area with placeholder space to prevent layout jumps
- **Refactor**: FieldNumber.kt - Extract stateless FieldNumberContent for optimal recomposition control
- **Fix**: FieldNumber.kt - Fixed supporting text area with placeholder space to prevent layout jumps

### v1.4.1 (2026-02-04)

- **Docs**: Added mandatory skill update rule

### v1.4.0 (2026-02-04)

- **Feature**: Introduced schema-based validation system (`domain/ctx/helper/schema/`)
- **Added**: `CompSchema`, `CompSchemaFactory`, `FieldTextSchema`, `FieldNumberSchema`
- **Added**: `FormState.compSchemaMap` for validation schemas
- **Added**: `FormCtx.setError()` and `FormCtx.clearError()` methods
- **Refactor**: `FormCtxValidationHelper` uses pure `validate()` from schemas
- **Removed**: `FormEvent.ValidationResult` (validation now synchronous)
- **Improved**: Validation errors preserve custom/server errors when clearing
- **Docs**: Compacted documentation with file path references

### v1.3.0 (2026-02-03)

- **Refactor**: FormReducer logic merged into FormCtxImpl
- **Refactor**: FormInitializer moved to FormCtxInitHelper
- **Added**: Helper objects for code splitting
- **Feature**: FormCtxImpl owns MutableStateFlow internally
- **Removed**: domain/reducer package

### v1.2.0 (2026-02-03)

- **Docs**: Complete restructure for improved readability

### v1.1.0 (2026-02-03)

- **BREAKING**: FormCtx provided via `LocalFormCtx` CompositionLocal
- **BREAKING**: `rememberFieldController()` no longer takes `formCtx` parameter

### v1.0.0 (2026-01-30)

- Initial skill documentation
