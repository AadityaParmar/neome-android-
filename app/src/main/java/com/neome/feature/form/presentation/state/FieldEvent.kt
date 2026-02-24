package com.neome.feature.form.presentation.state

import com.neome.api.meta.base.Types.MetaIdComp
import com.neome.api.meta.base.Types.RowId
import kotlinx.serialization.json.JsonElement

/**
 * Events emitted FROM field components to the Form.
 * These are converted to FormEvent internally by the Form component.
 */
sealed interface FieldEvent {
    /**
     * The field ID that emitted the event.
     */
    val fieldId: MetaIdComp

    /**
     * Field value has changed.
     */
    data class ValueChanged(
        override val fieldId: MetaIdComp,
        val value: JsonElement?
    ) : FieldEvent

    /**
     * Field gained focus.
     */
    data class Focused(
        override val fieldId: MetaIdComp
    ) : FieldEvent

    /**
     * Field lost focus.
     */
    data class Blurred(
        override val fieldId: MetaIdComp
    ) : FieldEvent

    /**
     * Field/component was clicked.
     */
    data class Click(
        override val fieldId: MetaIdComp
    ) : FieldEvent

    // ==================== Grid events ====================

    /**
     * Add a new row to the grid.
     */
    data class GridAdd(
        override val fieldId: MetaIdComp
    ) : FieldEvent

    /**
     * Edit the given grid row (e.g. open row editor).
     */
    data class GridEdit(
        override val fieldId: MetaIdComp,
        val rowId: RowId
    ) : FieldEvent

    /**
     * Remove the given row from the grid.
     */
    data class GridRemove(
        override val fieldId: MetaIdComp,
        val rowId: RowId
    ) : FieldEvent

    /**
     * Submit the current grid row (validate + merge into parent grid).
     */
    data class GridSubmit(
        override val fieldId: MetaIdComp
    ) : FieldEvent

    /**
     * Close/dismiss the grid row editor without saving.
     */
    data class GridClose(
        override val fieldId: MetaIdComp
    ) : FieldEvent
}

/**
 * Functional interface for handling field events.
 */
fun interface FieldEventHandler {
    fun onFieldEvent(event: FieldEvent)
}
