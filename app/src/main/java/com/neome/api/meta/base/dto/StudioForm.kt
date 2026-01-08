// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnCalculateFormulaMode
import com.neome.api.meta.base.Types.EnumDefnThemeTabVariant
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdForm
import com.neome.api.meta.base.Types.MetaIdRole
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioCompositeMap
import com.neome.api.meta.base.dto.StudioDetails
import com.neome.api.meta.base.dto.StudioDtoPermissionMatrix
import com.neome.api.meta.base.dto.StudioMapOfActionPermission
import com.neome.api.meta.base.dto.StudioMapOfFormula
import com.neome.api.meta.base.dto.StudioMapOfLayoutForm
import com.neome.api.meta.base.dto.StudioPaymentConfig
import com.neome.api.meta.base.dto.StudioValueVarIdParagraph
import com.neome.api.meta.base.dto.StudioValueVarIdText
import com.neome.api.meta.base.dto.StudioVisibilityRuleMap

interface StudioForm : StudioBase
{
  val actionPermissionMap: StudioMapOfActionPermission?
  val aiInstructions: String?
  val allowToPrintForm: Boolean?
  val calculateFormulaMode: EnumDefnCalculateFormulaMode?
  val chatBubbleFieldIdSet: Array<MetaIdField>?
  val chatLabelFieldId: MetaIdField?
  val chatLabelPatternVarId: StudioValueVarIdText?
  val chatPatternVarId: StudioValueVarIdParagraph?
  val commentReadOnlyRoleSet: Array<MetaIdRole>?
  val commentRoleSet: Array<MetaIdRole>?
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