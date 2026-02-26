package com.neome.feature.form.domain.ctx.base.schema

import com.neome.api.meta.base.dto.DefnFieldParagraph
import com.neome.core.common.serializer.api.meta.base.dto.DefnCompSeal
import com.neome.feature.form.domain.model.DefnFormUi
import com.neome.core.common.serializer.api.meta.base.dto.FieldValueParagraphData
import com.neome.feature.form.domain.util.FieldVal.FieldValueResolver
import com.neome.feature.form.presentation.state.FieldProperties
import com.neome.feature.form.presentation.state.FieldState
import io.konform.validation.Invalid
import io.konform.validation.Validation
import kotlinx.serialization.json.JsonElement

/**
 * CompSchema implementation for FieldParagraph.
 *
 * Uses Konform library for type-safe, declarative validation.
 * Validations are applied dynamically based on FieldProperties:
 * - required: value must not be blank
 * - minCharCount: minimum character count (if not null)
 * - maxCharCount: maximum character count (if not null)
 */
class FieldParagraphSchema(
    override val defnForm: DefnFormUi,
    override val defnComp: DefnCompSeal
) : CompSchema(defnForm, defnComp) {

    private val defnField = defnComp as DefnFieldParagraph

    override fun validate(fieldValue: JsonElement?, fieldState: FieldState?): String? {
        val typedValue = FieldValueResolver.fnJsonElementFieldValue(
            defnField.type,
            fieldValue
        ) as FieldValueParagraphData?
        val properties = fieldState?.fieldProperties ?: FieldProperties()

        val textValue = typedValue?.value ?: ""

        val validation = buildValidation(properties, textValue.isEmpty())
        val result = validation(textValue)

        return if (result is Invalid) {
            result.errors.firstOrNull()?.message
        } else {
            null
        }
    }

    private fun buildValidation(properties: FieldProperties, isEmpty: Boolean): Validation<String> {
        return Validation {
            // Required check
            if (properties.required) {
                constrain("Required") { it.isNotBlank() }
            }

            // Skip other validations if value is empty and not required
            if (isEmpty && !properties.required) {
                return@Validation
            }

            // Min char count
            properties.minCharCount?.let { min ->
                constrain("Must be at least $min characters") { it.length >= min }
            }

            // Max char count
            properties.maxCharCount?.let { max ->
                constrain("Must be at most $max characters") { it.length <= max }
            }
        }
    }
}
