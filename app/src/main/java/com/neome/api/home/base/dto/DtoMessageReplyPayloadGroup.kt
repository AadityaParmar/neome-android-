// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.base.dto

import com.neome.api.home.base.dto.DtoMessageReplyPayload
import com.neome.api.meta.base.Types.EntId
import com.neome.api.meta.base.Types.GroupId
import com.neome.api.meta.base.Types.MediaIdAvatar

interface DtoMessageReplyPayloadGroup : DtoMessageReplyPayload
{
  val about: String?
  val entId: EntId?
  val groupId: GroupId?
  val mediaIdAvatar: MediaIdAvatar?
  val name: String?
}