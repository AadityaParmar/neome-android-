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

open class DefnForm {
    var actionPermissionMap: DefnStudioMapOfActionPermission? = null

    var allowToPrintForm: Boolean? = null

    var calculateFormulaMode: EnumDefnCalculateFormulaMode? = null

    var chatBubbleFieldIdSet: Array<MetaIdField>? = null

    var chatLabelFieldId: MetaIdField? = null

    var chatLabelPatternVar: DefnDtoText? = null

    var chatPatternVar: DefnDtoParagraph? = null

    var commentReadOnlyRoleSet: Array<MetaIdRole>? = null

    var commentRoleSet: Array<MetaIdRole>? = null

    lateinit var compMap: Map<MetaIdComp, DefnComp>

    var configForm: Boolean? = null

    lateinit var displayCompositeId: MetaIdComposite

    var formulaFieldIdSet: Array<MetaIdField>? = null

    var gridLookupMap: Map<MetaIdLayoutGrid, MetaIdGrid>? = null

    var label: String? = null

    var layoutMap: DefnLayoutFormMap? = null

    lateinit var metaId: MetaIdForm

    lateinit var name: Symbol

    var paymentConfig: DefnPaymentConfig? = null

    var permissionMatrix: DefnDtoPermissionMatrix? = null

    var theme: DefnDtoFormTheme? = null

    var visibilityRuleMap: DefnVisibilityRuleMap? = null
}
