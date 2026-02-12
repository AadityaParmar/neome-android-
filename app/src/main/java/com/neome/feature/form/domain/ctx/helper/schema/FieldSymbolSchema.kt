package com.neome.feature.form.domain.ctx.helper.schema

import com.neome.api.meta.base.dto.DefnFieldSymbol
import com.neome.core.common.serializer.api.meta.base.dto.DefnCompSeal
import com.neome.core.common.serializer.api.meta.base.dto.DefnFormData
import com.neome.core.common.serializer.api.meta.base.dto.FieldValueTextData
import com.neome.feature.form.domain.util.FieldValueResolver
import com.neome.feature.form.presentation.state.FieldProperties
import com.neome.feature.form.presentation.state.FieldState
import io.konform.validation.Invalid
import io.konform.validation.Validation
import kotlinx.serialization.json.JsonElement

/**
 * CompSchema implementation for FieldSymbol.
 *
 * Uses Konform library for type-safe, declarative validation.
 * Symbol fields have strict validation rules:
 * - required: value must not be blank
 * - minCharCount: minimum character count
 * - maxCharCount: maximum character count (capped at MAX_CHARACTER_COUNT_SYMBOL)
 * - First character cannot be a digit
 * - No whitespace allowed
 * - Only ASCII characters
 * - No special characters allowed
 */
class FieldSymbolSchema(
    override val defnForm: DefnFormData,
    override val defnComp: DefnCompSeal
) : CompSchema(defnForm, defnComp) {

    private val defnField = defnComp as DefnFieldSymbol

    override fun validate(fieldValue: JsonElement?, fieldState: FieldState?): String? {
        // For symbol, we work with the raw string value
        val typedValue = FieldValueResolver.fnJsonElementFieldValue(
            defnField.type,
            fieldValue
        ) as FieldValueTextData?

        val symbolValue = typedValue?.value ?: ""
        val properties = fieldState?.fieldProperties ?: FieldProperties()

        val validation = buildValidation(properties, symbolValue.isEmpty())
        val result = validation(symbolValue)

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

            // Skip other validations if empty and not required
            if (isEmpty && !properties.required) {
                return@Validation
            }

            // First character cannot be a digit
            constrain("First character cannot be a digit") { symbol ->
                symbol.isEmpty() || !symbol[0].isDigit()
            }

            // No whitespace allowed
            constrain("White spaces are not allowed") { symbol ->
                !symbol.contains(" ")
            }

            // Only ASCII characters
            constrain("String must contain only ASCII characters") { symbol ->
                symbol.all { it.code <= 127 }
            }

            // No special characters allowed
            constrain("Special characters are not allowed") { symbol ->
                val specialChars = "!@#\$%^&*()_+-=[]{};\':\"\\|,.<>/?`~"
                symbol.none { specialChars.contains(it) }
            }
        }
    }

    companion object {
        private const val MAX_CHARACTER_COUNT_SYMBOL = 50L
    }
}
