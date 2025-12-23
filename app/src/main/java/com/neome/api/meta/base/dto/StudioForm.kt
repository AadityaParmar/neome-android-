// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnCalculateFormulaMode
import com.neome.api.meta.base.Types.EnumDefnThemeTabVariant
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdForm
import com.neome.api.meta.base.Types.MetaIdRole

open class StudioForm : StudioBase() {
    var actionPermissionMap: StudioMapOfActionPermission? = null
    var aiInstructions: String? = null
    var allowToPrintForm: Boolean? = null
    var calculateFormulaMode: EnumDefnCalculateFormulaMode? = null
    var chatBubbleFieldIdSet: Array<MetaIdField>? = null
    var chatLabelFieldId: MetaIdField? = null
    var chatLabelPatternVarId: StudioValueVarIdText? = null
    var chatPatternVarId: StudioValueVarIdParagraph? = null
    var commentReadOnlyRoleSet: Array<MetaIdRole>? = null
    var commentRoleSet: Array<MetaIdRole>? = null
    lateinit var compositeMap: StudioCompositeMap
    var configForm: Boolean? = null
    lateinit var details: StudioDetails
    var formulaMap: StudioMapOfFormula? = null
    var layoutMap: StudioMapOfLayoutForm? = null
    lateinit var metaId: MetaIdForm
    var payment: StudioPaymentConfig? = null
    var permissionMatrix: StudioDtoPermissionMatrix? = null
    var tabVariant: EnumDefnThemeTabVariant? = null
    var visibilityRuleMap: StudioVisibilityRuleMap? = null
}
