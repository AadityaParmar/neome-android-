// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnPaymentMethodKind
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdGrid
import com.neome.api.meta.base.Types.MetaIdPipelineParam
import com.neome.api.meta.base.dto.StudioBuildArgBinder
import com.neome.api.meta.base.dto.StudioEntAutomationStep
import com.neome.api.meta.base.dto.StudioValueVarIdCondition

interface StudioEntAutomationStepGeneratePaymentLink : StudioEntAutomationStep
{
  val allowedPaymentMethodSet: Array<EnumDefnPaymentMethodKind>?
  val amountValue: StudioBuildArgBinder?
  val currencyValue: StudioBuildArgBinder?
  val descriptionValue: StudioBuildArgBinder?
  val expiryDurationValue: StudioBuildArgBinder?
  val inputFormPipelineVarId: MetaIdPipelineParam?
  val iterateOnGridFilterVarId: StudioValueVarIdCondition?
  val iterateOnGridId: MetaIdGrid?
  val outputFormPipelineVarId: MetaIdPipelineParam?
  val paymentLinkFieldId: MetaIdField?
  val referenceIdFieldId: MetaIdField?
  val spreadsheetRowIdFieldId: MetaIdField?
}