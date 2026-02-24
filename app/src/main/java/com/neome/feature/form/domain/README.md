# Form Domain Layer

## Purpose

The domain layer manages the **logical structure, state, and contract** of dynamic forms in the application. It defines immutable type definitions for form permissions and structure, orchestrates form context and state through MVI-inspired patterns, exposes an imperative API for parent screens, and provides pure transformation utilities for runtime form resolution.

As part of Clean Architecture, this layer has **no Android framework dependencies** (except Coroutines) and no imports from the data or presentation layers.

---

## Responsibilities

### Core Type Definitions
- Sealed interface `TypeUiPermissionRole` representing component-level access control (Role with EnumDefnRoles or Caller)
- Custom `TypeUiPermissionRoleSerializer` for Kotlinx Serialization support
- Data classes `TypeUiFormPermission`, `TypeUiFormPermissionMap`, `TypeUiFormParentMap` encapsulating permission and relationship structures
- Data class `TypeUiManagerialRelationship` storing manager/assistant relationships for hierarchical forms
- Data class `DefnFormUi` extending `DefnForm` with computed UI-ready fields (`_permissionMap`, `_parentMap`, `_managerialRelationship`) marked @Serializable

### Form Context Management
- `FormCtx` interface defining the contract for form state observation and event dispatch
- `FormCtxImpl` owning `FormState` (as mutableStateOf) and routing all `FormEvent` dispatches to specialized handlers in `ctx/base/`
- `LocalFormCtx` providing CompositionLocal dependency injection for form context throughout the Compose tree
- State immutability at the interface level while enabling efficient mutations internally

### External API
- `FormRef` interface exposing imperative read/write access for parent screens
- `FormRefImpl` delegating to `FormState` reads and `FormEvent` dispatches via lambdas
- Single-responsibility contract: read form state, write field values, trigger submit/reset, control send button visibility

### Utility Layer
- Pure, side-effect-free transformation utilities (`FilterForm.prepareUiForm`) converting `DefnFormData` → `DefnFormUi` with resolved permissions and relationships
- Runtime resolution helpers: `ArgValueResolver`, `FieldPropertyResolver`, `ConditionResolver`, `FormPlus` for dynamic form adaptation
- Type conversion and default value handling via `FieldVal` utilities
- No Android framework dependencies; no mutation of input data

---

## Flow

### 1. Form Preparation (Initialization)
- Server provides `DefnForm` (form definition) and caller entity metadata
- `util/FilterForm.prepareUiForm()` transforms `DefnFormData` → `DefnFormUi`
  - Resolves permissions (`TypeUiFormPermission`) per component based on `TypeUiPermissionRole`
  - Computes parent relationships (`TypeUiFormParentMap`)
  - Calculates manager/assistant hierarchies (`TypeUiManagerialRelationship`)
- **Result**: immutable `DefnFormUi` stable for the entire form lifetime

### 2. Context Creation
- Presentation layer creates `FormCtxImpl` with the prepared `DefnFormUi`
- `FormCtxImpl` initializes `FormState` (mutableStateOf) with empty field values, validation state, and submit flag
- Form context becomes available via `LocalFormCtx` CompositionLocal to all descendant Composables

### 3. Runtime Event Dispatch
- User interacts with form UI (field change, button click, etc.)
- Composable dispatches `FormEvent` via `formCtx.dispatch(event)`
- `FormCtxImpl.dispatch()` routes event to appropriate handler in `ctx/base/` (e.g., `onFieldValueChanged`, `onSubmitClicked`)
- Handler validates, transforms, and updates `FormState` immutably
- `FormState` changes trigger recomposition of observing Composables

### 4. External Access
- Parent screen holds `FormRef` (typically via a ViewModel)
- `FormRef` enables imperative operations:
  - Read current field values: `getFieldValue(componentId)`
  - Write values: `setFieldValue(componentId, newValue)`
  - Trigger actions: `submit()`, `reset()`
  - Control visibility: `setSendButtonEnabled(enabled)`
- Parent can also observe `FormState` via `FormRef` for conditional logic (e.g., enable/disable parent buttons)

---

## Key Entry Points

### TypesForm.kt
- **Sealed interface** `TypeUiPermissionRole` — Component-level permission abstraction (Role | Caller)
- **Data class** `TypeUiFormPermission` — Per-component permission state (permission, disabled, required maps keyed by role)
- **Data class** `TypeUiFormPermissionMap` — Wraps map of component ID → permissions
- **Data class** `TypeUiFormParentMap` — Maps component IDs to parent component ID lists
- **Data class** `TypeUiManagerialRelationship` — Manager/assistant relationship sets
- **Data class** `DefnFormUi` — Server form definition extended with computed UI-ready fields

### ctx/FormCtxImpl
- **Single entry point** for all form state mutations via `dispatch(FormEvent)`
- Owns `FormState` (mutable) and routes events to `ctx/base/` handlers
- Provides observable state via `FormCtx.state` (StateFlow)
- Initializes with prepared `DefnFormUi` and caller metadata

### ref/FormRef
- **Imperative API** for parent screens to read/write form state without observing context
- Methods: `getFieldValue()`, `setFieldValue()`, `submit()`, `reset()`, `setSendButtonEnabled()`
- `FormRefImpl` delegates all operations back to `FormState` and `FormCtxImpl.dispatch()`

### util/FilterForm
- **Entry function** `prepareUiForm(formData, caller)` transforms raw definition → computed UI form
- Resolves all permissions and relationships once, ahead of runtime
- Pure function with no side effects; output is cached and reused throughout form lifetime

---

## Package Structure

- **TypesForm.kt** — Core type definitions and @Serializable data classes for form structure and permissions
- **ctx/** — Form context and state management; owns FormState and event dispatch logic. See `ctx/README.md`
- **ref/** — External imperative API bridge; exposes FormRef for parent screen access. See `ref/README.md`
- **util/** — Pure transformation and resolution utilities; prepare UI form and resolve runtime properties. See `util/README.md`

---

## Dependencies / Relationships

### Internal
- **ctx/** depends on **TypesForm.kt** (reads DefnFormUi, TypeUiPermissionRole)
- **ref/** depends on **ctx/** (accesses FormCtx and FormState)
- **util/** depends on **TypesForm.kt** (produces DefnFormUi, reads DefnFormData)

### External (upward)
- **Presentation layer** (feature/form/presentation/) creates FormCtxImpl and uses FormRef
- **Data layer** (feature/form/data/) provides DefnFormData via repository

### External (lateral)
- **Domain models** (feature/form/domain/model/ — if separate) define Item, Form, DefnForm, DefnFormData, etc.
- Assumes availability of core types like `MetaIdComp`, `EnumDefnRoles`, `DefnForm`, `DefnFormData`

### Framework / stdlib
- **Kotlin stdlib** — sealed interfaces, data classes, collections
- **Kotlinx Serialization** — @Serializable annotations on type definitions
- **Kotlin Coroutines** — no direct use in domain; available for future Flow-based patterns

---

## Related READMEs

- **ctx/README.md** — Form context creation, state management via FormCtxImpl, event routing
- **ref/README.md** — FormRef interface contract, imperative API design, delegation pattern
- **util/README.md** — Form preparation pipeline, permission/relationship resolution, field value handling
