package com.neome.feature.form.domain.ctx.base.schema

import com.neome.api.meta.base.dto.DefnFieldPickGridRow
import com.neome.core.common.serializer.api.meta.base.dto.DefnCompSeal
import com.neome.feature.form.domain.model.DefnFormUi
import com.neome.feature.form.presentation.state.FieldProperties
import com.neome.feature.form.presentation.state.FieldState
import com.neome.feature.utils.JsonParser
import io.konform.validation.Invalid
import io.konform.validation.Validation
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement

/**
 * CompSchema implementation for FieldPickGridRow and FieldPickReportRow.
 *
 * Uses Konform library for type-safe, declarative validation.
 * Validations:
 * - required: value must be present
 */
class FieldPickGridRowSchema(
    override val defnForm: DefnFormUi,
    override val defnComp: DefnCompSeal
) : CompSchema(defnForm, defnComp) {

    private val defnField = defnComp as? DefnFieldPickGridRow

    override fun validate(fieldValue: JsonElement?, fieldState: FieldState?): String? {
        if (fieldValue == null) {
            val properties = fieldState?.fieldProperties ?: FieldProperties()
            return if (properties.required) "Required" else null
        }

        val typedValue = try {
            JsonParser.json.decodeFromJsonElement(
                PickGridRowValue.serializer(),
                fieldValue
            )
        } catch (e: Exception) {
            null
        }

        val properties = fieldState?.fieldProperties ?: FieldProperties()

        val validation = buildValidation(properties)
        val result = validation(typedValue)

        return if (result is Invalid) {
            result.errors.firstOrNull()?.message
        } else {
            null
        }
    }

    private fun buildValidation(properties: FieldProperties): Validation<PickGridRowValue?> {
        return Validation {
            // Required check
            if (properties.required) {
                constrain("Required") {
                    it != null && !it.value.isNullOrBlank()
                }
            }
        }
    }

    /**
     * Internal data class for PickGridRow/PickReportRow value structure.
     */
    @Serializable
    private data class PickGridRowValue(
        val value: String? = null,
        val displayField: String? = null
    )
}
