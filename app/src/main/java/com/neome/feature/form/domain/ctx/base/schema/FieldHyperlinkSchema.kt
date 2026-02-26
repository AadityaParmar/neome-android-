package com.neome.feature.form.domain.ctx.base.schema

import com.neome.api.meta.base.dto.DefnFieldHyperlink
import com.neome.core.common.serializer.api.meta.base.dto.DefnCompSeal
import com.neome.core.common.serializer.api.meta.base.dto.FieldValueTextData
import com.neome.feature.form.domain.model.DefnFormUi
import com.neome.feature.form.domain.util.FieldVal.FieldValueResolver
import com.neome.feature.form.presentation.state.FieldProperties
import com.neome.feature.form.presentation.state.FieldState
import io.konform.validation.Invalid
import io.konform.validation.Validation
import kotlinx.serialization.json.JsonElement

/**
 * CompSchema implementation for FieldHyperlink.
 *
 * Uses Konform library for type-safe, declarative validation.
 * Validations:
 * - required: value must not be blank
 * - URL format: must match URL regex pattern
 */
class FieldHyperlinkSchema(
    override val defnForm: DefnFormUi,
    override val defnComp: DefnCompSeal
) : CompSchema(defnForm, defnComp) {

    private val defnField = defnComp as DefnFieldHyperlink

    override fun validate(fieldValue: JsonElement?, fieldState: FieldState?): String? {
        val typedValue = FieldValueResolver.fnJsonElementFieldValue(
            defnField.type,
            fieldValue
        ) as FieldValueTextData?
        val properties = fieldState?.fieldProperties ?: FieldProperties()

        val urlValue = typedValue?.value ?: ""

        val validation = buildValidation(properties, urlValue.isEmpty())
        val result = validation(urlValue)

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

            // URL format validation
            constrain("Not valid url") { url ->
                url.isEmpty() || URL_REGEX.matches(url)
            }
        }
    }

    companion object {
        // URL pattern: optional protocol, domain with dots, optional path
        private val URL_REGEX = Regex(
            "^(https?://)?" +                    // Optional protocol
                "([a-zA-Z0-9-]+\\.)+" +      // Domain parts
                "[a-zA-Z]{2,}" +             // TLD
                "(/\\S*)?$"                  // Optional path
        )
    }
}
