// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.EntVdReportDia
import com.neome.api.meta.base.Types.MetaIdVdReportDia
import com.neome.api.meta.base.dto.StudioBase

interface EntVdReportDiaMap : StudioBase
{
  val keys: List<MetaIdVdReportDia>
  val map: Map<MetaIdVdReportDia, EntVdReportDia>
}