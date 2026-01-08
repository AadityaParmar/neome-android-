// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.base.dto

import com.neome.api.home.base.dto.DtoMessageReplyPayload

interface DtoMessageReplyPayloadLinkText : DtoMessageReplyPayload
{
  val imageUrl: String?
  val textSummary: String
}