---
name: defn-form
description: Android Form Component Architecture skill for MVI+UDF form system with field types, validation, property resolution, and dependency tracking
license: MIT
compatibility: opencode
metadata:
  scope: android
  feature: form
---

# skill:defnForm

> **Reference File**: This is a pointer to the canonical skill documentation.
>
> **Full Documentation**: [`app/src/main/java/com/neome/feature/form/form.md`](../../../app/src/main/java/com/neome/feature/form/form.md)

## Quick Reference

| Property         | Value                                       |
|------------------|---------------------------------------------|
| **Version**      | 1.8.0                                       |
| **Last Updated** | 2026-02-06                                  |
| **Scope**        | Android Form Component Architecture         |
| **Path**         | `app/src/main/java/com/neome/feature/form/` |

## Usage

```kotlin
using skill : defnForm do [instruction]
```

## Common Tasks

| Task                       | Example                                  |
|----------------------------|------------------------------------------|
| Add new field type         | `Add new field type FieldPhone`          |
| Add validation rule        | `Add email format validation`            |
| Add cross-field validation | `Validate password confirmation matches` |
| Add formula support        | `Implement formula calculation for X`    |
| Fix field bug              | `Fix validation bug in FieldNumber`      |
| Add async validation       | `Add async username availability check`  |
| Add conditional visibility | `Hide field Y when X is empty`           |

## Key Files

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

## Architecture

- **Pattern**: MVI + UDF (Unidirectional Data Flow) + CompositionLocal
- **State**: Immutable `FormState` with `FieldState` per field
- **Events**: `FormEvent` (internal), `FormIntent` (external), `FieldEvent` (field→form)
- **Context**: `LocalFormCtx` provides stable context without prop drilling
- **Validation**: Schema-based with Konform library (`DefnCompSchema` system)
- **Background**: All mutations via `enqueue()` on `Dispatchers.Default`

## Field Types

**Leaf Fields** (have FieldState): `text`, `email`, `number`, `decimal`, `date`, `dateTime`, `paragraph`, `bool`, `pickText`, `mobileNumber`, `handle`, `hyperlink`, `time`, `dateRange`, `dateTimeRange`, `image`, `document`

**Composite Types** (no FieldState): `section`, `tab`, `grid`, `wizard`, `spreadsheetRef`

## Recent Changes (v1.8.0)

- Comprehensive `FieldProperties` expansion with 20+ new properties
- Enhanced `FieldPropertyResolver` with full field/var/value cascade support
- `extractFieldIdReferences()` supports 20+ field types
- `FieldValueResolver` fixes for decimal type conversion
- `CompSchema.isRequired()` helper method
- Text/Number schema validation with Konform library

---

**For complete documentation including API reference, how-to guides, best practices, anti-patterns, and troubleshooting, see the [full skill file](../../../app/src/main/java/com/neome/feature/form/form.md).**
