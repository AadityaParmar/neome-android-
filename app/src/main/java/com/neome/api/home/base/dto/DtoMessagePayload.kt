// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.base.dto

import com.neome.api.meta.base.Types.ContactId
import com.neome.api.home.base.Types.EnumMessageType

interface DtoMessagePayload
{
  val isForwarded: Boolean?
  val mentionMap: Map<String, ContactId>?
  val messageType: EnumMessageType
}