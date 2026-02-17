// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdFieldDynamicRule
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioDtoDynamicRule

interface StudioMapOfDynamicRule : StudioBase
{
  val keys: List<MetaIdFieldDynamicRule>
  val map: Map<MetaIdFieldDynamicRule, StudioDtoDynamicRule>
}