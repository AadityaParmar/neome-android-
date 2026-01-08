// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.base.dto

import com.neome.api.meta.base.Types.ChatId

interface DtoChatBadgeMap
{
  val chatBadgeMap: Map<ChatId, Number>?
}