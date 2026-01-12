package com.neome.feature.form.presentation.state

import androidx.compose.runtime.Immutable
import com.neome.api.meta.base.Types.MetaIdComp
import com.neome.core.common.serializer.api.meta.base.dto.DefnFormData
import com.neome.core.common.serializer.api.meta.base.dto.FormValueRawData
import kotlinx.serialization.json.JsonElement

/**
 * Centralized state for the Form component.
 * Holds all configuration and runtime data.
 */
@Immutable
data class FormState(
    // Configuration (from parent)
    val defnForm: DefnFormData? = null,
    val initialFormValue: FormValueRawData? = null,

    // Runtime state (centralized)
    val fieldStates: Map<MetaIdComp, FieldState> = emptyMap(),

    // Field errors (separate from fieldStates for easy access)
    val errors: Map<MetaIdComp, FieldError> = emptyMap(),

    // Dependency tracking for property recalculation
    val fieldDependencies: FieldDependencyMap = FieldDependencyMap(),

    // Form-wide configuration
    val disabled: Boolean = false,
    val readOnly: Boolean = false,

    // Form-level state
    val isSubmitting: Boolean = false,
    val formError: String? = null,
    val isInitialized: Boolean = false
) {
    /**
     * Get current form values as a map.
     */
    fun getValueMap(): Map<MetaIdComp, JsonElement> {
        return fieldStates.mapNotNull { (fieldId, state) ->
            state.value?.let { fieldId to it }
        }.toMap()
    }

    /**
     * Check if any field has validation errors.
     */
    val hasErrors: Boolean
        get() = errors.isNotEmpty()

    /**
     * Check if any field is dirty (modified from initial value).
     */
    val isDirty: Boolean
        get() = fieldStates.values.any { it.isDirty }

    /**
     * Check if all required fields are filled and no errors.
     */
    val isValid: Boolean
        get() = !hasErrors && fieldStates.values.none { state ->
            state.fieldProperties.required && state.value == null
        }

    /**
     * Get field state by ID.
     */
    fun getFieldState(fieldId: MetaIdComp): FieldState? = fieldStates[fieldId]

    /**
     * Get field value by ID.
     */
    fun getValue(fieldId: MetaIdComp): JsonElement? = fieldStates[fieldId]?.value

    /**
     * Get field error by ID.
     */
    fun getError(fieldId: MetaIdComp): FieldError? = errors[fieldId]

    /**
     * Check if field has error.
     */
    fun hasError(fieldId: MetaIdComp): Boolean = errors.containsKey(fieldId)
}

/**
 * Tracks field dependencies for property recalculation.
 *
 * Example: If FieldB.placeHolderFieldId = FieldA.id
 * Then dependents[FieldA.id] = setOf(FieldB.id)
 *
 * When FieldA value changes -> trigger FieldB to recalculate properties
 */
@Immutable
data class FieldDependencyMap(
    // Map of fieldId -> set of fields that depend on it
    val dependents: Map<MetaIdComp, Set<MetaIdComp>> = emptyMap()
) {
    /**
     * Get all fields that depend on the given field.
     */
    fun getDependents(fieldId: MetaIdComp): Set<MetaIdComp> = dependents[fieldId] ?: emptySet()

    /**
     * Add a dependency: dependentFieldId depends on sourceFieldId.
     */
    fun addDependency(sourceFieldId: MetaIdComp, dependentFieldId: MetaIdComp): FieldDependencyMap {
        val currentDependents = dependents[sourceFieldId] ?: emptySet()
        return copy(
            dependents = dependents + (sourceFieldId to (currentDependents + dependentFieldId))
        )
    }
}
