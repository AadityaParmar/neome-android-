// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnRowProperty
import com.neome.api.meta.base.Types.EnumDefnUserProperty
import com.neome.api.meta.base.dto.StudioFieldEditable

interface StudioFieldUserId : StudioFieldEditable
{
  val defaultValue: EnumDefnRowProperty?
  val displayProperty: EnumDefnUserProperty?
}