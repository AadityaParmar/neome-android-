// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnComp
import com.neome.api.meta.base.dto.DefnDtoFormTheme
import com.neome.api.meta.base.dto.DefnDtoParagraph
import com.neome.api.meta.base.dto.DefnDtoPermissionMatrix
import com.neome.api.meta.base.dto.DefnDtoText
import com.neome.api.meta.base.dto.DefnFormEventMap
import com.neome.api.meta.base.dto.DefnLayoutFormMap
import com.neome.api.meta.base.dto.DefnPaymentConfig
import com.neome.api.meta.base.dto.DefnStudioMapOfActionPermission
import com.neome.api.meta.base.dto.DefnVisibilityRuleMap
import com.neome.api.meta.base.Types.EnumDefnCalculateFormulaMode
import com.neome.api.meta.base.Types.MetaIdComp
import com.neome.api.meta.base.Types.MetaIdComposite
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdForm
import com.neome.api.meta.base.Types.MetaIdGrid
import com.neome.api.meta.base.Types.MetaIdLayoutGrid
import com.neome.api.meta.base.Types.MetaIdRole
import com.neome.api.meta.base.Symbol

interface DefnForm
{
  val actionPermissionMap: DefnStudioMapOfActionPermission?
  val allowToPrintForm: Boolean?
  val calculateFormulaMode: EnumDefnCalculateFormulaMode?
  val chatBubbleFieldIdSet: List<MetaIdField>?
  val chatLabelFieldId: MetaIdField?
  val chatLabelPatternVar: DefnDtoText?
  val chatPatternVar: DefnDtoParagraph?
  val commentReadOnlyRoleSet: List<MetaIdRole>?
  val commentRoleSet: List<MetaIdRole>?
  val compMap: Map<MetaIdComp, DefnComp>
  val configForm: Boolean?
  val displayCompositeId: MetaIdComposite
  val eventMap: DefnFormEventMap?
  val formulaFieldIdSet: List<MetaIdField>?
  val gridLookupMap: Map<MetaIdLayoutGrid, MetaIdGrid>?
  val label: String?
  val layoutMap: DefnLayoutFormMap?
  val metaId: MetaIdForm
  val name: Symbol
  val paymentConfig: DefnPaymentConfig?
  val permissionMatrix: DefnDtoPermissionMatrix?
  val theme: DefnDtoFormTheme?
  val visibilityRuleMap: DefnVisibilityRuleMap?
}