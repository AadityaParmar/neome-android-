// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.base.dto

import com.neome.api.meta.base.Types.EntUserId

open class DtoGroupMemberKey {
    lateinit var entUserId: EntUserId
    lateinit var handle: String
    lateinit var name: String
}
