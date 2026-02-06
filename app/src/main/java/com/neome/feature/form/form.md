# skill:defnForm

## Metadata

| Property           | Value                                       |
|--------------------|---------------------------------------------|
| **Version**        | 1.8.0                                       |
| **Last Updated**   | 2026-02-06                                  |
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
4. [Component Hierarchy](#component-hierarchy)
5. [How-To Guides](#how-to-guides)
6. [Troubleshooting](#troubleshooting)
7. [File Structure](#file-structure)
8. [Changelog](#changelog)

---

## Quick Reference

### Usage Pattern

```kotlin
using skill : defnForm do [instruction]
```

### Common Instructions

| Task                       | Example Instruction                      |
|----------------------------|------------------------------------------|
| Add new field type         | `Add new field type FieldPhone`          |
| Add validation rule        | `Add email format validation`            |
| Add cross-field validation | `Validate password confirmation matches` |
| Add formula support        | `Implement formula calculation for X`    |
| Fix field bug              | `Fix validation bug in FieldNumber`      |
| Add async validation       | `Add async username availability check`  |
| Add conditional visibility | `Hide field Y when X is empty`           |

### Key Files

| Purpose           | File                                              |
|-------------------|---------------------------------------------------|
| Root Composable   | `presentation/components/Form.kt`                 |
| State Owner       | `domain/ctx/FormCtxImpl.kt`                       |
| Init Helper       | `domain/ctx/helper/FormCtxInitHelper.kt`          |
| Event Helper      | `domain/ctx/helper/FormCtxEventHelper.kt`         |
| Validation Helper | `domain/ctx/helper/FormCtxValidationHelper.kt`    |
| Schema Builder    | `domain/ctx/helper/schema/CalcSchema.kt`          |
| Schema Factory    | `domain/ctx/helper/schema/CompSchemaFactory.kt`   |
| Schema Base       | `domain/ctx/helper/schema/CompSchema.kt`          |
| Text Schema       | `domain/ctx/helper/schema/FieldTextSchema.kt`     |
| Number Schema     | `domain/ctx/helper/schema/FieldNumberSchema.kt`   |
| Field Factory     | `presentation/components/base/FieldFactory.kt`    |
| External API      | `domain/ref/FormRef.kt`                           |
| Internal Context  | `domain/ctx/FormCtx.kt`                           |
| Field Controller  | `presentation/components/base/FieldController.kt` |
| State Classes     | `presentation/state/FormState.kt`                 |
| Events            | `presentation/state/FormEvent.kt`                 |
| Actions           | `presentation/state/FormAction.kt`                |
| Field State       | `presentation/state/FieldState.kt`                |
| Property Resolver | `domain/util/FieldPropertyResolver.kt`            |
| Value Resolver    | `domain/util/FieldValueResolver.kt`               |

---

## Architecture Overview

### Pattern: MVI + UDF + CompositionLocal

```
                              FORM ARCHITECTURE (v1.4.0)
===============================================================================================

  Parent (Screen/ViewModel)
         │
         │ FormRef (imperative API)
         ▼
   ┌──────────────────────────────────────────────────────────────────────────┐
   │                              Form Component                               │
   │                                                                          │
   │   ┌──────────────────────────────────────────────────────────────────┐   │
   │   │                        FormCtxImpl                                │   │
   │   │                    (Central State Owner)                          │   │
   │   │                                                                   │   │
   │   │   ┌─────────────────┐                                            │   │
   │   │   │ MutableStateFlow │ ◄─── Owned internally                     │   │
   │   │   │   <FormState>    │                                           │   │
   │   │   └────────┬─────────┘                                           │   │
   │   │            │                                                      │   │
   │   │   ┌────────▼─────────────────────────────────────────────────┐   │   │
   │   │   │                     dispatch(event)                       │   │   │
   │   │   │                                                           │   │   │
   │   │   │   ┌─────────────────┐  ┌─────────────────────────────┐   │   │   │
   │   │   │   │ FormCtxInitHelper│  │ FormCtxEventHelper         │   │   │   │
   │   │   │   │ (initialization) │  │ (value, focus, trigger)    │   │   │   │
   │   │   │   └─────────────────┘  └─────────────────────────────┘   │   │   │
   │   │   │                                                           │   │   │
   │   │   │   ┌───────────────────────┐  ┌─────────────────────────┐ │   │   │
   │   │   │   │FormCtxValidationHelper│  │ FormCtxStateHelper      │ │   │   │
   │   │   │   │ + CompSchema system   │  │ (flows, queries)        │ │   │   │
   │   │   │   └───────────────────────┘  └─────────────────────────┘ │   │   │
   │   │   └───────────────────────────────────────────────────────────┘   │   │
   │   │                                                                   │   │
   │   │   ┌──────────────────────┐                                       │   │
   │   │   │ createFormRef()      │ ──► Returns FormRefImpl               │   │
   │   │   └──────────────────────┘                                       │   │
   │   │                                                                   │   │
   │   └───────────────────────────────────────────────────────────────────┘   │
   │          │                                                                 │
   │          │ LocalFormCtx (CompositionLocal)                                │
   │          ▼                                                                 │
   │   ┌─────────────────────────────────────────────────────────────────┐    │
   │   │                      Field Components                            │    │
   │   │  FieldText │ FieldNumber │ FieldDate │ FieldSection │ ...       │    │
   │   │          (use rememberFieldController + LocalFormCtx)            │    │
   │   └─────────────────────────────────────────────────────────────────┘    │
   │                                                                          │
   └──────────────────────────────────────────────────────────────────────────┘
         │
          │ FormIntent (Submit, Watch, ValidationStateChanged, SendBtnStateChanged)
          ▼
  Parent (Screen/ViewModel)
```

### Core Principles

| Principle              | Implementation                                     |
|------------------------|----------------------------------------------------|
| Single Source of Truth | All state in immutable `FormState`                 |
| Pure Handlers          | Helper functions have no side effects              |
| Reactive Updates       | StateFlow for UI observation                       |
| Imperative API         | `FormRef` for parent control                       |
| Stable Context         | `FormCtx` never recreated after Form init          |
| No Prop Drilling       | `LocalFormCtx` provides context to all descendants |
| Schema Validation      | `DefnCompSchema` for type-specific validation      |
| Background Processing  | All mutations via `enqueue()` on `Dispatchers.Default` |

---

## Core Concepts

### State Definitions

> **Reference Files:**
> - `presentation/state/FormState.kt` - FormState, FieldDependencyMap
> - `presentation/state/FieldState.kt` - FieldState, FieldProperties
> - `presentation/state/FieldError.kt` - FieldError, ErrorType

**Key Properties in FormState:**

- `defnForm` - Form schema definition
- `fieldStates` - Map of field ID to FieldState
- `errors` - Map of field ID to FieldError
- `fieldDependencies` - Dependency tracking for property recalculation
- `compSchemaMap` - Validation schemas built during initialization
- `disableSendBtnSet` - Set of flags disabling send button (empty = enabled)
- `isInitialized`, `disabled`, `readOnly`, `isSubmitting`

**Computed Properties:** `hasErrors`, `isDirty`, `isValid`, `isSendBtnEnabled`

**FieldProperties (v1.8.0):**

| Category           | Properties                                              |
|--------------------|---------------------------------------------------------|
| Base               | `required`, `disabled`, `readOnly`, `hidden`            |
| Display            | `label`, `helperText`, `placeholder`                    |
| Text/Paragraph     | `minCharCount`, `maxCharCount`, `lineCount`, `flexHeight` |
| Number/Counter     | `minNumber`, `maxNumber`, `step`, `minDisplayValue`, `justifyContent` |
| Decimal            | `minDecimal`, `maxDecimal`                              |
| Media              | `maxSize`, `showLabel`, `showPreview`, `showSize`       |
| UI Toggles         | `showAsCheckbox`, `showSecond`, `showAsDropdown`        |
| Button             | `textSize`, `disableElevation`                          |

**SendBtnDisableFlag Types:**

- `Invalid` - Form has validation errors (auto-managed by FormCtxValidationHelper)
- `Uploading` - File upload in progress
- `Processing` - Background processing in progress
- `Validating` - Validation in progress
- `Custom(key)` - Custom flag with unique key

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

| Intent                   | Direction     | Purpose                          |
|--------------------------|---------------|----------------------------------|
| `Submit`                 | Form → Parent | Deliver validated form data      |
| `Watch`                  | Form → Parent | Notify field value changes       |
| `ValidationStateChanged` | Form → Parent | Notify validation state changes  |
| `SendBtnStateChanged`    | Form → Parent | Notify send button state changes |

### Error Handling

> **Reference File:** `presentation/state/FieldError.kt`

- **Validation errors** - Auto-cleared when field value changes
- **Custom/Server errors** - Persist until manually cleared via `clearErrors()`

### API Interfaces

> **Reference Files:**
> - `domain/ref/FormRef.kt` - External API for parent components
> - `domain/ctx/FormCtx.kt` - Internal API for field components

**FormRef** (for parents): `getValue`, `getValues`, `setValue`, `setValues`, `validate`, `setError`, `clearErrors`, `submit`, `reset`, `isDirty`, `isValid`, `isTouched`, `watchFieldState`, `watchFormState`, `addSendBtnDisableFlag`, `removeSendBtnDisableFlag`, `isSendBtnEnabled`, `awaitIdle`

**FormCtx** (for fields): `trigger`, `getValues`, `getValue`, `getFieldState`, `getError`, `hasField`, `getDefnForm`, `validate`, `setError`, `clearError`, `watchFieldState`, `watchFieldError`, `watchFormState`, `addSendBtnDisableFlag`, `removeSendBtnDisableFlag`, `awaitIdle`

### Validation Schema System

> **Reference Files:**
> - `domain/ctx/helper/schema/DefnCompSchema.kt` - Abstract base class
> - `domain/ctx/helper/schema/CalcSchema.kt` - Builds schemas during init
> - `domain/ctx/helper/schema/CompSchemaFactory.kt` - Factory by field type
> - `domain/ctx/helper/schema/DefnFieldTextSchema.kt` - Text validation
> - `domain/ctx/helper/schema/DefnFieldNumberSchema.kt` - Number validation

**Schema Lifecycle:**

1. `CalcSchema.buildFormSchemas()` called during form initialization
2. Schemas stored in `FormState.compSchemaMap`
3. `FormCtxValidationHelper` calls `schema.validatePure()` during validation
4. Errors set/cleared based on validation result

---

## Component Hierarchy

```
Form (provides LocalFormCtx)
└── FormContent
    └── FieldFactory (routes by type)
        │
        ├── COMPOSITE TYPES (no FieldState)
        │   ├── FieldTab → FieldFactory (per tab content)
        │   ├── FieldSection → FieldFactory (per child)
        │   ├── grid, wizard, spreadsheetRef
        │
        └── LEAF TYPES (have FieldState)
            ├── FieldText, FieldNumber, FieldDecimal, FieldEmail
            ├── FieldDate, FieldDateTime, FieldParagraph
            ├── FieldBool, FieldPickText, FieldMobileNumber
            ├── FieldHandle, FieldHyperlink, FieldTime
            ├── FieldDateRange, FieldDateTimeRange
            └── FieldImage, FieldDocument
```

> **Reference Files:**
> - `presentation/components/base/FieldFactory.kt` - Type routing
> - `presentation/components/base/FieldController.kt` - Field helper
> - `presentation/components/field/*.kt` - Individual field implementations

---

## How-To Guides

### Adding a New Field Type

1. **Create Field Component** in `presentation/components/field/Field{Name}.kt`
    - Use `rememberFieldController<FieldValueXData>()` for state
    - Wrap with `FieldBase` for consistent styling
    - Check `properties.hidden` for early return

2. **Register in FieldFactory** - Add case in `presentation/components/base/FieldFactory.kt`

3. **Add Value Conversion** (if needed) in `domain/util/FieldValueResolver.kt`

4. **Add Validation Schema** (if needed):
    - Create `domain/ctx/helper/schema/DefnField{Name}Schema.kt`
    - Register in `domain/ctx/helper/schema/CompSchemaFactory.kt`

> **Example Reference:** See `presentation/components/field/FieldText.kt` and `domain/ctx/helper/schema/DefnFieldTextSchema.kt`

### Adding a Validation Rule

1. **Create Schema Class** extending `DefnCompSchema`
    - Implement `validatePure(fieldValue, fieldState): String?`
    - Return error message or null (pure function, no side effects)

2. **Register in CompSchemaFactory** - Add case for field type

> **Example Reference:** See `domain/ctx/helper/schema/DefnFieldNumberSchema.kt`

### Adding Property Resolution

1. **Add property** to `FieldProperties` in `presentation/state/FieldState.kt`
2. **Add resolver** in `domain/util/FieldPropertyResolver.kt`
3. **Add to dependency extraction** in `extractFieldIdReferences()`

**Supported Field Types for Dependency Extraction (v1.8.0):**
Text, Number, Decimal, Counter, Date, DateTime, Duration, Time, Paragraph, Password, Button, Audio, Document, Image, Video, Voice, PickUser, SetOfUser, ShowCode, Switch

### Adding Cross-Field Validation

Cross-field schemas may need `FormCtx` access. Modify `CompSchemaFactory` to pass context if needed.

---

## Troubleshooting

| Issue                  | Cause                                   | Solution                                                     |
|------------------------|-----------------------------------------|--------------------------------------------------------------|
| Field not updating     | Missing dependency registration         | Check `extractFieldIdReferences()` includes the source field |
| Validation not running | `shouldValidate = false`                | Ensure `shouldValidate` parameter is true                    |
| FormCtx not found      | Field outside Form tree                 | Wrap component in Form or check hierarchy                    |
| Stale field state      | Not using `collectAsStateWithLifecycle` | Replace `collectAsState` with lifecycle-aware version        |
| Infinite recomposition | Unstable lambda/object in composable    | Use `remember` or move to ViewModel                          |
| Field not rendering    | `hidden = true` in properties           | Check property resolution logic                              |

---

## File Structure

```
app/src/main/java/com/neome/feature/form/
│
├── domain/
│   ├── ctx/
│   │   ├── FormCtx.kt                      # Internal API interface
│   │   ├── FormCtxImpl.kt                  # Central state owner
│   │   └── helper/
│   │       ├── FormReducerResult.kt        # Event processing result
│   │       ├── FormCtxInitHelper.kt        # Initialization logic
│   │       ├── FormCtxEventHelper.kt       # Event handlers
│   │       ├── FormCtxValidationHelper.kt  # Validation logic
│   │       ├── FormCtxStateHelper.kt       # State flow utilities
│   │       └── schema/                     # Validation schema system
│   │           ├── CalcSchema.kt           # Builds schemas for all fields
│   │           ├── CompSchemaFactory.kt    # Factory by field type
│   │           ├── DefnCompSchema.kt       # Abstract base class
│   │           ├── DefnFieldTextSchema.kt  # Text validation
│   │           └── DefnFieldNumberSchema.kt # Number validation
│   │
│   ├── ref/
│   │   ├── FormRef.kt                      # External API interface
│   │   └── FormRefImpl.kt                  # Implementation
│   │
│   └── util/
│       ├── FieldPropertyResolver.kt        # Dynamic property resolution
│       ├── FieldValueResolver.kt           # Type conversion
│       └── CalcFormula.kt                  # Formula calculation
│
├── presentation/
│   ├── components/
│   │   ├── Form.kt                         # Root composable
│   │   ├── base/
│   │   │   ├── FieldBase.kt                # Common field wrapper
│   │   │   ├── FieldController.kt          # Field helper
│   │   │   └── FieldFactory.kt             # Type-based routing
│   │   ├── composite/
│   │   │   ├── FieldSection.kt
│   │   │   └── FieldTab.kt
│   │   └── field/
│   │       └── Field*.kt                   # Individual fields
│   │
│   ├── screen/
│   │   ├── FormScreen.kt
│   │   └── FormScreenViewModel.kt
│   │
│   ├── sample/
│   │   └── FormSampleDataFactory.kt
│   │
│   └── state/
│       ├── FormState.kt
│       ├── FieldState.kt
│       ├── FormEvent.kt
│       ├── FormAction.kt                    # Action types for background processing
│       ├── FormIntent.kt
│       ├── FieldEvent.kt
│       └── FieldError.kt
│
└── form.md                                 # THIS FILE
```

---

## Changelog

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
- **Added**: `DefnCompSchema`, `CalcSchema`, `CompSchemaFactory`, `DefnFieldTextSchema`, `DefnFieldNumberSchema`
- **Added**: `FormState.compSchemaMap` for validation schemas
- **Added**: `FormCtx.setError()` and `FormCtx.clearError()` methods
- **Refactor**: `FormCtxValidationHelper` uses pure `validatePure()` from schemas
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
