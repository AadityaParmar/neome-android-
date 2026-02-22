package com.neome.feature.form.domain.ctx.helper.events

import com.neome.api.meta.base.Types
import com.neome.feature.form.presentation.state.FormEventProps
import com.neome.feature.form.presentation.state.FormState

object FormCtxEventPropsHelper {

    fun mergeEventPropsIntoFieldStates(state: FormState): FormState {
        val eventPropsMap = state.formEventPropsMap
        if (eventPropsMap.isEmpty()) return state

        var updatedFieldStates = state.fieldStates

        for ((compId, eventProps) in eventPropsMap) {
            val fieldState = updatedFieldStates[compId] ?: continue
            val base = fieldState.fieldProperties

            val mergedHidden = base.hidden || eventProps.hidden || eventProps.invisible
            val mergedDisabled = base.disabled || eventProps.disabled

            if (mergedHidden != base.hidden || mergedDisabled != base.disabled) {
                updatedFieldStates = updatedFieldStates + (compId to fieldState.copy(
                    fieldProperties = base.copy(
                        hidden = mergedHidden,
                        disabled = mergedDisabled
                    )
                ))
            }
        }

        return if (updatedFieldStates !== state.fieldStates) {
            state.copy(fieldStates = updatedFieldStates)
        } else {
            state
        }
    }

    fun updateFormEventProps(
        state: FormState,
        compIdSet: List<Types.MetaIdComp>?,
        update: (FormEventProps) -> FormEventProps
    ): FormState {
        if (compIdSet.isNullOrEmpty()) return state

        var updatedMap = state.formEventPropsMap

        for (compId in compIdSet) {
            val current = updatedMap[compId] ?: FormEventProps()
            updatedMap = updatedMap + (compId to update(current))
        }

        return state.copy(formEventPropsMap = updatedMap)
    }
}
