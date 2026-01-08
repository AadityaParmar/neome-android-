// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.base.dto

import com.neome.api.home.base.dto.DtoGroupMemberKey
import com.neome.api.home.base.dto.DtoMessagePayload

interface DtoMessagePayloadGroupNameChange : DtoMessagePayload
{
  val initiatorMember: DtoGroupMemberKey
  val newSubject: String
}