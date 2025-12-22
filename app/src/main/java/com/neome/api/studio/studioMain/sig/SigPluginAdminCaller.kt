// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.studio.studioMain.sig

import com.neome.api.meta.base.Types.AdminId
import com.neome.api.meta.base.Types.EnumDefnAdminDoNotOptionPlugin
import com.neome.api.nucleus.base.sig.Sig

class SigPluginAdminCaller : Sig() {
    val adminId: AdminId
    var doNotEditOptionSet: EnumDefnAdminDoNotOptionPlugin[]? = null
    var doNotShowOptionSet: EnumDefnAdminDoNotOptionPlugin[]? = null
    var hasLock: boolean? = null
    val nickName: string
}
