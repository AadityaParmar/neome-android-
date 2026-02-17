// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.base.dto

import com.neome.api.ent.base.dto.DtoAuthMethodStatusMap
import com.neome.api.meta.base.Types.MetaIdPlugin

interface DtoPluginAuthMap
{
  val pluginAuthMap: Map<MetaIdPlugin, DtoAuthMethodStatusMap>
}