// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnKindRating
import com.neome.api.meta.base.dto.StudioVar

open class StudioVarRatingKind : StudioVar()
{
  var value: EnumDefnKindRating? = null
}