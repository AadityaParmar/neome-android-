package com.neome.feature.form.domain.ctx.base

import com.neome.api.meta.base.Types.EnumDefnCompType
import com.neome.core.common.serializer.api.meta.base.dto.FormValueData
import com.neome.feature.form.domain.model.DefnFormUi
import com.neome.feature.form.domain.ctx.base.events.FormCtxInitEvents
import com.neome.feature.form.domain.ctx.base.schema.CompSchemaFactory
import com.neome.feature.form.domain.util.FieldPropertyResolver
import com.neome.feature.form.domain.util.FieldVal.FieldValueResolver
import com.neome.feature.form.presentation.state.FieldState
import com.neome.feature.form.presentation.state.FormState

object FormCtxInitHelper {

    private val COMPOSITE_TYPES = setOf(
        EnumDefnCompType.grid,
        EnumDefnCompType.section,
        EnumDefnCompType.spreadsheetRef,
        EnumDefnCompType.tab,
        EnumDefnCompType.wizard
    )

    fun isCompositeType(compType: EnumDefnCompType): Boolean {
        return compType in COMPOSITE_TYPES
    }

    fun initializeFormState(
        defnForm: DefnFormUi,
        initialValue: FormValueData?
    ): FormState {
        val compMap = defnForm.compMap
        val realInitialValue = FieldValueResolver.fnEnsureInit(defnForm, initialValue)
        val initialValueMap = realInitialValue.valueMap

        val leafFields = compMap.filter { (_, defnComp) ->
            !isCompositeType(defnComp.type)
        }
        val dependencyMap = FieldPropertyResolver.buildDependencyMap(leafFields)

        // Include grid in fieldStates and valueMap (grid is composite but has a value)
        val valueCarryingCompositeTypes = setOf(EnumDefnCompType.grid)

        val fieldStates = compMap
            .filter { (_, defnComp) ->
                !isCompositeType(defnComp.type) || defnComp.type in valueCarryingCompositeTypes
            }
            .mapValues { (fieldId, defnComp) ->
                val value = initialValueMap[fieldId]
                val fieldProperties = FieldPropertyResolver.resolveFieldProperties(
                    defnComp = defnComp,
                    defnForm,
                    getFieldValue = { id -> initialValueMap[id] }
                )

                FieldState(
                    defaultValue = value,
                    fieldProperties = fieldProperties
                )
            }

        // Build valueMap from initial values (leaf fields + grid)
        val valueMap = initialValueMap.filterKeys { fieldId ->
            compMap[fieldId]?.let { defnComp ->
                !isCompositeType(defnComp.type) || defnComp.type in valueCarryingCompositeTypes
            } ?: false
        }

        // Build validation schemas for all fields
        val compSchemaMap = CompSchemaFactory.buildFormSchemas(defnForm)

        val baseState = FormState(
            defnForm = defnForm,
            initialFormValue = realInitialValue,
            fieldStates = fieldStates,
            valueMap = valueMap,
            fieldDependencies = dependencyMap,
            errors = emptyMap(),
            compSchemaMap = compSchemaMap,
            isInitialized = true
        )

        // Initialize form events: categorize by kind and execute onInitForm events
        val initAccessor = ReducerFormStateAccessor(baseState)
        FormCtxInitEvents.initEvents(defnForm, initAccessor)

        return initAccessor.getState()
    }
}
