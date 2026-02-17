// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdComposite
import com.neome.api.meta.base.Types.MetaIdSpreadsheet
import com.neome.api.meta.base.Types.MetaIdVdRegion
import com.neome.api.meta.base.dto.Point
import com.neome.api.meta.base.dto.VdBase

interface EntVdErdEntity : VdBase
{
  val expanded: Boolean?
  val expandedCompositeIdSet: List<MetaIdComposite>?
  val parentRegionId: MetaIdVdRegion?
  val point: Point?
  val spreadsheetId: MetaIdSpreadsheet
}