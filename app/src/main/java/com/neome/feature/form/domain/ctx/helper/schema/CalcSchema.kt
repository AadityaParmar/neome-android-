package com.neome.feature.form.domain.ctx.helper.schema

import com.neome.api.meta.base.Types.MetaIdComp
import com.neome.core.common.serializer.api.meta.base.dto.DefnFormData

/**
 * Calculates CompSchema instances for all form fields.
 *
 * This object is the main orchestrator for building validation schemas.
 * It is called once during form initialization in [FormCtxInitHelper.initializeFormState].
 *
 * The resulting schema map is stored in [FormState.compSchemaMap] and used
 * for field validation at runtime.
 */
object CalcSchema {

    /**
     * Builds CompSchema instances for all leaf fields in the form.
     *
     * Iterates over all components in the form definition and creates
     * appropriate CompSchema based on their type. Composite types
     * (section, tab, grid, etc.) are skipped as they don't have values.
     *
     * @param defnForm The form definition containing the component map
     * @return Map of fieldId to CompSchema for all fields that have validation schemas
     */
    fun buildFormSchemas(defnForm: DefnFormData): Map<MetaIdComp, DefnCompSchema> {
        return defnForm.compMap
            .mapNotNull { (fieldId, defnComp) ->
                val schema = CompSchemaFactory.create(defnForm, defnComp)
                schema?.let { fieldId to it }
            }
            .toMap()
    }
}
