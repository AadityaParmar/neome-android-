// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdReport
import com.neome.api.meta.base.dto.StudioEntReport

open class StudioEntReportComposite : StudioEntReport()
{
  var mergeReportIdSet: Array<MetaIdReport>? = null
}