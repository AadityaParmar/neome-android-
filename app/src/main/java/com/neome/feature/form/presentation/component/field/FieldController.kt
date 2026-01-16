package com.neome.feature.form.presentation.component.field

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.remember
import com.neome.api.meta.base.dto.DefnField
import com.neome.core.common.serializer.api.meta.base.dto.DefnCompSeal
import com.neome.feature.form.presentation.ctx.FormCtx
import com.neome.feature.form.presentation.state.FieldError
import com.neome.feature.form.presentation.state.FieldEvent
import com.neome.feature.form.presentation.state.FieldProperties
import com.neome.feature.utils.JsonParser
import kotlinx.serialization.KSerializer
import kotlinx.serialization.json.Json
import kotlinx.serialization.serializer

/**
 * Controller for form fields that provides standardized access to field state and operations.
 *
 * All field components should use this controller to ensure consistent
 * state management and property access across different field types.
 */
@Immutable
data class FieldController<T>(
    private val defnComp: DefnCompSeal,
    private val onFieldEvent: (FieldEvent) -> Unit,
    private val formCtx: FormCtx,
    private val serializer: KSerializer<T>
) {
    /** Field ID extracted from defnComp */
    val fieldId = (defnComp as? DefnField)?.metaId

    /** Current field state */
    val fieldState = fieldId?.let { formCtx.getFieldState(it) }

    /** Current field value as typed data */
    val fieldValue: T?
        get() = fieldState?.value?.let { jsonElement ->
            try {
                JsonParser.json.decodeFromJsonElement(serializer, jsonElement)
            } catch (e: Exception) {
                null // Return null if deserialization fails
            }
        }

    /** Field validation error, if any */
    val error: FieldError?
        get() = fieldId?.let { formCtx.getError(it) }

    /** Computed field properties (required, disabled, etc.) */
    val fieldProperties: FieldProperties
        get() = fieldState?.fieldProperties ?: FieldProperties()

    /** Callback function for value changes */
    val onChange: (T?) -> Unit = { newValue ->
        val jsonValue = newValue?.let { Json.encodeToJsonElement(serializer, it) }
        fieldId?.let { onFieldEvent(FieldEvent.ValueChanged(it, jsonValue)) }
    }
}

/**
 * Composable for creating and managing a field controller with stable reference.
 *
 * Provides a stable field controller instance that encapsulates field state and operations.
 * The controller is remembered across recompositions when the inputs remain the same.
 * Serialization and deserialization are handled automatically using kotlinx.serialization.
 *
 * @param T The type of field value data (e.g., FieldValueTextData, FieldValueNumberData)
 * @param defnComp Field definition containing field configuration
 * @param onFieldEvent Callback to emit field events to the form
 * @param formCtx Form context for accessing field state and other field values
 * @return FieldController instance with stable reference across recompositions
 */
@Composable
inline fun <reified T> rememberFieldController(
    defnComp: DefnCompSeal,
    noinline onFieldEvent: (FieldEvent) -> Unit,
    formCtx: FormCtx
): FieldController<T> {
    val serializer = serializer<T>()

    return remember(defnComp, onFieldEvent, formCtx) {
        FieldController(defnComp, onFieldEvent, formCtx, serializer)
    }
}
