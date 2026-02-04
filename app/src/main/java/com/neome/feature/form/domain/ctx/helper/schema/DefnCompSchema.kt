package com.neome.feature.form.domain.ctx.helper.schema

import com.neome.core.common.serializer.api.meta.base.dto.DefnCompSeal
import com.neome.core.common.serializer.api.meta.base.dto.DefnFormData
import com.neome.feature.form.domain.ctx.FormCtx
import com.neome.feature.form.presentation.state.FieldState
import kotlinx.serialization.json.JsonElement

/**
 * Interface for component validation schemas.
 *
 * Unlike static Zod schemas, CompSchema validates at runtime with access to:
 * - Current form values (via FormCtx)
 * - Current field properties
 * - Cross-field dependencies
 *
 * The validate() method internally sets/clears errors using FormCtx.
 */
abstract class DefnCompSchema(open val defnForm: DefnFormData, open val defnComp: DefnCompSeal) {

    /**
     * Pure validation that returns an error message without side effects.
     *
     * This method performs validation and returns the error message if validation fails,
     * or null if validation passes. Unlike [validate], this method does NOT call
     * FormCtx.setError() or FormCtx.clearError().
     *
     * Use this method when you need to validate during event processing without
     * dispatching additional events.
     *
     * @param formCtx The form context for accessing values and setting errors
     * @param fieldValue The current field value
     * @param fieldState The current field state (includes properties like required)
     * @return Error message if validation fails, null if validation passes
     */
    abstract fun validatePure(fieldValue: JsonElement?, fieldState: FieldState?): String?

    fun calcIsRequired(formCtx: FormCtx) {

    }
}
