package com.neome.feature.form.domain.util

import com.neome.api.meta.base.Types.MetaIdComp
import com.neome.api.meta.base.dto.DefnComp
import com.neome.api.meta.base.dto.DefnDtoText
import com.neome.api.meta.base.dto.DefnFieldAudio
import com.neome.api.meta.base.dto.DefnFieldButton
import com.neome.api.meta.base.dto.DefnFieldCounter
import com.neome.api.meta.base.dto.DefnFieldDate
import com.neome.api.meta.base.dto.DefnFieldDateTime
import com.neome.api.meta.base.dto.DefnFieldDecimal
import com.neome.api.meta.base.dto.DefnFieldDocument
import com.neome.api.meta.base.dto.DefnFieldDuration
import com.neome.api.meta.base.dto.DefnFieldEditable
import com.neome.api.meta.base.dto.DefnFieldImage
import com.neome.api.meta.base.dto.DefnFieldNumber
import com.neome.api.meta.base.dto.DefnFieldParagraph
import com.neome.api.meta.base.dto.DefnFieldPassword
import com.neome.api.meta.base.dto.DefnFieldPickUser
import com.neome.api.meta.base.dto.DefnFieldSetOfUser
import com.neome.api.meta.base.dto.DefnFieldShowCode
import com.neome.api.meta.base.dto.DefnFieldSwitch
import com.neome.api.meta.base.dto.DefnFieldText
import com.neome.api.meta.base.dto.DefnFieldTime
import com.neome.api.meta.base.dto.DefnFieldVideo
import com.neome.api.meta.base.dto.DefnFieldVoice
import com.neome.api.meta.base.dto.FieldValueSwitch
import com.neome.core.common.serializer.api.meta.base.dto.DefnFieldSwitchData
import com.neome.core.common.serializer.api.meta.base.dto.DefnFormData
import com.neome.feature.form.presentation.state.FieldDependencyMap
import com.neome.feature.form.presentation.state.FieldProperties
import kotlinx.serialization.json.JsonElement

/**
 * Utility for resolving field properties from DefnComp.
 *
 * Properties can be resolved in 3 ways:
 * 1. Direct value: defnComp.property (e.g., defnComp.placeHolder)
 * 2. Variable: defnComp.propertyVar (e.g., defnComp.placeHolderVar) -> resolveArgValue()
 * 3. Field reference: defnComp.propertyFieldId (e.g., defnComp.placeHolderFieldId) -> get value from another field
 */
object FieldPropertyResolver {

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

        val required = resolveRequired(defnComp, defnForm, getFieldValue)

        return FieldProperties(
            required = required,
            disabled = resolveDisabled(defnComp, defnForm, getFieldValue),
            readOnly = defnComp.readOnly == true,
            hidden = resolveHidden(defnComp),
            helperText = resolveHelperText(defnComp, defnForm, getFieldValue),
            placeholder = resolvePlaceholder(defnComp, defnForm, getFieldValue),
            label = resolveLabel(defnComp, defnForm, getFieldValue, required),

            // Text/Paragraph validation
            minCharCount = resolveMinCharCount(defnComp, defnForm, getFieldValue),
            maxCharCount = resolveMaxCharCount(defnComp, defnForm, getFieldValue),
            lineCount = resolveLineCount(defnComp, defnForm, getFieldValue),

            // Number/Counter validation
            minNumber = resolveMinNumber(defnComp, defnForm, getFieldValue),
            maxNumber = resolveMaxNumber(defnComp, defnForm, getFieldValue),
            step = resolveStep(defnComp, defnForm, getFieldValue),
            minDisplayValue = resolveMinDisplayValue(defnComp),

            // Decimal validation
            minDecimal = resolveMinDecimal(defnComp, defnForm, getFieldValue),
            maxDecimal = resolveMaxDecimal(defnComp, defnForm, getFieldValue),

            // Display/UI properties
            showAsCheckbox = resolveShowAsCheckbox(defnComp, defnForm, getFieldValue),
            showLabel = resolveShowLabel(defnComp, defnForm, getFieldValue),
            showPreview = resolveShowPreview(defnComp, defnForm, getFieldValue),
            showSize = resolveShowSize(defnComp, defnForm, getFieldValue),
            showSecond = resolveShowSecond(defnComp, defnForm, getFieldValue),
            showAsDropdown = resolveShowAsDropdown(defnComp, defnForm, getFieldValue),

            // Media properties
            maxSize = resolveMaxSize(defnComp, defnForm, getFieldValue),

            // Button properties
            textSize = resolveTextSize(defnComp, defnForm, getFieldValue),
            disableElevation = resolveDisableElevation(defnComp, defnForm, getFieldValue),

            // Layout properties
            justifyContent = resolveJustifyContent(defnComp),
            flexHeight = resolveFlexHeight(defnComp)
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
        if (defnComp is DefnFieldEditable) {
            defnComp.helperTextFieldId?.let { references.add(it) }
            defnComp.placeHolderFieldId?.let { references.add(it) }
            defnComp.labelFieldId?.let { references.add(it) }
            defnComp.requiredFieldId?.let { references.add(it) }
        }

        // For text fields, check validation constraint field references
        if (defnComp is DefnFieldText) {
            defnComp.minCharCountFieldId?.let { references.add(it) }
            defnComp.maxCharCountFieldId?.let { references.add(it) }
        }

        // For number fields, check validation constraint field references
        if (defnComp is DefnFieldNumber) {
            defnComp.minFieldId?.let { references.add(it) }
            defnComp.maxFieldId?.let { references.add(it) }
        }

        // For decimal fields, check validation constraint field references
        if (defnComp is DefnFieldDecimal) {
            defnComp.minFieldId?.let { references.add(it) }
            defnComp.maxFieldId?.let { references.add(it) }
        }

        // For counter fields (Long min/max + step)
        if (defnComp is DefnFieldCounter) {
            defnComp.minFieldId?.let { references.add(it) }
            defnComp.maxFieldId?.let { references.add(it) }
            defnComp.stepFieldId?.let { references.add(it) }
        }

        // For date fields
        if (defnComp is DefnFieldDate) {
            defnComp.minFieldId?.let { references.add(it) }
            defnComp.maxFieldId?.let { references.add(it) }
        }

        // For dateTime fields
        if (defnComp is DefnFieldDateTime) {
            defnComp.minFieldId?.let { references.add(it) }
            defnComp.maxFieldId?.let { references.add(it) }
        }

        // For duration fields
        if (defnComp is DefnFieldDuration) {
            defnComp.minFieldId?.let { references.add(it) }
            defnComp.maxFieldId?.let { references.add(it) }
        }

        // For time fields
        if (defnComp is DefnFieldTime) {
            defnComp.minFieldId?.let { references.add(it) }
            defnComp.maxFieldId?.let { references.add(it) }
            defnComp.showSecondFieldId?.let { references.add(it) }
        }

        // For paragraph fields
        if (defnComp is DefnFieldParagraph) {
            defnComp.minCharCountFieldId?.let { references.add(it) }
            defnComp.maxCharCountFieldId?.let { references.add(it) }
            defnComp.lineCountFieldId?.let { references.add(it) }
        }

        // For password fields
        if (defnComp is DefnFieldPassword) {
            defnComp.minCharCountFieldId?.let { references.add(it) }
            defnComp.maxCharCountFieldId?.let { references.add(it) }
        }

        // For button fields
        if (defnComp is DefnFieldButton) {
            defnComp.textSizeFieldId?.let { references.add(it) }
            defnComp.disableElevationFieldId?.let { references.add(it) }
        }

        // For audio fields
        if (defnComp is DefnFieldAudio) {
            defnComp.maxSizeFieldId?.let { references.add(it) }
        }

        // For document fields
        if (defnComp is DefnFieldDocument) {
            defnComp.maxSizeFieldId?.let { references.add(it) }
            defnComp.showSizeFieldId?.let { references.add(it) }
        }

        // For image fields (Camera extends Image, so this covers both)
        if (defnComp is DefnFieldImage) {
            defnComp.maxSizeFieldId?.let { references.add(it) }
            defnComp.showLabelFieldId?.let { references.add(it) }
            defnComp.showPreviewFieldId?.let { references.add(it) }
            defnComp.showSizeFieldId?.let { references.add(it) }
        }

        // For video fields
        if (defnComp is DefnFieldVideo) {
            defnComp.maxSizeFieldId?.let { references.add(it) }
            defnComp.showPreviewFieldId?.let { references.add(it) }
            defnComp.showSizeFieldId?.let { references.add(it) }
        }

        // For voice fields
        if (defnComp is DefnFieldVoice) {
            defnComp.maxSizeFieldId?.let { references.add(it) }
        }

        // For pick user fields
        if (defnComp is DefnFieldPickUser) {
            defnComp.showAsDropdownFieldId?.let { references.add(it) }
        }

        // For set of user fields
        if (defnComp is DefnFieldSetOfUser) {
            defnComp.showAsDropdownFieldId?.let { references.add(it) }
        }

        // For show code fields
        if (defnComp is DefnFieldShowCode) {
            defnComp.showLabelFieldId?.let { references.add(it) }
        }

        // For switch/boolean fields
        if (defnComp is DefnFieldSwitch) {
            defnComp.showAsCheckboxFieldId?.let { references.add(it) }
        }

        return references
    }

    // ==================== Individual Property Resolvers ====================

    private fun resolveRequired(
        defnComp: DefnComp,
        defnForm: DefnFormData,
        getFieldValue: (MetaIdComp) -> JsonElement?
    ): Boolean {
        if (defnComp !is DefnFieldEditable) return false

        return if (defnComp.required != null) defnComp.required == true
        else if (defnComp.requiredVar != null) defnComp.requiredVar == true
        else if (defnComp.requiredFieldId != null) {
            val fieldId = defnComp.requiredFieldId as MetaIdComp
            val fieldValue = getFieldValue(fieldId)
            return getBoolFieldValue(defnForm, fieldId, fieldValue)

        } else {
            false
        }
    }


    private fun resolveDisabled(
        defnComp: DefnComp,
        defnForm: DefnFormData,
        getFieldValue: (MetaIdComp) -> JsonElement?
    ): Boolean {
        return if (defnComp.disabled != null) defnComp.disabled == true
        else if (defnComp.disabledVar != null) defnComp.disabledVar == true
        else if (defnComp.disabledFieldId != null) {
            val fieldId = defnComp.disabledFieldId as MetaIdComp
            val fieldValue = getFieldValue(fieldId)
            getBoolFieldValue(defnForm, fieldId, fieldValue)
        } else {
            false
        }
    }

    private fun resolveHidden(defnComp: DefnComp): Boolean {
        return defnComp.hidden == true || defnComp.invisible == true
    }

    private fun resolveHelperText(
        defnComp: DefnComp,
        defnForm: DefnFormData,
        getFieldValue: (MetaIdComp) -> JsonElement?
    ): String? {
        if (defnComp !is DefnFieldEditable) return null

        return if (defnComp.helperText != null) defnComp.helperText
        else if (defnComp.helperTextVar != null) resolveArgValue(defnComp.helperTextVar)
        else if (defnComp.helperTextFieldId != null) {
            val fieldId = defnComp.helperTextFieldId as MetaIdComp
            val fieldValue = getFieldValue(fieldId)
            val field = defnForm.compMap[fieldId]

            fieldValue.let {
                if (field != null)
                    FieldValueResolver.fnFieldValueToRawValue(field.type, it) as? String
                else null
            }
        } else {
            null
        }
    }

    private fun resolvePlaceholder(
        defnComp: DefnComp,
        defnForm: DefnFormData,
        getFieldValue: (MetaIdComp) -> JsonElement?
    ): String? {
        if (defnComp !is DefnFieldEditable) return null

        return if (defnComp.placeHolder != null) defnComp.placeHolder
        else if (defnComp.placeHolderVar != null) resolveArgValue(defnComp.placeHolderVar)
        else if (defnComp.placeHolderFieldId != null) {
            val fieldId = defnComp.placeHolderFieldId as MetaIdComp
            val fieldValue = getFieldValue(fieldId)
            val field = defnForm.compMap[fieldId]

            fieldValue.let {
                if (field != null)
                    FieldValueResolver.fnFieldValueToRawValue(field.type, it) as? String
                else null
            }
        } else {
            null
        }
    }

    private fun resolveLabel(
        defnComp: DefnComp,
        defnForm: DefnFormData,
        getFieldValue: (MetaIdComp) -> JsonElement?,
        required: Boolean?
    ): String {
        val label = if (defnComp.label != null) defnComp.label!!
        else if (defnComp is DefnFieldEditable && defnComp.labelFieldId != null) {
            val fieldId = defnComp.labelFieldId as MetaIdComp
            val fieldValue = getFieldValue(fieldId)
            val field = defnForm.compMap[fieldId]

            val resolved = fieldValue.let {
                if (field != null)
                    FieldValueResolver.fnFieldValueToRawValue(field.type, it) as? String
                else null
            }
            resolved ?: defnComp.name.toString()
        } else {
            defnComp.name.toString()
        }

        return if (required == true) "$label *" else label
    }

    // ==================== Text Field Property Resolvers ====================

    private fun resolveMinCharCount(
        defnComp: DefnComp,
        defnForm: DefnFormData,
        getFieldValue: (MetaIdComp) -> JsonElement?
    ): Long? {
        if (defnComp !is DefnFieldText) return null

        return when {
            defnComp.minCharCount != null -> defnComp.minCharCount
            defnComp.minCharCountVar != null -> defnComp.minCharCountVar
            defnComp.minCharCountFieldId != null -> {
                val fieldId = defnComp.minCharCountFieldId as MetaIdComp
                val field = defnForm.compMap[fieldId]
                field?.let { FieldValueResolver.fnResolveNumericValue(it.type, getFieldValue(fieldId)) }
            }
            else -> null
        }
    }

    private fun resolveMaxCharCount(
        defnComp: DefnComp,
        defnForm: DefnFormData,
        getFieldValue: (MetaIdComp) -> JsonElement?
    ): Long? {
        if (defnComp !is DefnFieldText) return null

        return when {
            defnComp.maxCharCount != null -> defnComp.maxCharCount
            defnComp.maxCharCountVar != null -> defnComp.maxCharCountVar
            defnComp.maxCharCountFieldId != null -> {
                val fieldId = defnComp.maxCharCountFieldId as MetaIdComp
                val field = defnForm.compMap[fieldId]
                field?.let { FieldValueResolver.fnResolveNumericValue(it.type, getFieldValue(fieldId)) }
            }
            else -> null
        }
    }

    // ==================== Number Field Property Resolvers ====================

    private fun resolveMinNumber(
        defnComp: DefnComp,
        defnForm: DefnFormData,
        getFieldValue: (MetaIdComp) -> JsonElement?
    ): Long? {
        if (defnComp !is DefnFieldNumber) return null

        return when {
            defnComp.min != null -> defnComp.min
            defnComp.minVar != null -> defnComp.minVar
            defnComp.minFieldId != null -> {
                val fieldId = defnComp.minFieldId as MetaIdComp
                val field = defnForm.compMap[fieldId]
                field?.let { FieldValueResolver.fnResolveNumericValue(it.type, getFieldValue(fieldId)) }
            }
            else -> null
        }
    }

    private fun resolveMaxNumber(
        defnComp: DefnComp,
        defnForm: DefnFormData,
        getFieldValue: (MetaIdComp) -> JsonElement?
    ): Long? {
        if (defnComp !is DefnFieldNumber) return null

        return when {
            defnComp.max != null -> defnComp.max
            defnComp.maxVar != null -> defnComp.maxVar
            defnComp.maxFieldId != null -> {
                val fieldId = defnComp.maxFieldId as MetaIdComp
                val field = defnForm.compMap[fieldId]
                field?.let { FieldValueResolver.fnResolveNumericValue(it.type, getFieldValue(fieldId)) }
            }
            else -> null
        }
    }

    // ==================== Decimal Field Property Resolvers ====================

    private fun resolveMinDecimal(
        defnComp: DefnComp,
        defnForm: DefnFormData,
        getFieldValue: (MetaIdComp) -> JsonElement?
    ): Double? {
        if (defnComp !is DefnFieldDecimal) return null

        return when {
            defnComp.min != null -> defnComp.min
            defnComp.minVar != null -> defnComp.minVar
            defnComp.minFieldId != null -> {
                val fieldId = defnComp.minFieldId as MetaIdComp
                val field = defnForm.compMap[fieldId]
                field?.let { FieldValueResolver.fnResolveNumericDecimalValue(it.type, getFieldValue(fieldId)) }
            }
            else -> null
        }
    }

    private fun resolveMaxDecimal(
        defnComp: DefnComp,
        defnForm: DefnFormData,
        getFieldValue: (MetaIdComp) -> JsonElement?
    ): Double? {
        if (defnComp !is DefnFieldDecimal) return null

        return when {
            defnComp.max != null -> defnComp.max
            defnComp.maxVar != null -> defnComp.maxVar
            defnComp.maxFieldId != null -> {
                val fieldId = defnComp.maxFieldId as MetaIdComp
                val field = defnForm.compMap[fieldId]
                field?.let { FieldValueResolver.fnResolveNumericDecimalValue(it.type, getFieldValue(fieldId)) }
            }
            else -> null
        }
    }

    // ==================== Counter Field Property Resolvers ====================

    private fun resolveStep(
        defnComp: DefnComp,
        defnForm: DefnFormData,
        getFieldValue: (MetaIdComp) -> JsonElement?
    ): Long? {
        if (defnComp !is DefnFieldCounter) return null

        return when {
            defnComp.step != null -> defnComp.step
            defnComp.stepVar != null -> defnComp.stepVar
            defnComp.stepFieldId != null -> {
                val fieldId = defnComp.stepFieldId as MetaIdComp
                val field = defnForm.compMap[fieldId]
                field?.let { FieldValueResolver.fnResolveNumericValue(it.type, getFieldValue(fieldId)) }
            }
            else -> null
        }
    }

    private fun resolveMinDisplayValue(defnComp: DefnComp): Long? {
        if (defnComp !is DefnFieldCounter) return null
        return defnComp.minDisplayValue
    }

    private fun resolveJustifyContent(defnComp: DefnComp): String? {
        if (defnComp !is DefnFieldCounter) return null
        return defnComp.justifyContent?.value
    }

    // ==================== Paragraph Field Property Resolvers ====================

    private fun resolveLineCount(
        defnComp: DefnComp,
        defnForm: DefnFormData,
        getFieldValue: (MetaIdComp) -> JsonElement?
    ): Long? {
        if (defnComp !is DefnFieldParagraph) return null

        return when {
            defnComp.lineCount != null -> defnComp.lineCount
            defnComp.lineCountVar != null -> defnComp.lineCountVar
            defnComp.lineCountFieldId != null -> {
                val fieldId = defnComp.lineCountFieldId as MetaIdComp
                val field = defnForm.compMap[fieldId]
                field?.let { FieldValueResolver.fnResolveNumericValue(it.type, getFieldValue(fieldId)) }
            }
            else -> null
        }
    }

    private fun resolveFlexHeight(defnComp: DefnComp): Boolean? {
        if (defnComp !is DefnFieldParagraph) return null
        return defnComp.flexHeight
    }

    // ==================== Time Field Property Resolvers ====================

    private fun resolveShowSecond(
        defnComp: DefnComp,
        defnForm: DefnFormData,
        getFieldValue: (MetaIdComp) -> JsonElement?
    ): Boolean? {
        if (defnComp !is DefnFieldTime) return null

        return if (defnComp.showSecond != null) defnComp.showSecond
        else if (defnComp.showSecondVar != null) defnComp.showSecondVar
        else if (defnComp.showSecondFieldId != null) {
            val fieldId = defnComp.showSecondFieldId as MetaIdComp
            val fieldValue = getFieldValue(fieldId)
            getBoolFieldValue(defnForm, fieldId, fieldValue)
        } else {
            null
        }
    }

    // ==================== Media Field Property Resolvers ====================

    private fun resolveMaxSize(
        defnComp: DefnComp,
        defnForm: DefnFormData,
        getFieldValue: (MetaIdComp) -> JsonElement?
    ): Long? {
        val (maxSize, maxSizeVar, maxSizeFieldId) = when (defnComp) {
            is DefnFieldAudio -> Triple(defnComp.maxSize, defnComp.maxSizeVar, defnComp.maxSizeFieldId)
            is DefnFieldDocument -> Triple(defnComp.maxSize, defnComp.maxSizeVar, defnComp.maxSizeFieldId)
            is DefnFieldImage -> Triple(defnComp.maxSize, defnComp.maxSizeVar, defnComp.maxSizeFieldId)
            is DefnFieldVideo -> Triple(defnComp.maxSize, defnComp.maxSizeVar, defnComp.maxSizeFieldId)
            is DefnFieldVoice -> Triple(defnComp.maxSize, defnComp.maxSizeVar, defnComp.maxSizeFieldId)
            else -> return null
        }

        return if (maxSize != null) maxSize
        else if (maxSizeVar != null) maxSizeVar
        else if (maxSizeFieldId != null) {
            val fieldId = maxSizeFieldId as MetaIdComp
            val fieldValue = getFieldValue(fieldId)
            val field = defnForm.compMap[fieldId]

            fieldValue.let {
                if (field != null)
                    FieldValueResolver.fnResolveNumericValue(field.type, it)
                else null
            }
        } else {
            null
        }
    }

    private fun resolveShowLabel(
        defnComp: DefnComp,
        defnForm: DefnFormData,
        getFieldValue: (MetaIdComp) -> JsonElement?
    ): Boolean? {
        val (showLabel, showLabelVar, showLabelFieldId) = when (defnComp) {
            is DefnFieldImage -> Triple(defnComp.showLabel, defnComp.showLabelVar, defnComp.showLabelFieldId)
            is DefnFieldShowCode -> Triple(defnComp.showLabel, defnComp.showLabelVar, defnComp.showLabelFieldId)
            else -> return null
        }

        return if (showLabel != null) showLabel
        else if (showLabelVar != null) showLabelVar
        else if (showLabelFieldId != null) {
            val fieldId = showLabelFieldId as MetaIdComp
            val fieldValue = getFieldValue(fieldId)
            getBoolFieldValue(defnForm, fieldId, fieldValue)
        } else {
            null
        }
    }

    private fun resolveShowPreview(
        defnComp: DefnComp,
        defnForm: DefnFormData,
        getFieldValue: (MetaIdComp) -> JsonElement?
    ): Boolean? {
        val (showPreview, showPreviewVar, showPreviewFieldId) = when (defnComp) {
            is DefnFieldImage -> Triple(defnComp.showPreview, defnComp.showPreviewVar, defnComp.showPreviewFieldId)
            is DefnFieldVideo -> Triple(defnComp.showPreview, defnComp.showPreviewVar, defnComp.showPreviewFieldId)
            else -> return null
        }

        return if (showPreview != null) showPreview
        else if (showPreviewVar != null) showPreviewVar
        else if (showPreviewFieldId != null) {
            val fieldId = showPreviewFieldId as MetaIdComp
            val fieldValue = getFieldValue(fieldId)
            getBoolFieldValue(defnForm, fieldId, fieldValue)
        } else {
            null
        }
    }

    private fun resolveShowSize(
        defnComp: DefnComp,
        defnForm: DefnFormData,
        getFieldValue: (MetaIdComp) -> JsonElement?
    ): Boolean? {
        val (showSize, showSizeVar, showSizeFieldId) = when (defnComp) {
            is DefnFieldDocument -> Triple(defnComp.showSize, defnComp.showSizeVar, defnComp.showSizeFieldId)
            is DefnFieldImage -> Triple(defnComp.showSize, defnComp.showSizeVar, defnComp.showSizeFieldId)
            is DefnFieldVideo -> Triple(defnComp.showSize, defnComp.showSizeVar, defnComp.showSizeFieldId)
            else -> return null
        }

        return if (showSize != null) showSize
        else if (showSizeVar != null) showSizeVar
        else if (showSizeFieldId != null) {
            val fieldId = showSizeFieldId as MetaIdComp
            val fieldValue = getFieldValue(fieldId)
            getBoolFieldValue(defnForm, fieldId, fieldValue)
        } else {
            null
        }
    }

    // ==================== Button Field Property Resolvers ====================

    private fun resolveTextSize(
        defnComp: DefnComp,
        defnForm: DefnFormData,
        getFieldValue: (MetaIdComp) -> JsonElement?
    ): String? {
        if (defnComp !is DefnFieldButton) return null

        return if (defnComp.textSize != null) defnComp.textSize?.value
        else if (defnComp.textSizeVar != null) defnComp.textSizeVar?.value
        else if (defnComp.textSizeFieldId != null) {
            val fieldId = defnComp.textSizeFieldId as MetaIdComp
            val fieldValue = getFieldValue(fieldId)
            val field = defnForm.compMap[fieldId]

            fieldValue.let {
                if (field != null)
                    FieldValueResolver.fnFieldValueToRawValue(field.type, it) as? String
                else null
            }
        } else {
            null
        }
    }

    private fun resolveDisableElevation(
        defnComp: DefnComp,
        defnForm: DefnFormData,
        getFieldValue: (MetaIdComp) -> JsonElement?
    ): Boolean? {
        if (defnComp !is DefnFieldButton) return null

        return if (defnComp.disabledElevation != null) defnComp.disabledElevation
        else if (defnComp.disableElevationVar != null) defnComp.disableElevationVar
        else if (defnComp.disableElevationFieldId != null) {
            val fieldId = defnComp.disableElevationFieldId as MetaIdComp
            val fieldValue = getFieldValue(fieldId)
            getBoolFieldValue(defnForm, fieldId, fieldValue)
        } else {
            null
        }
    }

    // ==================== Switch Field Property Resolvers ====================

    private fun resolveShowAsCheckbox(
        defnComp: DefnComp,
        defnForm: DefnFormData,
        getFieldValue: (MetaIdComp) -> JsonElement?
    ): Boolean? {
        if (defnComp !is DefnFieldSwitch) return null

        return if (defnComp.showAsCheckbox != null) defnComp.showAsCheckbox
        else if (defnComp.showAsCheckboxVar != null) defnComp.showAsCheckboxVar
        else if (defnComp.showAsCheckboxFieldId != null) {
            val fieldId = defnComp.showAsCheckboxFieldId as MetaIdComp
            val fieldValue = getFieldValue(fieldId)
            getBoolFieldValue(defnForm, fieldId, fieldValue)
        } else {
            null
        }
    }

    // ==================== User Picker Field Property Resolvers ====================

    private fun resolveShowAsDropdown(
        defnComp: DefnComp,
        defnForm: DefnFormData,
        getFieldValue: (MetaIdComp) -> JsonElement?
    ): Boolean? {
        val (showAsDropdown, showAsDropdownVar, showAsDropdownFieldId) = when (defnComp) {
            is DefnFieldPickUser -> Triple(
                defnComp.showAsDropdown,
                defnComp.showAsDropdownVar,
                defnComp.showAsDropdownFieldId
            )

            is DefnFieldSetOfUser -> Triple(
                defnComp.showAsDropdown,
                defnComp.showAsDropdownVar,
                defnComp.showAsDropdownFieldId
            )

            else -> return null
        }

        return if (showAsDropdown != null) showAsDropdown
        else if (showAsDropdownVar != null) showAsDropdownVar
        else if (showAsDropdownFieldId != null) {
            val fieldId = showAsDropdownFieldId as MetaIdComp
            val fieldValue = getFieldValue(fieldId)
            getBoolFieldValue(defnForm, fieldId, fieldValue)
        } else {
            null
        }
    }

    // ==================== Helper Methods ====================

    private fun getBoolFieldValue(
        defnForm: DefnFormData,
        fieldId: MetaIdComp,
        fieldValue: JsonElement?
    ): Boolean {
        val field = defnForm.compMap[fieldId]
        return if (field != null && field is DefnFieldSwitchData) {
            val value = FieldValueResolver.fnJsonElementFieldValue(field.type, fieldValue)
            return if (value != null && value is FieldValueSwitch) value.value
            else false
        } else false
    }


    /**
     * Resolve DefnDtoText variable to a string value.
     *
     * DefnDtoText.value is a list of string segments that are concatenated.
     * Returns null if the value list is null or empty.
     *
     * TODO: Implement full variable resolution (e.g., context variables, calculations)
     *  when the variable resolution system is available.
     *
     * @param dtoText The DefnDtoText to resolve
     * @return Resolved string value or null
     */
    fun resolveArgValue(dtoText: DefnDtoText?): String? {
        if (dtoText == null) return null
        val segments = dtoText.value
        if (segments.isNullOrEmpty()) return null
        return segments.joinToString("")
    }
}
