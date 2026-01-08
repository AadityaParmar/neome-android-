// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnPlacement
import com.neome.api.meta.base.Types.EnumDefnTextSize
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdVar
import com.neome.api.meta.base.dto.StudioDtoColor
import com.neome.api.meta.base.dto.StudioField
import com.neome.api.meta.base.dto.StudioValueVarIdText

interface StudioFieldLabel : StudioField
{
  val bgColor: StudioDtoColor?
  val bgColorVarId: MetaIdVar?
  val bold: Boolean?
  val boldFieldId: MetaIdField?
  val boldVarId: MetaIdVar?
  val colorVarId: MetaIdVar?
  val italic: Boolean?
  val italicFieldId: MetaIdField?
  val italicVarId: MetaIdVar?
  val justifyText: EnumDefnPlacement?
  val justifyTextVarId: MetaIdVar?
  val opacity: Long?
  val opacityFieldId: MetaIdField?
  val opacityVarId: MetaIdVar?
  val strikeThrough: Boolean?
  val strikeThroughFieldId: MetaIdField?
  val strikeThroughVarId: MetaIdVar?
  val textPattern: String?
  val textPatternFieldId: MetaIdField?
  val textPatternVarId: StudioValueVarIdText?
  val textSize: EnumDefnTextSize?
  val textSizeFieldId: MetaIdField?
  val textSizeVarId: MetaIdVar?
  val underline: Boolean?
  val underlineFieldId: MetaIdField?
  val underlineVarId: MetaIdVar?
}