// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdAuthMethod
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioPluginAuthBase

interface StudioPluginAuthMap : StudioBase
{
  val defaultAuthMethodId: MetaIdAuthMethod?
  val keys: List<MetaIdAuthMethod>
  val map: Map<MetaIdAuthMethod, StudioPluginAuthBase>
}