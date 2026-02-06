package com.neome.feature.form.domain.ctx.helper.schema

import com.neome.api.meta.base.dto.DefnFieldEmail
import com.neome.core.common.serializer.api.meta.base.dto.DefnCompSeal
import com.neome.core.common.serializer.api.meta.base.dto.DefnFormData
import com.neome.core.common.serializer.api.meta.base.dto.FieldValueEmailData
import com.neome.feature.form.domain.util.FieldValueResolver
import com.neome.feature.form.presentation.state.FieldProperties
import com.neome.feature.form.presentation.state.FieldState
import io.konform.validation.Invalid
import io.konform.validation.Validation
import kotlinx.serialization.json.JsonElement

/**
 * CompSchema implementation for FieldEmail.
 *
 * Uses Konform library for type-safe, declarative validation.
 * Validations are applied dynamically based on FieldProperties:
 * - required: value must not be blank
 * - email format: must match email regex
 * - validDomainSetVar: domain must be in valid set (from DefnFieldEmail)
 * - invalidDomainSetVar: domain must not be in invalid set (from DefnFieldEmail)
 */
class FieldEmailSchema(
    override val defnForm: DefnFormData,
    override val defnComp: DefnCompSeal
) : CompSchema(defnForm, defnComp) {

    private val defnField = defnComp as DefnFieldEmail

    override fun validate(fieldValue: JsonElement?, fieldState: FieldState?): String? {
        val typedValue = FieldValueResolver.fnJsonElementFieldValue(
            defnField.type,
            fieldValue
        ) as FieldValueEmailData?
        val properties = fieldState?.fieldProperties ?: FieldProperties()

        val emailValue = typedValue?.value ?: ""

        val validation = buildValidation(properties, emailValue.isEmpty())
        val result = validation(emailValue)

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

            // Email format validation
            constrain("Must be a valid email") { email ->
                email.isEmpty() || EMAIL_REGEX.matches(email)
            }

            // Valid domain set validation
            defnField.validDomainSetVar?.let { validDomains ->
                if (validDomains.isNotEmpty()) {
                    constrain("Must be a valid domain") { email ->
                        if (email.isEmpty()) return@constrain true
                        val domain = email.substringAfter("@", "")
                        domain.isNotEmpty() && validDomains.contains(domain)
                    }
                }
            }

            // Invalid domain set validation
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

    companion object {
        private val EMAIL_REGEX = Regex(
            "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$"
        )
    }
}
