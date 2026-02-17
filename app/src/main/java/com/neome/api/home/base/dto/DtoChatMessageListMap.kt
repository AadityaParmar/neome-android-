// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.base.dto

import com.neome.api.meta.base.Types.ChatId
import com.neome.api.home.main.sig.SigMessage

interface DtoChatMessageListMap
{
  val chatMessageListMap: Map<ChatId, List<SigMessage>>?
}