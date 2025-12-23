// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.base.dto

open class DtoMessagePayloadGroupAvatarChange : DtoMessagePayload() {
    lateinit var initiatorMember: DtoGroupMemberKey
}
