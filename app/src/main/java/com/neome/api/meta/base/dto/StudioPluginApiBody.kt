// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioValueCodeJavascript

open class StudioPluginApiBody : StudioBase()
{
  var declarative: StudioValueCodeJavascript? = null
  var script: StudioValueCodeJavascript? = null
}