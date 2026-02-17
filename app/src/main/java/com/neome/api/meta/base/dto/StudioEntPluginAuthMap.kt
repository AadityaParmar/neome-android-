// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdAuthMethod
import com.neome.api.meta.base.dto.StudioEntPluginAuthBase

interface StudioEntPluginAuthMap
{
  val defaultAuthMethodId: MetaIdAuthMethod?
  val map: Map<MetaIdAuthMethod, StudioEntPluginAuthBase>
}