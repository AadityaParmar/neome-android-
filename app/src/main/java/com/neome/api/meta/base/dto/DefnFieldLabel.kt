// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnDtoColor
import com.neome.api.meta.base.dto.DefnDtoText
import com.neome.api.meta.base.dto.DefnField
import com.neome.api.meta.base.Types.EnumDefnPlacement
import com.neome.api.meta.base.Types.EnumDefnTextSize
import com.neome.api.meta.base.Types.MetaIdField

interface DefnFieldLabel : DefnField
{
  val bgColor: DefnDtoColor?
  val bgColorVar: DefnDtoColor?
  val bold: Boolean?
  val boldFieldId: MetaIdField?
  val boldVar: Boolean?
  val colorVar: DefnDtoColor?
  val italic: Boolean?
  val italicFieldId: MetaIdField?
  val italicVar: Boolean?
  val justifyText: EnumDefnPlacement?
  val justifyTextVar: EnumDefnPlacement?
  val opacity: Double?
  val opacityFieldId: MetaIdField?
  val opacityVar: Double?
  val strikeThrough: Boolean?
  val strikeThroughFieldId: MetaIdField?
  val strikeThroughVar: Boolean?
  val textPattern: String?
  val textPatternFieldId: MetaIdField?
  val textPatternVar: DefnDtoText?
  val textSize: EnumDefnTextSize?
  val textSizeFieldId: MetaIdField?
  val textSizeVar: EnumDefnTextSize?
  val underline: Boolean?
  val underlineFieldId: MetaIdField?
  val underlineVar: Boolean?
}