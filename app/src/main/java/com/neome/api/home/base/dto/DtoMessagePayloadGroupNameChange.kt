// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.base.dto

class DtoMessagePayloadGroupNameChange : DtoMessagePayload() {
    val initiatorMember: DtoGroupMemberKey
    val newSubject: string
}
