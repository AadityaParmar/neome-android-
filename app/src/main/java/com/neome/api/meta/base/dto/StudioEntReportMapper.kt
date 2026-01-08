// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdReport
import com.neome.api.meta.base.Types.MetaIdSpreadsheet
import com.neome.api.meta.base.Types.MetaIdVar
import com.neome.api.meta.base.dto.StudioEntReport

interface StudioEntReportMapper : StudioEntReport
{
  val inputFormMappingVarId: MetaIdVar?
  val mappedReportId: MetaIdReport?
  val outputFormMappingVarId: MetaIdVar?
  val saveToSpreadsheetId: MetaIdSpreadsheet?
}