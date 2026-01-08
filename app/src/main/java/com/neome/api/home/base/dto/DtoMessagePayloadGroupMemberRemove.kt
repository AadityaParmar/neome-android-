// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.base.dto

import com.neome.api.home.base.dto.DtoGroupMemberKey
import com.neome.api.home.base.dto.DtoMessagePayload

interface DtoMessagePayloadGroupMemberRemove : DtoMessagePayload
{
  val initiatorMember: DtoGroupMemberKey
  val targetMember: DtoGroupMemberKey
}