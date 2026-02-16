package com.neome.feature.form.domain.ctx.helper.schema

import com.neome.api.meta.base.Types.EnumDefnTextValidationPattern
import com.neome.api.meta.base.dto.DefnFieldText
import com.neome.core.common.serializer.api.meta.base.dto.DefnCompSeal
import com.neome.feature.form.domain.DefnFormUi
import com.neome.core.common.serializer.api.meta.base.dto.FieldValueTextData
import com.neome.feature.form.domain.util.FieldVal.FieldValueResolver
import com.neome.feature.form.presentation.state.FieldProperties
import com.neome.feature.form.presentation.state.FieldState
import io.konform.validation.Invalid
import io.konform.validation.Validation
import kotlinx.serialization.json.JsonElement


/**
 * CompSchema implementation for FieldText.
 *
 * Uses Konform library for type-safe, declarative validation.
 * Validations are applied dynamically based on FieldProperties:
 * - required: value must not be blank
 * - minCharCount: minimum character count (if not null)
 * - maxCharCount: maximum character count (if not null)
 * - validationPattern: regex pattern from DefnFieldText (aadhaar, gstin, pan, or custom)
 */
class FieldTextSchema(override val defnForm: DefnFormUi, override val defnComp: DefnCompSeal) :
    CompSchema(defnForm, defnComp) {

    private val defnField = defnComp as DefnFieldText

    /**
     * Pure validation that returns an error message without side effects.
     */
    override fun validate(fieldValue: JsonElement?, fieldState: FieldState?): String? {
        val typedValue =
            FieldValueResolver.fnJsonElementFieldValue(defnField.type, fieldValue) as FieldValueTextData?
        val properties = fieldState?.fieldProperties ?: FieldProperties()

        // Get the text value (empty string if null)
        val textValue = typedValue?.value ?: ""

        // Build and execute Konform validation
        val validation = buildValidation(properties, textValue.isEmpty())
        val result = validation(textValue)

        // Return first error message or null if valid
        return if (result is Invalid) {
            result.errors.firstOrNull()?.message
        } else {
            null
        }
    }

    /**
     * Build Konform validation dynamically based on FieldProperties.
     * Only applies validations for non-null constraint values.
     *
     * @param properties The resolved field properties
     * @param isEmpty Whether the current value is empty (for skipping validations on empty non-required fields)
     */
    private fun buildValidation(properties: FieldProperties, isEmpty: Boolean): Validation<String> {
        return Validation {
            // Required check - value must not be blank
            if (properties.required) {
                constrain("Required") { it.isNotBlank() }
            }

            // Skip other validations if value is empty and not required
            if (isEmpty && !properties.required) {
                return@Validation
            }

            // Min char count (only if not null)
            properties.minCharCount?.let { min ->
                constrain("Must be at least $min characters") { it.length >= min }
            }

            // Max char count (only if not null)
            properties.maxCharCount?.let { max ->
                constrain("Must be at most $max characters") { it.length <= max }
            }

            // Validation pattern from DefnFieldText (not from FieldProperties)
            defnField.validationPattern?.let { pattern ->
                when (pattern.value) {
                    EnumDefnTextValidationPattern.aadhaar -> {
                        constrain("Invalid Aadhaar number") { AADHAAR_REGEX.matches(it) }
                    }

                    EnumDefnTextValidationPattern.gstin -> {
                        constrain("Invalid GSTIN") { GSTIN_REGEX.matches(it) }
                    }

                    EnumDefnTextValidationPattern.pan -> {
                        constrain("Invalid PAN") { PAN_REGEX.matches(it) }
                    }

                    null -> {
                        // Check for custom pattern
                        pattern.customValue?.let { customRegex ->
                            val regex = Regex(customRegex)
                            constrain("Invalid format") { regex.matches(it) }
                        }
                    }
                }
            }
        }
    }

    companion object {
        // Indian ID regex patterns
        private val AADHAAR_REGEX = Regex("^[2-9][0-9]{11}$")
        private val GSTIN_REGEX = Regex("^[0-9]{2}[A-Z]{5}[0-9]{4}[A-Z][1-9A-Z]Z[0-9A-Z]$")
        private val PAN_REGEX = Regex("^[A-Z]{5}[0-9]{4}[A-Z]$")
    }
}
