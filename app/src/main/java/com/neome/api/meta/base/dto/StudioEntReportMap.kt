// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdReport
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioEntReport

interface StudioEntReportMap : StudioBase
{
  val keys: Array<MetaIdReport>
  val map: Map<MetaIdReport, StudioEntReport>
}