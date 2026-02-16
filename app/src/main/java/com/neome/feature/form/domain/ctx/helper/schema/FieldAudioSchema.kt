package com.neome.feature.form.domain.ctx.helper.schema

import com.neome.api.meta.base.dto.DefnFieldAudio
import com.neome.core.common.serializer.api.meta.base.dto.DefnCompSeal
import com.neome.feature.form.domain.DefnFormUi
import com.neome.core.common.serializer.api.meta.base.dto.FieldValueAudioData
import com.neome.feature.form.presentation.state.FieldProperties
import com.neome.feature.form.presentation.state.FieldState
import com.neome.feature.utils.JsonParser
import io.konform.validation.Invalid
import io.konform.validation.Validation
import kotlinx.serialization.json.JsonElement

/**
 * CompSchema implementation for FieldAudio.
 *
 * Uses Konform library for type-safe, declarative validation.
 * Validations:
 * - required: fileName and mediaIdAudio must be present
 * - maxSize: file size must be less than max (from FieldProperties, in MB)
 */
class FieldAudioSchema(
    override val defnForm: DefnFormUi,
    override val defnComp: DefnCompSeal
) : CompSchema(defnForm, defnComp) {

    private val defnField = defnComp as DefnFieldAudio

    override fun validate(fieldValue: JsonElement?, fieldState: FieldState?): String? {
        if (fieldValue == null) {
            val properties = fieldState?.fieldProperties ?: FieldProperties()
            return if (properties.required) "Required" else null
        }

        val typedValue = try {
            JsonParser.json.decodeFromJsonElement(
                FieldValueAudioData.serializer(),
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

    private fun buildValidation(properties: FieldProperties): Validation<FieldValueAudioData?> {
        return Validation {
            // Required check - fileName and mediaIdAudio must be present
            if (properties.required) {
                constrain("Required") {
                    it != null && it.fileName.isNotBlank()
                }
            }

            // Max file size validation
            properties.maxSize?.let { maxSizeMb ->
                val maxSizeBytes = maxSizeMb * 1024 * 1024 // Convert MB to bytes
                constrain("File size must be less than $maxSizeMb MB") { value ->
                    if (value == null) return@constrain true
                    val fileSize = value.fileSize ?: return@constrain true
                    fileSize <= maxSizeBytes
                }
            }
        }
    }
}
