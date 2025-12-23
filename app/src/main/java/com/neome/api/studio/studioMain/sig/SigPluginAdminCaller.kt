// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.studio.studioMain.sig

import com.neome.api.meta.base.Types.AdminId
import com.neome.api.meta.base.Types.EnumDefnAdminDoNotOptionPlugin
import com.neome.api.nucleus.base.sig.Sig

open class SigPluginAdminCaller : Sig() {
    lateinit var adminId: AdminId
    var doNotEditOptionSet: Array<EnumDefnAdminDoNotOptionPlugin>? = null
    var doNotShowOptionSet: Array<EnumDefnAdminDoNotOptionPlugin>? = null
    var hasLock: Boolean? = null
    lateinit var nickName: String
}
