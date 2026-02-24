package com.neome.feature.form.presentation.state

import androidx.compose.runtime.Immutable
import com.neome.api.meta.base.Types.MetaIdComp
import com.neome.api.meta.base.Types.RowId
import com.neome.core.common.serializer.api.meta.base.dto.FormValueData
import com.neome.feature.form.domain.DefnFormUi
import com.neome.feature.form.domain.ctx.base.events.FormCtxFormEvents
import com.neome.feature.form.domain.ctx.base.schema.CompSchema
import kotlinx.serialization.json.JsonElement

/**
 * Active grid row editing context.
 * Non-null = grid bottom sheet is open.
 * Single source of truth for all grid row field data during editing.
 */
@Immutable
data class GridCtx(
    /** Which grid field is being edited */
    val gridId: MetaIdComp,
    /** Which row (new or existing) */
    val rowId: RowId,
    /** true = adding new row, false = editing existing */
    val isNewRow: Boolean,
    /** Set of MetaIdComp that belong to this grid's child fields */
    val fieldIdSet: Set<MetaIdComp>,
    /** Field states for grid row child fields */
    val fieldStates: Map<MetaIdComp, FieldState> = emptyMap(),
    /** Field values for grid row child fields */
    val valueMap: Map<MetaIdComp, JsonElement> = emptyMap(),
    /** Validation errors for grid row child fields */
    val errors: Map<MetaIdComp, FieldError> = emptyMap(),
    /** Dependency tracking scoped to grid child fields */
    val fieldDependencies: FieldDependencyMap = FieldDependencyMap(),
    /** Validation schemas scoped to grid child fields */
    val compSchemaMap: Map<MetaIdComp, CompSchema> = emptyMap(),
    /** Event-driven property overrides scoped to grid child fields */
    val formEventPropsMap: Map<MetaIdComp, FormEventProps> = emptyMap()
)

/**
 * Flags that control the send button state.
 * When any flag is present in [FormState.sendBtnStateFlags], the send button is disabled.
 * When the set is empty, the send button is enabled.
 */
sealed interface SendBtnStateFlag {
    /** Form has validation errors - managed automatically by FormCtxValidationHelper */
    data object Invalid : SendBtnStateFlag

    /** File upload in progress */
    data object Uploading : SendBtnStateFlag

    /** Background processing in progress */
    data object Processing : SendBtnStateFlag

    /** Validation in progress */
    data object Validating : SendBtnStateFlag

    /** Send button should be invisible */
    data object Invisible : SendBtnStateFlag

    /** Send button disabled by form event action */
    data object Disabled : SendBtnStateFlag

    /** Custom flag with a unique key for extensibility */
    data class Custom(val key: String) : SendBtnStateFlag
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

    /**
     * Event-driven property overrides per component.
     * Set by form event actions (visible, invisible, hidden, enable, disable, highlight, blink, shake).
     * Only contains entries for components that have been affected by at least one event action.
     * @see FormEventProps
     */
    val formEventPropsMap: Map<MetaIdComp, FormEventProps> = emptyMap(),
    val categorizedEvents: FormCtxFormEvents.CategorizedEvents? = null,

    // Form-wide configuration
    val disabled: Boolean = false,
    val readOnly: Boolean = false,

    // Form-level state
    val isSubmitting: Boolean = false,
    val formError: String? = null,
    val isInitialized: Boolean = false,

    /**
     * Set of flags that control the send button state.
     * Send button is enabled only when this set is empty.
     * @see SendBtnStateFlag
     */
    val sendBtnStateFlags: Set<SendBtnStateFlag> = emptySet(),

    /** Active grid row editing context. Non-null = grid bottom sheet is open. */
    val gridCtx: GridCtx? = null
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
     * Returns true only when no state flags are present.
     * Any flag (including Invisible) disables the send button.
     */
    val isSendBtnEnabled: Boolean
        get() = sendBtnStateFlags.isEmpty()

    /**
     * Check if send button should be invisible.
     * Returns true when the Invisible flag is present.
     */
    val isSendBtnInvisible: Boolean
        get() = SendBtnStateFlag.Invisible in sendBtnStateFlags
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
