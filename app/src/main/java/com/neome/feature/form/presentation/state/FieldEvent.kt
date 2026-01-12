package com.neome.feature.form.presentation.state

import com.neome.api.meta.base.Types.MetaIdComp
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
}

/**
 * Functional interface for handling field events.
 */
fun interface FieldEventHandler {
    fun onFieldEvent(event: FieldEvent)
}
