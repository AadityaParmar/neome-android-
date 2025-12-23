// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import java.util.Date
import com.neome.api.meta.base.Types.EnumDefnDate
import com.neome.api.meta.base.dto.StudioBase

open class StudioBuildDate : StudioBase()
{
  var customValue: String? = null
  var value: EnumDefnDate? = null
}