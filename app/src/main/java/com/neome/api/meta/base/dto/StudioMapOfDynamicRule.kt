// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import java.util.Map
import com.neome.api.meta.base.Types.MetaIdFieldDynamicRule
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioDtoDynamicRule

open class StudioMapOfDynamicRule : StudioBase()
{
  lateinit var keys: Array<MetaIdFieldDynamicRule>
  lateinit var map: Map<MetaIdFieldDynamicRule, StudioDtoDynamicRule>
}