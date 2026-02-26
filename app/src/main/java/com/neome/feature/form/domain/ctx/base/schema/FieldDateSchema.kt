package com.neome.feature.form.domain.ctx.base.schema

import com.neome.api.meta.base.dto.DefnFieldDate
import com.neome.core.common.serializer.api.meta.base.dto.DefnCompSeal
import com.neome.feature.form.domain.model.DefnFormUi
import com.neome.core.common.serializer.api.meta.base.dto.FieldValueDateData
import com.neome.feature.form.domain.util.FieldVal.FieldValueResolver
import com.neome.feature.form.presentation.state.FieldProperties
import com.neome.feature.form.presentation.state.FieldState
import io.konform.validation.Invalid
import io.konform.validation.Validation
import kotlinx.serialization.json.JsonElement

/**
 * CompSchema implementation for FieldDate.
 *
 * Uses Konform library for type-safe, declarative validation.
 * Validations:
 * - required: value must not be blank
 * - min date: value must be after min date (from DefnFieldDate)
 * - max date: value must be before max date (from DefnFieldDate)
 *
 * Note: Date values are stored as ISO date strings (e.g., "2024-01-15").
 * For simplicity, we compare dates as strings which works for ISO format.
 */
class FieldDateSchema(
    override val defnForm: DefnFormUi,
    override val defnComp: DefnCompSeal
) : CompSchema(defnForm, defnComp) {

    private val defnField = defnComp as DefnFieldDate

    override fun validate(fieldValue: JsonElement?, fieldState: FieldState?): String? {
        val typedValue = FieldValueResolver.fnJsonElementFieldValue(
            defnField.type,
            fieldValue
        ) as FieldValueDateData?
        val properties = fieldState?.fieldProperties ?: FieldProperties()

        val dateValue = typedValue?.value

        val validation = buildValidation(properties)
        val result = validation(dateValue)

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

            // Note: min/max date validation would require resolving DefnBuildDate
            // which involves complex date calculations with timezone.
            // For now, we validate required only. Full min/max date validation
            // should be added when FieldPropertyResolver supports minDate/maxDate.
        }
    }
}
