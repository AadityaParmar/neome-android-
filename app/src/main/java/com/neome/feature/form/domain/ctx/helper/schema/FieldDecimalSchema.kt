package com.neome.feature.form.domain.ctx.helper.schema

import com.neome.api.meta.base.dto.DefnFieldDecimal
import com.neome.core.common.serializer.api.meta.base.dto.DefnCompSeal
import com.neome.core.common.serializer.api.meta.base.dto.DefnFormData
import com.neome.core.common.serializer.api.meta.base.dto.FieldValueDecimalData
import com.neome.feature.form.domain.util.FieldValueResolver
import com.neome.feature.form.presentation.state.FieldProperties
import com.neome.feature.form.presentation.state.FieldState
import io.konform.validation.Invalid
import io.konform.validation.Validation
import kotlinx.serialization.json.JsonElement

/**
 * CompSchema implementation for FieldDecimal.
 *
 * Uses Konform library for type-safe, declarative validation.
 * Validations are applied dynamically based on FieldProperties:
 * - required: value must not be null
 * - minDecimal: minimum value (if not null)
 * - maxDecimal: maximum value (if not null)
 */
class FieldDecimalSchema(
    override val defnForm: DefnFormData,
    override val defnComp: DefnCompSeal
) : CompSchema(defnForm, defnComp) {

    private val defnField = defnComp as DefnFieldDecimal

    override fun validate(fieldValue: JsonElement?, fieldState: FieldState?): String? {
        val typedValue = FieldValueResolver.fnJsonElementFieldValue(
            defnField.type,
            fieldValue
        ) as FieldValueDecimalData?
        val properties = fieldState?.fieldProperties ?: FieldProperties()

        val decimalValue = typedValue?.value

        val validation = buildValidation(properties)
        val result = validation(decimalValue)

        return if (result is Invalid) {
            result.errors.firstOrNull()?.message
        } else {
            null
        }
    }

    private fun buildValidation(properties: FieldProperties): Validation<Double?> {
        return Validation {
            // Required check
            if (properties.required) {
                constrain("Required") { it != null }
            }

            // Min decimal (only if not null and value is present)
            properties.minDecimal?.let { min ->
                constrain("Must be at least $min") { value ->
                    value == null || value >= min
                }
            }

            // Max decimal (only if not null and value is present)
            properties.maxDecimal?.let { max ->
                constrain("Must be at most $max") { value ->
                    value == null || value <= max
                }
            }
        }
    }
}
