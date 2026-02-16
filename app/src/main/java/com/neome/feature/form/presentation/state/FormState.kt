package com.neome.feature.form.presentation.state

import androidx.compose.runtime.Immutable
import com.neome.api.meta.base.Types.MetaIdComp
import com.neome.core.common.serializer.api.meta.base.dto.FormValueData
import com.neome.feature.form.domain.DefnFormUi
import com.neome.feature.form.domain.ctx.helper.schema.CompSchema
import kotlinx.serialization.json.JsonElement

/**
 * Flags that disable the send button.
 * When any flag is present in [FormState.disableSendBtnSet], the send button is disabled.
 * When the set is empty, the send button is enabled.
 */
sealed interface SendBtnDisableFlag {
    /** Form has validation errors - managed automatically by FormCtxValidationHelper */
    data object Invalid : SendBtnDisableFlag

    /** File upload in progress */
    data object Uploading : SendBtnDisableFlag

    /** Background processing in progress */
    data object Processing : SendBtnDisableFlag

    /** Validation in progress */
    data object Validating : SendBtnDisableFlag

    /** Custom flag with a unique key for extensibility */
    data class Custom(val key: String) : SendBtnDisableFlag
}

/**
 * Centralized state for the Form component.
 * Holds all configuration and runtime data.
 */
@Immutable
data class FormState(
    // Configuration (from parent)
    val defnForm: DefnFormUi? = null,
    val initialFormValue: FormValueData? = null,

    // Runtime state (centralized)
    val fieldStates: Map<MetaIdComp, FieldState> = emptyMap(),

    // Field values (separate from fieldStates for isolated observation)
    val valueMap: Map<MetaIdComp, JsonElement> = emptyMap(),

    // Field errors (separate from fieldStates for easy access)
    val errors: Map<MetaIdComp, FieldError> = emptyMap(),

    // Dependency tracking for property recalculation
    val fieldDependencies: FieldDependencyMap = FieldDependencyMap(),

    /**
     * Map of field ID to CompSchema for validation.
     * Built once during form initialization by [CalcSchema.buildFormSchemas].
     * Only contains schemas for leaf field types with validation rules.
     */
    val compSchemaMap: Map<MetaIdComp, CompSchema> = emptyMap(),

    // Form-wide configuration
    val disabled: Boolean = false,
    val readOnly: Boolean = false,

    // Form-level state
    val isSubmitting: Boolean = false,
    val formError: String? = null,
    val isInitialized: Boolean = false,

    /**
     * Set of flags that disable the send button.
     * Send button is enabled only when this set is empty.
     * @see SendBtnDisableFlag
     */
    val disableSendBtnSet: Set<SendBtnDisableFlag> = emptySet()
) {
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
        get() = !hasErrors && fieldStates.none { (fieldId, state) ->
            state.fieldProperties.required && valueMap[fieldId] == null
        }

    /**
     * Get field state by ID.
     */
    fun getFieldState(fieldId: MetaIdComp): FieldState? = fieldStates[fieldId]

    /**
     * Get field value by ID.
     */
    fun getValue(fieldId: MetaIdComp): JsonElement? = valueMap[fieldId]

    /**
     * Get field error by ID.
     */
    fun getError(fieldId: MetaIdComp): FieldError? = errors[fieldId]

    /**
     * Check if field has error.
     */
    fun hasError(fieldId: MetaIdComp): Boolean = errors.containsKey(fieldId)

    /**
     * Check if send button is enabled.
     * Returns true only when no disable flags are present.
     */
    val isSendBtnEnabled: Boolean
        get() = disableSendBtnSet.isEmpty()
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
