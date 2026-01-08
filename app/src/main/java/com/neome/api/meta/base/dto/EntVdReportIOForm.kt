// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdComposite
import com.neome.api.meta.base.Types.MetaIdForm
import com.neome.api.meta.base.Types.MetaIdVdRegion
import com.neome.api.meta.base.dto.Point
import com.neome.api.meta.base.dto.VdBase

interface EntVdReportIOForm : VdBase
{
  val expanded: Boolean?
  val expandedCompositeIdSet: Array<MetaIdComposite>?
  val formId: MetaIdForm
  val parentRegionId: MetaIdVdRegion?
  val point: Point?
}