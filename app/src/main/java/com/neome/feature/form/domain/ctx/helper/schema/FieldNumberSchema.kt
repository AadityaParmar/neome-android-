package com.neome.feature.form.domain.ctx.helper.schema

import com.neome.api.meta.base.dto.DefnFieldNumber
import com.neome.core.common.serializer.api.meta.base.dto.DefnCompSeal
import com.neome.feature.form.domain.DefnFormUi
import com.neome.core.common.serializer.api.meta.base.dto.FieldValueNumberData
import com.neome.feature.form.domain.util.FieldVal.FieldValueResolver
import com.neome.feature.form.presentation.state.FieldProperties
import com.neome.feature.form.presentation.state.FieldState
import io.konform.validation.Invalid
import io.konform.validation.Validation
import kotlinx.serialization.json.JsonElement


/**
 * CompSchema implementation for FieldNumber.
 *
 * Uses Konform library for type-safe, declarative validation.
 * Validations are applied dynamically based on FieldProperties:
 * - required: value must not be null
 * - minNumber: minimum value (if not null)
 * - maxNumber: maximum value (if not null)
 */
class FieldNumberSchema(override val defnForm: DefnFormUi, override val defnComp: DefnCompSeal) :
    CompSchema(defnForm, defnComp) {

    private val defnField = defnComp as DefnFieldNumber

    /**
     * Pure validation that returns an error message without side effects.
     */
    override fun validate(fieldValue: JsonElement?, fieldState: FieldState?): String? {
        val typedValue =
            FieldValueResolver.fnJsonElementFieldValue(defnField.type, fieldValue) as FieldValueNumberData?
        val properties = fieldState?.fieldProperties ?: FieldProperties()

        // Get the number value (null if not set)
        val numberValue = typedValue?.value

        // Build and execute Konform validation
        val validation = buildValidation(properties)
        val result = validation(numberValue)

        // Return first error message or null if valid
        return if (result is Invalid) {
            result.errors.firstOrNull()?.message
        } else {
            null
        }
    }

    /**
     * Build Konform validation dynamically based on FieldProperties.
     * Only applies validations for non-null constraint values.
     *
     * @param properties The resolved field properties
     */
    private fun buildValidation(properties: FieldProperties): Validation<Long?> {
        return Validation {
            // Required check - value must not be null
            if (properties.required) {
                constrain("Required") { it != null }
            }

            // Min number (only if not null and value is present)
            properties.minNumber?.let { min ->
                constrain("Must be at least ${min.toLong()}") { value ->
                    value == null || value >= min
                }
            }

            // Max number (only if not null and value is present)
            properties.maxNumber?.let { max ->
                constrain("Must be at most ${max.toLong()}") { value ->
                    value == null || value <= max
                }
            }
        }
    }
}
