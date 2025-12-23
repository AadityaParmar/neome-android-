// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import java.util.Map
import com.neome.api.meta.base.Types.MetaIdReport
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioEntReport

open class StudioEntReportMap : StudioBase()
{
  lateinit var keys: Array<MetaIdReport>
  lateinit var map: Map<MetaIdReport, StudioEntReport>
}