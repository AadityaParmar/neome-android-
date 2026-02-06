package com.neome.feature.form.domain.ctx.helper.schema

import com.neome.api.meta.base.dto.DefnFieldOtp
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
 * CompSchema implementation for FieldOtp.
 *
 * Uses Konform library for type-safe, declarative validation.
 * Validations:
 * - OTP length must equal otpDigitSize (from DefnFieldOtp)
 */
class FieldOtpSchema(
    override val defnForm: DefnFormData,
    override val defnComp: DefnCompSeal
) : CompSchema(defnForm, defnComp) {

    private val defnField = defnComp as DefnFieldOtp

    override fun validate(fieldValue: JsonElement?, fieldState: FieldState?): String? {
        val typedValue = FieldValueResolver.fnJsonElementFieldValue(
            defnField.type,
            fieldValue
        ) as FieldValueTextData?

        val otpValue = typedValue?.value ?: ""

        val validation = buildValidation()
        val result = validation(otpValue)

        return if (result is Invalid) {
            result.errors.firstOrNull()?.message
        } else {
            null
        }
    }

    private fun buildValidation(): Validation<String> {
        val digitSize = defnField.otpDigitSize ?: 6 // Default to 6 digits

        return Validation {
            // OTP must have exact digit size
            constrain("Must be $digitSize digits") { otp ->
                otp.isNotEmpty() && otp.length == digitSize.toInt()
            }

            // OTP must contain only digits
            constrain("Must contain only digits") { otp ->
                otp.isEmpty() || otp.all { it.isDigit() }
            }
        }
    }
}
