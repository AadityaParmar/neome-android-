# Module-wise README Documentation System for Form Feature

## TL;DR

> **Quick Summary**: Create a co-located README.md documentation system for form feature packages so AI agents can understand module internals without parsing source code. Start with the `events` package as proof-of-concept, establish a reusable template, add enforcement rules, and track via memory.
>
> **Deliverables**:
> - README template (markdown) optimized for LLM consumption
> - `domain/ctx/helper/events/README.md` — first fully documented package
> - Knowledge graph entries tracking all form modules and README status
> - CLAUDE.md enforcement rule directing agents to read READMEs first
>
> **Estimated Effort**: Medium
> **Parallel Execution**: YES — 2 waves
> **Critical Path**: Task 1 (events README + template) → F1 + F2 (verification). Tasks 2 + 3 run in parallel with Task 1.

---

## Context

### Original Request
User wants module-wise README files in the form component so AI agents don't have to read and understand source code. Start with `com.neome.feature.form.domain.ctx.helper.events` package. Create a template structure, use memory skill for tracking, configure agent behavior to read READMEs first.

### Interview Summary
**Key Discussions**:
- **Format**: Markdown (.md) — LLMs parse natively, supports tables/code/diagrams
- **Placement**: Co-located inside each package directory (e.g., `events/README.md`)
- **Detail level**: Full internals — include private methods, internal flow, cascade logic
- **Agent behavior**: Read README first, dive into source only when making changes

**Research Findings**:
- Form feature: 112 Kotlin files across ~12 packages in domain + presentation layers
- Events package: 4 files, 618 LOC, stateless singletons with pure state transformation functions
- Existing precedent: `RAW_PICKER.md` (410 lines) — excellent LLM-oriented package doc
- Existing feature doc: `form.md` (936+ lines) — feature-level, covers cross-cutting flows
- Architecture: MVI + UDF + CompositionLocal, Clean Architecture layers

### Metis Review
**Identified Gaps** (addressed):
- **form.md duplication risk**: READMEs document internal mechanics; form.md stays as feature-level overview. No form.md modifications in this task.
- **opencode.json doesn't support agent directives**: Enforcement goes in CLAUDE.md instead
- **Template scaling**: Events (4 files) ≠ schema (40 files). Template must handle both via category grouping for large packages.
- **Memory skill overkill for 12 items**: Keep it lightweight — knowledge graph as a module registry, not heavy state machine.
- **RAW_PICKER.md naming conflict**: Standardize on `README.md` naming; existing `RAW_PICKER.md` stays untouched.
- **Cross-layer violation**: `FormEventProps` in presentation/state but used by domain/events — document reality, don't fix.
- **TODO stubs**: Mark as `[NOT IMPLEMENTED]` with one-line intent description.

---

## Work Objectives

### Core Objective
Establish a reusable README documentation system for form feature packages that enables AI agents to understand module internals from structured documentation rather than parsing source code.

### Concrete Deliverables
1. `app/src/main/java/com/neome/feature/form/domain/ctx/helper/events/README.md` — First package README
2. CLAUDE.md rule addition — "Read README.md before modifying package files" directive
3. Knowledge graph entries — Module registry with README tracking
4. README template section in events README itself (serves as template by example)

### Definition of Done
- [ ] `events/README.md` exists, covers all 4 files, matches template structure
- [ ] Every `.kt` file in events/ is referenced in the README
- [ ] Public API signatures in README match actual code
- [ ] CLAUDE.md contains README-first enforcement rule
- [ ] Knowledge graph has module registry with README status

### Must Have
- README follows RAW_PICKER.md precedent structure (proven pattern in this codebase)
- Full internals documented: private methods, internal flow, cascade depth logic
- "How to Make Changes" section for each README (most valuable for agents)
- File Map showing package structure and related external files
- Cross-references to form.md for feature-level context (not duplication)

### Must NOT Have (Guardrails)
- Do NOT modify form.md, field-maker.md, or RAW_PICKER.md
- Do NOT modify any .kt source files
- Do NOT fix code issues discovered during documentation (e.g., cross-layer imports)
- Do NOT create cursor rules or .mdc files for individual packages
- Do NOT create READMEs for packages other than events/ (template validation only)
- Do NOT use mermaid diagrams (ASCII art only, matching form.md precedent)
- Do NOT speculate on future behavior for TODO stubs — mark as `[NOT IMPLEMENTED]` only

---

## Verification Strategy (MANDATORY)

> **ZERO HUMAN INTERVENTION** — ALL verification is agent-executed. No exceptions.

### Test Decision
- **Infrastructure exists**: N/A (documentation task)
- **Automated tests**: None — structural verification via grep/count
- **Framework**: Bash commands for file-count cross-checks and signature verification

### QA Policy
Every task MUST include agent-executed QA scenarios.
Evidence saved to `.sisyphus/evidence/task-{N}-{scenario-slug}.{ext}`.

- **Documentation**: Use Bash (grep, wc, diff) — Cross-reference file counts, verify signatures
- **Configuration**: Use Bash (grep) — Verify CLAUDE.md contains directive
- **Memory**: Use knowledge graph queries — Verify entities exist

---

## Execution Strategy

### Parallel Execution Waves

```
Wave 1 (Start Immediately — template + content + enforcement):
├── Task 1: Design README template structure in events/README.md [deep]
├── Task 2: Add CLAUDE.md enforcement rule [quick]
└── Task 3: Create knowledge graph module registry [quick]

Wave FINAL (After ALL tasks — review):
├── Task F1: Plan compliance audit [deep]
└── Task F2: Scope fidelity check [deep]

Critical Path: Task 1 (contains the README content) → F1-F2
Parallel Speedup: Tasks 2+3 run alongside Task 1
Max Concurrent: 3 (Wave 1)
```

### Dependency Matrix

| Task | Depends On | Blocks |
|------|-----------|--------|
| 1 | None | F1, F2 |
| 2 | None | F1, F2 |
| 3 | None | F1, F2 |
| F1 | 1, 2, 3 | — |
| F2 | 1, 2, 3 | — |

### Agent Dispatch Summary

- **Wave 1**: **3 tasks** — T1 → `deep`, T2 → `quick`, T3 → `quick`
- **FINAL**: **2 tasks** — F1 → `deep`, F2 → `deep`

---

## TODOs

- [ ] 1. Create events/README.md — Full Package Documentation Using Template Structure

  **What to do**:
  - Create `app/src/main/java/com/neome/feature/form/domain/ctx/helper/events/README.md`
  - Follow the exact section structure modeled after `RAW_PICKER.md` (proven LLM-friendly format in this codebase)
  - This README serves dual purpose: (a) document the events package, (b) establish the template for all future package READMEs

  **README Template Structure** (follow this EXACTLY — it IS the template):

  ```markdown
  # {Package Name} — AI Context Document

  > For cross-cutting flows and feature-level context, see [form.md](relative/path/to/form.md)
  > Last verified: {YYYY-MM-DD}

  ## Overview
  [1-3 sentences: what this package does, its role in the form system]
  [List key files with one-line purpose each]

  ## Architecture Context
  [ASCII art showing where this package sits in the form system]
  [Caller → This Package → Dependencies relationship]

  ## File Map
  [Directory tree of this package + related external files table]
  [For each external file: path, purpose, why it's related]

  ## Data Structures
  [Key data classes/interfaces used or defined by this package]
  [Show Kotlin signatures with field-level comments]
  [Include cross-package types that are central to understanding]

  ## Public API
  [Every public function with full signature]
  [Group by file/class]
  [Include parameter descriptions and return type semantics]

  ## Internal Mechanics
  [Private methods and their roles]
  [Execution flow with numbered steps]
  [State transformation patterns]
  [Edge cases and guard conditions]

  ## Key Patterns & Invariants
  [Design patterns used (singleton, pure functions, etc.)]
  [Invariants that must be maintained (e.g., cascade depth)]
  [Performance considerations]
  [Known limitations and TODO stubs marked as [NOT IMPLEMENTED]]

  ## How to Make Changes
  [Specific modification recipes — the MOST valuable section for agents]
  [Each recipe: what to modify, which files, what to update, verification command]
  [Common tasks: adding new action types, adding new event kinds, etc.]

  ## Dependencies & Imports
  [Internal project imports grouped by layer]
  [External library imports]
  [Cross-layer imports noted with architectural context]

  ## Build & Verify
  [Compile command]
  [How to test changes to this package]
  ```

  **Events Package Content** (write using these researched facts):

  **Overview section**: 4 files implementing the declarative form event system — event categorization, conditional action execution, property override management, cascade-protected event processing. All files are stateless `object` singletons with pure functions (take `FormState`, return `FormState`).

  **Architecture Context section**:
  ```
  FormCtxInitHelper ──────────► FormCtxFormEvents.initEvents()
                                    │
  FormCtxEventHelper ─────────► FormCtxFormEvents.executeEvents()
  (onChange / onClickButton         │
   / onSubmitForm)                  ▼
                              FormCtxFormEvents.executeEventInternal()
                                    │
                                    ├─ ConditionResolver.resolve()
                                    ├─ FormCtxActionExecutor.executeAction()
                                    │       │
                                    │       ├─ field actions (setValue/clear/visible/hidden/...)
                                    │       ├─ component actions (section clear/visible/...)
                                    │       └─ sendButton actions (visible/disable/...)
                                    │
                                    ├─ FormCtxEventPropsHelper.updateFormEventProps()
                                    └─ FormCtxEventHelper.processFieldValueChanged() [cascade, depth+1]
                                            │
                                            └─ Back to executeEvents() if onChange events exist
  ```

  **File Map** (4 files):
  - `FormCtxFormEvents.kt` (163 lines) — Orchestrator: initEvents(), executeEvents(), executeEvent(), CategorizedEvents data class
  - `FormCtxActionExecutor.kt` (341 lines) — Action executor: 12 action types on field/component/sendButton targets
  - `FormCtxEventPropsHelper.kt` (55 lines) — Property override accumulator and merger
  - `FormCtxInitEvents.kt` (59 lines) — Event categorizer: sorts events by kind during form init

  Related external files table:
  | File | Purpose |
  |------|---------|
  | `domain/ctx/helper/FormCtxEventHelper.kt` | Primary caller — processes field value changes, triggers events |
  | `domain/ctx/helper/FormCtxInitHelper.kt` | Calls initEvents() during form initialization |
  | `domain/ctx/helper/FormCtxValidationHelper.kt` | Called by FormCtxEventHelper after events for validation |
  | `domain/util/ConditionResolver.kt` | Evaluates event conditions |
  | `domain/util/FieldVal/FieldValueResolver.kt` | Converts raw values to typed field values for setValue actions |
  | `presentation/state/FormState.kt` | Holds `categorizedEvents`, `formEventPropsMap`, `valueMap` |
  | `presentation/state/FieldState.kt` | Defines `FormEventProps` data class (cross-layer import) |

  **Data Structures section**: Document:
  - `CategorizedEvents` — (defined in FormCtxFormEvents.kt) — onChangeMap, onSubmitFormList, onClickButtonMap
  - `FormEventProps` — (defined in presentation/state/FieldState.kt) — hidden, invisible, disabled, highlight, blink, shake
  - `DefnEventAction` — (external type) — kind, actionOn, compIdSet, source, conditionId
  - `SendBtnStateFlag` — (defined in FormState.kt) — Invalid, Uploading, Processing, Validating, Invisible, Disabled, Custom

  **Public API section**: Document ALL public functions from all 4 files with full signatures (read from source):
  - FormCtxFormEvents: initEvents(), executeEvents(), executeEvent(), mergeEventPropsIntoFieldStates()
  - FormCtxActionExecutor: executeAction(), resolveSourceValue(), resolveAffectedFieldIds()
  - FormCtxEventPropsHelper: mergeEventPropsIntoFieldStates(), updateFormEventProps()
  - FormCtxInitEvents: initEvents()

  **Internal Mechanics section**: Document:
  - `executeEventInternal()` — cascade depth guard, condition checking flow, action binding iteration, value change detection
  - `executeActionOnField()` — 12 action type switch with setValue resolution, clear, visibility/disable/animation props
  - `executeActionOnComponent()` — section field expansion for clear, visibility/disable/animation props
  - `executeActionOnSendButton()` — flag-based state management
  - Event Props Lifecycle: created → accumulated → reset each cycle → merged after all events

  **Key Patterns & Invariants section**: Document:
  - MAX_CASCADE_DEPTH = 5 (prevents A→B→C→A infinite recursion)
  - formEventPropsMap reset at start of each executeEvents() call
  - All functions are pure: FormState in → FormState out, no side effects
  - Event props use OR merging: event overrides can only ADD restrictions (hidden/disabled), never remove definition-level flags
  - Action binding order preserved (iterates keys in definition order)
  - TODO stubs: `[NOT IMPLEMENTED]` — executeAction, executeFormula, click action kinds
  - Cross-layer note: FormEventProps lives in presentation/state/ but is consumed by this domain package

  **How to Make Changes section** — write recipes for:
  1. **Adding a new event action kind** (e.g., `focus`):
     - Add case to `Types.EnumDefnKindEventAction` (external — API types)
     - Add handling in `FormCtxActionExecutor.executeActionOnField()`
     - If it affects FormEventProps: add field to `FormEventProps` data class, update `FormCtxEventPropsHelper.mergeEventPropsIntoFieldStates()` merge logic
     - If it affects sendButton: add handling in `executeActionOnSendButton()`
     - Verify: `./gradlew :app:compileDebugKotlin`

  2. **Adding a new event kind** (e.g., `onFocus`):
     - Add case to `Types.EnumDefnKindFormEvent` (external — API types)
     - Add categorization in `FormCtxInitEvents.initEvents()` — create new map/list
     - Add field to `CategorizedEvents` data class
     - Add trigger point in `FormCtxEventHelper` for the new event kind
     - Verify: `./gradlew :app:compileDebugKotlin`

  3. **Modifying condition evaluation logic**:
     - Condition evaluation lives in `ConditionResolver.resolve()` (NOT in this package)
     - This package only calls it and checks `notCondition` inversion
     - To change condition behavior: modify `domain/util/ConditionResolver.kt`

  4. **Changing cascade depth limit**:
     - Edit `MAX_CASCADE_DEPTH` constant in `FormCtxFormEvents.kt` line 15
     - Consider: higher depth = more onChange chains allowed but risk of performance issues

  **Dependencies section**: Document imports grouped by:
  - Internal domain: `DefnFormUi`, `ConditionResolver`, `FieldValueResolver`, `FormCtxEventHelper`
  - Internal presentation (cross-layer): `FormState`, `FormEventProps`, `FieldState`, `SendBtnStateFlag`
  - External API types: `Types.MetaIdComp`, `Types.MetaIdFormEvent`, `Types.EnumDefnKindEventAction`, `DefnEventAction`, `FieldDtoArg`
  - Android/Kotlin: `android.util.Log`, `kotlinx.serialization.json.*`

  **Must NOT do**:
  - Do NOT copy text verbatim from form.md — write fresh from source code analysis
  - Do NOT include speculative "future plans" for TODO stubs
  - Do NOT create mermaid diagrams — use ASCII art only
  - Do NOT exceed ~500 lines — this is 4 files with clear patterns, aim for 300-400 lines
  - Do NOT document anything outside the events package (except related external file references)

  **Recommended Agent Profile**:
  - **Category**: `deep`
    - Reason: Requires deep understanding of source code to write accurate internal documentation. Must cross-reference 4 source files, verify signatures, and write precise modification recipes.
  - **Skills**: [`defn-form`]
    - `defn-form`: Provides complete form system context needed for accurate architecture descriptions and cross-references
  - **Skills Evaluated but Omitted**:
    - `frontend-ui-ux`: Not applicable — this is domain layer documentation, not UI
    - `writing`: This is technical documentation requiring code analysis, not prose writing

  **Parallelization**:
  - **Can Run In Parallel**: YES (with Tasks 2, 3)
  - **Parallel Group**: Wave 1 (with Tasks 2, 3)
  - **Blocks**: F1, F2
  - **Blocked By**: None (can start immediately)

  **References** (CRITICAL — executor has NO interview context):

  **Pattern References** (existing code to follow):
  - `presentation/components/raw/picker/RAW_PICKER.md` — **PRIMARY TEMPLATE**: Follow this exact section structure, tone, and detail level. This is the proven LLM-friendly format in this codebase. Read it fully before writing.

  **Source Files to Document** (read ALL of these completely):
  - `domain/ctx/helper/events/FormCtxFormEvents.kt` — 163 lines, orchestrator with CategorizedEvents
  - `domain/ctx/helper/events/FormCtxActionExecutor.kt` — 341 lines, action executor with 12 action types
  - `domain/ctx/helper/events/FormCtxEventPropsHelper.kt` — 55 lines, property override helper
  - `domain/ctx/helper/events/FormCtxInitEvents.kt` — 59 lines, event categorizer

  **Context Files** (read for cross-reference accuracy):
  - `domain/ctx/helper/FormCtxEventHelper.kt` — 515 lines, primary caller of events package
  - `presentation/state/FormState.kt` — 176 lines, holds categorizedEvents + formEventPropsMap
  - `presentation/state/FieldState.kt` — 115 lines, defines FormEventProps + FieldProperties

  **External References**:
  - None needed — all context is in the codebase

  **WHY Each Reference Matters**:
  - RAW_PICKER.md: Shows exact format, tone, section ordering that works for AI agents in this project
  - Source files: Must be read verbatim to extract accurate signatures, constants, patterns
  - FormCtxEventHelper.kt: Needed to write accurate "Architecture Context" showing caller relationships
  - FormState.kt/FieldState.kt: Needed to document data structures accurately

  **Acceptance Criteria**:

  **QA Scenarios (MANDATORY):**

  ```
  Scenario: README exists and covers all source files
    Tool: Bash
    Preconditions: Task 1 completed, README.md created
    Steps:
      1. ls app/src/main/java/com/neome/feature/form/domain/ctx/helper/events/README.md
      2. Count .kt file references: grep -c "\.kt" events/README.md
      3. Verify each file mentioned: grep "FormCtxFormEvents" events/README.md && grep "FormCtxActionExecutor" events/README.md && grep "FormCtxEventPropsHelper" events/README.md && grep "FormCtxInitEvents" events/README.md
    Expected Result: File exists, >= 4 .kt references, all 4 file names found
    Failure Indicators: File missing, < 4 references, any file name not found
    Evidence: .sisyphus/evidence/task-1-readme-coverage.txt

  Scenario: Public API signatures match source code
    Tool: Bash (ast_grep_search + grep)
    Preconditions: README.md created
    Steps:
      1. Extract "fun initEvents" signature from FormCtxFormEvents.kt
      2. Verify README contains matching signature
      3. Extract "fun executeAction" signature from FormCtxActionExecutor.kt
      4. Verify README contains matching signature
      5. Extract "fun mergeEventPropsIntoFieldStates" signature from FormCtxEventPropsHelper.kt
      6. Verify README contains matching signature
    Expected Result: All 3 signatures in README match source code parameter types and names
    Failure Indicators: Missing signature, wrong parameter types, missing parameters
    Evidence: .sisyphus/evidence/task-1-signature-accuracy.txt

  Scenario: README doesn't exceed size limit
    Tool: Bash
    Preconditions: README.md created
    Steps:
      1. wc -l events/README.md
    Expected Result: Line count <= 500
    Failure Indicators: Line count > 500
    Evidence: .sisyphus/evidence/task-1-size-check.txt

  Scenario: "How to Make Changes" section exists with actionable recipes
    Tool: Bash (grep)
    Preconditions: README.md created
    Steps:
      1. grep -c "How to Make Changes" events/README.md
      2. grep -c "gradlew" events/README.md (verify compile command present)
      3. grep "Adding a new event action" events/README.md
    Expected Result: Section exists, compile command present, at least one modification recipe
    Failure Indicators: Section missing, no compile command, no recipes
    Evidence: .sisyphus/evidence/task-1-modification-recipes.txt
  ```

  **Evidence to Capture:**
  - [ ] task-1-readme-coverage.txt — File reference count verification
  - [ ] task-1-signature-accuracy.txt — API signature cross-check
  - [ ] task-1-size-check.txt — Line count verification
  - [ ] task-1-modification-recipes.txt — How to Make Changes verification

  **Commit**: YES
  - Message: `docs(form): add README for domain/ctx/helper/events package`
  - Files: `app/src/main/java/com/neome/feature/form/domain/ctx/helper/events/README.md`
  - Pre-commit: `grep -c ".kt" app/src/main/java/com/neome/feature/form/domain/ctx/helper/events/README.md` (expect >= 4)

- [ ] 2. Add README-First Enforcement Rule to CLAUDE.md

  **What to do**:
  - Add a new section to `CLAUDE.md` (the project's root agent instructions file) that directs AI agents to check for and read package-level README.md files before modifying source code in that package
  - Place the rule in an appropriate location — after the "Architecture Rules" section and before "MVI Pattern Rules" (it's a general coding practice rule)
  - The rule should be concise but unambiguous

  **Exact content to add** (adapt formatting to match CLAUDE.md style):

  ```markdown
  ## Package README Convention

  Some packages contain a `README.md` file (AI Context Document) that documents the package's internals, public API, data structures, key patterns, and modification recipes.

  **Before modifying any file in a package that contains a README.md:**
  1. Read the package's `README.md` first to understand architecture, patterns, and invariants
  2. Follow the "How to Make Changes" recipes when they cover your modification type
  3. After making changes, verify the README is still accurate — update it if your changes affect documented APIs, patterns, or file maps

  **Current packages with READMEs:**
  - `feature/form/domain/ctx/helper/events/README.md` — Form event system
  - `feature/form/presentation/components/raw/picker/RAW_PICKER.md` — Raw picker components

  > This list will grow as more packages are documented. Check for `README.md` in any package you're about to modify.
  ```

  **Must NOT do**:
  - Do NOT restructure or rewrite existing CLAUDE.md content
  - Do NOT modify form.md, field-maker.md, or any other documentation file
  - Do NOT add cursor rules (.mdc files)
  - Do NOT modify opencode.json (it doesn't support agent directives)

  **Recommended Agent Profile**:
  - **Category**: `quick`
    - Reason: Single file edit, clear content to add, well-defined insertion point
  - **Skills**: []
  - **Skills Evaluated but Omitted**:
    - `defn-form`: Not needed — this is a CLAUDE.md config edit, not form code

  **Parallelization**:
  - **Can Run In Parallel**: YES (with Tasks 1, 3)
  - **Parallel Group**: Wave 1
  - **Blocks**: F1, F2
  - **Blocked By**: None

  **References**:

  **Pattern References**:
  - `CLAUDE.md` — Read current structure to find correct insertion point. Best location: after the "Package Structure" code block (which ends the Architecture Rules section) and before the `## MVI Pattern Rules` heading. This places it as a bridge between architecture conventions and pattern rules.
  - `presentation/components/raw/picker/RAW_PICKER.md` — Already exists as a package README, should be listed in the "Current packages" list

  **WHY Each Reference Matters**:
  - CLAUDE.md: Must read existing structure to insert new section in the right place without disrupting existing content
  - RAW_PICKER.md: Already an existing package-level doc — include in the "Current packages" list for completeness

  **Acceptance Criteria**:

  **QA Scenarios (MANDATORY):**

  ```
  Scenario: CLAUDE.md contains README enforcement rule
    Tool: Bash (grep)
    Preconditions: CLAUDE.md edited
    Steps:
      1. grep "Package README Convention" CLAUDE.md
      2. grep "README.md" CLAUDE.md | grep -i "before modifying"
      3. grep "events/README.md" CLAUDE.md
    Expected Result: Section heading found, enforcement directive present, events README listed
    Failure Indicators: Section missing, directive not found, events README not listed
    Evidence: .sisyphus/evidence/task-2-claude-md-rule.txt

  Scenario: Existing CLAUDE.md content unchanged
    Tool: Bash (git diff)
    Preconditions: CLAUDE.md edited
    Steps:
      1. git diff CLAUDE.md — verify only additions, no deletions of existing content
      2. Count deleted lines: git diff CLAUDE.md | grep "^-[^-]" | wc -l
    Expected Result: 0 deleted lines (pure addition)
    Failure Indicators: Any deleted lines indicate existing content was modified
    Evidence: .sisyphus/evidence/task-2-claude-md-no-deletions.txt
  ```

  **Evidence to Capture:**
  - [ ] task-2-claude-md-rule.txt — Rule presence verification
  - [ ] task-2-claude-md-no-deletions.txt — No existing content modified

  **Commit**: YES (group with Task 1 or separate)
  - Message: `docs: add README-first enforcement rule to CLAUDE.md`
  - Files: `CLAUDE.md`
  - Pre-commit: `grep "Package README Convention" CLAUDE.md`

- [ ] 3. Create Knowledge Graph Module Registry

  **What to do**:
  - Use the `memory` MCP tool to create knowledge graph entities that track:
    1. The form feature's module/package inventory (all ~12 packages)
    2. Which packages have READMEs (currently: events, raw/picker)
    3. The README template structure (for reference by future README-generation tasks)
  - This enables agents to query "does this package have a README?" at runtime

  **Entities to create**:

  Entity 1: `form-readme-system`
  - Type: `documentation-system`
  - Observations:
    - "Module-wise README documentation system for form feature packages"
    - "READMEs are co-located inside package directories as README.md"
    - "Format: Markdown optimized for LLM consumption"
    - "Template modeled after RAW_PICKER.md structure"
    - "Agent rule: read README.md before modifying package source files"
    - "CLAUDE.md contains enforcement directive under 'Package README Convention' section"

  Entity 2: `form-module-registry`
  - Type: `module-registry`
  - Observations (one per module with README status):
    - "domain/ctx/helper/events/ — README: YES (events/README.md)"
    - "presentation/components/raw/picker/ — README: YES (RAW_PICKER.md)"
    - "domain/ctx/helper/schema/ — README: PENDING (40 files, needs category grouping)"
    - "domain/ctx/helper/ — README: PENDING (4 files: ValidationHelper, InitHelper, EventHelper, ReducerResult)"
    - "domain/ctx/ — README: PENDING (3 files: FormCtx, FormCtxImpl, FormApiContext)"
    - "domain/util/ — README: PENDING (8+3 files: resolvers, utilities, FieldVal sub-package)"
    - "domain/ref/ — README: PENDING (2 files: FormRef, FormRefImpl)"
    - "presentation/state/ — README: PENDING (6 files: FormState, FieldState, FormEvent, FormIntent, FieldEvent, FieldError)"
    - "presentation/components/base/ — README: PENDING (3 files: FieldBase, FieldController, FieldFactory)"
    - "presentation/components/field/ — README: PENDING (29 files, needs category grouping)"
    - "presentation/components/composite/ — README: PENDING (2 files: FieldSection, FieldTab)"
    - "presentation/screen/ — README: PENDING (2 files: FormScreen, FormScreenViewModel)"

  Entity 3: `form-readme-template`
  - Type: `template`
  - Observations:
    - "Template sections in order: Overview, Architecture Context, File Map, Data Structures, Public API, Internal Mechanics, Key Patterns & Invariants, How to Make Changes, Dependencies & Imports, Build & Verify"
    - "Max size: ~500 lines per README"
    - "For packages with 10+ files: use category grouping instead of per-file docs"
    - "ASCII art for diagrams (no mermaid)"
    - "Cross-reference form.md for feature-level context, don't duplicate"
    - "Mark TODO stubs as [NOT IMPLEMENTED] with one-line intent"
    - "Primary precedent: RAW_PICKER.md (presentation/components/raw/picker/)"

  Relations:
  - `form-readme-system` → `uses_template` → `form-readme-template`
  - `form-readme-system` → `tracks_modules_in` → `form-module-registry`

  **Must NOT do**:
  - Do NOT create entities for non-form-feature modules
  - Do NOT duplicate README content in knowledge graph (just track status)
  - Do NOT create complex state machines — keep it simple

  **Recommended Agent Profile**:
  - **Category**: `quick`
    - Reason: Pure knowledge graph operations — create entities, set observations, create relations
  - **Skills**: []
  - **Skills Evaluated but Omitted**:
    - `defn-form`: Not needed — this is memory/knowledge graph work, not form code

  **Parallelization**:
  - **Can Run In Parallel**: YES (with Tasks 1, 2)
  - **Parallel Group**: Wave 1
  - **Blocks**: F1, F2
  - **Blocked By**: None

  **References**:

  **Pattern References**:
  - None needed — uses memory MCP tool directly

  **API References**:
  - `memory_create_entities` tool — Create entities with entityType and observations
  - `memory_create_relations` tool — Create relations between entities
  - `memory_search_nodes` tool — For verification after creation

  **WHY Each Reference Matters**:
  - memory tools: Direct API for creating the knowledge graph entries

  **Acceptance Criteria**:

  **QA Scenarios (MANDATORY):**

  ```
  Scenario: Knowledge graph entities exist
    Tool: memory MCP tools
    Preconditions: Task 3 completed
    Steps:
      1. memory_search_nodes(query="form readme") — should find form-readme-system
      2. memory_search_nodes(query="module registry") — should find form-module-registry
      3. memory_search_nodes(query="readme template") — should find form-readme-template
      4. memory_open_nodes(names=["form-module-registry"]) — should list all 12 modules with status
    Expected Result: 3 entities found, module registry has 12 module observations, 2 marked YES, 10 marked PENDING
    Failure Indicators: Missing entities, incomplete module list, wrong status
    Evidence: .sisyphus/evidence/task-3-knowledge-graph.txt

  Scenario: Relations exist between entities
    Tool: memory MCP tools
    Preconditions: Entities created
    Steps:
      1. memory_open_nodes(names=["form-readme-system"]) — check relations
    Expected Result: Has relations to form-readme-template and form-module-registry
    Failure Indicators: Missing relations
    Evidence: .sisyphus/evidence/task-3-relations.txt
  ```

  **Evidence to Capture:**
  - [ ] task-3-knowledge-graph.txt — Entity existence verification
  - [ ] task-3-relations.txt — Relation verification

  **Commit**: NO (knowledge graph is runtime state, not files)

---

## Final Verification Wave (MANDATORY — after ALL implementation tasks)

> 2 review agents run in PARALLEL. ALL must APPROVE. Rejection → fix → re-run.

- [ ] F1. **Plan Compliance Audit** — `deep`
  Read the plan end-to-end. For each "Must Have": verify implementation exists. For each "Must NOT Have": search for violations. Specifically verify:
  1. events/README.md exists and covers all 4 .kt files
  2. Every public API signature in README matches actual code (use ast_grep_search)
  3. CLAUDE.md contains the README-first rule
  4. No form.md/field-maker.md/RAW_PICKER.md files were modified (git diff)
  5. No .kt files were modified (git diff)
  Output: `Must Have [N/N] | Must NOT Have [N/N] | VERDICT: APPROVE/REJECT`

- [ ] F2. **Scope Fidelity Check** — `deep`
  Verify only intended files were created/modified:
  1. `git diff --name-only` should show ONLY: events/README.md, CLAUDE.md (and .sisyphus files)
  2. No other README.md files created outside events/
  3. events/README.md doesn't contradict form.md on shared topics (compare event system sections)
  4. README doesn't contain speculative content about TODO stubs
  Output: `Files [expected/actual] | Contradictions [CLEAN/N issues] | VERDICT`

---

## Commit Strategy

| Order | Message | Files | Pre-commit |
|-------|---------|-------|------------|
| 1 | `docs(form): add README for domain/ctx/helper/events package` | `events/README.md` | `grep -c ".kt" events/README.md` (must be >= 4) |
| 2 | `docs: add README-first enforcement rule to CLAUDE.md` | `CLAUDE.md` | `grep "README" CLAUDE.md` |

---

## Success Criteria

### Verification Commands
```bash
# events/README.md exists and references all 4 .kt files
ls app/src/main/java/com/neome/feature/form/domain/ctx/helper/events/README.md  # Expected: file exists
grep -c "\.kt" app/src/main/java/com/neome/feature/form/domain/ctx/helper/events/README.md  # Expected: >= 4

# CLAUDE.md has enforcement rule
grep -i "readme" CLAUDE.md  # Expected: matches found

# No source files modified
git diff --name-only -- '*.kt'  # Expected: empty (no .kt changes)

# Knowledge graph has entries
# Verify via memory_search_nodes query for "form module"
```

### Final Checklist
- [ ] events/README.md created with full template structure
- [ ] All 4 .kt files in events/ documented in README
- [ ] Public API signatures verified against source
- [ ] "How to Make Changes" section present and actionable
- [ ] CLAUDE.md enforcement rule added
- [ ] Knowledge graph module registry populated
- [ ] No form.md/field-maker.md/RAW_PICKER.md modifications
- [ ] No .kt file modifications
