// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.StudioValueVarIdBase

open class StudioValueText : StudioValueVarIdBase()
{
  var paramSet: Array<String>? = null
  lateinit var value: String
}