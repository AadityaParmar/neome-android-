// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdReport
import com.neome.api.meta.base.Types.MetaIdVdRegion
import com.neome.api.meta.base.dto.Point
import com.neome.api.meta.base.dto.StudioBase

interface EntVdReport : StudioBase
{
  val expanded: Boolean?
  val parentRegionId: MetaIdVdRegion?
  val point: Point?
  val reportId: MetaIdReport
}