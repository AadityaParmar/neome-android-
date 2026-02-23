package com.neome.feature.form.domain.ctx.base.schema

import com.neome.api.meta.base.dto.DefnFieldScanCode
import com.neome.core.common.serializer.api.meta.base.dto.DefnCompSeal
import com.neome.feature.form.domain.DefnFormUi
import com.neome.core.common.serializer.api.meta.base.dto.FieldValueScanCodeData
import com.neome.feature.form.presentation.state.FieldProperties
import com.neome.feature.form.presentation.state.FieldState
import com.neome.feature.utils.JsonParser
import io.konform.validation.Invalid
import io.konform.validation.Validation
import kotlinx.serialization.json.JsonElement

/**
 * CompSchema implementation for FieldScanCode.
 *
 * Uses Konform library for type-safe, declarative validation.
 * Validations:
 * - required: scanCode must be defined
 * - captureLocation: location must be captured if required
 * - captureTime: time must be captured if required
 * - captureUser: user must be captured if required
 */
class FieldScanCodeSchema(
    override val defnForm: DefnFormUi,
    override val defnComp: DefnCompSeal
) : CompSchema(defnForm, defnComp) {

    private val defnField = defnComp as DefnFieldScanCode

    override fun validate(fieldValue: JsonElement?, fieldState: FieldState?): String? {
        if (fieldValue == null) {
            val properties = fieldState?.fieldProperties ?: FieldProperties()
            return if (properties.required) "Required" else null
        }

        val typedValue = try {
            JsonParser.json.decodeFromJsonElement(
                FieldValueScanCodeData.serializer(),
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

    private fun buildValidation(properties: FieldProperties): Validation<FieldValueScanCodeData?> {
        return Validation {
            // Required check - scanCode must be defined
            if (properties.required) {
                constrain("Required") {
                    it != null && it.scanCode.isNotBlank()
                }
            }

            // Capture value validations - only when value is present and required
            if (properties.required) {
                constrain("capture validation") { value ->
                    if (value == null) return@constrain true

                    val captureErrors = mutableListOf<String>()

                    if (defnField.captureTime == true && value.captureTime.isNullOrBlank()) {
                        captureErrors.add("Time")
                    }
                    if (defnField.captureLocation == true && value.captureLocation?.value?.geoPoint == null) {
                        captureErrors.add("Location")
                    }
                    if (defnField.captureUser == true && value.captureUser?.value == null) {
                        captureErrors.add("User value")
                    }

                    captureErrors.isEmpty()
                }
            }
        }
    }
}
