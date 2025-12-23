// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdForm
import com.neome.api.meta.base.dto.StudioBase

open class StudioEntPluginDev : StudioBase()
{
  var packageNameVar: String? = null
  var pluginConfigFormId: MetaIdForm? = null
}