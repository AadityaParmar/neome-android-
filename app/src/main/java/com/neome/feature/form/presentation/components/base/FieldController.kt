package com.neome.feature.form.presentation.components.base

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.remember
import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.DefnField
import com.neome.core.common.serializer.api.meta.base.dto.DefnCompSeal
import com.neome.feature.form.domain.ctx.FormCtx
import com.neome.feature.form.domain.ctx.LocalFormCtx
import com.neome.feature.form.presentation.state.FieldError
import com.neome.feature.form.presentation.state.FieldEvent
import com.neome.feature.form.presentation.state.FieldProperties
import com.neome.feature.utils.JsonParser
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.serialization.KSerializer
import kotlinx.serialization.json.Json
import kotlinx.serialization.serializer

/**
 * Reactive UI state for a form field's properties and error.
 *
 * Holds computed properties and validation error for a field.
 * Emitted via [FieldController.field] StateFlow so composables
 * can destructure properties and error from a single collect.
 *
 * Field value is exposed separately via [FieldController.value] StateFlow
 * for finer-grained recomposition control.
 */
@Immutable
data class FieldUiState(
    val properties: FieldProperties = FieldProperties(),
    val error: FieldError? = null
)

/**
 * Controller for form fields that provides standardized access to field state and operations.
 *
 * This is a stable remembered object. Reactive state is exposed through two StateFlows:
 * - [value]: The deserialized field value, updated independently.
 * - [field]: Combined properties and error as [FieldUiState].
 *
 * Composables collect both with `collectAsStateWithLifecycle()`.
 *
 * All field components should use this controller to ensure consistent
 * state management and property access across different field types.
 */
@Immutable
data class FieldController<T>(
    /** Field ID extracted from defnComp */
    val fieldId: Types.MetaIdComp?,

    /** Reactive StateFlow of the deserialized field value */
    val value: StateFlow<T?>,

    /** Reactive StateFlow combining field properties and error */
    val field: StateFlow<FieldUiState>,

    /** Callback function for value changes */
    val onChange: (T?) -> Unit
)

/**
 * Composable for creating and managing a field controller with stable reference.
 *
 * Returns a stable [FieldController] instance that is remembered across recompositions.
 * The controller exposes two reactive StateFlows:
 * - [FieldController.value] for the deserialized field value.
 * - [FieldController.field] for properties and error.
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
 * val fieldValue by fieldController.value.collectAsStateWithLifecycle()
 * val (properties, error) = fieldController.field.collectAsStateWithLifecycle().value
 *
 * if (properties.hidden) return
 * val currentValue = fieldValue?.value ?: ""
 * ```
 *
 * @param T The type of field value data (e.g., FieldValueTextData, FieldValueNumberData)
 * @param defnComp Field definition containing field configuration
 * @param onFieldEvent Callback to emit field events to the form
 * @return FieldController instance with stable reference across recompositions
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
        val valueFlow = createFieldValueFlow(fieldId, formCtx, serializer)
        val fieldFlow = createFieldUiStateFlow(fieldId, formCtx)

        val onChange: (T?) -> Unit = { newValue ->
            val jsonValue = newValue?.let { Json.encodeToJsonElement(serializer, it) }
            fieldId?.let { onFieldEvent(FieldEvent.ValueChanged(it, jsonValue)) }
        }

        FieldController(
            fieldId = fieldId,
            value = valueFlow,
            field = fieldFlow,
            onChange = onChange
        )
    }
}

/**
 * Creates a StateFlow of the deserialized field value from the raw JSON value flow.
 *
 * @param fieldId Field identifier, or null if defnComp is not a DefnField
 * @param formCtx Form context providing reactive watch methods
 * @param serializer KSerializer for deserializing the field value from JsonElement
 * @return StateFlow that emits a new deserialized value on any value change
 */
fun <T> createFieldValueFlow(
    fieldId: Types.MetaIdComp?,
    formCtx: FormCtx,
    serializer: KSerializer<T>
): StateFlow<T?> {
    if (fieldId == null) {
        return MutableStateFlow(null)
    }

    return formCtx.watchFieldValue(fieldId).map { jsonValue ->
        jsonValue?.let { jsonElement ->
            try {
                JsonParser.json.decodeFromJsonElement(serializer, jsonElement)
            } catch (e: Exception) {
                null
            }
        }
    }.stateIn(
        scope = CoroutineScope(Dispatchers.Default),
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = formCtx.getValue(fieldId)?.let { jsonElement ->
            try {
                JsonParser.json.decodeFromJsonElement(serializer, jsonElement)
            } catch (e: Exception) {
                null
            }
        }
    )
}

/**
 * Creates a combined StateFlow of [FieldUiState] from field state and error flows.
 *
 * @param fieldId Field identifier, or null if defnComp is not a DefnField
 * @param formCtx Form context providing reactive watch methods
 * @return StateFlow that emits a new FieldUiState on any state or error change
 */
fun createFieldUiStateFlow(
    fieldId: Types.MetaIdComp?,
    formCtx: FormCtx
): StateFlow<FieldUiState> {
    if (fieldId == null) {
        return MutableStateFlow(FieldUiState())
    }

    return combine(
        formCtx.watchFieldState(fieldId),
        formCtx.watchFieldError(fieldId)
    ) { state, error ->
        FieldUiState(
            properties = state?.fieldProperties ?: FieldProperties(),
            error = error
        )
    }.stateIn(
        scope = CoroutineScope(Dispatchers.Default),
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = FieldUiState(
            properties = formCtx.getFieldState(fieldId)?.fieldProperties ?: FieldProperties(),
            error = formCtx.getError(fieldId)
        )
    )
}
