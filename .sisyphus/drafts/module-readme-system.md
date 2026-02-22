# Draft: Module-wise README Documentation System

## Requirements (confirmed)
- Create README files per module/package in the form feature
- Primary consumers: AI agents/LLMs (not humans)
- Should eliminate need for agents to read and understand source code
- Start with `domain.ctx.helper.events` package as first README
- Create a reusable template structure
- Use memory skill to track README locations and status
- Configure opencode.json so agents try README first before reading code

## Research Findings

### Form Feature Structure
- **112 Kotlin files** across domain + presentation layers
- **Key domain modules**: ctx (FormCtx), ctx/helper/events, ctx/helper/schema (40 files), util (resolvers), ref
- **Key presentation modules**: state, components/field (29 files), components/base, screen
- Existing docs: `form.md` (main), `field-maker.md`, `RAW_PICKER.md`

### Events Package Analysis (4 files, ~618 LOC)
- `FormCtxFormEvents.kt` - Orchestrator: initEvents(), executeEvents(), executeEvent()
- `FormCtxActionExecutor.kt` - Action executor: setValue, clear, visibility, disable, animations
- `FormCtxEventPropsHelper.kt` - Property override management and merging
- `FormCtxInitEvents.kt` - Event categorization by type during init

### Identified Modules Needing READMEs
1. `domain/ctx/helper/events/` - Event system (4 files)
2. `domain/ctx/helper/schema/` - Schema/validation system (40 files)
3. `domain/ctx/helper/` - Core helpers: validation, init, event handling (4 files)
4. `domain/ctx/` - FormCtx interface & implementation (3 files)
5. `domain/util/` - Resolvers: ArgValue, FieldValue, Condition, FieldProperty (8 files)
6. `domain/util/FieldVal/` - Value resolution sub-module (3 files)
7. `domain/ref/` - FormRef system (2 files)
8. `presentation/state/` - State management (6 files)
9. `presentation/components/base/` - Base field components (3 files)
10. `presentation/components/field/` - All field UI components (29 files)
11. `presentation/components/composite/` - Section/Tab (2 files)
12. `presentation/screen/` - FormScreen + ViewModel (2 files)

## Technical Decisions
- **Format**: Markdown (.md) — LLMs parse natively, supports tables/code/diagrams
- **Template structure**: Designed based on events package analysis (see plan)
- **README placement**: Inside each package directory (co-located with code)
- **Detail level**: Full internals — include private methods, internal flow, cascade logic
- **Agent behavior**: Read README first, dive into source only when making changes
- **Memory skill**: Track module → README path mapping + generation status

## Open Questions (ALL RESOLVED)
- ~~Format~~ → Markdown
- ~~Placement~~ → Co-located in package dir
- ~~Detail level~~ → Full internals
- ~~Agent behavior~~ → README first, code if needed

## Scope Boundaries
- INCLUDE: All form feature modules (domain + presentation)
- INCLUDE: Template creation, memory skill, opencode.json config
- EXCLUDE: Modules outside form feature (for now)
- EXCLUDE: Human-oriented documentation (form.md already exists)
