package com.neome.feature.form.domain.ctx.base.schema

import com.neome.api.meta.base.dto.DefnFieldHandle
import com.neome.core.common.serializer.api.meta.base.dto.DefnCompSeal
import com.neome.feature.form.domain.DefnFormUi
import com.neome.core.common.serializer.api.meta.base.dto.FieldValueHandleData
import com.neome.feature.form.presentation.state.FieldProperties
import com.neome.feature.form.presentation.state.FieldState
import com.neome.feature.utils.JsonParser
import io.konform.validation.Invalid
import io.konform.validation.Validation
import kotlinx.serialization.json.JsonElement

/**
 * CompSchema implementation for FieldHandle.
 *
 * Handle field accepts either email or mobile number.
 * Uses lazy validation: if value starts with "+" or is numeric only, validates as mobile.
 * Otherwise, validates as email.
 *
 * Validations:
 * - required: value must not be blank
 * - Email validation: if value contains "@"
 * - Mobile validation: if value starts with "+" or is numeric
 */
class FieldHandleSchema(
    override val defnForm: DefnFormUi,
    override val defnComp: DefnCompSeal
) : CompSchema(defnForm, defnComp) {

    private val defnField = defnComp as DefnFieldHandle

    override fun validate(fieldValue: JsonElement?, fieldState: FieldState?): String? {
        if (fieldValue == null) {
            val properties = fieldState?.fieldProperties ?: FieldProperties()
            return if (properties.required) "Required" else null
        }

        val typedValue = try {
            JsonParser.json.decodeFromJsonElement(
                FieldValueHandleData.serializer(),
                fieldValue
            )
        } catch (e: Exception) {
            null
        }

        val properties = fieldState?.fieldProperties ?: FieldProperties()
        val handleValue = typedValue?.value?.trim() ?: ""

        // Determine if this is mobile or email
        val isMobile = handleValue.isNotEmpty() &&
            (handleValue.startsWith("+") ||
                (handleValue.all { it.isDigit() } && !handleValue.contains("@")))

        val validation = if (isMobile) {
            buildMobileValidation(properties, handleValue.isEmpty())
        } else {
            buildEmailValidation(properties, handleValue.isEmpty())
        }

        val result = validation(handleValue)

        return if (result is Invalid) {
            result.errors.firstOrNull()?.message
        } else {
            null
        }
    }

    private fun buildEmailValidation(properties: FieldProperties, isEmpty: Boolean): Validation<String> {
        return Validation {
            // Required check
            if (properties.required) {
                constrain("Required") { it.isNotBlank() }
            }

            // Skip other validations if empty and not required
            if (isEmpty && !properties.required) {
                return@Validation
            }

            // Email format validation
            constrain("Must be a valid email") { email ->
                email.isEmpty() || EMAIL_REGEX.matches(email)
            }

            // Valid domain set validation from DefnFieldHandle
            defnField.validDomainSetVar?.let { validDomains ->
                if (validDomains.isNotEmpty()) {
                    constrain("Must be a valid domain") { email ->
                        if (email.isEmpty()) return@constrain true
                        val domain = email.substringAfter("@", "")
                        domain.isNotEmpty() && validDomains.contains(domain)
                    }
                }
            }

            // Invalid domain set validation from DefnFieldHandle
            defnField.invalidDomainSetVar?.let { invalidDomains ->
                if (invalidDomains.isNotEmpty()) {
                    constrain("Must be a valid domain") { email ->
                        if (email.isEmpty()) return@constrain true
                        val domain = email.substringAfter("@", "")
                        domain.isEmpty() || !invalidDomains.contains(domain)
                    }
                }
            }
        }
    }

    private fun buildMobileValidation(properties: FieldProperties, isEmpty: Boolean): Validation<String> {
        return Validation {
            // Required check
            if (properties.required) {
                constrain("Required") { it.isNotBlank() }
            }

            // Skip other validations if empty and not required
            if (isEmpty && !properties.required) {
                return@Validation
            }

            // Basic phone number validation
            constrain("Invalid mobile number") { phone ->
                if (phone.isEmpty()) return@constrain true
                // For handle field, we allow numeric only (without +)
                // or with + prefix followed by digits
                val isValidFormat = PHONE_FORMAT_REGEX.matches(phone) ||
                    phone.all { it.isDigit() }
                if (!isValidFormat) return@constrain false

                // Check minimum length (at least 7 digits)
                val digits = phone.removePrefix("+")
                digits.length >= 7 && digits.length <= 15
            }

            // Invalid country code set validation from DefnFieldHandle
            defnField.invalidMobileCountryCodeSetVar?.let { invalidCodes ->
                if (invalidCodes.isNotEmpty()) {
                    constrain("Invalid country code") { phone ->
                        if (phone.isEmpty() || !phone.startsWith("+")) return@constrain true
                        !invalidCodes.any { code -> phone.startsWith(code) }
                    }
                }
            }

            // Valid country code set validation from DefnFieldHandle
            defnField.validMobileCountryCodeSetVar?.let { validCodes ->
                if (validCodes.isNotEmpty()) {
                    constrain("Invalid country code") { phone ->
                        if (phone.isEmpty() || !phone.startsWith("+")) return@constrain true
                        validCodes.any { code -> phone.startsWith(code) }
                    }
                }
            }
        }
    }

    companion object {
        private val EMAIL_REGEX = Regex("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")
        private val PHONE_FORMAT_REGEX = Regex("^\\+[0-9]+$")
    }
}
