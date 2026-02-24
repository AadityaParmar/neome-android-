# util — Form Definition Resolution and Transformation Utilities

## Purpose

Pure-function utility package providing all transformations and resolutions needed to prepare form definitions for UI consumption and to execute runtime form operations. Contains no mutable state—all utilities are Kotlin `object` singletons. This package bridges definition-layer data structures with presentation-layer requirements through deterministic resolution pipelines.

## Responsibilities

- **Permission resolution**: Compute role-based permission maps with priority-ordered fallback (write > writeOnce > writeOnInsert > read > invisible > hide)
- **Relationship mapping**: Build parent-child hierarchies (section→field→grid) and managerial relationships (manager, grandManager, allManagers, assistants)
- **Caller injection**: Inject caller-specific properties (timezone, handle, dateFormat, autoPickSelf for pickUser/setOfUser fields)
- **Dynamic property resolution**: Resolve 30+ field properties using 3-tier priority (direct value → variable resolution → field reference)
- **Dependency mapping**: Build inter-field dependency maps from `*FieldId` references for cascade triggering
- **Condition evaluation**: Evaluate AND/OR condition trees with typed operators (hasValue, equalTo, greaterThan, lessThan, contains, inList, dateRange)
- **Arg value resolution**: Parse and resolve arg value strings by kind (context, derived, variable, field reference)
- **Form tree traversal**: Recursively walk form definition trees (tabs → sections → fields → grids)

## Flow

### Form Preparation Path
Form preparation occurs once when a `DefnFormData` is loaded and must be transformed into `DefnFormUi`:

1. **`FilterForm.prepareUiForm`** — Entry point. Accepts raw `DefnFormData` and `SigEntCaller` entity.
   - Calls `prepare()` which recursively walks all components via `FormPlus.loopDefnForm`
   - Resolves role-based permissions per component, computing the permission priority order for each caller role
   - Inherits parent permissions down the component tree
   - Builds parent maps (maps each component to its containing section/tab/grid)
   - Injects caller properties into special fields (timezone, handle, dateFormat, autoPickSelf)
   - Populates managerial relationship user sets (manager, grandManager, allManagers, assistants)
   - Delegates to `ArgValueResolver.resolveDefnForm` for all component arg resolution
   - Returns immutable `DefnFormUi` ready for presentation

2. **`ArgValueResolver.resolveDefnForm`** — Iterates `compMap` resolving each component's text/paragraph args.
   - For each component, calls `resolve()` for `DefnDtoText` and `resolveParagraph()` for `DefnDtoParagraph`
   - Each arg string is parsed as JSON-encoded `StudioDtoArgValueForClient` and dispatched by `kind` discriminator
   - Delegates to `resolveArgForFieldVal` for default value initialization in `FieldVal` package

### Runtime Path
During form interaction, dynamic property resolution and condition evaluation are triggered:

3. **`FieldPropertyResolver.resolveFieldProperties`** — Resolves all 30+ properties for a single component.
   - Checks direct value first (shortest path)
   - Falls back to variable resolution via `resolveArgValue` (reads `*Var` fields)
   - Falls back to field reference lookup (reads `*FieldId` values from other fields)
   - Returns immutable `FieldProperties` consumed by helpers/actions
   - **`buildDependencyMap`** — Scans all components' `*FieldId` references to build `FieldDependencyMap` used for cascade triggering

4. **`ConditionResolver.resolve`** — Evaluates a `DefnEventConditionMap` (AND/OR tree of leaf conditions).
   - Each leaf condition compares a field's current value against expected values using typed operators
   - Supports date/time comparisons, set-type fields, context binder (caller) resolution
   - Includes **debug logging** for each leaf condition (condition name, field name, operator, lhs/rhs values, result) and each AND/OR group (clause count, result) for verification
   - Returns `Boolean?` (true/false/null for unresolvable)

5. **`FormPlus.loopDefnForm`** — Recursive form tree traversal.
   - Walks from root `displayCompositeId` through all tabs, sections, wizards, grids, and formLists
   - Invokes callback with each component and its parent context
   - Used by `FilterForm`, `FieldValueResolver.fnEnsureInit`, and other helpers

## Key Entry Points

| File | Symbol | Role |
|------|--------|------|
| `FilterForm.kt` | `FilterForm.prepareUiForm` | Transforms `DefnFormData` → `DefnFormUi` with permissions, parent maps, caller injection |
| `ArgValueResolver.kt` | `ArgValueResolver.resolveDefnForm` | Resolves all arg values in form definition components |
| `ArgValueResolver.kt` | `ArgValueResolver.resolve` | Resolves a `DefnDtoText` arg string list |
| `ArgValueResolver.kt` | `ArgValueResolver.resolveParagraph` | Resolves a `DefnDtoParagraph` arg string list |
| `ArgValueResolver.kt` | `ArgValueResolver.resolveArgStr` | Parses and dispatches a single JSON-encoded arg string by kind |
| `ArgValueResolver.kt` | `ArgValueResolver.resolveArgForFieldVal` | Resolves arg values during default value initialization |
| `FieldPropertyResolver.kt` | `FieldPropertyResolver.resolveFieldProperties` | Resolves all dynamic properties for a component → `FieldProperties` |
| `FieldPropertyResolver.kt` | `FieldPropertyResolver.buildDependencyMap` | Builds `FieldDependencyMap` from `*FieldId` references across all components |
| `FieldPropertyResolver.kt` | `FieldPropertyResolver.resolveArgValue` | Resolves a `DefnDtoText` variable to a plain string |
| `ConditionResolver.kt` | `ConditionResolver.resolve` | Evaluates an AND/OR condition tree → `Boolean?` |
| `FormPlus.kt` | `FormPlus.loopDefnForm` | Recursive tree traversal of form definition components |
| `FormPlus.kt` | `FormPlus.getCompMetaId` | Extracts `MetaIdComp` from any component type |
| `FormPlus.kt` | `FormPlus.getSystemFieldCompType` | Maps system field IDs to their component types |
| `FormPlus.kt` | `FormPlus.matchAllRoles` | Checks if all caller roles are present in a target role set |
| `CalcFormula.kt` | `CalcFormula.calc` | Formula calculation stub (empty body, TODO implementation) |
| `DatePlus.kt` | `DatePlus.formatDate` | Date formatting stub (returns input as-is, TODO implementation) |
| `DatePlus.kt` | `DatePlus.calcDefnBuildDate` / `calcDefnBuildDateTime` | Build-date resolution stubs (returns value or customValue, TODO implementation) |
| `TypeArgValueResolver.kt` | `TypeCustomValueDate` / `TypeCustomValueTime` / `TypeCustomValueDateTime` / `TypeCustomValueSeq` | Serializable data classes for typed arg custom values |
| `TypeArgValueResolver.kt` | `StudioDtoArgValueForClient` | Client-side polymorphic arg value wrapper with `kind` discriminator |

## Dependencies and Relationships

### Domain Layer Dependencies
- `com.neome.api.meta.base.Types` — Type aliases and enums (MetaIdComp, MetaIdField, MetaIdRole, EnumDefnCompType, EnumDefnArgBinder, EnumDefnArgBinderContext, EnumDefnEventOperator, EnumDefnPermission, EnumDefnRoles, EnumDefnFields)
- `com.neome.api.meta.base.dto.*` — Data transfer objects (DefnComp, DefnForm, DefnField*, DefnEventCondition, DefnEventConditionMap, DefnDtoPermissionMatrix, FieldDtoArg, FormValue)
- `com.neome.api.ent.entDrawer.sig.SigEntCaller` — Caller entity containing roles, handle, timezone, managers, settings

### Serialization Dependencies
- `com.neome.core.common.serializer.api.meta.base.dto.*` — Serializable DTOs (DefnFormData, DefnCompSeal, FormValueData, all FieldValue*Data types, StudioDtoArgValue*Data classes)
- `com.neome.feature.utils.JsonParser` — kotlinx.serialization JSON instance

### Presentation Layer Dependencies
- `com.neome.feature.form.domain.DefnFormUi` — UI-ready form definition (output of FilterForm preparation)
- `com.neome.feature.form.domain.TypeUiFormPermission`, `TypeUiFormPermissionMap`, `TypeUiFormParentMap`, `TypeUiPermissionRole`, `TypeUiManagerialRelationship` — Permission and relationship types
- `com.neome.feature.form.presentation.state.FieldProperties`, `FieldDependencyMap` — State types consumed by presentation helpers

### Internal Package Relationships
- **FieldVal/** — Child package providing field value type conversion and default resolution (see `FieldVal/README.md`)
- **../ctx/helper/** — Consumer package using `FieldPropertyResolver`, `ConditionResolver`, `FormPlus` for helper execution
- **../ctx/helper/events/** — Event executor using `ConditionResolver` for action condition evaluation
- **../ctx/helper/schema/** — Schema utilities using `FieldVal.FieldValueResolver` for type conversion

## Related READMEs

- **Parent**: `../README.md` — Domain package overview
- **Child**: `FieldVal/README.md` — Field value type conversion and default resolution
- **Form Root**: `../../form.md` — Complete form feature documentation
- **Consumers**: 
  - `../ctx/helper/README.md` — Form helpers using util utilities
  - `../ctx/helper/events/README.md` — Event execution using condition resolution
  - `../ctx/helper/schema/README.md` — Schema helpers using field value resolution

## Implementation Notes

### Known Stubs (TODO)
- `CalcFormula.calc(formula, valueMap)` — Formula calculation engine not yet implemented
- `DatePlus.formatDate()` — Date formatting utilities not yet implemented
- `DatePlus.calcDefnBuildDate()` / `calcDefnBuildDateTime()` — Build-date resolution not yet implemented

### Partial Implementations
- `FilterForm.prepare()` has commented-out post-processing steps: `ensureParentVisibility()`, `trimPermissionMap()`
- `FieldPropertyResolver.resolveArgValue()` has ArgValueResolver delegation commented out; currently falls back to raw field join

### Framework Integration
- `ConditionResolver` imports `android.util.Log` — the only Android framework dependency in this domain-layer package (used for debug logging)
- Debug logging at tag `"ConditionResolver"` includes: condition name, field name (from component label, field name, or field ID fallback), operator, left/right values, and result for verification

### Design Principles
- All utilities are pure functions (no side effects, no mutable state)
- All resolution happens deterministically based on provided input (form definition, caller entity, field values)
- Permission resolution respects priority order: explicit write > writeOnce > writeOnInsert > read > invisible > hide
- Dependency mapping enables automatic cascade triggering when referenced fields change
- Condition resolution includes comprehensive debug logging for verification and troubleshooting
