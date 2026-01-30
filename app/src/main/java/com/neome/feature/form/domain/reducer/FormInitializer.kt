package com.neome.feature.form.domain.reducer

import com.neome.api.meta.base.Types.EnumDefnCompType
import com.neome.core.common.serializer.api.meta.base.dto.DefnFormData
import com.neome.core.common.serializer.api.meta.base.dto.FormValueRawData
import com.neome.feature.form.domain.util.FieldPropertyResolver
import com.neome.feature.form.presentation.state.FieldState
import com.neome.feature.form.presentation.state.FormState

/**
 * Handles form initialization logic.
 * Separated from reducer for clarity and testability.
 */
object FormInitializer {

    /**
     * Composite component types that should not have FieldState.
     * These are structural containers (section, tab, grid, etc.) that contain other fields
     * but are not themselves fields with values.
     */
    private val COMPOSITE_TYPES = setOf(
        EnumDefnCompType.grid,
        EnumDefnCompType.section,
        EnumDefnCompType.spreadsheetRef,
        EnumDefnCompType.tab,
        EnumDefnCompType.wizard
    )

    /**
     * Check if a component type is a composite container.
     *
     * @param compType Component type to check
     * @return true if this is a composite container type
     */
    private fun isCompositeType(compType: EnumDefnCompType): Boolean {
        return compType in COMPOSITE_TYPES
    }

    /**
     * Create initial FormState from DefnForm and initial values.
     * Only creates FieldState for leaf field components, not composite containers.
     *
     * @param defnForm Form definition containing field configurations
     * @param initialValue Initial form values (optional)
     * @return Initialized FormState
     */
    fun initializeFormState(
        defnForm: DefnFormData,
        initialValue: FormValueRawData?
    ): FormState {
        val compMap = defnForm.compMap
        val initialValueMap = initialValue?.valueMap ?: emptyMap()

        // Build dependency map for property recalculation
        // Only include leaf fields in dependency tracking
        val leafFields = compMap.filter { (_, defnComp) ->
            !isCompositeType(defnComp.type)
        }
        val dependencyMap = FieldPropertyResolver.buildDependencyMap(leafFields)

        // Create initial field states with resolved properties
        // Only create FieldState for leaf field components, not composite containers
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

        return FormState(
            defnForm = defnForm,
            initialFormValue = initialValue,
            fieldStates = fieldStates,
            fieldDependencies = dependencyMap,
            errors = emptyMap(),
            isInitialized = true
        )
    }
}
