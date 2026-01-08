// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.base.dto

import com.neome.api.home.base.dto.DtoGroupMemberKey
import com.neome.api.home.base.dto.DtoMessagePayload

interface DtoMessagePayloadGroupAvatarChange : DtoMessagePayload
{
  val initiatorMember: DtoGroupMemberKey
}