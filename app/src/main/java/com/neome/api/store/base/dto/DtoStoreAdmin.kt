// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.store.base.dto

import com.neome.api.meta.base.Types.AdminId
import com.neome.api.meta.base.Types.EnumDefnAdminDoNotOptionStoreItem

class DtoStoreAdmin {
    val adminId: AdminId
    val doNotEditOptionSet: EnumDefnAdminDoNotOptionStoreItem[]
    val doNotShowOptionSet: EnumDefnAdminDoNotOptionStoreItem[]
    val handle: string
    val hasLock: boolean
    var isCurrentUser: boolean? = null
    val isMember: boolean
    val nickName: string
}
