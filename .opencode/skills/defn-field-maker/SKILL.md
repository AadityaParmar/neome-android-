# Skill: defn-field-maker

# skill:defnFieldMaker

> **Reference File**: This is a pointer to the canonical skill documentation.
>
> **Full Documentation**: [`app/src/main/java/com/neome/feature/form/field-maker.md`](../../../app/src/main/java/com/neome/feature/form/field-maker.md)

## Quick Reference

| Property         | Value                                                     |
|------------------|-----------------------------------------------------------|
| **Version**      | 1.0.0                                                     |
| **Last Updated** | 2026-02-17                                                |
| **Scope**        | Creating new field types for the Form FieldFactory system |
| **Path**         | `app/src/main/java/com/neome/feature/form/`               |
| **Depends On**   | `skill:defnForm` (form architecture knowledge)            |

## Usage

```kotlin
using skill : defnFieldMaker do [instruction]
```

## Common Tasks

| Task                       | Example                                              |
|----------------------------|------------------------------------------------------|
| Add simple text-like field | `Add new field type FieldColor`                      |
| Add numeric field          | `Add new field type FieldRating with min/max`        |
| Add complex field          | `Add new field type FieldLocation with capture`      |
| Add picker field           | `Add new field type FieldPickText with dropdown`     |
| Add media field            | `Add new field type FieldAudio with size validation` |

## Files to Touch (8 Steps)

| #  | File (relative to `feature/form/`)                      | Action  | When           |
|----|----------------------------------------------------------|---------|----------------|
| 1  | `domain/util/FieldVal/Converter.kt`                     | EDIT    | Always         |
| 2  | `domain/util/FieldVal/DefaultValue.kt`                  | EDIT    | If has default |
| 3  | `domain/util/FieldPropertyResolver.kt`                  | EDIT    | If has unique props |
| 4  | `presentation/state/FieldState.kt`                      | EDIT    | If new FieldProperties |
| 5  | `domain/ctx/helper/schema/Field{Name}Schema.kt`         | CREATE  | Always         |
| 6  | `domain/ctx/helper/schema/CompSchemaFactory.kt`          | EDIT    | Always         |
| 7  | `presentation/components/field/Field{Name}.kt`           | CREATE  | Always         |
| 8  | `presentation/components/base/FieldFactory.kt`           | EDIT    | Always         |

## Prerequisites

These artifacts are **auto-generated** and MUST already exist before using this skill:

- `DefnField{Name}` interface in `api/meta/base/dto/`
- `DefnField{Name}Data` data class in `core/common/serializer/api/meta/base/dto/`
- `FieldValue{Name}Data` data class in `core/common/serializer/api/meta/base/dto/`
- `EnumDefnCompType.{name}` enum entry in `api/meta/base/Types.kt`
- `DefnCompSerializer` routing in `core/common/serializer/api/meta/base/dto/DefnCompData.kt`

## Architecture

- **Pattern**: MVI + UDF (Unidirectional Data Flow) + CompositionLocal
- **State**: Immutable `FormState` with `FieldState` per field, held in Compose `mutableStateOf`
- **Controller**: `rememberFieldController<FieldValueXData>()` provides `derivedStateOf`-based reactive state
- **Validation**: Schema-based with Konform library (`CompSchema` system)
- **Dispatch**: All mutations synchronous via `dispatch(FormEvent)`

## Field Component Pattern

```kotlin
@Composable
fun Field{Name}(defnComp: DefnCompSeal, onFieldEvent: (FieldEvent) -> Unit, modifier: Modifier = Modifier) {
    val controller = rememberFieldController<FieldValue{Name}Data>(defnComp, onFieldEvent)
    if (controller.fieldId == null) return
    val fieldValue = controller.value.value
    val (properties, error) = controller.field.value
    if (properties.hidden) return

    FieldBase(modifier) {
        Field{Name}Content(/* stateless params */)
    }
}
```

---

**For complete documentation including code templates, validation patterns, property resolution, reference examples, anti-patterns, and verification checklist, see the [full skill file](../../../app/src/main/java/com/neome/feature/form/field-maker.md).**
