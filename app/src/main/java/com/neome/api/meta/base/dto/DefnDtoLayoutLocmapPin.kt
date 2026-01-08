// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnDtoColor
import com.neome.api.meta.base.dto.DefnDtoParagraph
import com.neome.api.meta.base.dto.DefnDtoText
import com.neome.api.meta.base.Types.EnumDefnMapPinShape
import com.neome.api.meta.base.dto.FieldDtoImage
import com.neome.api.meta.base.Types.MetaIdField

interface DefnDtoLayoutLocmapPin
{
  val avatar: FieldDtoImage?
  val avatarFieldId: MetaIdField?
  val avatarVar: FieldDtoImage?
  val color: DefnDtoColor?
  val colorFieldId: MetaIdField?
  val colorVar: DefnDtoColor?
  val label: String?
  val labelFieldId: MetaIdField?
  val labelVar: DefnDtoText?
  val shape: EnumDefnMapPinShape?
  val shapeFieldId: MetaIdField?
  val shapeVar: EnumDefnMapPinShape?
  val toolTip: String?
  val toolTipFieldId: MetaIdField?
  val toolTipVar: DefnDtoParagraph?
}