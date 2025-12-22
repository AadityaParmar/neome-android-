// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.studio.studioMain.msg

import com.neome.api.meta.base.Types.AdminId
import com.neome.api.meta.base.Types.EnumDefnAdminDoNotOptionEnt
import com.neome.api.nucleus.base.msg.Msg
import com.neome.api.meta.base.dto.StudioModuleSelection

class MsgEntAdminAdd : Msg() {
    val adminId: AdminId
    var doNotEditOptionSet: EnumDefnAdminDoNotOptionEnt[]? = null
    var doNotShowOptionSet: EnumDefnAdminDoNotOptionEnt[]? = null
    val handle: string
    var modules: StudioModuleSelection? = null
    val nickName: string
}
