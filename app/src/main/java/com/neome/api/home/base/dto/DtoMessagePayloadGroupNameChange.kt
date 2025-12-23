// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.base.dto

import com.neome.api.home.base.dto.DtoGroupMemberKey
import com.neome.api.home.base.dto.DtoMessagePayload

open class DtoMessagePayloadGroupNameChange : DtoMessagePayload()
{
  lateinit var initiatorMember: DtoGroupMemberKey
  lateinit var newSubject: String
}