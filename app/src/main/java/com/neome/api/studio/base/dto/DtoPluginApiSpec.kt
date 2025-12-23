// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.studio.base.dto

import com.neome.api.meta.base.Types.EnumDefnPluginApiMethod
import com.google.gson.JsonObject
import com.neome.api.meta.base.Symbol

open class DtoPluginApiSpec
{
  var input: Any? = null
  lateinit var method: EnumDefnPluginApiMethod
  lateinit var name: Symbol
  var output: Any? = null
  lateinit var url: String
}