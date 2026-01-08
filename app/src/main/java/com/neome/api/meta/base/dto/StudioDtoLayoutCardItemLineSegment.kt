// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnTextSize
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdVar
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioDtoColor
import com.neome.api.meta.base.dto.StudioValueVarIdText

interface StudioDtoLayoutCardItemLineSegment : StudioBase
{
  val color: StudioDtoColor?
  val colorFieldId: MetaIdField?
  val colorVarId: MetaIdVar?
  val line: String?
  val lineFieldIdSet: Array<MetaIdField>?
  val lineVarId: StudioValueVarIdText?
  val showLabels: Boolean?
  val textSize: EnumDefnTextSize?
  val textSizeFieldId: MetaIdField?
  val textSizeVarId: MetaIdVar?
}