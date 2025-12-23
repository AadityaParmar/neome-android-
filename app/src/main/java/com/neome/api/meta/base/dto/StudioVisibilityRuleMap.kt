// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import java.util.Map
import com.neome.api.meta.base.Types.MetaIdVisibilityRule
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioVisibilityRule

open class StudioVisibilityRuleMap : StudioBase()
{
  lateinit var keys: Array<MetaIdVisibilityRule>
  lateinit var map: Map<MetaIdVisibilityRule, StudioVisibilityRule>
}