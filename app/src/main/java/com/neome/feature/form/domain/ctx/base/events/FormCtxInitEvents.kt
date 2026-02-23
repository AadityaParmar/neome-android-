package com.neome.feature.form.domain.ctx.base.events

import com.neome.api.meta.base.Types
import com.neome.feature.form.domain.DefnFormUi
import com.neome.feature.form.domain.ctx.FormStateAccessor

object FormCtxInitEvents {

    fun initEvents(defnForm: DefnFormUi, accessor: FormStateAccessor) {
        val state = accessor.getState()
        val eventMap = defnForm.eventMap ?: return

        val onChangeMap = mutableMapOf<Types.MetaIdComp, MutableList<Types.MetaIdFormEvent>>()
        val onSubmitFormList = mutableListOf<Types.MetaIdFormEvent>()
        val onClickButtonMap = mutableMapOf<Types.MetaIdComp, MutableList<Types.MetaIdFormEvent>>()

        // Iterate keys in order to preserve event sequence defined in the form definition
        for (eventId in eventMap.keys) {
            val event = eventMap.map[eventId] ?: continue

            when (event.kind) {
                Types.EnumDefnKindFormEvent.onChange -> {
                    // Null or empty eventFieldIdSet means this event applies to all fields
                    val fieldIds = event.eventFieldIdSet?.takeIf { it.isNotEmpty() }
                        ?: state.fieldStates.keys
                    fieldIds.forEach { fieldId ->
                        onChangeMap.getOrPut(fieldId) { mutableListOf() }.add(event.metaId)
                    }
                }

                Types.EnumDefnKindFormEvent.onSubmitForm -> {
                    onSubmitFormList.add(event.metaId)
                }

                Types.EnumDefnKindFormEvent.onClickButton -> {
                    // For button events, eventFieldIdSet holds the button component IDs
                    event.eventFieldIdSet?.forEach { compId ->
                        onClickButtonMap.getOrPut(compId) { mutableListOf() }.add(event.metaId)
                    }
                }

                Types.EnumDefnKindFormEvent.onInitForm -> {
                    // Execute immediately via accessor
                    FormCtxFormEvents.executeEvent(event.metaId, accessor, defnForm)
                    FormCtxEventPropsHelper.mergeEventPropsIntoFieldStates(accessor)
                }
            }
        }

        val categorizedEvents = FormCtxFormEvents.CategorizedEvents(
            onChangeMap = onChangeMap,
            onSubmitFormList = onSubmitFormList,
            onClickButtonMap = onClickButtonMap
        )

        // Store categorizedEvents into the accessor state
        accessor.updateState { it.copy(categorizedEvents = categorizedEvents) }
    }
}
