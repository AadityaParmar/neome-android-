package com.neome.feature.form.domain.ctx.base.events

import com.neome.api.meta.base.Types
import com.neome.feature.form.domain.ctx.FormStateAccessor
import com.neome.feature.form.presentation.state.FormEventProps

object FormCtxEventPropsHelper {

    fun mergeEventPropsIntoFieldStates(accessor: FormStateAccessor) {
        val state = accessor.getState()
        val eventPropsMap = state.formEventPropsMap
        if (eventPropsMap.isEmpty()) return

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

        if (updatedFieldStates !== state.fieldStates) {
            accessor.updateFieldStates(updatedFieldStates)
        }
    }

    fun updateFormEventProps(
        accessor: FormStateAccessor,
        compIdSet: List<Types.MetaIdComp>?,
        update: (FormEventProps) -> FormEventProps
    ) {
        if (compIdSet.isNullOrEmpty()) return

        val state = accessor.getState()
        var updatedMap = state.formEventPropsMap

        for (compId in compIdSet) {
            val current = updatedMap[compId] ?: FormEventProps()
            updatedMap = updatedMap + (compId to update(current))
        }

        accessor.setFormEventPropsMap(updatedMap)
    }
}
