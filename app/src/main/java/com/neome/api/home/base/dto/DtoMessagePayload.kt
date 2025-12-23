// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.base.dto

import com.neome.api.meta.base.Types.ContactId
import com.neome.api.home.base.Types.EnumMessageType
import java.util.Map

open class DtoMessagePayload
{
  var isForwarded: Boolean? = null
  var mentionMap: Map<String, ContactId>? = null
  lateinit var messageType: EnumMessageType
}