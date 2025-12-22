// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.studio.base.dto

import com.neome.api.meta.base.Types.AdminId
import com.neome.api.meta.base.Types.EnumDefnAdminDoNotOptionEnt
import com.neome.api.meta.base.dto.StudioModuleSelection

class DtoEntAdmin {
    val adminId: AdminId
    val createdOn: string
    var doNotEditOptionSet: EnumDefnAdminDoNotOptionEnt[]? = null
    var doNotShowOptionSet: EnumDefnAdminDoNotOptionEnt[]? = null
    val handle: string
    val hasLock: boolean
    var isCurrentUser: boolean? = null
    val isMember: boolean
    val modules: StudioModuleSelection
    val nickName: string
    val updatedOn: string
}
