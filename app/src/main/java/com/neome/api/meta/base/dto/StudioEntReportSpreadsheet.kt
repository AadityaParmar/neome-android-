// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdSpreadsheet
import com.neome.api.meta.base.Types.MetaIdVar
import com.neome.api.meta.base.dto.StudioEntReport
import com.neome.api.meta.base.dto.StudioValueVarIdCondition

open class StudioEntReportSpreadsheet : StudioEntReport()
{
  var ascOrder: Boolean? = null
  var filterConditionVarId: StudioValueVarIdCondition? = null
  var fromSpreadsheetId: MetaIdSpreadsheet? = null
  var limit: Number? = null
  var orderByFieldId: MetaIdField? = null
  var outputFormMappingVarId: MetaIdVar? = null
}