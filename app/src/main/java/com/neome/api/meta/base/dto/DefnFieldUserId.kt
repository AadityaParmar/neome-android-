// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnFieldEditable
import com.neome.api.meta.base.Types.EnumDefnRowProperty
import com.neome.api.meta.base.Types.EnumDefnUserProperty

open class DefnFieldUserId : DefnFieldEditable()
{
  var defaultValue: EnumDefnRowProperty? = null
  var displayProperty: EnumDefnUserProperty? = null
}