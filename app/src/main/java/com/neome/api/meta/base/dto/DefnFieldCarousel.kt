// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnDtoMedia
import com.neome.api.meta.base.dto.DefnField
import com.neome.api.meta.base.Types.EnumDefnThemeImageCorner
import com.neome.api.meta.base.Types.MetaIdField

open class DefnFieldCarousel : DefnField()
{
  var borderRadius: Array<Number>? = null
  var fieldIdSet: Array<MetaIdField>? = null
  var height: Number? = null
  var imageCornerVar: EnumDefnThemeImageCorner? = null
  var mediaVarSet: Array<DefnDtoMedia>? = null
  var showAsCard: Boolean? = null
  var showMediaPlaceholder: Boolean? = null
  var width: Number? = null
}