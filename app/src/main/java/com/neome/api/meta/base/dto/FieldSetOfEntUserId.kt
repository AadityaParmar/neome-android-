// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EntUserId

open class FieldSetOfEntUserId
{
  var displaySet: Array<String>? = null
  lateinit var valueSet: Array<EntUserId>
}