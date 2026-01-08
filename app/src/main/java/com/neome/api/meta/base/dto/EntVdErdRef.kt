// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdSpreadsheet
import com.neome.api.meta.base.Types.MetaIdVdRegion
import com.neome.api.meta.base.dto.Point
import com.neome.api.meta.base.dto.StudioBase

interface EntVdErdRef : StudioBase
{
  val diamondExpanded: Boolean?
  val diamondParentRegionId: MetaIdVdRegion?
  val diamondPoint: Point?
  val expanded: Boolean?
  val fieldId: MetaIdField
  val fromNodeHandleId: String?
  val fromNodeId: MetaIdSpreadsheet?
  val parentRegionId: MetaIdVdRegion?
  val point: Point?
  val toNodeId: MetaIdSpreadsheet?
}