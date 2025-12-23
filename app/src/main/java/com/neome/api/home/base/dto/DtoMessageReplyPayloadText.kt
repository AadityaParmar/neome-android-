// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.base.dto

import com.neome.api.home.base.dto.DtoMessageReplyPayload

open class DtoMessageReplyPayloadText : DtoMessageReplyPayload()
{
  lateinit var textSummary: String
}