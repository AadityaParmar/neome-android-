package com.neome.feature.form.domain.ctx.base.schema

import com.neome.api.meta.base.Types.EnumDefnDurationUnit
import com.neome.api.meta.base.dto.DefnFieldDuration
import com.neome.core.common.serializer.api.meta.base.dto.DefnCompSeal
import com.neome.feature.form.domain.model.DefnFormUi
import com.neome.core.common.serializer.api.meta.base.dto.FieldDtoDurationData
import com.neome.core.common.serializer.api.meta.base.dto.FieldValueDurationData
import com.neome.feature.form.presentation.state.FieldProperties
import com.neome.feature.form.presentation.state.FieldState
import com.neome.feature.utils.JsonParser
import io.konform.validation.Invalid
import io.konform.validation.Validation
import kotlinx.serialization.json.JsonElement

/**
 * CompSchema implementation for FieldDuration.
 *
 * Uses Konform library for type-safe, declarative validation.
 * Validations:
 * - required: value and unit must be present
 * - Duration required: unit without value is invalid
 * - Unit required: value without unit is invalid
 * - minDuration: duration must be >= min (from DefnFieldDuration)
 * - maxDuration: duration must be <= max (from DefnFieldDuration)
 */
class FieldDurationSchema(
    override val defnForm: DefnFormUi,
    override val defnComp: DefnCompSeal
) : CompSchema(defnForm, defnComp) {

    private val defnField = defnComp as DefnFieldDuration

    override fun validate(fieldValue: JsonElement?, fieldState: FieldState?): String? {
        if (fieldValue == null) {
            val properties = fieldState?.fieldProperties ?: FieldProperties()
            return if (properties.required) "Required" else null
        }

        val typedValue = try {
            JsonParser.json.decodeFromJsonElement(
                FieldValueDurationData.serializer(),
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

    private fun buildValidation(properties: FieldProperties): Validation<FieldValueDurationData?> {
        return Validation {
            // Required check - both value and unit must be present
            if (properties.required) {
                constrain("Required") {
                    it != null && it.value.value != null && it.value.unit != null
                }
            }

            // Duration required - unit without value is invalid
            constrain("Duration required") { value ->
                if (value == null) return@constrain true
                // If unit is set but value is not, that's invalid
                !(value.value.value == null && value.value.unit != null)
            }

            // Unit required - value without unit is invalid
            constrain("Unit required") { value ->
                if (value == null) return@constrain true
                // If value is set but unit is not, that's invalid
                !(value.value.value != null && value.value.unit == null)
            }

            // Min duration validation
            defnField.min?.let { minDuration ->
                val minSeconds = getDurationInSeconds(minDuration)
                constrain("Duration must be greater than ${minDuration.value} ${minDuration.unit}") { value ->
                    if (value?.value?.value == null || value.value.unit == null) return@constrain true
                    val valueSeconds = getDurationInSeconds(value.value)
                    valueSeconds >= minSeconds
                }
            }

            // Max duration validation
            defnField.max?.let { maxDuration ->
                val maxSeconds = getDurationInSeconds(maxDuration)
                constrain("Duration must be less than ${maxDuration.value} ${maxDuration.unit}") { value ->
                    if (value?.value?.value == null || value.value.unit == null) return@constrain true
                    val valueSeconds = getDurationInSeconds(value.value)
                    valueSeconds <= maxSeconds
                }
            }
        }
    }

    /**
     * Convert duration to seconds for comparison.
     */
    private fun getDurationInSeconds(duration: FieldDtoDurationData): Long {
        val value = duration.value ?: return 0
        return when (duration.unit) {
            EnumDefnDurationUnit.seconds -> value
            EnumDefnDurationUnit.minutes -> value * 60
            EnumDefnDurationUnit.hours -> value * 60 * 60
            EnumDefnDurationUnit.days -> value * 60 * 60 * 24
            EnumDefnDurationUnit.weeks -> value * 60 * 60 * 24 * 7
            EnumDefnDurationUnit.months -> value * 60 * 60 * 24 * 30
            EnumDefnDurationUnit.quarters -> value * 60 * 60 * 24 * 90
            EnumDefnDurationUnit.years -> value * 60 * 60 * 24 * 365
            null -> 0
        }
    }

    private fun getDurationInSeconds(duration: com.neome.api.meta.base.dto.FieldDtoDuration): Long {
        val value = duration.value ?: return 0
        return when (duration.unit) {
            EnumDefnDurationUnit.seconds -> value
            EnumDefnDurationUnit.minutes -> value * 60
            EnumDefnDurationUnit.hours -> value * 60 * 60
            EnumDefnDurationUnit.days -> value * 60 * 60 * 24
            EnumDefnDurationUnit.weeks -> value * 60 * 60 * 24 * 7
            EnumDefnDurationUnit.months -> value * 60 * 60 * 24 * 30
            EnumDefnDurationUnit.quarters -> value * 60 * 60 * 24 * 90
            EnumDefnDurationUnit.years -> value * 60 * 60 * 24 * 365
            null -> 0
        }
    }
}
