package com.neome.feature.form.domain.ctx.base.schema

import com.neome.api.meta.base.dto.DefnFieldSlider
import com.neome.core.common.serializer.api.meta.base.dto.DefnCompSeal
import com.neome.feature.form.domain.DefnFormUi
import com.neome.feature.form.presentation.state.FieldProperties
import com.neome.feature.form.presentation.state.FieldState
import com.neome.feature.utils.JsonParser
import io.konform.validation.Invalid
import io.konform.validation.Validation
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement

/**
 * CompSchema implementation for FieldSlider.
 *
 * Uses Konform library for type-safe, declarative validation.
 * Validations:
 * - required: value must be present
 * - minValue: slider min value must be >= field min
 * - maxValue: slider max value must be <= field max and >= field min
 */
class FieldSliderSchema(
    override val defnForm: DefnFormUi,
    override val defnComp: DefnCompSeal
) : CompSchema(defnForm, defnComp) {

    private val defnField = defnComp as DefnFieldSlider

    override fun validate(fieldValue: JsonElement?, fieldState: FieldState?): String? {
        if (fieldValue == null) {
            val properties = fieldState?.fieldProperties ?: FieldProperties()
            return if (properties.required) "Required" else null
        }

        val typedValue = try {
            JsonParser.json.decodeFromJsonElement(
                SliderValue.serializer(),
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

    private fun buildValidation(properties: FieldProperties): Validation<SliderValue?> {
        return Validation {
            // Required check
            if (properties.required) {
                constrain("Required") {
                    it != null
                }
            }

            // Min value validation - slider minValue must be >= field min
            properties.minNumber?.let { min ->
                constrain("Value can't be less than $min") { value ->
                    if (value?.minValue == null) return@constrain true
                    value.minValue >= min
                }
            }

            // Max value validation - slider maxValue must be <= field max
            properties.maxNumber?.let { max ->
                constrain("Value can't be greater than $max") { value ->
                    if (value?.maxValue == null) return@constrain true
                    value.maxValue <= max
                }
            }

            // Max value must also be >= min
            properties.minNumber?.let { min ->
                constrain("Value can't be less than $min") { value ->
                    if (value?.maxValue == null) return@constrain true
                    value.maxValue >= min
                }
            }
        }
    }

    /**
     * Internal data class for Slider value structure.
     */
    @Serializable
    private data class SliderValue(
        val minValue: Long? = null,
        val maxValue: Long? = null
    )
}
