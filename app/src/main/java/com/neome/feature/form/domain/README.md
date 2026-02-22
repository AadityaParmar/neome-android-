# domain — Form Domain Layer

## Purpose

Contains the domain layer for the form feature: the UI-ready form definition type (`DefnFormUi`), role-based permission model, managerial relationship types, the form context facade (`ctx`), external form API (`ref`), and all resolution/transformation utilities (`util`). This package has no Android framework dependencies (except one `android.util.Log` usage in `ConditionResolver`).

## Responsibilities

- Define `DefnFormUi` — the UI-ready extension of `DefnForm` that adds computed permission maps, parent maps, and managerial relationships
- Define the role-based permission model: `TypeUiPermissionRole` (sealed interface: `Caller` | `Role`), `TypeUiFormPermission` (per-component permission/disabled/required maps), `TypeUiFormPermissionMap` (component → permission lookup)
- Define `TypeUiFormParentMap` for component parent-child hierarchy tracking
- Define `TypeUiManagerialRelationship` for manager/assistant role sets used in permission resolution
- Provide custom `TypeUiPermissionRoleSerializer` for serializing `TypeUiPermissionRole` as plain strings
- Delegate form context management, event dispatch, and state ownership to `ctx/`
- Delegate external form API (React Hook Form–style) to `ref/`
- Delegate form definition resolution, transformation, and utility functions to `util/`

## Flow

1. **Form definition ingestion** — A raw `DefnFormData` arrives from the API layer. `FilterForm.prepareUiForm` (in `util/`) transforms it into a `DefnFormUi` by computing `_permissionMap`, `_parentMap`, and `_managerialRelationship` from the permission matrix and caller roles.
2. **Context creation** — `FormCtxImpl` (in `ctx/`) receives the `DefnFormUi` and initializes form state via helpers.
3. **Runtime dispatch** — Field composables access `FormCtx` via `LocalFormCtx` to read state and dispatch events. Events are processed by pure-state helpers in `ctx/helper/`.
4. **External access** — Parent screens use `FormRef` (in `ref/`) for imperative operations (setValue, validate, submit, etc.).

## Key Entry Points

| File | Symbol | Role |
|------|--------|------|
| `TypesForm.kt` | `DefnFormUi` | `@Serializable data class` extending `DefnForm` with `_permissionMap`, `_parentMap`, `_managerialRelationship` |
| `TypesForm.kt` | `TypeUiPermissionRole` | Sealed interface — `Caller` (current user) or `Role(role: EnumDefnRoles)` |
| `TypesForm.kt` | `TypeUiPermissionRoleSerializer` | Custom `KSerializer<TypeUiPermissionRole>` — serializes as `"caller"` or role value string |
| `TypesForm.kt` | `TypeUiFormPermission` | Per-component permission config: `permission`, `disabled`, `required` maps keyed by role |
| `TypesForm.kt` | `TypeUiFormPermissionMap` | Maps `MetaIdComp` → `TypeUiFormPermission` |
| `TypesForm.kt` | `TypeUiFormParentMap` | Maps `MetaIdComp` → list of parent `MetaIdComp` |
| `TypesForm.kt` | `TypeUiManagerialRelationship` | Managerial role sets: `manager`, `grandManager`, `allManagers`, `assistants`, `allAssistants` |

## Dependencies

- `com.neome.api.meta.base.dto.DefnForm` — Base form definition interface (extended by `DefnFormUi`)
- `com.neome.api.meta.base.Types.EnumDefnRoles`, `EnumDefnPermission`, `EnumDefnCalculateFormulaMode` — Role and permission enums
- `com.neome.api.meta.base.Types.MetaIdComp`, `MetaIdField`, `MetaIdForm`, `MetaIdComposite`, `MetaIdRole`, `MetaIdGrid`, `MetaIdLayoutGrid` — ID types
- `com.neome.api.meta.base.Symbol` — Symbol type for form name
- `com.neome.core.common.serializer.api.meta.base.dto.*` — Serializable DTO types (`DefnCompSeal`, `DefnFormData`, `FormValueData`, theme/paragraph/text/permission DTOs)
- `com.neome.core.common.serializer.sysId.*` — Custom serializers for ID types (`MetaIdCompSer`, `MetaIdFieldSer`, `EntUserIdSer`, etc.)
- `kotlinx.serialization` — `@Serializable`, `KSerializer`, `PrimitiveSerialDescriptor`

## Related READMEs

- **Child**: `ctx/README.md` (form context facade — state ownership, event dispatch, CompositionLocal)
- **Child**: `ref/README.md` (external form API — imperative access for parent screens)
- **Child**: `util/README.md` (resolution and transformation utilities — FilterForm, FieldPropertyResolver, ConditionResolver, etc.)
- **Parent**: `../README.md` (form feature root)
- **Sibling**: `../presentation/README.md` (presentation layer — screens, components, state types)
- **Reference**: `../form.md` (full form feature documentation)
- **Reference**: `../MODULES.md` (module-level context)

## Change Notes

- Initial documentation created from source analysis (2026-02-22)
- 1 source file (`TypesForm.kt`, 135 lines) + 3 child packages (`ctx/`, `ref/`, `util/`)
- `DefnFormUi` uses JSON-merge construction pattern: `FilterForm.prepare` serializes `DefnFormData` to JSON, merges computed UI properties, and deserializes as `DefnFormUi`
- All `_`-prefixed properties on `DefnFormUi` are UI-computed (not from API): `_permissionMap`, `_parentMap`, `_managerialRelationship`
