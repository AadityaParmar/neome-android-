// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnDtoDynamicRule
import com.neome.api.meta.base.Types.MetaIdFieldDynamicRule

interface DefnMapOfDynamicRule
{
  val keys: List<MetaIdFieldDynamicRule>
  val map: Map<MetaIdFieldDynamicRule, DefnDtoDynamicRule>
}