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
import com.neome.feature.form.presentation.state.FormState
import com.neome.feature.utils.JsonParser
import kotlinx.serialization.KSerializer
import kotlinx.serialization.json.Json
import kotlinx.serialization.serializer

/**
 * Reactive UI state for a form field's properties and error.
 *
 * Holds computed properties and validation error for a field.
 * Emitted via [FieldController.field] State so composables
 * can destructure properties and error from a single read.
 *
 * Field value is exposed separately via [FieldController.value] State
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
 * This is a stable remembered object. Reactive state is exposed through two Compose States:
 * - [value]: The deserialized field value, derived from FormState via derivedStateOf.
 * - [field]: Combined properties and error as [FieldUiState], derived from FormState.
 *
 * Both use derivedStateOf for fine-grained recomposition — only recomposes
 * when the specific field's data changes, not on every FormState change.
 *
 * All field components should use this controller to ensure consistent
 * state management and property access across different field types.
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
    formState: FormState,
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
    formState: FormState
): FieldUiState {
    if (fieldId == null) return FieldUiState()

    val properties = formState.getFieldState(fieldId)?.fieldProperties ?: FieldProperties()

    return FieldUiState(
        properties = properties,
        error = formState.getError(fieldId)
    )
}
