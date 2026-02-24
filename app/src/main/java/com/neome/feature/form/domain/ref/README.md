# `domain/ref` — FormRef Package

External imperative API for parent screens to control embedded forms.

## Purpose

This package provides a **ref-based imperative API** that allows parent screens to interact with a `Form` component from outside the Compose hierarchy. Inspired by React Hook Form's ref pattern, it enables:

- **Read access** to form values and field states
- **Write access** to programmatically set values
- **Form operations** like submit and reset
- **State queries** for dirty/valid/touched status
- **Send button control** for disabling/hiding the submit action

This pattern is essential when a parent screen needs to:
- Pre-populate form fields from external data
- Programmatically trigger form submission
- Query form state to control sibling UI elements
- Coordinate multiple forms within a single screen

## Responsibilities

| File | Responsibility |
|------|----------------|
| `FormRef.kt` → `FormRef` | Public interface defining all operations available to parent screens |
| `FormRefImpl.kt` → `FormRefImpl` | Concrete implementation backed by state accessor and event dispatcher |

### Interface Operations

**Read Operations:**
- `FormRef.getValue(fieldId)` — Single field value lookup
- `FormRef.getValues()` — Complete form data as `FormValueRawData` for API submission
- `FormRef.getValueMap()` — Raw field ID → value map
- `FormRef.getFieldState(fieldId)` — Detailed field state including validation status

**Write Operations:**
- `FormRef.setValue(fieldId, value)` — Update single field (triggers validation)
- `FormRef.setValues(valueMap)` — Bulk update multiple fields (triggers validation)

**Form Operations:**
- `FormRef.submit()` — Validate and submit if valid
- `FormRef.reset(valueMap?)` — Reset to initial values or provided values

**State Queries:**
- `FormRef.isDirty(fieldId?)` — Check if field/form has unsaved changes
- `FormRef.isValid(fieldId?)` — Check if field/form passes validation
- `FormRef.isTouched(fieldId?)` — Check if user has interacted with field/form

**Send Button Control:**
- `FormRef.addSendBtnStateFlag(flag)` — Add a disable flag (cumulative)
- `FormRef.removeSendBtnStateFlag(flag)` — Remove a disable flag
- `FormRef.isSendBtnEnabled()` — Check if all flags are cleared
- `FormRef.isSendBtnInvisible()` — Check if send button should be hidden

## Flow

```
┌─────────────────────────────────────────────────────────────────────┐
│                         Parent Screen                                │
│                                                                      │
│  1. Obtains FormRef from FormCtx.createFormRef()                    │
│  2. Calls methods on FormRef:                                        │
│     • Read: getValue(), getValues(), getFieldState()                │
│     • Write: setValue(), setValues()                                │
│     • Query: isDirty(), isValid(), isTouched()                      │
│     • Action: submit(), reset()                                     │
│     • Button: addSendBtnStateFlag(), removeSendBtnStateFlag()       │
└───────────────────────────────┬─────────────────────────────────────┘
                                │
                                ▼
┌─────────────────────────────────────────────────────────────────────┐
│                          FormRefImpl                                 │
│                                                                      │
│  • Read ops: Invoke getFormState() → read FormState                 │
│  • Write ops: Invoke dispatchEvent(FormEvent) → ViewModel handles   │
└───────────────────────────────┬─────────────────────────────────────┘
                                │
          ┌─────────────────────┴─────────────────────┐
          ▼                                           ▼
   ┌─────────────┐                           ┌────────────────┐
   │  FormState  │                           │   FormEvent    │
   │  (snapshot) │                           │  (dispatched)  │
   └─────────────┘                           └───────┬────────┘
                                                    │
                                                    ▼
                                           ┌────────────────┐
                                           │ FormViewModel  │
                                           │  (processes    │
                                           │   FormEvent)   │
                                           └────────────────┘
```

**Call Flow:**

1. **Construction** — `FormRefImpl` is instantiated with two lambdas:
   - `getFormState: () → FormState` — Returns current form state snapshot
   - `dispatchEvent: (FormEvent) → Unit` — Dispatches events to the form reducer

2. **Read operations** — Methods like `getValue`, `getValues`, `getFieldState` invoke `getFormState()` and return data from the resulting `FormState` snapshot.

3. **Write operations** — `setValue` dispatches `FormEvent.FieldValueChanged`; `setValues` dispatches `FormEvent.SetValues`. The form reducer processes these synchronously.

4. **Form operations** — `submit` dispatches `FormEvent.Submit` (triggers validation then submission). `reset` dispatches `FormEvent.Reset` with optional new values.

5. **State queries** — `isDirty`, `isValid`, `isTouched` read directly from `FormState` and `FieldState` properties.

6. **Send button** — `addSendBtnStateFlag`/`removeSendBtnStateFlag` dispatch events to toggle flags. `isSendBtnEnabled`/`isSendBtnInvisible` read from state.

**Key Design Decisions:**

1. **Synchronous API** — All operations return immediately; state is read synchronously
2. **Event-based writes** — Mutations dispatch `FormEvent` for the ViewModel to process
3. **Stateless implementation** — `FormRefImpl` holds no state; it's a thin facade over lambdas

## Key Entry Points

| Entry Point | Description |
|-------------|-------------|
| `FormRef` interface (`FormRef.kt`) | Public contract for all form operations — the type parent screens interact with |
| `FormRefImpl` class (`FormRefImpl.kt`) | Concrete implementation — created by `FormCtxImpl.createFormRef()` |
| `FormCtxImpl.createFormRef()` | Factory method that binds `FormRefImpl` to the active form's state and event dispatcher |

**Usage Pattern:**

Parent screens obtain a `FormRef` instance from `FormCtx` (via `LocalFormCtx` composition local or direct injection). The `FormRef` provides immediate, synchronous access to form state and event dispatch.

## Dependencies & Relationships

### Internal Dependencies

| Dependency | Source | Purpose |
|------------|--------|---------|
| `FormState` | `presentation.state.FormState` | Snapshot of form values, field states, validation status, send button flags |
| `FormEvent` | `presentation.state.FormEvent` | Sealed interface for form mutations (value changes, submit, reset, flag changes) |
| `FieldState` | `presentation.state.FieldState` | Individual field state (value, touched, dirty, error, properties) |
| `SendBtnStateFlag` | `presentation.state.SendBtnStateFlag` | Enum of flags that can disable/hide the send button |
| `MetaIdComp` | `api.meta.base.Types.MetaIdComp` | Field identifier type from API layer |
| `FormValueRawData` | `core.common.serializer...FormValueRawData` | DTO for complete form data ready for API submission |
| `JsonElement` | `kotlinx.serialization.json.JsonElement` | Serialized field value representation |

### Package Relationships

```
domain/
├── ref/                    ← This package (imperative API)
│   ├── FormRef             ← Interface
│   └── FormRefImpl         ← Implementation
├── ctx/                    ← Creates FormRef instances
│   └── FormCtxImpl.createFormRef()
└── README.md               ← Parent README
```

### Layer Compliance

This package is part of the **domain layer** but bridges to presentation:
- Domain types: `FormRef` interface, `FormRefImpl` implementation
- Presentation types used: `FormState`, `FormEvent`, `FieldState`, `SendBtnStateFlag`

This bridging is acceptable because `FormRef` is a domain-level abstraction that happens to operate on presentation state. The domain layer defines the API contract; presentation provides the concrete state types.

## Related READMEs

- **Parent:** [`domain/README.md`](../README.md) — Form domain layer overview
- **Sibling:** [`domain/ctx/README.md`](../ctx/README.md) — FormCtx that creates FormRef instances
- **State definitions:** [`presentation/state/README.md`](../../presentation/state/README.md) — FormState, FormEvent, FieldState definitions
