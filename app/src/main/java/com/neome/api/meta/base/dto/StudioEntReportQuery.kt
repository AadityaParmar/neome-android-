// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdSpreadsheet
import com.neome.api.meta.base.dto.StudioEntReport
import com.neome.api.meta.base.dto.StudioValueCodeNeoQL

open class StudioEntReportQuery : StudioEntReport()
{
  var fromSpreadsheetIdSet: Array<MetaIdSpreadsheet>? = null
  var neoQL: StudioValueCodeNeoQL? = null
}