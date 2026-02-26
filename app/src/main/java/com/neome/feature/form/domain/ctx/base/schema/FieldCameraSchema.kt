package com.neome.feature.form.domain.ctx.base.schema

import com.neome.api.meta.base.dto.DefnFieldCamera
import com.neome.core.common.serializer.api.meta.base.dto.DefnCompSeal
import com.neome.feature.form.domain.model.DefnFormUi
import com.neome.core.common.serializer.api.meta.base.dto.FieldValueCameraData
import com.neome.feature.form.presentation.state.FieldProperties
import com.neome.feature.form.presentation.state.FieldState
import com.neome.feature.utils.JsonParser
import io.konform.validation.Invalid
import io.konform.validation.Validation
import kotlinx.serialization.json.JsonElement

/**
 * CompSchema implementation for FieldCamera.
 *
 * Uses Konform library for type-safe, declarative validation.
 * Validations:
 * - required: value must be present
 * - maxSize: file size must be less than max (from FieldProperties, in MB)
 * - captureLocation: location must be captured if required
 * - captureTime: time must be captured if required
 * - captureUser: user must be captured if required
 */
class FieldCameraSchema(
    override val defnForm: DefnFormUi,
    override val defnComp: DefnCompSeal
) : CompSchema(defnForm, defnComp) {

    private val defnField = defnComp as DefnFieldCamera

    override fun validate(fieldValue: JsonElement?, fieldState: FieldState?): String? {
        if (fieldValue == null) {
            val properties = fieldState?.fieldProperties ?: FieldProperties()
            return if (properties.required) "Required" else null
        }

        val typedValue = try {
            JsonParser.json.decodeFromJsonElement(
                FieldValueCameraData.serializer(),
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

    private fun buildValidation(properties: FieldProperties): Validation<FieldValueCameraData?> {
        return Validation {
            // Required check
            if (properties.required) {
                constrain("Required") {
                    it != null
                }
            }

            // Max file size validation
            properties.maxSize?.let { maxSizeMb ->
                val maxSizeBytes = maxSizeMb * 1024 * 1024 // Convert MB to bytes
                constrain("File size must be less than $maxSizeMb MB") { value ->
                    if (value == null) return@constrain true
                    val fileSize = value.value.size ?: return@constrain true
                    fileSize <= maxSizeBytes
                }
            }

            // Capture value validations - only when value is present and required
            if (properties.required) {
                // Build capture validation error message
                val captureErrors = mutableListOf<String>()

                constrain("capture validation") { value ->
                    if (value == null) return@constrain true

                    captureErrors.clear()

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
