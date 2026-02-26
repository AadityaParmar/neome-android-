package com.neome.feature.form.domain.ctx.base.schema

import com.neome.api.meta.base.dto.DefnFieldPickTree
import com.neome.core.common.serializer.api.meta.base.dto.DefnCompSeal
import com.neome.feature.form.domain.model.DefnFormUi
import com.neome.core.common.serializer.api.meta.base.dto.FieldValueOptionIdData
import com.neome.feature.form.presentation.state.FieldProperties
import com.neome.feature.form.presentation.state.FieldState
import com.neome.feature.utils.JsonParser
import io.konform.validation.Invalid
import io.konform.validation.Validation
import kotlinx.serialization.json.JsonElement

/**
 * CompSchema implementation for FieldPickTree.
 *
 * Uses Konform library for type-safe, declarative validation.
 * Validations:
 * - required: optionId must be present
 */
class FieldPickTreeSchema(
    override val defnForm: DefnFormUi,
    override val defnComp: DefnCompSeal
) : CompSchema(defnForm, defnComp) {

    private val defnField = defnComp as DefnFieldPickTree

    override fun validate(fieldValue: JsonElement?, fieldState: FieldState?): String? {
        if (fieldValue == null) {
            val properties = fieldState?.fieldProperties ?: FieldProperties()
            return if (properties.required) "Required" else null
        }

        val typedValue = try {
            JsonParser.json.decodeFromJsonElement(
                FieldValueOptionIdData.serializer(),
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

    private fun buildValidation(properties: FieldProperties): Validation<FieldValueOptionIdData?> {
        return Validation {
            // Required check - optionId must be present
            if (properties.required) {
                constrain("Required") {
                    it != null && it.optionId.isNotBlank()
                }
            }
        }
    }
}
