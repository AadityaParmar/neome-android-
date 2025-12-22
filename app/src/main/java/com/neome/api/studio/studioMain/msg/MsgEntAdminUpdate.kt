// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.studio.studioMain.msg

import com.neome.api.meta.base.Types.AdminId
import com.neome.api.meta.base.Types.EnumDefnAdminDoNotOptionEnt
import com.neome.api.meta.base.dto.StudioModuleSelection
import com.neome.api.nucleus.base.msg.Msg

class MsgEntAdminUpdate : Msg() {
    val adminId: AdminId
    var doNotEditOptionSet: EnumDefnAdminDoNotOptionEnt[]? = null
    var doNotShowOptionSet: EnumDefnAdminDoNotOptionEnt[]? = null
    var handle: string? = null
    var modules: StudioModuleSelection? = null
    val nickName: string
}
