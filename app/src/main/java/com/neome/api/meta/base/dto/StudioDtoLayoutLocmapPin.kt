// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnMapPinShape
import com.neome.api.meta.base.dto.FieldDtoImage
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdVar
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioDtoColor
import com.neome.api.meta.base.dto.StudioValueVarIdParagraph
import com.neome.api.meta.base.dto.StudioValueVarIdText

interface StudioDtoLayoutLocmapPin : StudioBase
{
  val avatar: FieldDtoImage?
  val avatarFieldId: MetaIdField?
  val avatarVarId: MetaIdVar?
  val color: StudioDtoColor?
  val colorFieldId: MetaIdField?
  val colorVarId: MetaIdVar?
  val label: String?
  val labelFieldId: MetaIdField?
  val labelVarId: StudioValueVarIdText?
  val shape: EnumDefnMapPinShape?
  val shapeFieldId: MetaIdField?
  val shapeVarId: MetaIdVar?
  val toolTip: String?
  val toolTipFieldId: MetaIdField?
  val toolTipVarId: StudioValueVarIdParagraph?
}