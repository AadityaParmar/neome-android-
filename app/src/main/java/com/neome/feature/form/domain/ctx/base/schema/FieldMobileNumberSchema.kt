package com.neome.feature.form.domain.ctx.base.schema

import com.neome.api.meta.base.dto.DefnFieldMobileNumber
import com.neome.core.common.serializer.api.meta.base.dto.DefnCompSeal
import com.neome.feature.form.domain.DefnFormUi
import com.neome.core.common.serializer.api.meta.base.dto.FieldValueMobileData
import com.neome.feature.form.presentation.state.FieldProperties
import com.neome.feature.form.presentation.state.FieldState
import com.neome.feature.utils.JsonParser
import io.konform.validation.Invalid
import io.konform.validation.Validation
import kotlinx.serialization.json.JsonElement

/**
 * CompSchema implementation for FieldMobileNumber.
 *
 * Uses Konform library for type-safe, declarative validation.
 * Validations:
 * - required: value must not be blank
 * - Must start with "+"
 * - Must contain only numbers after "+"
 * - Basic phone format validation (regex-based)
 * - invalidCountryCodeSetVar: country code must not be in invalid set
 * - validCountryCodeSetVar: country code must be in valid set
 */
class FieldMobileNumberSchema(
    override val defnForm: DefnFormUi,
    override val defnComp: DefnCompSeal
) : CompSchema(defnForm, defnComp) {

    private val defnField = defnComp as DefnFieldMobileNumber

    override fun validate(fieldValue: JsonElement?, fieldState: FieldState?): String? {
        if (fieldValue == null) {
            val properties = fieldState?.fieldProperties ?: FieldProperties()
            return if (properties.required) "Required" else null
        }

        val typedValue = try {
            JsonParser.json.decodeFromJsonElement(
                FieldValueMobileData.serializer(),
                fieldValue
            )
        } catch (e: Exception) {
            null
        }

        val properties = fieldState?.fieldProperties ?: FieldProperties()
        val phoneValue = typedValue?.value?.trim() ?: ""

        val validation = buildValidation(properties, phoneValue.isEmpty())
        val result = validation(phoneValue)

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

            // Must start with "+"
            constrain("Must start with +") { phone ->
                phone.isEmpty() || phone.startsWith("+")
            }

            // Must contain only numbers after "+"
            constrain("Should contain only numbers") { phone ->
                if (phone.isEmpty()) return@constrain true
                PHONE_FORMAT_REGEX.matches(phone)
            }

            // Basic phone number validation - at least 7 digits after country code
            constrain("Invalid mobile number") { phone ->
                if (phone.isEmpty()) return@constrain true
                // Remove + and check if we have at least 7 digits
                val digits = phone.removePrefix("+")
                digits.length >= 7 && digits.length <= 15
            }

            // Invalid country code set validation
            defnField.invalidCountryCodeSetVar?.let { invalidCodes ->
                if (invalidCodes.isNotEmpty()) {
                    constrain("Invalid country code") { phone ->
                        if (phone.isEmpty()) return@constrain true
                        // Check if phone starts with any invalid country code
                        !invalidCodes.any { code -> phone.startsWith(code) }
                    }
                }
            }

            // Valid country code set validation
            defnField.validCountryCodeSetVar?.let { validCodes ->
                if (validCodes.isNotEmpty()) {
                    constrain("Invalid country code") { phone ->
                        if (phone.isEmpty()) return@constrain true
                        // Check if phone starts with any valid country code
                        validCodes.any { code -> phone.startsWith(code) }
                    }
                }
            }
        }
    }

    companion object {
        // Phone format: + followed by digits only
        private val PHONE_FORMAT_REGEX = Regex("^\\+[0-9]+$")
    }
}
