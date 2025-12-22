// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Symbol
import com.neome.api.meta.base.Types.EnumDefnCalculateFormulaMode
import com.neome.api.meta.base.Types.MetaIdComp
import com.neome.api.meta.base.Types.MetaIdComposite
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdForm
import com.neome.api.meta.base.Types.MetaIdGrid
import com.neome.api.meta.base.Types.MetaIdLayoutGrid
import com.neome.api.meta.base.Types.MetaIdRole

class DefnForm {
    var actionPermissionMap: DefnStudioMapOfActionPermission? = null
    var allowToPrintForm: boolean? = null
    var calculateFormulaMode: EnumDefnCalculateFormulaMode? = null
    var chatBubbleFieldIdSet: MetaIdField[]? = null
    var chatLabelFieldId: MetaIdField? = null
    var chatLabelPatternVar: DefnDtoText? = null
    var chatPatternVar: DefnDtoParagraph? = null
    var commentReadOnlyRoleSet: MetaIdRole[]? = null
    var commentRoleSet: MetaIdRole[]? = null
    val compMap: Record<MetaIdComp, DefnComp>
    var configForm: boolean? = null
    val displayCompositeId: MetaIdComposite
    var formulaFieldIdSet: MetaIdField[]? = null
    var gridLookupMap: Record<MetaIdLayoutGrid, MetaIdGrid>? = null
    var label: string? = null
    var layoutMap: DefnLayoutFormMap? = null
    val metaId: MetaIdForm
    val name: Symbol
    var paymentConfig: DefnPaymentConfig? = null
    var permissionMatrix: DefnDtoPermissionMatrix? = null
    var theme: DefnDtoFormTheme? = null
    var visibilityRuleMap: DefnVisibilityRuleMap? = null
}
