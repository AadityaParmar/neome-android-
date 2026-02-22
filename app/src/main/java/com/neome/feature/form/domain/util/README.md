# util — Form Definition Resolution and Transformation Utilities

## Purpose

Provides all pure-function utilities the form engine uses to resolve, transform, and prepare form definitions before and during runtime. This includes field property resolution, condition evaluation, arg value resolution, permission-based form filtering, form tree traversal, and date/formula stubs. All utilities are Kotlin `object` singletons with no mutable state.

## Responsibilities

- Resolve dynamic field properties from definitions using a 3-tier priority system (direct value → variable → field reference)
- Build inter-field dependency maps from `*FieldId` references across all components
- Evaluate AND/OR condition trees with typed operators (hasValue, equalTo, greaterThan, contains, etc.)
- Parse and resolve arg value strings by kind (context binder, derived, variable, field reference)
- Transform `DefnFormData` into `DefnFormUi` by computing role-based permissions, parent maps, managerial relationships, and caller-specific property injection
- Traverse form definition trees recursively (tabs → sections → fields → grids)
- Provide date/time formatting and formula calculation stubs

## Flow

1. **Form preparation** — `FilterForm.prepareUiForm` is the entry point for transforming a raw `DefnFormData` into a `DefnFormUi`. It calls `prepare` which walks the component tree via `FormPlus.loopDefnForm`, resolves role-based permissions per component (with parent inheritance), builds parent maps, injects caller properties (timezone, handle, dateFormat, autoPickSelf), and populates managerial relationships. Then it delegates to `ArgValueResolver.resolveDefnForm` to resolve all arg values in the form definition.
2. **Arg resolution** — `ArgValueResolver.resolveDefnForm` iterates the compMap, resolving each component's text/paragraph arg strings. `resolveArgStr` parses JSON-encoded `StudioDtoArgValueForClient` and dispatches by kind: `context` → caller attributes/ent/callerSetting, `derived` → field value lookup, `variable` → date/dateTime/time/sequence resolution, `field` → direct field value. `resolveArgForFieldVal` resolves args during default value initialization.
3. **Property resolution** — `FieldPropertyResolver.resolveFieldProperties` resolves 30+ properties per component. For each property, it checks direct value first, then `*Var` variable, then `*FieldId` reference (reads another field's current value). Returns an immutable `FieldProperties`. `buildDependencyMap` scans all components' `*FieldId` references via `extractFieldIdReferences` to build the `FieldDependencyMap` used for cascade triggering.
4. **Condition evaluation** — `ConditionResolver.resolve` evaluates a `DefnEventConditionMap` (AND/OR tree of conditions). Each condition compares a field's value against expected values using operators like `hasValue`, `equalTo`, `greaterThan`, `contains`, etc. Handles date/time comparisons, set-type fields, and context binder caller resolution. Logs each leaf condition and each AND/OR group at debug level (tag `ConditionResolver`) with condition name, field name (from comp label/name or field id fallback), operator, lhs/rhs values, and result for verification.
5. **Tree traversal** — `FormPlus.loopDefnForm` recursively walks from the root `displayCompositeId` through tabs, sections, wizards, grids, and formLists, invoking a callback for each component with its parent. Used by `FilterForm`, `FieldValueResolver.fnEnsureInit`, and others.

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
| `CalcFormula.kt` | `CalcFormula.calc` | Formula calculation stub (empty body) |
| `DatePlus.kt` | `DatePlus.formatDate` | Date formatting stub (returns input as-is) |
| `DatePlus.kt` | `DatePlus.calcDefnBuildDate` / `calcDefnBuildDateTime` | Build-date resolution stubs (returns value or customValue) |
| `TypeArgValueResolver.kt` | `TypeCustomValueDate` / `TypeCustomValueTime` / `TypeCustomValueDateTime` / `TypeCustomValueSeq` | Serializable data classes for typed arg custom values |
| `TypeArgValueResolver.kt` | `StudioDtoArgValueForClient` | Client-side polymorphic arg value wrapper with `kind` discriminator |

## Dependencies

- `com.neome.api.meta.base.Types` — `MetaIdComp`, `MetaIdField`, `MetaIdRole`, `EnumDefnCompType`, `EnumDefnArgBinder`, `EnumDefnArgBinderContext`, `EnumDefnEventOperator`, `EnumDefnPermission`, `EnumDefnRoles`, `EnumDefnFields`
- `com.neome.api.meta.base.dto.*` — `DefnComp`, `DefnForm`, `DefnField*`, `DefnEventCondition`, `DefnEventConditionMap`, `DefnDtoPermissionMatrix`, `FieldDtoArg`, `FormValue`
- `com.neome.api.ent.entDrawer.sig.SigEntCaller` — Caller entity (roles, handle, timezone, managers, etc.)
- `com.neome.core.common.serializer.api.meta.base.dto.*` — `DefnFormData`, `DefnCompSeal`, `FormValueData`, all `FieldValue*Data` DTOs, `StudioDtoArgValue*Data` classes
- `com.neome.feature.form.domain.DefnFormUi` — UI-ready form definition (output of `FilterForm`)
- `com.neome.feature.form.domain.TypeUiFormPermission`, `TypeUiFormPermissionMap`, `TypeUiFormParentMap`, `TypeUiPermissionRole`, `TypeUiManagerialRelationship` — Permission/relationship types defined in `TypesForm.kt`
- `com.neome.feature.form.presentation.state.FieldProperties`, `FieldDependencyMap` — State types consumed by helpers
- `com.neome.feature.utils.JsonParser` — kotlinx.serialization JSON instance

## Related READMEs

- **Child**: `FieldVal/README.md` (field value type conversion and default resolution)
- **Parent**: `../README.md` (domain package root)
- **Consumer**: `../ctx/helper/README.md` (helper package — uses FieldPropertyResolver, ConditionResolver)
- **Consumer**: `../ctx/helper/events/README.md` (event executor — uses ConditionResolver for action conditions)
- **Consumer**: `../ctx/helper/schema/README.md` (schemas — uses FieldValueResolver from FieldVal)
- **Form root**: `../../form.md` (full form feature documentation)

## Change Notes

- Initial documentation created from source analysis (2026-02-22)
- 8 source files + 1 child package (FieldVal/)
- `CalcFormula.calc` and `DatePlus` methods are stubs (TODO bodies)
- `FilterForm.prepare` has post-processing steps commented out (`ensureParentVisibility`, `trimPermissionMap`)
- `FieldPropertyResolver.resolveArgValue` has ArgValueResolver delegation commented out; falls back to raw join
- `ConditionResolver` imports `android.util.Log` — only Android framework dependency in domain/util
- ConditionResolver: debug logging added for each condition (condition name, field name, operator, lhs/rhs values, result) and for AND/OR groups (condition name, clause count, result) to allow verification of which condition resolved to what.
