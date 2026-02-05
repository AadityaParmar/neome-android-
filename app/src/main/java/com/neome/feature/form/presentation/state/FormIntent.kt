package com.neome.feature.form.presentation.state

import androidx.compose.runtime.Immutable
import com.neome.api.meta.base.Types.MetaIdComp
import com.neome.core.mvi.UiEvent
import kotlinx.serialization.json.JsonElement

/**
 * Intents emitted FROM the Form component TO the parent.
 * These are external communication events that the parent can handle.
 */
sealed interface FormIntent : UiEvent {

    /**
     * Form submission with complete form data.
     * Emitted when user triggers form submission and validation passes.
     */
    @Immutable
    data class Submit(
        val valueMap: Map<MetaIdComp, JsonElement>
    ) : FormIntent

    /**
     * Field change notification.
     * Emitted when a field value changes (parent can opt-in to receive these).
     *
     * @param fieldId The field identifier
     * @param fieldValue The new field value
     * @param valueMap Complete form data snapshot
     */
    @Immutable
    data class Watch(
        val fieldId: MetaIdComp,
        val fieldValue: JsonElement?,
        val valueMap: Map<MetaIdComp, JsonElement>
    ) : FormIntent

    /**
     * Form validation state changed.
     * Emitted when the overall form validity changes.
     */
    @Immutable
    data class ValidationStateChanged(
        val isValid: Boolean,
        val hasErrors: Boolean
    ) : FormIntent

    /**
     * Send button enabled state changed.
     * Emitted when the send button transitions between enabled and disabled states.
     * Also emitted on form initialization with the initial state.
     *
     * @param enabled true if send button is now enabled, false if disabled
     */
    @Immutable
    data class SendBtnStateChanged(val enabled: Boolean) : FormIntent
}
