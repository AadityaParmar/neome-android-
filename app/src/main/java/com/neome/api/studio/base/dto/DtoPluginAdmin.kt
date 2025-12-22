// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.studio.base.dto

import com.neome.api.meta.base.Types.AdminId
import com.neome.api.meta.base.Types.EnumDefnAdminDoNotOptionPlugin

class DtoPluginAdmin {
    val adminId: AdminId
    val doNotEditOptionSet: EnumDefnAdminDoNotOptionPlugin[]
    val doNotShowOptionSet: EnumDefnAdminDoNotOptionPlugin[]
    val handle: string
    val hasLock: boolean
    var isCurrentUser: boolean? = null
    val isMember: boolean
    val nickName: string
}
