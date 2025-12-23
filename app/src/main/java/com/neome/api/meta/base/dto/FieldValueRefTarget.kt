// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.RowId

open class FieldValueRefTarget
{
  var displayValue: String? = null
  lateinit var token: String
  lateinit var value: RowId
  var version: String? = null
}