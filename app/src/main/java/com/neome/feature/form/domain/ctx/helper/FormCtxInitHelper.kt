package com.neome.feature.form.domain.ctx.helper

import com.neome.api.meta.base.Types.EnumDefnCompType
import com.neome.core.common.serializer.api.meta.base.dto.DefnFormData
import com.neome.core.common.serializer.api.meta.base.dto.FormValueRawData
import com.neome.feature.form.domain.ctx.helper.schema.CompSchemaFactory
import com.neome.feature.form.domain.util.FieldPropertyResolver
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
        defnForm: DefnFormData,
        initialValue: FormValueRawData?
    ): FormState {
        val compMap = defnForm.compMap
        val initialValueMap = initialValue?.valueMap ?: emptyMap()

        val leafFields = compMap.filter { (_, defnComp) ->
            !isCompositeType(defnComp.type)
        }
        val dependencyMap = FieldPropertyResolver.buildDependencyMap(leafFields)

        val fieldStates = compMap
            .filter { (_, defnComp) ->
                !isCompositeType(defnComp.type)
            }
            .mapValues { (fieldId, defnComp) ->
                val value = initialValueMap[fieldId]
                val fieldProperties = FieldPropertyResolver.resolveFieldProperties(
                    defnComp = defnComp,
                    defnForm,
                    getFieldValue = { id -> initialValueMap[id] }
                )

                FieldState(
                    value = value,
                    defaultValue = value,
                    fieldProperties = fieldProperties
                )
            }

        // Build validation schemas for all fields
        val compSchemaMap = CompSchemaFactory.buildFormSchemas(defnForm)

        return FormState(
            defnForm = defnForm,
            initialFormValue = initialValue,
            fieldStates = fieldStates,
            fieldDependencies = dependencyMap,
            errors = emptyMap(),
            compSchemaMap = compSchemaMap,
            isInitialized = true
        )
    }
}
