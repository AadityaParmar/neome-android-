// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnStudioPickFieldId
import com.neome.api.meta.base.Types.MetaIdPlugin

open class DefnStudioPickPluginFieldId : DefnStudioPickFieldId()
{
  lateinit var pluginId: MetaIdPlugin
}