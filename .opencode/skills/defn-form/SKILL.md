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
| **Version**      | 1.9.0                                       |
| **Last Updated** | 2026-02-15                                  |
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
| Field State       | `presentation/state/FieldState.kt`                |
| Property Resolver | `domain/util/FieldPropertyResolver.kt`            |
| Value Resolver    | `domain/util/FieldValueResolver.kt`               |

## Architecture

- **Pattern**: MVI + UDF (Unidirectional Data Flow) + CompositionLocal
- **State**: Immutable `FormState` with `FieldState` per field, held in Compose `mutableStateOf`
- **Events**: `FormEvent` (unified API), `FormIntent` (external), `FieldEvent` (field->form)
- **Context**: `LocalFormCtx` provides stable context without prop drilling
- **Validation**: Schema-based with Konform library (`DefnCompSchema` system)
- **Dispatch**: All mutations synchronous via `dispatch(FormEvent)`. Future threading via caller-chosen dispatchers.

## Field Types

**Leaf Fields** (have FieldState): `text`, `email`, `number`, `decimal`, `date`, `dateTime`, `paragraph`, `bool`, `pickText`, `mobileNumber`, `handle`, `hyperlink`, `time`, `dateRange`, `dateTimeRange`, `image`, `document`

**Composite Types** (no FieldState): `section`, `tab`, `grid`, `wizard`, `spreadsheetRef`

## Recent Changes (v1.9.0)

- Removed coroutines, queues, Mutex from FormCtxImpl — all mutations are now synchronous
- Deleted `FormAction.kt` — `FormEvent` is now the unified API for all mutations
- Deleted `FormCtxStateHelper.kt` — replaced with Compose `derivedStateOf`
- Replaced `MutableStateFlow<FormState>` with `mutableStateOf<FormState>` (Compose runtime)
- `FormCtx` exposes `val formState: State<FormState>` instead of watch methods
- Removed `awaitIdle()` — operations are synchronous, state always consistent after each call
- `FieldController` uses `State<T?>` + `derivedStateOf` instead of `StateFlow` + `stateIn`
- Field components use `fieldController.value.value` instead of `collectAsStateWithLifecycle()`
- `FormCtxImpl` no longer requires `CoroutineScope` parameter
- `FormRefImpl` simplified to `(getFormState, dispatchEvent)` constructor

---

**For complete documentation including API reference, how-to guides, best practices, anti-patterns, and troubleshooting, see the [full skill file](../../../app/src/main/java/com/neome/feature/form/form.md).**
