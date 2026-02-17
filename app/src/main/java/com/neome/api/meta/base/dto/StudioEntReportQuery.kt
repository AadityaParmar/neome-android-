// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdSpreadsheet
import com.neome.api.meta.base.dto.StudioEntReport
import com.neome.api.meta.base.dto.StudioValueCodeNeoQL

interface StudioEntReportQuery : StudioEntReport
{
  val fromSpreadsheetIdSet: List<MetaIdSpreadsheet>?
  val neoQL: StudioValueCodeNeoQL?
}