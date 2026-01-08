// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.base.dto

import com.neome.api.home.base.dto.DtoMessagePayload
import com.neome.api.meta.base.Types.EntId
import com.neome.api.meta.base.Types.EntUserId
import com.neome.api.meta.base.Types.MediaIdAvatar

interface DtoMessagePayloadUser : DtoMessagePayload
{
  val entId: EntId?
  val entUserId: EntUserId?
  val handle: String
  val mediaIdAvatar: MediaIdAvatar?
  val nickName: String
}