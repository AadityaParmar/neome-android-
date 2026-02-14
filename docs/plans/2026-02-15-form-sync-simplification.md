# Form Component Sync Simplification Plan

> **For Claude:** REQUIRED SUB-SKILL: Use superpowers:executing-plans to implement this plan task-by-task.

**Goal:** Remove coroutines, queues, and async machinery from the form component. Make all state mutations synchronous via a single `dispatch(FormEvent)` entry point. Replace Flow-based observation with Compose `State<FormState>`. Eliminate `FormAction` (merge into `FormEvent`). Design for future threading where callers choose their own dispatcher.

**Architecture:**
The current architecture has two event entry points: `dispatch(event)` (sync, used by UI) and `enqueue(action)` (async, launches coroutine on `Dispatchers.Default`, converts `FormAction` → `FormEvent`, then calls `dispatch`). Since `MutableStateFlow.update{}` is already thread-safe, the coroutine/queue layer is unnecessary overhead. The new design: single `dispatch(FormEvent)` function, `FormCtx` exposes `State<FormState>` (Compose state), field components use `derivedStateOf` for per-field granularity. `FormAction` is eliminated — `FormEvent` becomes the unified API. `awaitIdle()` is removed. `FormCtxStateHelper` is deleted.

**Tech Stack:** Kotlin, Jetpack Compose, MutableState (Compose runtime)

---

## Summary of Changes

| Component | Current | New |
|---|---|---|
| `FormCtxImpl` | `CoroutineScope`, `Mutex`, `activeJobs`, `enqueue()`, `Dispatchers.Default` | No coroutines. Single `dispatch(FormEvent)` method |
| `FormCtx` interface | `watchFieldState/Value/Error()`, `watchFormState()`, `awaitIdle()` | `val formState: State<FormState>` + sync getters |
| `FormAction.kt` | Separate sealed interface, 1:1 mirror of `FormEvent` | **Deleted**. `FormEvent` is the unified API |
| `FormEvent.kt` | Internal events only | Unified API (absorbs `FormAction` cases) |
| `FormRef` / `FormRefImpl` | `enqueueAction`, `awaitIdle()`, `watchFieldState()`, `watchFormState()` | `dispatch(FormEvent)` directly, remove `awaitIdle`, remove watch methods |
| `FormCtxStateHelper` | Creates derived `StateFlow`s via `stateIn` | **Deleted** |
| `FieldController.kt` | `StateFlow<T?>`, `StateFlow<FieldUiState>`, `CoroutineScope(Dispatchers.Default)` | Compose `State<T?>`, `State<FieldUiState>`, uses `derivedStateOf` |
| `Form.kt` | `rememberCoroutineScope()`, `collectAsState()` | No coroutine scope needed. Direct `formCtx.formState` access |
| `FieldTab.kt` | `formCtx.watchFormState().collectAsState()` | `formCtx.formState` directly |
| All field components | `collectAsStateWithLifecycle()` on StateFlows | `derivedStateOf` on Compose State |

## Files Impacted

### Core (must change):
1. `domain/ctx/FormCtxImpl.kt` — Remove coroutines, simplify to sync dispatch
2. `domain/ctx/FormCtx.kt` — Replace watch methods with `formState: State<FormState>`
3. `presentation/state/FormAction.kt` — **DELETE** entire file
4. `presentation/state/FormEvent.kt` — Add `SetValue` (single field) from FormAction
5. `domain/ref/FormRefImpl.kt` — Use dispatch directly, remove enqueue/awaitIdle
6. `domain/ref/FormRef.kt` — Remove `awaitIdle()`, `watchFieldState()`, `watchFormState()`
7. `domain/ctx/helper/FormCtxStateHelper.kt` — **DELETE** entire file
8. `presentation/components/base/FieldController.kt` — Replace StateFlow with derivedStateOf
9. `presentation/components/Form.kt` — Remove coroutineScope, simplify

### Field components (pattern change in each):
10. `field/FieldText.kt`
11. `field/FieldNumber.kt`
12. `field/FieldDecimal.kt`
13. `field/FieldEmail.kt`
14. `field/FIeldParagraph.kt`
15. `field/FieldDate.kt`
16. `field/FieldDateTime.kt`
17. `field/FieldDateRange.kt`
18. `field/FieldDateTimeRange.kt`
19. `field/FieldTime.kt`
20. `field/FieldHandle.kt`
21. `field/FieldHyperlink.kt`
22. `field/FieldMobileNumber.kt`
23. `field/FieldImage.kt`
24. `field/FieldDocument.kt`
25. `field/FieldSwitch.kt`
26. `field/FieldCounter.kt`
27. `field/FieldLogCounter.kt`

### Composite components:
28. `composite/FieldTab.kt`

### Documentation:
29. `form.md` — Update architecture docs
30. `.opencode/skills/defn-form/SKILL.md` — Update skill reference

---

## Task 1: Merge FormAction into FormEvent

**Files:**
- Modify: `presentation/state/FormEvent.kt`
- Delete: `presentation/state/FormAction.kt`

**Step 1: Add missing event types to FormEvent**

`FormAction` has one case not in `FormEvent`: `SetValue` (single field, which maps to `FieldValueChanged`). `FormAction.SetValue` maps to `FormEvent.FieldValueChanged` already, so no new event type is needed. The `toFormEvent()` mapping shows every `FormAction` maps to an existing `FormEvent`. We just need to delete `FormAction.kt` and update all callers.

Edit `FormEvent.kt` — no changes needed to the sealed interface itself. Remove the `UiEvent` superinterface import if `UiEvent` is only used here via `FormAction`.

```kotlin
// FormEvent.kt — verify no changes needed (FormAction was a 1:1 mirror)
// The existing FormEvent already covers all cases.
// Just remove: import com.neome.core.mvi.UiEvent (if unused after FormAction deletion)
```

**Step 2: Delete FormAction.kt**

```bash
git rm app/src/main/java/com/neome/feature/form/presentation/state/FormAction.kt
```

**Step 3: Commit**

```bash
git add -A && git commit -m "refactor(form): delete FormAction, FormEvent is the unified API"
```

---

## Task 2: Simplify FormCtx Interface

**Files:**
- Modify: `domain/ctx/FormCtx.kt`

**Step 1: Replace watch methods and awaitIdle with formState**

Remove:
- `watchFieldState(fieldId)` 
- `watchFieldValue(fieldId)`
- `watchFieldError(fieldId)`
- `watchFormState()`
- `suspend fun awaitIdle()`

Add:
- `val formState: State<FormState>` (Compose State)

Keep all sync getters (`getValue`, `getFieldState`, `getError`, `hasField`, `getDefnForm`, `getValues`).
Keep mutation methods (`trigger`, `validate`, `setError`, `clearError`, `addSendBtnDisableFlag`, `removeSendBtnDisableFlag`).

```kotlin
package com.neome.feature.form.domain.ctx

import androidx.compose.runtime.State
import androidx.compose.runtime.staticCompositionLocalOf
import com.neome.api.meta.base.Types.MetaIdComp
import com.neome.core.common.serializer.api.meta.base.dto.DefnFormData
import com.neome.feature.form.presentation.state.FieldError
import com.neome.feature.form.presentation.state.FieldState
import com.neome.feature.form.presentation.state.FormState
import com.neome.feature.form.presentation.state.SendBtnDisableFlag
import kotlinx.serialization.json.JsonElement

/**
 * Internal form context for field components.
 * Provides access to form operations without exposing full FormRef.
 *
 * This is passed to all field renderers via CompositionLocal so they can:
 * - Access form state reactively via [formState]
 * - Access other field values (for dependent calculations)
 * - Trigger recalculation of field properties
 * - Query field states
 * - Validate fields
 *
 * All mutations are synchronous via dispatch. For future threading,
 * callers wrap dispatch calls in their own dispatcher.
 */
interface FormCtx {

    // ==================== Reactive State ====================

    /**
     * Compose State holding the current FormState.
     * Reading this in a composable automatically triggers recomposition on change.
     * Use derivedStateOf for per-field granularity.
     */
    val formState: State<FormState>

    // ==================== Read Operations ====================

    fun trigger(fieldId: MetaIdComp)
    fun getValues(): Map<MetaIdComp, JsonElement>
    fun getFieldState(fieldId: MetaIdComp): FieldState?
    fun getValue(fieldId: MetaIdComp): JsonElement?
    fun getError(fieldId: MetaIdComp): FieldError?
    fun hasField(fieldId: MetaIdComp): Boolean
    fun getDefnForm(): DefnFormData?

    // ==================== Validation ====================

    fun validate(fieldId: MetaIdComp? = null)
    fun setError(fieldId: MetaIdComp, error: String)
    fun clearError(fieldId: MetaIdComp)

    // ==================== Send Button Control ====================

    fun addSendBtnDisableFlag(flag: SendBtnDisableFlag)
    fun removeSendBtnDisableFlag(flag: SendBtnDisableFlag)
}

val LocalFormCtx = staticCompositionLocalOf<FormCtx> {
    error("FormCtx not provided. Ensure Form composable is in the composition tree.")
}
```

**Step 2: Commit**

```bash
git add -A && git commit -m "refactor(form): simplify FormCtx - replace watch/awaitIdle with formState: State<FormState>"
```

---

## Task 3: Simplify FormCtxImpl — Remove Coroutines

**Files:**
- Modify: `domain/ctx/FormCtxImpl.kt`
- Delete: `domain/ctx/helper/FormCtxStateHelper.kt`

**Step 1: Rewrite FormCtxImpl**

Remove: `CoroutineScope`, `Dispatchers.Default`, `Mutex`, `activeJobs`, `Job`, `enqueue()`, `awaitIdle()`, all `ConcurrentHashMap` field flows, `FormCtxStateHelper` usage.

Replace `MutableStateFlow` with `mutableStateOf` (Compose runtime).

All methods that previously called `enqueue(FormAction.X)` now call `dispatch(FormEvent.X)` directly.

```kotlin
package com.neome.feature.form.domain.ctx

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import com.neome.api.meta.base.Types.MetaIdComp
import com.neome.core.common.serializer.api.meta.base.dto.DefnFormData
import com.neome.core.common.serializer.api.meta.base.dto.FormValueRawData
import com.neome.feature.form.domain.ctx.helper.FormCtxEventHelper
import com.neome.feature.form.domain.ctx.helper.FormCtxInitHelper
import com.neome.feature.form.domain.ctx.helper.FormCtxValidationHelper
import com.neome.feature.form.domain.ctx.helper.FormReducerResult
import com.neome.feature.form.domain.ref.FormRef
import com.neome.feature.form.domain.ref.FormRefImpl
import com.neome.feature.form.presentation.state.FieldError
import com.neome.feature.form.presentation.state.FieldState
import com.neome.feature.form.presentation.state.FormEvent
import com.neome.feature.form.presentation.state.FormIntent
import com.neome.feature.form.presentation.state.FormState
import com.neome.feature.form.presentation.state.SendBtnDisableFlag
import kotlinx.serialization.json.JsonElement

class FormCtxImpl(
    private val defnForm: DefnFormData,
    initialValue: FormValueRawData?,
    private val onIntent: (FormIntent) -> Unit
) : FormCtx {

    private val _formState = mutableStateOf(
        FormCtxInitHelper.initializeFormState(defnForm, initialValue)
    )

    override val formState: State<FormState> get() = _formState

    private val currentState: FormState get() = _formState.value

    init {
        onIntent(FormIntent.SendBtnStateChanged(enabled = _formState.value.isSendBtnEnabled))
    }

    internal fun dispatch(event: FormEvent) {
        val result = processEvent(currentState, event)
        _formState.value = result.state
        result.intent?.let { onIntent(it) }
    }

    private fun processEvent(state: FormState, event: FormEvent): FormReducerResult {
        val defnForm = state.defnForm ?: return FormReducerResult(state)

        return when (event) {
            is FormEvent.Initialize -> FormReducerResult(state)
            is FormEvent.FieldValueChanged -> FormCtxEventHelper.handleFieldValueChanged(state, event, defnForm)
            is FormEvent.FieldFocused -> FormCtxEventHelper.handleFieldFocused(state, event)
            is FormEvent.FieldBlurred -> FormCtxEventHelper.handleFieldBlurred(state, event)
            is FormEvent.FieldTouched -> FormCtxEventHelper.handleFieldTouched(state, event)
            is FormEvent.TriggerField -> FormCtxEventHelper.handleTriggerField(state, event, defnForm)
            is FormEvent.ValidateField -> FormCtxValidationHelper.handleValidateField(state, event)
            is FormEvent.ValidateAll -> FormCtxValidationHelper.handleValidateAll(state)
            is FormEvent.SetFieldError -> FormCtxValidationHelper.handleSetFieldError(state, event)
            is FormEvent.ClearFieldError -> FormCtxValidationHelper.handleClearFieldError(state, event)
            is FormEvent.ClearAllErrors -> FormCtxValidationHelper.handleClearAllErrors(state)
            is FormEvent.Submit -> FormCtxEventHelper.handleSubmit(state)
            is FormEvent.Reset -> FormCtxEventHelper.handleReset(state, event)
            is FormEvent.SetValues -> FormCtxEventHelper.handleSetValues(state, event, defnForm)
            is FormEvent.AddSendBtnDisableFlag -> handleAddSendBtnDisableFlag(state, event)
            is FormEvent.RemoveSendBtnDisableFlag -> handleRemoveSendBtnDisableFlag(state, event)
        }
    }

    private fun handleAddSendBtnDisableFlag(
        state: FormState,
        event: FormEvent.AddSendBtnDisableFlag
    ): FormReducerResult {
        if (event.flag in state.disableSendBtnSet) return FormReducerResult(state)
        val wasEnabled = state.isSendBtnEnabled
        val newSet = state.disableSendBtnSet + event.flag
        val newState = state.copy(disableSendBtnSet = newSet)
        val intent = if (wasEnabled) FormIntent.SendBtnStateChanged(enabled = false) else null
        return FormReducerResult(newState, intent)
    }

    private fun handleRemoveSendBtnDisableFlag(
        state: FormState,
        event: FormEvent.RemoveSendBtnDisableFlag
    ): FormReducerResult {
        if (event.flag !in state.disableSendBtnSet) return FormReducerResult(state)
        val wasEnabled = state.isSendBtnEnabled
        val newSet = state.disableSendBtnSet - event.flag
        val newState = state.copy(disableSendBtnSet = newSet)
        val isNowEnabled = newState.isSendBtnEnabled
        val intent = if (!wasEnabled && isNowEnabled) FormIntent.SendBtnStateChanged(enabled = true) else null
        return FormReducerResult(newState, intent)
    }

    fun createFormRef(): FormRef {
        return FormRefImpl(
            getFormState = { currentState },
            dispatchEvent = ::dispatch
        )
    }

    // ==================== FormCtx Implementation ====================

    override fun trigger(fieldId: MetaIdComp) {
        dispatch(FormEvent.TriggerField(fieldId))
    }

    override fun getValues(): Map<MetaIdComp, JsonElement> = currentState.valueMap
    override fun getFieldState(fieldId: MetaIdComp): FieldState? = currentState.getFieldState(fieldId)
    override fun getValue(fieldId: MetaIdComp): JsonElement? = currentState.getValue(fieldId)
    override fun getError(fieldId: MetaIdComp): FieldError? = currentState.getError(fieldId)
    override fun hasField(fieldId: MetaIdComp): Boolean = currentState.fieldStates.containsKey(fieldId)
    override fun getDefnForm(): DefnFormData? = currentState.defnForm

    override fun validate(fieldId: MetaIdComp?) {
        if (fieldId != null) {
            dispatch(FormEvent.ValidateField(fieldId))
        } else {
            dispatch(FormEvent.ValidateAll)
        }
    }

    override fun setError(fieldId: MetaIdComp, error: String) {
        dispatch(FormEvent.SetFieldError(fieldId, error))
    }

    override fun clearError(fieldId: MetaIdComp) {
        dispatch(FormEvent.ClearFieldError(fieldId))
    }

    override fun addSendBtnDisableFlag(flag: SendBtnDisableFlag) {
        dispatch(FormEvent.AddSendBtnDisableFlag(flag))
    }

    override fun removeSendBtnDisableFlag(flag: SendBtnDisableFlag) {
        dispatch(FormEvent.RemoveSendBtnDisableFlag(flag))
    }
}
```

**Step 2: Delete FormCtxStateHelper.kt**

```bash
git rm app/src/main/java/com/neome/feature/form/domain/ctx/helper/FormCtxStateHelper.kt
```

**Step 3: Commit**

```bash
git add -A && git commit -m "refactor(form): remove coroutines/queue from FormCtxImpl, delete FormCtxStateHelper"
```

---

## Task 4: Simplify FormRef and FormRefImpl

**Files:**
- Modify: `domain/ref/FormRef.kt`
- Modify: `domain/ref/FormRefImpl.kt`

**Step 1: Simplify FormRef interface**

Remove: `awaitIdle()`, `watchFieldState()`, `watchFormState()`.
Keep: All sync read/write operations.
Change: Write operations dispatch `FormEvent` directly instead of `FormAction`.

```kotlin
package com.neome.feature.form.domain.ref

import com.neome.api.meta.base.Types.MetaIdComp
import com.neome.core.common.serializer.api.meta.base.dto.FormValueRawData
import com.neome.feature.form.presentation.state.FieldState
import com.neome.feature.form.presentation.state.FormState
import com.neome.feature.form.presentation.state.SendBtnDisableFlag
import kotlinx.serialization.json.JsonElement

/**
 * External API for parent screens to interact with the Form component.
 *
 * Inspired by React Hook Form's ref pattern.
 * All operations are synchronous. State is updated immediately after each call.
 */
interface FormRef {

    // ==================== Read Operations ====================

    fun getValue(fieldId: MetaIdComp): JsonElement?
    fun getValues(): FormValueRawData?
    fun getValueMap(): Map<MetaIdComp, JsonElement>
    fun getFieldState(fieldId: MetaIdComp): FieldState?

    // ==================== Write Operations ====================

    fun setValue(fieldId: MetaIdComp, value: JsonElement?, shouldValidate: Boolean = true)
    fun setValues(valueMap: Map<MetaIdComp, JsonElement>, shouldValidate: Boolean = true)

    // ==================== Validation ====================

    fun validate(fieldId: MetaIdComp? = null)
    fun setError(fieldId: MetaIdComp, error: String)
    fun clearErrors(fieldId: MetaIdComp? = null)

    // ==================== Form Operations ====================

    fun submit()
    fun reset(valueMap: Map<MetaIdComp, JsonElement>? = null)

    // ==================== State Queries ====================

    fun isDirty(fieldId: MetaIdComp? = null): Boolean
    fun isValid(fieldId: MetaIdComp? = null): Boolean
    fun isTouched(fieldId: MetaIdComp? = null): Boolean

    // ==================== Send Button Control ====================

    fun addSendBtnDisableFlag(flag: SendBtnDisableFlag)
    fun removeSendBtnDisableFlag(flag: SendBtnDisableFlag)
    fun isSendBtnEnabled(): Boolean
}
```

**Step 2: Rewrite FormRefImpl**

Remove: `CoroutineScope`, `enqueueAction`, `awaitIdleFn`, `ConcurrentHashMap`, `stateIn`, all Flow imports.
Constructor takes: `getFormState: () -> FormState` and `dispatchEvent: (FormEvent) -> Unit`.

```kotlin
package com.neome.feature.form.domain.ref

import com.neome.api.meta.base.Types.MetaIdComp
import com.neome.core.common.serializer.api.meta.base.dto.FormValueRawData
import com.neome.feature.form.presentation.state.FieldState
import com.neome.feature.form.presentation.state.FormEvent
import com.neome.feature.form.presentation.state.FormState
import com.neome.feature.form.presentation.state.SendBtnDisableFlag
import kotlinx.serialization.json.JsonElement

class FormRefImpl(
    private val getFormState: () -> FormState,
    private val dispatchEvent: (FormEvent) -> Unit
) : FormRef {

    private val currentState: FormState get() = getFormState()

    // ==================== Read Operations ====================

    override fun getValue(fieldId: MetaIdComp): JsonElement? = currentState.getValue(fieldId)

    override fun getValues(): FormValueRawData? {
        val state = currentState
        val initialValue = state.initialFormValue ?: return null
        return FormValueRawData(
            createdBy = initialValue.createdBy,
            createdOn = initialValue.createdOn,
            rowId = initialValue.rowId,
            rowOrder = initialValue.rowOrder,
            updatedBy = initialValue.updatedBy,
            updatedOn = initialValue.updatedOn,
            valueMap = state.valueMap
        )
    }

    override fun getValueMap(): Map<MetaIdComp, JsonElement> = currentState.valueMap
    override fun getFieldState(fieldId: MetaIdComp): FieldState? = currentState.getFieldState(fieldId)

    // ==================== Write Operations ====================

    override fun setValue(fieldId: MetaIdComp, value: JsonElement?, shouldValidate: Boolean) {
        dispatchEvent(FormEvent.FieldValueChanged(fieldId, value, shouldValidate))
    }

    override fun setValues(valueMap: Map<MetaIdComp, JsonElement>, shouldValidate: Boolean) {
        dispatchEvent(FormEvent.SetValues(valueMap, shouldValidate))
    }

    // ==================== Validation ====================

    override fun validate(fieldId: MetaIdComp?) {
        if (fieldId != null) dispatchEvent(FormEvent.ValidateField(fieldId))
        else dispatchEvent(FormEvent.ValidateAll)
    }

    override fun setError(fieldId: MetaIdComp, error: String) {
        dispatchEvent(FormEvent.SetFieldError(fieldId, error))
    }

    override fun clearErrors(fieldId: MetaIdComp?) {
        if (fieldId != null) dispatchEvent(FormEvent.ClearFieldError(fieldId))
        else dispatchEvent(FormEvent.ClearAllErrors)
    }

    // ==================== Form Operations ====================

    override fun submit() = dispatchEvent(FormEvent.Submit)
    override fun reset(valueMap: Map<MetaIdComp, JsonElement>?) = dispatchEvent(FormEvent.Reset(valueMap))

    // ==================== State Queries ====================

    override fun isDirty(fieldId: MetaIdComp?): Boolean {
        val state = currentState
        return if (fieldId != null) state.getFieldState(fieldId)?.isDirty ?: false
        else state.isDirty
    }

    override fun isValid(fieldId: MetaIdComp?): Boolean {
        val state = currentState
        return if (fieldId != null) {
            !state.hasError(fieldId) && state.getFieldState(fieldId)?.let { fs ->
                !fs.fieldProperties.required || state.valueMap[fieldId] != null
            } ?: true
        } else state.isValid
    }

    override fun isTouched(fieldId: MetaIdComp?): Boolean {
        val state = currentState
        return if (fieldId != null) state.getFieldState(fieldId)?.isTouched ?: false
        else state.fieldStates.values.any { it.isTouched }
    }

    // ==================== Send Button Control ====================

    override fun addSendBtnDisableFlag(flag: SendBtnDisableFlag) {
        dispatchEvent(FormEvent.AddSendBtnDisableFlag(flag))
    }

    override fun removeSendBtnDisableFlag(flag: SendBtnDisableFlag) {
        dispatchEvent(FormEvent.RemoveSendBtnDisableFlag(flag))
    }

    override fun isSendBtnEnabled(): Boolean = currentState.isSendBtnEnabled
}
```

**Step 3: Commit**

```bash
git add -A && git commit -m "refactor(form): simplify FormRef/FormRefImpl - remove coroutines, use dispatch directly"
```

---

## Task 5: Rewrite FieldController — Replace StateFlow with derivedStateOf

**Files:**
- Modify: `presentation/components/base/FieldController.kt`

**Step 1: Rewrite FieldController**

Replace `StateFlow<T?>` and `StateFlow<FieldUiState>` with Compose `State<T?>` and `State<FieldUiState>`.
Replace `createFieldValueFlow` and `createFieldUiStateFlow` with `derivedStateOf` blocks.
Remove all Flow/CoroutineScope/Dispatchers imports.

```kotlin
package com.neome.feature.form.presentation.components.base

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.State
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.DefnField
import com.neome.core.common.serializer.api.meta.base.dto.DefnCompSeal
import com.neome.feature.form.domain.ctx.LocalFormCtx
import com.neome.feature.form.presentation.state.FieldError
import com.neome.feature.form.presentation.state.FieldEvent
import com.neome.feature.form.presentation.state.FieldProperties
import com.neome.feature.utils.JsonParser
import kotlinx.serialization.KSerializer
import kotlinx.serialization.json.Json
import kotlinx.serialization.serializer

/**
 * Reactive UI state for a form field's properties and error.
 */
@Immutable
data class FieldUiState(
    val properties: FieldProperties = FieldProperties(),
    val error: FieldError? = null
)

/**
 * Controller for form fields that provides standardized access to field state and operations.
 *
 * Reactive state is exposed through two Compose State objects:
 * - [value]: The deserialized field value, derived from FormState.
 * - [field]: Combined properties and error as [FieldUiState], derived from FormState.
 *
 * Both use derivedStateOf for fine-grained recomposition — only recomposes
 * when the specific field's data changes, not on every FormState change.
 */
@Immutable
data class FieldController<T>(
    /** Field ID extracted from defnComp */
    val fieldId: Types.MetaIdComp?,

    /** Compose State of the deserialized field value */
    val value: State<T?>,

    /** Compose State combining field properties and error */
    val field: State<FieldUiState>,

    /** Callback function for value changes */
    val onChange: (T?) -> Unit
)

/**
 * Composable for creating and managing a field controller with stable reference.
 *
 * Returns a stable [FieldController] instance that is remembered across recompositions.
 * Uses derivedStateOf to derive per-field state from the centralized FormState,
 * ensuring fine-grained recomposition.
 *
 * Usage:
 * ```kotlin
 * val fieldController = rememberFieldController<FieldValueTextData>(
 *     defnComp = defnComp,
 *     onFieldEvent = onFieldEvent
 * )
 *
 * if (fieldController.fieldId == null) return
 *
 * val fieldValue = fieldController.value.value
 * val (properties, error) = fieldController.field.value
 *
 * if (properties.hidden) return
 * val currentValue = fieldValue?.value ?: ""
 * ```
 */
@Composable
inline fun <reified T> rememberFieldController(
    defnComp: DefnCompSeal,
    noinline onFieldEvent: (FieldEvent) -> Unit
): FieldController<T> {
    val formCtx = LocalFormCtx.current
    val serializer = serializer<T>()
    val fieldId = (defnComp as? DefnField)?.metaId

    return remember(defnComp, onFieldEvent) {
        val valueState = derivedStateOf {
            deriveFieldValue(fieldId, formCtx.formState.value, serializer)
        }

        val fieldState = derivedStateOf {
            deriveFieldUiState(fieldId, formCtx.formState.value)
        }

        val onChange: (T?) -> Unit = { newValue ->
            val jsonValue = newValue?.let { Json.encodeToJsonElement(serializer, it) }
            fieldId?.let { onFieldEvent(FieldEvent.ValueChanged(it, jsonValue)) }
        }

        FieldController(
            fieldId = fieldId,
            value = valueState,
            field = fieldState,
            onChange = onChange
        )
    }
}

/**
 * Derive deserialized field value from FormState.
 */
fun <T> deriveFieldValue(
    fieldId: Types.MetaIdComp?,
    formState: com.neome.feature.form.presentation.state.FormState,
    serializer: KSerializer<T>
): T? {
    if (fieldId == null) return null
    val jsonValue = formState.getValue(fieldId) ?: return null
    return try {
        JsonParser.json.decodeFromJsonElement(serializer, jsonValue)
    } catch (e: Exception) {
        null
    }
}

/**
 * Derive FieldUiState from FormState for a specific field.
 */
fun deriveFieldUiState(
    fieldId: Types.MetaIdComp?,
    formState: com.neome.feature.form.presentation.state.FormState
): FieldUiState {
    if (fieldId == null) return FieldUiState()
    return FieldUiState(
        properties = formState.getFieldState(fieldId)?.fieldProperties ?: FieldProperties(),
        error = formState.getError(fieldId)
    )
}
```

**Step 2: Commit**

```bash
git add -A && git commit -m "refactor(form): rewrite FieldController with derivedStateOf instead of StateFlow"
```

---

## Task 6: Simplify Form.kt Root Composable

**Files:**
- Modify: `presentation/components/Form.kt`

**Step 1: Remove coroutineScope, simplify state access**

Remove: `rememberCoroutineScope()`, `collectAsState()` import, `coroutineScope` parameter to `FormCtxImpl`.
Use `formCtx.formState.value` directly instead of collecting from StateFlow.

```kotlin
// Key changes in Form.kt:

// 1. Remove: val coroutineScope = rememberCoroutineScope()

// 2. Change FormCtxImpl constructor call:
val formCtx = remember(defnForm, initialValue) {
    FormCtxImpl(
        defnForm = defnForm,
        initialValue = initialValue,
        onIntent = { currentOnIntent(it) }
    )
}

// 3. Replace: val formState by formCtx.stateFlow.collectAsState()
// With: val formState = formCtx.formState.value
// (Or just pass formCtx.formState directly to FormContent)

// 4. Remove import: import androidx.compose.runtime.collectAsState
// 5. Remove import: import androidx.compose.runtime.rememberCoroutineScope
```

**Step 2: Commit**

```bash
git add -A && git commit -m "refactor(form): simplify Form.kt - remove coroutineScope, use Compose State"
```

---

## Task 7: Update All Field Components — Replace collectAsStateWithLifecycle with direct State access

**Files:** All 18 field component files listed above + FieldTab.kt

**Pattern change for every field component:**

Before:
```kotlin
import androidx.lifecycle.compose.collectAsStateWithLifecycle

val fieldValue by fieldController.value.collectAsStateWithLifecycle()
val (properties, error) = fieldController.field.collectAsStateWithLifecycle().value
```

After:
```kotlin
// No import needed for collectAsStateWithLifecycle

val fieldValue = fieldController.value.value
val (properties, error) = fieldController.field.value
```

**For FieldTab.kt specifically:**

Before:
```kotlin
val formState by formCtx.watchFormState().collectAsState()
```

After:
```kotlin
val formState = formCtx.formState.value
```

**Step 1: Update each field file**

Apply the pattern change to all 18+ field files. Remove `import androidx.lifecycle.compose.collectAsStateWithLifecycle` from each.

**Step 2: Commit**

```bash
git add -A && git commit -m "refactor(form): update all field components to use Compose State instead of StateFlow"
```

---

## Task 8: Clean Up FormEvent.kt — Remove UiEvent superinterface if unused

**Files:**
- Modify: `presentation/state/FormEvent.kt`

**Step 1: Check if UiEvent is needed**

After deleting `FormAction.kt`, check if `FormEvent` still needs `UiEvent` superinterface. If `UiEvent` is only used as a marker interface and `FormIntent` also extends it, keep it. Otherwise remove.

```kotlin
// If UiEvent is just a marker, it's fine to keep. 
// Check: does FormIntent also extend UiEvent? Yes it does.
// Decision: Keep UiEvent on FormEvent for now (it's a marker interface).
```

**Step 2: Remove toFormEvent import from FormCtxImpl**

Since `FormAction` and `toFormEvent()` no longer exist, remove the import:
```kotlin
// Remove: import com.neome.feature.form.presentation.state.toFormEvent
```

**Step 3: Commit**

```bash
git add -A && git commit -m "refactor(form): clean up FormEvent imports"
```

---

## Task 9: Update Documentation

**Files:**
- Modify: `app/src/main/java/com/neome/feature/form/form.md`
- Modify: `.opencode/skills/defn-form/SKILL.md`

**Step 1: Update form.md**

- Remove references to `FormAction`, `enqueue()`, `Dispatchers.Default`, coroutine scope, `awaitIdle()`
- Update architecture diagram to show sync dispatch
- Update key files table (remove `FormAction.kt`, `FormCtxStateHelper.kt`)
- Update field component usage examples to use `derivedStateOf` pattern
- Add version note about the simplification

**Step 2: Update SKILL.md**

- Remove `FormAction.kt` from key files table
- Update "Background: All mutations via `enqueue()` on `Dispatchers.Default`" line
- Update to reflect sync architecture

**Step 3: Commit**

```bash
git add -A && git commit -m "docs(form): update architecture docs for sync simplification"
```

---

## Task 10: Verify Build

**Step 1: Run build**

```bash
./gradlew :app:compileDebugKotlin
```

Expected: BUILD SUCCESSFUL

**Step 2: Fix any compilation errors**

Check for:
- Missing imports after deletions
- Any remaining references to deleted `FormAction`, `FormCtxStateHelper`, `awaitIdle`, `enqueue`
- Type mismatches from `StateFlow` → `State` change

**Step 3: Final commit if fixes needed**

```bash
git add -A && git commit -m "fix(form): resolve compilation issues from sync simplification"
```

---

## Dependency Order

```
Task 1 (Delete FormAction) 
  → Task 2 (Simplify FormCtx interface)
    → Task 3 (Rewrite FormCtxImpl) 
      → Task 4 (Simplify FormRef/FormRefImpl)
        → Task 5 (Rewrite FieldController)
          → Task 6 (Simplify Form.kt)
            → Task 7 (Update all field components)
              → Task 8 (Clean up imports)
                → Task 9 (Update docs)
                  → Task 10 (Verify build)
```

All tasks are sequential — each depends on the previous.

---

## Future Threading Design

After this refactoring, all state mutations flow through `FormCtxImpl.dispatch(event)`. To add separate threading later:

```kotlin
// Future: wrap dispatch in a dispatcher
class FormCtxImpl(
    private val dispatcher: CoroutineDispatcher = Dispatchers.Main // future param
) {
    fun dispatchAsync(event: FormEvent) {
        scope.launch(dispatcher) {
            dispatch(event) // existing sync logic
        }
    }
}
```

The key insight: business logic (processEvent, helpers) stays pure and sync. Threading is a caller concern, not a form concern.
