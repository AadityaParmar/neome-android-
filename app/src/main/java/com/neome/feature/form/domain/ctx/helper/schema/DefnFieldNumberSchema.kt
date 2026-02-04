package com.neome.feature.form.domain.ctx.helper.schema

import com.neome.api.meta.base.dto.DefnFieldNumber
import com.neome.core.common.serializer.api.meta.base.dto.DefnCompSeal
import com.neome.core.common.serializer.api.meta.base.dto.DefnFormData
import com.neome.core.common.serializer.api.meta.base.dto.FieldValueNumberData
import com.neome.feature.form.domain.util.FieldValueResolver
import com.neome.feature.form.presentation.state.FieldState
import kotlinx.serialization.json.JsonElement


/**
 * CompSchema implementation for FieldNumber

 */
class DefnFieldNumberSchema(override val defnForm: DefnFormData, override val defnComp: DefnCompSeal) :
    DefnCompSchema(defnForm, defnComp) {


    /**
     * Pure validation that returns an error message without side effects.
     */
    override fun validatePure(fieldValue: JsonElement?, fieldState: FieldState?): String? {
        val defnField = defnComp as DefnFieldNumber
        val typedValue =
            FieldValueResolver.fnJsonElementFieldValue(defnField.type, fieldValue) as FieldValueNumberData?
        val fieldProperties = fieldState?.fieldProperties

        if (fieldProperties?.required == true) {
            if (typedValue == null) {
                return "Required"
            }
        }

        return null
    }
}
