// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.studio.studioMain.msg

import com.neome.api.meta.base.Types.AdminId
import com.neome.api.meta.base.Types.EnumDefnAdminDoNotOptionPlugin
import com.neome.api.meta.base.dto.StudioModuleSelection
import com.neome.api.nucleus.base.msg.Msg

class MsgPluginAdminUpdate : Msg() {
    val adminId: AdminId
    var doNotEditOptionSet: EnumDefnAdminDoNotOptionPlugin[]? = null
    var doNotShowOptionSet: EnumDefnAdminDoNotOptionPlugin[]? = null
    var handle: string? = null
    var modules: StudioModuleSelection? = null
    val nickName: string
}
