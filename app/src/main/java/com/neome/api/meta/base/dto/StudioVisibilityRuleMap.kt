// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdVisibilityRule
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioVisibilityRule

interface StudioVisibilityRuleMap : StudioBase
{
  val keys: List<MetaIdVisibilityRule>
  val map: Map<MetaIdVisibilityRule, StudioVisibilityRule>
}