package com.neome.feature.form.domain.util

import com.neome.api.meta.base.Types.MetaIdComp
import com.neome.api.meta.base.dto.DefnComp
import com.neome.api.meta.base.dto.DefnDtoText
import com.neome.api.meta.base.dto.DefnFieldEditable
import com.neome.core.common.serializer.api.meta.base.dto.DefnFormData
import com.neome.feature.form.presentation.state.FieldDependencyMap
import com.neome.feature.form.presentation.state.FieldProperties
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonPrimitive
import kotlinx.serialization.json.contentOrNull

/**
 * Utility for resolving field properties from DefnComp.
 *
 * Properties can be resolved in 3 ways:
 * 1. Direct value: defnComp.property (e.g., defnComp.placeHolder)
 * 2. Variable: defnComp.propertyVar (e.g., defnComp.placeHolderVar) -> resolveArgValue()
 * 3. Field reference: defnComp.propertyFieldId (e.g., defnComp.placeHolderFieldId) -> get value from another field
 */
object PropertyResolver {

    /**
     * Resolve FieldProperties from DefnComp.
     *
     * @param defnComp The component definition
     * @param getFieldValue Function to get another field's value (for field references)
     * @return Resolved FieldProperties
     */
    fun resolveFieldProperties(
        defnComp: DefnComp,
        defnForm: DefnFormData,
        getFieldValue: (MetaIdComp) -> JsonElement?
    ): FieldProperties {

        val required = resolveRequired(defnComp)

        return FieldProperties(
            required = required,
            disabled = resolveDisabled(defnComp, getFieldValue),
            readOnly = defnComp.readOnly == true,
            hidden = resolveHidden(defnComp),
            helperText = resolveHelperText(defnComp, defnForm, getFieldValue),
            placeholder = resolvePlaceholder(defnComp, defnForm, getFieldValue),
            label = resolveLabel(defnComp, required)
        )
    }

    /**
     * Build dependency map by scanning DefnComp for *FieldId properties.
     *
     * @param compMap Map of component IDs to their definitions
     * @return FieldDependencyMap tracking which fields depend on which
     */
    fun buildDependencyMap(
        compMap: Map<MetaIdComp, DefnComp>
    ): FieldDependencyMap {
        var dependencyMap = FieldDependencyMap()

        compMap.forEach { (fieldId, defnComp) ->
            // Check for field ID references in the component
            val fieldIdReferences = extractFieldIdReferences(defnComp)

            fieldIdReferences.forEach { sourceFieldId ->
                dependencyMap = dependencyMap.addDependency(sourceFieldId, fieldId)
            }
        }

        return dependencyMap
    }

    /**
     * Extract all field ID references from a DefnComp.
     * These are fields whose values are used to compute properties of this component.
     */
    private fun extractFieldIdReferences(defnComp: DefnComp): List<MetaIdComp> {
        val references = mutableListOf<MetaIdComp>()

        // Check common *FieldId properties
        // Note: These properties may exist on subtypes of DefnComp
        // We use reflection-like approach via when checking the type

        defnComp.disabledFieldId?.let { references.add(it) }

        // For editable fields, check additional field references
        if (defnComp is com.neome.api.meta.base.dto.DefnFieldEditable) {
            defnComp.helperTextFieldId?.let { references.add(it) }
            defnComp.placeHolderFieldId?.let { references.add(it) }
            defnComp.labelFieldId?.let { references.add(it) }
            defnComp.requiredFieldId?.let { references.add(it) }
        }

        return references
    }

    // ==================== Individual Property Resolvers ====================

    private fun resolveRequired(defnComp: DefnComp): Boolean {
        // Required is typically determined by validation rules
        // For now, return false - will be enhanced when validation is implemented
        return false
    }

    private fun resolveDisabled(
        defnComp: DefnComp,
        getFieldValue: (MetaIdComp) -> JsonElement?
    ): Boolean {
        // Priority: disabledFieldId > disabledVar > disabled

        // Check if disabled based on another field's value
        defnComp.disabledFieldId?.let { fieldId ->
            val fieldValue = getFieldValue(fieldId)
            if (fieldValue != null) {
                return isTruthy(fieldValue)
            }
        }

        // Check disabledVar (would need resolveArgValue implementation)
        if (defnComp.disabledVar == true) {
            return true
        }

        // Fall back to direct value
        return defnComp.disabled == true
    }

    private fun resolveHidden(defnComp: DefnComp): Boolean {
        return defnComp.hidden == true || defnComp.invisible == true
    }

    private fun resolveHelperText(
        defnComp: DefnComp,
        defnForm: DefnFormData,
        getFieldValue: (MetaIdComp) -> JsonElement?
    ): String? {
        // Helper text resolution follows: helperTextFieldId > helperTextVar > helperText

        // Check if helperText is based on another field's value (only for DefnFieldEditable)
        if (defnComp is DefnFieldEditable) {
            defnComp.helperTextFieldId?.let { fieldId ->
                val value = getFieldValue(fieldId) ?: return null
                val compType = defnForm.compMap.get(fieldId)?.type ?: return null

                val fieldValue = fieldValueResolver.fnFieldValueToRawValue(compType, value)
                if (fieldValue != null && fieldValue is String) {
                    return fieldValue
                }
            }

            // Check helperTextVar (only for DefnFieldEditable)
            defnComp.helperTextVar?.let { textVar ->
                val resolvedValue = resolveArgValue(textVar)
                if (resolvedValue != null) {
                    return resolvedValue
                }
            }

            // Fall back to direct helperText value (only for DefnFieldEditable)
            return defnComp.helperText
        }

        return null
    }

    private fun resolvePlaceholder(
        defnComp: DefnComp,
        defnForm: DefnFormData,
        getFieldValue: (MetaIdComp) -> JsonElement?
    ): String? {
        // Placeholder resolution follows: placeHolderFieldId > placeHolderVar > placeHolder

        // Check if placeholder is based on another field's value (only for DefnFieldEditable)
        if (defnComp is DefnFieldEditable) {
            defnComp.placeHolderFieldId?.let { fieldId ->
                val value = getFieldValue(fieldId) ?: return null
                val compType = defnForm.compMap.get(fieldId)?.type ?: return null

                val fieldValue = fieldValueResolver.fnFieldValueToRawValue(compType, value)
                if (fieldValue != null && fieldValue is String) {
                    return fieldValue
                }
            }

            // Check placeHolderVar (only for DefnFieldEditable)
            defnComp.placeHolderVar?.let { placeHolderVar ->
                val resolvedValue = resolveArgValue(placeHolderVar)
                if (resolvedValue != null) {
                    return resolvedValue
                }
            }

            // Fall back to direct placeHolder value (only for DefnFieldEditable)
            return defnComp.placeHolder
        }

        return null
    }

    private fun resolveLabel(
        defnComp: DefnComp,
        required: Boolean?
    ): String {
        // Label resolution would follow:
        // labelFieldId > labelVar > label
        // For now, return the direct label
        val label = defnComp.label ?: defnComp.name.toString()
        return if (required == true) "$label *" else label
    }

    // ==================== Helper Methods ====================

    /**
     * Check if a JsonElement value is "truthy".
     */
    private fun isTruthy(value: JsonElement): Boolean {
        return when (value) {
            is JsonPrimitive -> {
                when {
                    value.isString -> value.content.isNotBlank() && value.content != "false"
                    else -> value.contentOrNull?.toBooleanStrictOrNull() == true
                }
            }

            else -> true // Non-null objects/arrays are truthy
        }
    }

    /**
     * Get string value from JsonElement.
     */
    private fun getStringValue(value: JsonElement?): String? {
        return (value as? JsonPrimitive)?.contentOrNull
    }

    /**
     * Resolve DefnDtoText variable.
     * This is a placeholder - actual implementation would depend on the variable resolution system.
     *
     * @param dtoText The DefnDtoText to resolve
     * @return Resolved string value or null
     */
    fun resolveArgValue(dtoText: DefnDtoText?): String? {
        if (dtoText == null) return null

        // Basic placeholder implementation
        // In a real implementation, this would resolve variables from context,
        // perform calculations, etc. based on the DefnDtoText structure

        // For now, return a simple representation
        // This prevents the function from always returning null
        return dtoText.toString()
    }
}
