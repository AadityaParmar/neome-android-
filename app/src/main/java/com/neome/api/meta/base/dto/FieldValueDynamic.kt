// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnCompType

open class FieldValueDynamic
{
  var fieldType: EnumDefnCompType? = null
  lateinit var value: String
}