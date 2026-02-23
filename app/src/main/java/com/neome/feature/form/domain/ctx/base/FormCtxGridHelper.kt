package com.neome.feature.form.domain.ctx.base

import com.neome.feature.form.domain.DefnFormUi
import com.neome.feature.form.domain.ctx.FormStateAccessor
import com.neome.feature.form.presentation.state.FormEvent

/**
 * Helper for internal grid event handling (add row, edit row, remove row).
 * Used by FormCtxImpl when processing FormEvent.GridAdd, GridEdit, GridRemove.
 */
object FormCtxGridHelper {

    fun handleGridAdd(
        accessor: FormStateAccessor,
        event: FormEvent.GridAdd,
        defnForm: DefnFormUi
    ) {
        // TODO: Create new row, update grid value in valueMap, trigger field
    }

    fun handleGridEdit(
        accessor: FormStateAccessor,
        event: FormEvent.GridEdit,
        defnForm: DefnFormUi
    ) {
        // TODO: Open row editor or navigate to edit UI for event.rowId
    }

    fun handleGridRemove(
        accessor: FormStateAccessor,
        event: FormEvent.GridRemove,
        defnForm: DefnFormUi
    ) {
        // TODO: Remove row from grid value in valueMap, trigger field
    }
}
