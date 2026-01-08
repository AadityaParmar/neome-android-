// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnStudioPickCompId
import com.neome.api.meta.base.Types.MetaIdPlugin

interface DefnStudioPickPluginCompId : DefnStudioPickCompId
{
  val pluginId: MetaIdPlugin
}