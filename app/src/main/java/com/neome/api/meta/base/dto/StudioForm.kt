// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnCalculateFormulaMode
import com.neome.api.meta.base.Types.EnumDefnThemeTabVariant
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdForm
import com.neome.api.meta.base.Types.MetaIdRole

interface StudioForm : StudioBase {
    val actionPermissionMap: StudioMapOfActionPermission?
    val aiInstructions: String?
    val allowToPrintForm: Boolean?
    val calculateFormulaMode: EnumDefnCalculateFormulaMode?
    val chatBubbleFieldIdSet: List<MetaIdField>?
    val chatLabelFieldId: MetaIdField?
    val chatLabelPatternVarId: StudioValueVarIdText?
    val chatPatternVarId: StudioValueVarIdParagraph?
    val commentReadOnlyRoleSet: List<MetaIdRole>?
    val commentRoleSet: List<MetaIdRole>?
    val compositeMap: StudioCompositeMap
    val configForm: Boolean?
    val details: StudioDetails
    val formulaMap: StudioMapOfFormula?
    val layoutMap: StudioMapOfLayoutForm?
    val metaId: MetaIdForm
    val payment: StudioPaymentConfig?
    val permissionMatrix: StudioDtoPermissionMatrix?
    val tabVariant: EnumDefnThemeTabVariant?
    val visibilityRuleMap: StudioVisibilityRuleMap?
}
