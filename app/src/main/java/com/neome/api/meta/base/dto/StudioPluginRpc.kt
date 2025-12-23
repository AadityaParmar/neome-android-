// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import java.util.Date
import com.neome.api.meta.base.Types.MetaIdForm
import com.neome.api.meta.base.dto.StudioBase

open class StudioPluginRpc : StudioBase()
{
  lateinit var lastUpdateTime: String
  var pluginConfigFormId: MetaIdForm? = null
}