# Form feature — Init-README plan (gradual execution)

This plan drives **readme-driven documentation** for each package under `com.neome.feature.form`. Execute one checklist item at a time (or in small batches) using the **init-readme** workflow.

---

## Init-README protocol (reference)

Use this workflow for each unchecked item:

1. **Target** — If missing, ask once for the package/class/module to document.
2. **Understand** — Invoke readme-driven-code-understanding for the target.
3. **Map** — Spawn one general subagent to map behavior/flow and key entry points from minimal required files.
4. **Existing README** — If `README.md` exists in the target path, **update** it against latest code (do not skip).
5. **Create or update** the nearest relevant `README.md` with this **exact structure**:
   - **Purpose**
   - **Responsibilities**
   - **Flow**
   - **Key entry points** (file paths + class/function/method names)
   - **Dependencies/relationships**
   - **Related READMEs** (parent/child/peer pointers)
   - **Change notes**
6. **Parent/child** — Parent README points to child README for child internals; do not duplicate.
7. **Interdependency** — Add concise path-based pointers to related `README.md` files.
8. **Concise** — Behavior-focused; no code snippets; reference paths/symbol names only.
9. **Consistency** — Same section order and style across all directories.
10. **Verify** — README statements must match latest code behavior, entry points, and relationships.

**Output per run:** Files created/updated · What was documented · Alignment verification summary · Gaps/assumptions (if any).

---

## Execution order

Execute in this order so that **child READMEs exist before parent READMEs** (parents can then link to children).

- **Phase 1 — Domain leaves:** schema → events (update if needed) → FieldVal → ref
- **Phase 2 — Domain mid:** helper (ctx/helper) → util → ctx → domain root
- **Phase 3 — Presentation leaves:** state → base → composite → field → raw/picker
- **Phase 4 — Presentation mid:** components → screen → sample
- **Phase 5 — Root:** form feature root README

---

## Checklist

Mark `[x]` when the README for that scope is created/updated and verified.

### Phase 1 — Domain leaves

| Done | Scope (package / path) | README path | Notes |
|------|------------------------|-------------|--------|
| [x] | `domain.ctx.helper.schema` | `domain/ctx/helper/schema/README.md` | CompSchema, CompSchemaFactory, all Field*Schema; 40 files. Group by category in Key entry points. |
| [x] | `domain.ctx.helper.events` | `domain/ctx/helper/events/README.md` | **Exists.** Run init-readme to **update** against latest code when executing this plan. |
| [x] | `domain.util.FieldVal` | `domain/util/FieldVal/README.md` | FieldValueResolver, Converter, DefaultValue (value types, defaults, MutableFormValue). |
| [x] | `domain.ref` | `domain/ref/README.md` | FormRef, FormRefImpl; external API for parents. |

### Phase 2 — Domain mid

| Done | Scope (package / path) | README path | Notes |
|------|------------------------|-------------|--------|
| [x] | `domain.ctx.helper` | `domain/ctx/helper/README.md` | FormReducerResult, FormCtxInitHelper, FormCtxEventHelper, FormCtxValidationHelper. Point to `events/README.md`, `schema/README.md`. |
| [x] | `domain.util` | `domain/util/README.md` | FieldPropertyResolver, FilterForm, FormPlus, ConditionResolver, CalcFormula, ArgValueResolver, TypeArgValueResolver, DatePlus. Point to `FieldVal/README.md`. |
| [x] | `domain.ctx` | `domain/ctx/README.md` | FormCtx, FormCtxImpl, FormApiContext. Point to `helper/README.md`. |
| [x] | `domain` | `domain/README.md` | TypesForm only (DefnFormUi, permission types). Point to `ctx/`, `ref/`, `util/`. |

### Phase 3 — Presentation leaves

| Done | Scope (package / path) | README path | Notes |
|------|------------------------|-------------|--------|
| [x] | `presentation.state` | `presentation/state/README.md` | FormState, FieldState, FormEvent, FormIntent, FieldEvent, FieldError. |
| [x] | `presentation.components.base` | `presentation/components/base/README.md` | FieldFactory, FieldController, FieldBase. |
| [x] | `presentation.components.composite` | `presentation/components/composite/README.md` | FieldSection, FieldTab. |
| [x] | `presentation.components.field` | `presentation/components/field/README.md` | All Field* components, MuiIconMapper, RawCounter, RawCaptureExtraProperties, ImagePreviewDialog, SignatureDrawDialog. Group by type (text, number, date, pick, media, etc.). |
| [x] | `presentation.components.raw.picker` | `presentation/components/raw/picker/README.md` | RawPickerSingleSelect, RawPickerMultiSelect. Consider pointing to existing `RAW_PICKER.md` if kept. |

### Phase 4 — Presentation mid

| Done | Scope (package / path) | README path | Notes |
|------|------------------------|-------------|--------|
| [x] | `presentation.components` | `presentation/components/README.md` | Form.kt, Utils.kt. Point to `base/`, `composite/`, `field/`, `raw/picker/` READMEs. |
| [x] | `presentation.screen` | `presentation/screen/README.md` | FormScreen, FormScreenViewModel. |
| [x] | `presentation.sample` | `presentation/sample/README.md` | FormSampleDataFactory. |
| [x] | `presentation` | `presentation/README.md` | Thin parent: state, components, screen, sample. Point to each child README. |

### Phase 5 — Root

| Done | Scope (package / path) | README path | Notes |
|------|------------------------|-------------|--------|
| [x] | Form feature root | `README.md` (next to form.md) | Purpose: form feature overview and doc index. Point to form.md, MODULES.md, domain/README.md, presentation/README.md. No duplication of form.md; keep as entry point + pointers. |

---

## Optional: single-class or small-module READMEs

If you later want READMEs for a **single class** or a **tiny group** (e.g. one file), add a row here and use the same protocol. Prefer one README per **package/directory** for consistency.

| Done | Scope | README path | Notes |
|------|--------|-------------|--------|
| (none yet) | — | — | Add rows as needed. |

---

## Summary

- **Total package-level READMEs:** 17 (1 already exists — events; 16 to create or confirm).
- **Template:** Use `domain/ctx/helper/events/README.md` as structure reference.
- **Cross-links:** Each README lists Related READMEs (parent, children, siblings, form.md, MODULES.md).
- **Verification:** After each run, confirm entry points and dependencies match current code.

Update this plan when you complete an item (mark `[x]`) or add optional rows.
