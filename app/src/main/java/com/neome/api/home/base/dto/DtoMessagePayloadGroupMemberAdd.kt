// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.base.dto

class DtoMessagePayloadGroupMemberAdd : DtoMessagePayload() {
    val initiatorMember: DtoGroupMemberKey
    val targetMember: DtoGroupMemberKey
}
