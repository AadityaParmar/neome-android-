// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.base.dto

import com.neome.api.home.base.dto.DtoMessagePayload

open class DtoMessagePayloadText : DtoMessagePayload()
{
  var isUpdated: Boolean? = null
  lateinit var text: String
}