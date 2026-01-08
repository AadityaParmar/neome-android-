// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdSpreadsheet
import com.neome.api.meta.base.Types.MetaIdVar
import com.neome.api.meta.base.dto.StudioEntReport
import com.neome.api.meta.base.dto.StudioValueVarIdCondition

interface StudioEntReportSpreadsheet : StudioEntReport
{
  val ascOrder: Boolean?
  val filterConditionVarId: StudioValueVarIdCondition?
  val fromSpreadsheetId: MetaIdSpreadsheet?
  val limit: Long?
  val orderByFieldId: MetaIdField?
  val outputFormMappingVarId: MetaIdVar?
}