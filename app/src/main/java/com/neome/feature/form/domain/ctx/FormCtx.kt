package com.neome.feature.form.domain.ctx

import androidx.compose.runtime.State
import androidx.compose.runtime.staticCompositionLocalOf
import com.neome.api.meta.base.Types.MetaIdComp
import com.neome.core.common.serializer.api.meta.base.dto.DefnDtoFormThemeData
import com.neome.feature.form.domain.ctx.base.FormCtxApiCtx
import com.neome.feature.form.presentation.state.FieldError
import com.neome.feature.form.presentation.state.FieldProperties
import com.neome.feature.form.presentation.state.FieldState
import com.neome.feature.form.presentation.state.FormEventProps
import com.neome.feature.form.presentation.state.FormIntent
import com.neome.feature.form.presentation.state.FormState
import com.neome.feature.form.presentation.state.SendBtnStateFlag
import kotlinx.serialization.json.JsonElement


interface FormStateAccessor {
    // ==================== Read ====================

    /** Get full current state snapshot */
    fun getState(): FormState

    /** Get field value from valueMap */
    fun getValue(fieldId: MetaIdComp): JsonElement?

    /** Get field state */
    fun getFieldState(fieldId: MetaIdComp): FieldState?

    /** Get field error */
    fun getError(fieldId: MetaIdComp): FieldError?

    /** Get all values */
    fun getValueMap(): Map<MetaIdComp, JsonElement>

    /** Get all field states */
    fun getFieldStates(): Map<MetaIdComp, FieldState>

    /** Get all errors */
    fun getErrors(): Map<MetaIdComp, FieldError>

    /** Get field properties */
    fun getFieldProperties(fieldId: MetaIdComp): FieldProperties?

    // ==================== Write ====================

    /** Set a field value in valueMap */
    fun setValue(fieldId: MetaIdComp, value: JsonElement?)

    /** Remove a field value from valueMap */
    fun removeValue(fieldId: MetaIdComp)

    /** Update a field state */
    fun setFieldState(fieldId: MetaIdComp, fieldState: FieldState)

    /** Update field states map */
    fun updateFieldStates(fieldStates: Map<MetaIdComp, FieldState>)

    /** Set error for a field */
    fun setError(fieldId: MetaIdComp, error: FieldError)

    /** Clear error for a field */
    fun clearError(fieldId: MetaIdComp)

    /** Update errors map */
    fun updateErrors(errors: Map<MetaIdComp, FieldError>)

    /** Clear all errors */
    fun clearAllErrors()

    /** Update form event props map */
    fun setFormEventPropsMap(map: Map<MetaIdComp, FormEventProps>)

    /** Update send button state flags */
    fun setSendBtnStateFlags(flags: Set<SendBtnStateFlag>)

    /** Set isSubmitting flag */
    fun setIsSubmitting(value: Boolean)

    /** Generic state update for complex transformations */
    fun updateState(transform: (FormState) -> FormState)

    // ==================== Intent ====================

    /** Emit a side-effect intent */
    fun emitIntent(intent: FormIntent)
}

interface FormCtx {

    val formState: State<FormState>

    fun getFieldState(fieldId: MetaIdComp): FieldState?


    fun getApiCtx(): FormCtxApiCtx? = null

    fun getDefnFormTheme(): DefnDtoFormThemeData?

}

val LocalFormCtx = staticCompositionLocalOf<FormCtx> {
    error("FormCtx not provided. Ensure Form composable is in the composition tree.")
}
