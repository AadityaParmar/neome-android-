package com.neome.feature.form.domain.ctx.base.schema

import com.neome.core.common.serializer.api.meta.base.dto.DefnCompSeal
import com.neome.feature.form.domain.DefnFormUi
import com.neome.feature.form.domain.util.FieldVal.FieldValueResolver
import com.neome.feature.form.presentation.state.FieldState
import kotlinx.serialization.json.JsonElement

/**
 * Base class for component validation schemas.
 *
 * Each field type has a concrete schema that implements [validate] as a pure function.
 * Schemas are created once at form initialization via [CompSchemaFactory] and reused
 * for the lifetime of the form.
 *
 * The [validate] method is side-effect-free -- it returns an error message (or null)
 * without modifying form state. Error map updates are handled by the caller
 * (e.g., [FormCtxValidationHelper] or [FormCtxEventHelper]).
 */
abstract class CompSchema(open val defnForm: DefnFormUi, open val defnComp: DefnCompSeal) {

    /**
     * Pure validation that returns an error message without side effects.
     *
     * @param fieldValue The current field value (from FormState.valueMap)
     * @param fieldState The current field state (includes computed properties like required)
     * @return Error message if validation fails, null if validation passes
     */
    abstract fun validate(fieldValue: JsonElement?, fieldState: FieldState?): String?

    protected fun isRequired(fieldValue: JsonElement?, fieldState: FieldState?): String? {
        val typedValue =
            FieldValueResolver.fnJsonElementFieldValue(defnComp.type, fieldValue)
        val fieldProperties = fieldState?.fieldProperties

        if (fieldProperties?.required == true) {
            if (typedValue == null) {
                return "Required"
            }
        }
        return null
    }
}
