// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioValueCodeJavascript

interface StudioPluginApiBody : StudioBase
{
  val declarative: StudioValueCodeJavascript?
  val script: StudioValueCodeJavascript?
}