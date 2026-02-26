package com.neome.feature.form.domain.ctx.base.schema

import com.neome.core.common.serializer.api.meta.base.dto.DefnCompSeal
import com.neome.feature.form.domain.model.DefnFormUi
import com.neome.feature.form.presentation.state.FieldProperties
import com.neome.feature.form.presentation.state.FieldState
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.jsonPrimitive

/**
 * CompSchema implementation for FieldCurrency (pickEnum).
 *
 * Uses Konform library for type-safe, declarative validation.
 * Validations:
 * - required: value must not be null/empty
 */
class FieldCurrencySchema(
    override val defnForm: DefnFormUi,
    override val defnComp: DefnCompSeal
) : CompSchema(defnForm, defnComp) {

//    private val defnField = defnComp as DefnFieldPickEnum

    override fun validate(fieldValue: JsonElement?, fieldState: FieldState?): String? {
        val properties = fieldState?.fieldProperties ?: FieldProperties()

        // Extract string value from JsonElement
        val stringValue = fieldValue?.let {
            if (it is JsonElement && it.jsonPrimitive.content.isNotEmpty()) {
                it.jsonPrimitive.content
            } else {
                null
            }
        }

        // Required validation
        if (properties.required && stringValue.isNullOrEmpty()) {
            return "Required"
        }

        return null
    }
}
