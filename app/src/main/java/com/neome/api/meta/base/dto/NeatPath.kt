// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumNeatPathCaption

open class NeatPath
{
  var caption: EnumNeatPathCaption? = null
  var primary: Array<String>? = null
  var secondary: String? = null
}