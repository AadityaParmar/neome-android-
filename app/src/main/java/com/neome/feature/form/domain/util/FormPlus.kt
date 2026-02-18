package com.neome.feature.form.domain.util

import com.neome.api.meta.base.Types.EnumDefnCompType
import com.neome.api.meta.base.Types.EnumDefnFields
import com.neome.api.meta.base.Types.MetaIdComp
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdRole
import com.neome.api.meta.base.dto.DefnField
import com.neome.api.meta.base.dto.DefnForm
import com.neome.api.meta.base.dto.DefnGrid
import com.neome.api.meta.base.dto.DefnSection
import com.neome.api.meta.base.dto.DefnTab
import com.neome.api.meta.base.dto.DefnWizard
import com.neome.core.common.serializer.api.meta.base.dto.DefnCompSeal
import com.neome.core.common.serializer.api.meta.base.dto.DefnFieldFormListData
import com.neome.core.common.serializer.api.meta.base.dto.DefnGridData
import com.neome.core.common.serializer.api.meta.base.dto.DefnSectionData
import com.neome.core.common.serializer.api.meta.base.dto.DefnTabData
import com.neome.core.common.serializer.api.meta.base.dto.DefnWizardData


object FormPlus {
    /**
     * Returns true if every role in [callerRoles] is present in [targetRoles].
     */
    fun matchAllRoles(
        callerRoles: Set<MetaIdRole>,
        targetRoles: Set<MetaIdRole>
    ): Boolean {
        return callerRoles.all { it in targetRoles }
    }

    fun getSystemFieldCompType(fieldId: MetaIdField): EnumDefnCompType? {
        return when (fieldId.getId()) {
            EnumDefnFields.CreatedBy.value -> EnumDefnCompType.userId
            EnumDefnFields.UpdatedBy.value -> EnumDefnCompType.userId
            EnumDefnFields.CreatedOn.value -> EnumDefnCompType.date
            EnumDefnFields.UpdatedOn.value -> EnumDefnCompType.date
            EnumDefnFields.RowId.value -> EnumDefnCompType.rowId
            EnumDefnFields.RowOrder.value -> EnumDefnCompType.text
            else -> null
        }
    }

    fun getCompMetaId(comp: DefnCompSeal): MetaIdComp? {
        return (comp as? DefnField)?.metaId
            ?: (comp as? DefnSection)?.metaId
            ?: (comp as? DefnGrid)?.metaId
            ?: (comp as? DefnTab)?.metaId
            ?: (comp as? DefnWizard)?.metaId
    }

    /**
     * Recursively traverses the form definition tree starting from [DefnForm.displayCompositeId].
     *
     * Accepts any [DefnForm] implementation (e.g., [DefnFormData], DefnFormUi).
     * Both concrete types store [DefnCompSeal] in their compMap, so the cast is safe.
     *
     * @param defnForm The form definition containing the component map and root composite ID.
     * @param cb Callback invoked for each component with (comp, parent). Return `true` to break the loop early.
     */
    @Suppress("UNCHECKED_CAST")
    fun loopDefnForm(defnForm: DefnForm, cb: (comp: DefnCompSeal, parent: DefnCompSeal) -> Boolean?) {
        val compMap = defnForm.compMap as Map<MetaIdComp, DefnCompSeal>
        val displayCompositeId = defnForm.displayCompositeId

        val rootComp = compMap[displayCompositeId] ?: return

        getComp(displayCompositeId, rootComp, compMap, cb)
    }

    /**
     * @return `true` to continue iteration, `false` to break.
     */
    private fun getComp(
        compId: MetaIdComp,
        parentComp: DefnCompSeal,
        compMap: Map<MetaIdComp, DefnCompSeal>,
        callback: (comp: DefnCompSeal, parent: DefnCompSeal) -> Boolean?
    ): Boolean {
        val comp = compMap[compId] ?: return true

        // Resolve the parent from compMap using the parent's metaId (mirrors TS: compMap[parentMetaId] || comp)
        val parentMetaId: MetaIdComp? = when (parentComp) {
            is DefnSectionData -> parentComp.metaId
            is DefnGridData -> parentComp.metaId
            is DefnTabData -> parentComp.metaId
            is DefnWizardData -> parentComp.metaId
            else -> null
        }
        val resolvedParent = parentMetaId?.let { compMap[it] } ?: comp

        if (callback(comp, resolvedParent) == true) {
            return false // return false to break the loop
        }

        // Recurse into children based on component type
        when (comp) {
            is DefnTabData -> {
                comp.tabIdSet?.all { tabId -> getComp(tabId, comp, compMap, callback) }
            }

            is DefnSectionData -> {
                comp.fieldIdSet?.all { fieldId -> getComp(fieldId, comp, compMap, callback) }
            }

            is DefnWizardData -> {
                comp.compositeIdSet?.all { compositeId -> getComp(compositeId, comp, compMap, callback) }
            }

            is DefnFieldFormListData -> {
                comp.displayItemId?.let { getComp(it, comp, compMap, callback) }
            }

            is DefnGridData -> {
                comp.fieldIdSet?.all { fieldId -> getComp(fieldId, comp, compMap, callback) }
            }

            else -> { /* leaf field — no children to traverse */
            }
        }

        return true
    }
}


