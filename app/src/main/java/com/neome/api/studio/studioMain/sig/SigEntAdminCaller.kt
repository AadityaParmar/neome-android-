// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.studio.studioMain.sig

import com.neome.api.meta.base.Types.AdminId
import com.neome.api.meta.base.Types.EnumDefnAdminDoNotOptionEnt
import com.neome.api.meta.base.dto.StudioModuleSelection
import com.neome.api.nucleus.base.sig.Sig

open class SigEntAdminCaller : Sig() {
    lateinit var adminId: AdminId
    var doNotEditOptionSet: Array<EnumDefnAdminDoNotOptionEnt>? = null
    var doNotShowOptionSet: Array<EnumDefnAdminDoNotOptionEnt>? = null
    var hasLock: Boolean? = null
    var modules: StudioModuleSelection? = null
    lateinit var nickName: String
}
