// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnVisibilityRule
import com.neome.api.meta.base.Types.MetaIdVisibilityRule

interface DefnVisibilityRuleMap
{
  val keys: Array<MetaIdVisibilityRule>
  val map: Map<MetaIdVisibilityRule, DefnVisibilityRule>
}