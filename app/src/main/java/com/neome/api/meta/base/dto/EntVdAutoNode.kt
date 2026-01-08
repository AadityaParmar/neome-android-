// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnKindAutoNode
import com.neome.api.meta.base.Types.MetaIdVdAutoNode
import com.neome.api.meta.base.Types.MetaIdVdRegion
import com.neome.api.meta.base.dto.Point
import com.neome.api.meta.base.dto.Size
import com.neome.api.meta.base.dto.StudioValueParagraph
import com.neome.api.meta.base.Symbol
import com.neome.api.meta.base.dto.VdBase

interface EntVdAutoNode : VdBase
{
  val kind: EnumDefnKindAutoNode
  val logMsg: StudioValueParagraph?
  val metaId: MetaIdVdAutoNode
  val name: Symbol
  val parentRegionId: MetaIdVdRegion?
  val point: Point?
  val size: Size?
}