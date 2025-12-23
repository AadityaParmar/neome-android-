// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdComposite
import com.neome.api.meta.base.Types.MetaIdSpreadsheet
import com.neome.api.meta.base.Types.MetaIdVdRegion
import com.neome.api.meta.base.dto.Point
import com.neome.api.meta.base.dto.VdBase

open class EntVdErdEntity : VdBase()
{
  var expanded: Boolean? = null
  var expandedCompositeIdSet: Array<MetaIdComposite>? = null
  var parentRegionId: MetaIdVdRegion? = null
  var point: Point? = null
  lateinit var spreadsheetId: MetaIdSpreadsheet
}