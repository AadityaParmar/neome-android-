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

open class DefnFieldLabel : DefnField()
{
  var bgColor: DefnDtoColor? = null
  var bgColorVar: DefnDtoColor? = null
  var bold: Boolean? = null
  var boldFieldId: MetaIdField? = null
  var boldVar: Boolean? = null
  var colorVar: DefnDtoColor? = null
  var italic: Boolean? = null
  var italicFieldId: MetaIdField? = null
  var italicVar: Boolean? = null
  var justifyText: EnumDefnPlacement? = null
  var justifyTextVar: EnumDefnPlacement? = null
  var opacity: Number? = null
  var opacityFieldId: MetaIdField? = null
  var opacityVar: Number? = null
  var strikeThrough: Boolean? = null
  var strikeThroughFieldId: MetaIdField? = null
  var strikeThroughVar: Boolean? = null
  var textPattern: String? = null
  var textPatternFieldId: MetaIdField? = null
  var textPatternVar: DefnDtoText? = null
  var textSize: EnumDefnTextSize? = null
  var textSizeFieldId: MetaIdField? = null
  var textSizeVar: EnumDefnTextSize? = null
  var underline: Boolean? = null
  var underlineFieldId: MetaIdField? = null
  var underlineVar: Boolean? = null
}