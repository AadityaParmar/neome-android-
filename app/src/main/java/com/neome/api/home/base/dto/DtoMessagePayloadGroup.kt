// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.base.dto

import com.neome.api.home.base.dto.DtoMessagePayload
import com.neome.api.meta.base.Types.EntId
import com.neome.api.meta.base.Types.GroupId
import com.neome.api.meta.base.Types.MediaIdAvatar

interface DtoMessagePayloadGroup : DtoMessagePayload
{
  val about: String?
  val entId: EntId?
  val groupId: GroupId?
  val mediaIdAvatar: MediaIdAvatar?
  val name: String?
}