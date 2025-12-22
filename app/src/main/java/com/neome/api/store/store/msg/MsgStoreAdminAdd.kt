// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.store.store.msg

import com.neome.api.meta.base.Types.AdminId
import com.neome.api.meta.base.Types.EnumDefnAdminDoNotOptionStoreItem
import com.neome.api.meta.base.dto.StudioModuleSelection
import com.neome.api.nucleus.base.msg.Msg

class MsgStoreAdminAdd : Msg() {
    val adminId: AdminId
    var doNotEditOptionSet: EnumDefnAdminDoNotOptionStoreItem[]? = null
    var doNotShowOptionSet: EnumDefnAdminDoNotOptionStoreItem[]? = null
    val handle: string
    var modules: StudioModuleSelection? = null
    val nickName: string
}
