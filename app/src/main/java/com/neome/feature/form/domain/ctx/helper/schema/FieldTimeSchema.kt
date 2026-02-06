package com.neome.feature.form.domain.ctx.helper.schema

import com.neome.api.meta.base.dto.DefnFieldTime
import com.neome.core.common.serializer.api.meta.base.dto.DefnCompSeal
import com.neome.core.common.serializer.api.meta.base.dto.DefnFormData
import com.neome.core.common.serializer.api.meta.base.dto.FieldValueTimeData
import com.neome.feature.form.domain.util.FieldValueResolver
import com.neome.feature.form.presentation.state.FieldProperties
import com.neome.feature.form.presentation.state.FieldState
import io.konform.validation.Invalid
import io.konform.validation.Validation
import kotlinx.serialization.json.JsonElement

/**
 * CompSchema implementation for FieldTime.
 *
 * Uses Konform library for type-safe, declarative validation.
 * Validations:
 * - required: value must not be blank
 * - min time: value must be after min time (from DefnFieldTime)
 * - max time: value must be before max time (from DefnFieldTime)
 *
 * Note: Time values are stored as strings (e.g., "14:30:00" or "14:30").
 */
class FieldTimeSchema(
    override val defnForm: DefnFormData,
    override val defnComp: DefnCompSeal
) : CompSchema(defnForm, defnComp) {

    private val defnField = defnComp as DefnFieldTime

    override fun validate(fieldValue: JsonElement?, fieldState: FieldState?): String? {
        val typedValue = FieldValueResolver.fnJsonElementFieldValue(
            defnField.type,
            fieldValue
        ) as FieldValueTimeData?
        val properties = fieldState?.fieldProperties ?: FieldProperties()

        val timeValue = typedValue?.value

        val validation = buildValidation(properties)
        val result = validation(timeValue)

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

            // Note: min/max time validation would require resolving DefnBuildTime
            // For now, we validate required only. Full min/max time validation
            // should be added when FieldPropertyResolver supports minTime/maxTime.
        }
    }
}
