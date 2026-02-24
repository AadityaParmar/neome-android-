package com.neome.feature.form.presentation.components.composite.grid

import androidx.compose.runtime.State
import androidx.compose.runtime.derivedStateOf
import com.neome.api.meta.base.Types.MetaIdComp
import com.neome.core.common.serializer.api.meta.base.dto.DefnDtoFormThemeData
import com.neome.feature.form.domain.DefnFormUi
import com.neome.feature.form.domain.ctx.FormCtx
import com.neome.feature.form.presentation.state.FieldState
import com.neome.feature.form.presentation.state.FormState

/**
 * Read-only [FormCtx] that derives its [FormState] from [FormState.gridCtx].
 *
 * Provided via [CompositionLocalProvider] to child fields inside the grid
 * bottom sheet. Child fields use [rememberFieldController] which reads
 * from [formState] — they see grid row field states, values, and errors
 * transparently.
 *
 * Uses [derivedStateOf] to only recompose when [gridCtx] changes,
 * NOT when unrelated parent fields change.
 */
class GridFormCtx(
    private val parentFormCtx: FormCtx,
    private val defnForm: DefnFormUi
) : FormCtx {

    override val formState: State<FormState> = derivedStateOf {
        val parentState = parentFormCtx.formState.value
        val gridCtx = parentState.gridCtx

        if (gridCtx != null) {
            FormState(
                defnForm = defnForm,
                fieldStates = gridCtx.fieldStates,
                valueMap = gridCtx.valueMap,
                errors = gridCtx.errors,
                fieldDependencies = gridCtx.fieldDependencies,
                formEventPropsMap = gridCtx.formEventPropsMap,
                compSchemaMap = gridCtx.compSchemaMap,
                isInitialized = true
            )
        } else {
            FormState(defnForm = defnForm, isInitialized = false)
        }
    }

    override fun getFieldState(fieldId: MetaIdComp): FieldState? {
        val gridCtx = parentFormCtx.formState.value.gridCtx ?: return null
        return gridCtx.fieldStates[fieldId]
    }

    override fun getDefnFormTheme(): DefnDtoFormThemeData? = defnForm.theme
}
