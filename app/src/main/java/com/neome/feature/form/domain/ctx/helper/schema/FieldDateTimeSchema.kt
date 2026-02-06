package com.neome.feature.form.domain.ctx.helper.schema

import com.neome.api.meta.base.dto.DefnFieldDateTime
import com.neome.core.common.serializer.api.meta.base.dto.DefnCompSeal
import com.neome.core.common.serializer.api.meta.base.dto.DefnFormData
import com.neome.core.common.serializer.api.meta.base.dto.FieldValueDateTimeData
import com.neome.feature.form.domain.util.FieldValueResolver
import com.neome.feature.form.presentation.state.FieldProperties
import com.neome.feature.form.presentation.state.FieldState
import io.konform.validation.Invalid
import io.konform.validation.Validation
import kotlinx.serialization.json.JsonElement

/**
 * CompSchema implementation for FieldDateTime.
 *
 * Uses Konform library for type-safe, declarative validation.
 * Validations:
 * - required: value must not be blank
 *
 * Note: DateTime values are stored as ISO datetime strings.
 */
class FieldDateTimeSchema(
    override val defnForm: DefnFormData,
    override val defnComp: DefnCompSeal
) : CompSchema(defnForm, defnComp) {

    private val defnField = defnComp as DefnFieldDateTime

    override fun validate(fieldValue: JsonElement?, fieldState: FieldState?): String? {
        val typedValue = FieldValueResolver.fnJsonElementFieldValue(
            defnField.type,
            fieldValue
        ) as FieldValueDateTimeData?
        val properties = fieldState?.fieldProperties ?: FieldProperties()

        val dateTimeValue = typedValue?.value

        val validation = buildValidation(properties)
        val result = validation(dateTimeValue)

        return if (result is Invalid) {
            result.errors.firstOrNull()?.message
        } else {
            null
        }
    }

    private fun buildValidation(properties: FieldProperties): Validation<String?> {
        return Validation {
            // Required check
            if (properties.required) {
                constrain("Required") { !it.isNullOrBlank() }
            }
        }
    }
}
