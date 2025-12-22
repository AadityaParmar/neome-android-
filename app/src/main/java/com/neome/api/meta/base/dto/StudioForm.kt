// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnCalculateFormulaMode
import com.neome.api.meta.base.Types.EnumDefnThemeTabVariant
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdForm
import com.neome.api.meta.base.Types.MetaIdRole

class StudioForm : StudioBase() {
    var actionPermissionMap: StudioMapOfActionPermission? = null
    var aiInstructions: string? = null
    var allowToPrintForm: boolean? = null
    var calculateFormulaMode: EnumDefnCalculateFormulaMode? = null
    var chatBubbleFieldIdSet: MetaIdField[]? = null
    var chatLabelFieldId: MetaIdField? = null
    var chatLabelPatternVarId: StudioValueVarIdText? = null
    var chatPatternVarId: StudioValueVarIdParagraph? = null
    var commentReadOnlyRoleSet: MetaIdRole[]? = null
    var commentRoleSet: MetaIdRole[]? = null
    val compositeMap: StudioCompositeMap
    var configForm: boolean? = null
    val details: StudioDetails
    var formulaMap: StudioMapOfFormula? = null
    var layoutMap: StudioMapOfLayoutForm? = null
    val metaId: MetaIdForm
    var payment: StudioPaymentConfig? = null
    var permissionMatrix: StudioDtoPermissionMatrix? = null
    var tabVariant: EnumDefnThemeTabVariant? = null
    var visibilityRuleMap: StudioVisibilityRuleMap? = null
}
