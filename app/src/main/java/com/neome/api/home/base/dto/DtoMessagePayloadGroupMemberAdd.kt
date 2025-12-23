// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.base.dto

open class DtoMessagePayloadGroupMemberAdd : DtoMessagePayload() {
    lateinit var initiatorMember: DtoGroupMemberKey
    lateinit var targetMember: DtoGroupMemberKey
}
