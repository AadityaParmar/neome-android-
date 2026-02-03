# skill:defnForm

> **Reference File**: This is a pointer to the canonical skill documentation.
>
> **Full Documentation**: [`app/src/main/java/com/neome/feature/form/form.md`](../../../app/src/main/java/com/neome/feature/form/form.md)

## Quick Reference

| Property       | Value                                                    |
|----------------|----------------------------------------------------------|
| **Version**    | 1.2.0                                                    |
| **Scope**      | Android Form Component Architecture                      |
| **Path**       | `app/src/main/java/com/neome/feature/form/`              |

## Usage

```kotlin
using skill : defnForm do [instruction]
```

## Common Tasks

| Task                          | Example                                  |
|-------------------------------|------------------------------------------|
| Add new field type            | `Add new field type FieldPhone`          |
| Add validation rule           | `Add email format validation`            |
| Add cross-field validation    | `Validate password confirmation matches` |
| Fix field bug                 | `Fix validation bug in FieldNumber`      |
| Add async validation          | `Add async username availability check`  |
| Add conditional visibility    | `Hide field Y when X is empty`           |

## Key Files

| Purpose          | File                                           |
|------------------|------------------------------------------------|
| Root Composable  | `presentation/components/Form.kt`              |
| State Reducer    | `domain/reducer/FormReducer.kt`                |
| Field Factory    | `presentation/components/base/FieldFactory.kt` |
| External API     | `domain/ref/FormRef.kt`                        |
| Internal Context | `domain/ctx/FormCtx.kt`                        |
| Field Controller | `presentation/components/base/FieldController.kt` |

## Architecture

- **Pattern**: MVI + UDF (Unidirectional Data Flow) + CompositionLocal
- **State**: Immutable `FormState` with `FieldState` per field
- **Events**: `FormEvent` (internal), `FormIntent` (external), `FieldEvent` (field→form)
- **Context**: `LocalFormCtx` provides stable context without prop drilling

## Field Types

**Leaf Fields** (have FieldState): `text`, `email`, `number`, `decimal`, `date`, `dateTime`, `paragraph`, `bool`, `pickText`

**Composite Types** (no FieldState): `section`, `tab`, `grid`, `wizard`, `spreadsheetRef`

---

**For complete documentation including API reference, how-to guides, best practices, anti-patterns, and troubleshooting, see the [full skill file](../../../app/src/main/java/com/neome/feature/form/form.md).**
