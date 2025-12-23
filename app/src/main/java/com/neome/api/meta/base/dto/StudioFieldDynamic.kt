// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.StudioField
import com.neome.api.meta.base.dto.StudioMapOfDynamicRule

open class StudioFieldDynamic : StudioField()
{
  var ruleMap: StudioMapOfDynamicRule? = null
}