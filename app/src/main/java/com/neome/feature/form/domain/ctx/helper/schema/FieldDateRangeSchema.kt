package com.neome.feature.form.domain.ctx.helper.schema

import com.neome.api.meta.base.dto.DefnFieldDateRange
import com.neome.core.common.serializer.api.meta.base.dto.DefnCompSeal
import com.neome.feature.form.domain.DefnFormUi
import com.neome.core.common.serializer.api.meta.base.dto.FieldValueDateRangeData
import com.neome.feature.form.presentation.state.FieldProperties
import com.neome.feature.form.presentation.state.FieldState
import com.neome.feature.utils.JsonParser
import io.konform.validation.Invalid
import io.konform.validation.Validation
import kotlinx.serialization.json.JsonElement

/**
 * CompSchema implementation for FieldDateRange and FieldDateTimeRange.
 *
 * Uses Konform library for type-safe, declarative validation.
 * Validations:
 * - required: both from and to must be present
 * - allowSingleDate: if false, both values must be set when one is set
 */
class FieldDateRangeSchema(
    override val defnForm: DefnFormUi,
    override val defnComp: DefnCompSeal
) : CompSchema(defnForm, defnComp) {

    private val defnField = defnComp as? DefnFieldDateRange

    override fun validate(fieldValue: JsonElement?, fieldState: FieldState?): String? {
        if (fieldValue == null) {
            val properties = fieldState?.fieldProperties ?: FieldProperties()
            return if (properties.required) "Required" else null
        }

        val typedValue = try {
            JsonParser.json.decodeFromJsonElement(
                FieldValueDateRangeData.serializer(),
                fieldValue
            )
        } catch (e: Exception) {
            null
        }

        val properties = fieldState?.fieldProperties ?: FieldProperties()

        val validation = buildValidation(properties, typedValue)
        val result = validation(typedValue)

        return if (result is Invalid) {
            result.errors.firstOrNull()?.message
        } else {
            null
        }
    }

    private fun buildValidation(
        properties: FieldProperties,
        value: FieldValueDateRangeData?
    ): Validation<FieldValueDateRangeData?> {
        return Validation {
            // Required check - both from and to must be present
            if (properties.required) {
                constrain("Required") {
                    it != null && !it.from.isNullOrBlank() && !it.to.isNullOrBlank()
                }
            }

            // Both values must be set unless allowSingleDate is true
            if (defnField?.allowSingleDate != true) {
                constrain("Both values must be set") {
                    if (it == null) return@constrain true
                    // If one is set, the other must be set too
                    val hasFrom = !it.from.isNullOrBlank()
                    val hasTo = !it.to.isNullOrBlank()
                    // Both empty is ok, both set is ok, only one set is not ok
                    (hasFrom == hasTo)
                }
            }
        }
    }
}
