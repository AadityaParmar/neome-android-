# base — Field Base Components

## Purpose

Provides the foundational building blocks that every form field composable depends on: a layout wrapper (`FieldBase`), a reactive state controller (`FieldController` / `rememberFieldController`), and the top-level component dispatcher (`FieldFactory`). All concrete field components in `field/` and composite components in `composite/` are built on top of these three pieces.

## Responsibilities

- `FieldBase` — wraps any field UI in a standard `Column(fillMaxWidth)` and short-circuits rendering when `FieldProperties.hidden` is true
- `FieldController<T>` — stable remembered data class that exposes two `derivedStateOf`-backed Compose `State` objects: `value: State<T?>` (deserialized field value) and `field: State<FieldUiState>` (properties + error), plus an `onChange` callback that encodes `T?` to `JsonElement` and emits `FieldEvent.ValueChanged`
- `FieldUiState` — lightweight `@Immutable` data class pairing `FieldProperties` with `FieldError?`, destructured by field composables in a single read
- `rememberFieldController<T>` — `@Composable` inline factory that extracts `fieldId` from `defnComp`, creates `derivedStateOf` values via `deriveFieldValue` / `deriveFieldUiState`, and returns a `remember`-stable `FieldController<T>` keyed on `(defnComp, onFieldEvent)`
- `deriveFieldValue` / `deriveFieldUiState` — pure top-level functions used inside `derivedStateOf` blocks; `deriveFieldValue` decodes `FormState.valueMap[fieldId]` with a `KSerializer<T>`; `deriveFieldUiState` reads `FieldState.fieldProperties` and `FormState.errors[fieldId]`
- `FieldFactory` — `@Composable` that `when`-dispatches on `defnComp.type` (`EnumDefnCompType`) to the correct leaf `Field*` composable or composite (`FieldSection`, `FieldTab`); falls back to a placeholder `Text` for unimplemented types (e.g. `grid`)

## Flow

1. **Form tree entry** — `Form.kt` (in `components/`) renders the root component using `FieldFactory(defnComp = rootComp, defnForm, onFieldEvent)`.
2. **Dispatch** — `FieldFactory` matches `defnComp.type` and calls the appropriate `Field*` composable, passing through `defnComp`, `onFieldEvent`, and `modifier`. Composite types (`section`, `tab`) also receive `defnForm`.
3. **Controller creation** — Each leaf `Field*` calls `rememberFieldController<ValueType>(defnComp, onFieldEvent)`. This reads `LocalFormCtx.current` to access `formState`, builds two `derivedStateOf` states, and returns a stable `FieldController<T>`.
4. **Rendering** — The field reads `fieldController.field.value` (destructured to `properties`, `error`) and `fieldController.value.value`. `FieldBase(properties = properties)` guards visibility and applies layout. The field renders its specific UI inside `FieldBase`.
5. **User interaction** — On value change, the field calls `fieldController.onChange(newValue)`, which encodes to `JsonElement` and dispatches `FieldEvent.ValueChanged(fieldId, jsonValue)` via `onFieldEvent`. Focus/blur/click events are dispatched directly via `onFieldEvent`.

## Key Entry Points

| File | Symbol | Role |
|------|--------|------|
| `FieldFactory.kt` | `FieldFactory` | `@Composable` dispatcher — routes `EnumDefnCompType` to correct field/composite composable |
| `FieldController.kt` | `rememberFieldController<T>` | `@Composable inline fun` — creates stable `FieldController<T>` with `derivedStateOf` states |
| `FieldController.kt` | `FieldController<T>` | `@Immutable data class` — holds `fieldId`, `value: State<T?>`, `field: State<FieldUiState>`, `onChange: (T?) -> Unit` |
| `FieldController.kt` | `FieldUiState` | `@Immutable data class` — `properties: FieldProperties`, `error: FieldError?` |
| `FieldController.kt` | `deriveFieldValue` | Top-level fun — decodes `JsonElement` from `FormState.valueMap` using `KSerializer<T>` |
| `FieldController.kt` | `deriveFieldUiState` | Top-level fun — reads `FieldState.fieldProperties` + `FormState.errors` into `FieldUiState` |
| `FieldBase.kt` | `FieldBase` | `@Composable` — hidden guard + `Column(fillMaxWidth)` wrapper for field content |

## Dependencies

- `androidx.compose.runtime` — `@Composable`, `@Immutable`, `State`, `derivedStateOf`, `remember`
- `com.neome.api.meta.base.Types.MetaIdComp`, `EnumDefnCompType` — field ID and component type enum
- `com.neome.api.meta.base.dto.DefnField` — cast target to extract `metaId` from `DefnCompSeal`
- `com.neome.core.common.serializer.api.meta.base.dto.DefnCompSeal` — opaque component definition passed to `FieldFactory` and `rememberFieldController`
- `com.neome.feature.form.domain.DefnFormUi` — passed to `FieldFactory` and composites for `compMap` lookups
- `com.neome.feature.form.domain.ctx.LocalFormCtx` — accessed in `rememberFieldController` to get `formState`
- `com.neome.feature.form.presentation.state.FieldEvent`, `FieldError`, `FieldProperties`, `FormState` — state types read/emitted by the controller
- `com.neome.feature.utils.JsonParser` — `Json` instance used in `deriveFieldValue` for deserialization
- `kotlinx.serialization` — `KSerializer`, `serializer<T>()`, `Json.encodeToJsonElement`

## Related READMEs

- **Parent**: `../README.md` (presentation/components root)
- **Child consumers**: `../field/README.md` (all leaf Field* composables use `rememberFieldController` + `FieldBase`)
- **Child consumers**: `../composite/README.md` (FieldSection, FieldTab — dispatched by `FieldFactory`, use `LocalFormCtx` directly)
- **State source**: `../../state/README.md` (FormState, FieldState, FieldProperties, FieldEvent)
- **Context source**: `../../../domain/ctx/README.md` (LocalFormCtx, FormCtx interface)
- **Form root**: `../../../form.md` (full form feature documentation)

## Change Notes

- Initial documentation created from source analysis (2026-02-22)
- 3 source files: `FieldBase.kt`, `FieldController.kt`, `FieldFactory.kt`
- `FieldFactory` has a TODO for `EnumDefnCompType.grid` — renders placeholder text currently
- `rememberFieldController` uses `inline fun <reified T>` to get `serializer<T>()` at call site; `onChange` captures the serializer via `noinline` lambda
- `FieldController.fieldId` is `MetaIdComp?` — callers guard against null (non-field component definitions return null `metaId`)
- `deriveFieldValue` silently returns null on deserialization failure (try/catch)
