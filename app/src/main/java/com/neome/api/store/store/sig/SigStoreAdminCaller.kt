// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.store.store.sig

import com.neome.api.meta.base.Types.AdminId
import com.neome.api.meta.base.Types.EnumDefnAdminDoNotOptionStoreItem
import com.neome.api.nucleus.base.sig.Sig

class SigStoreAdminCaller : Sig() {
    val adminId: AdminId
    var doNotEditOptionSet: EnumDefnAdminDoNotOptionStoreItem[]? = null
    var doNotShowOptionSet: EnumDefnAdminDoNotOptionStoreItem[]? = null
    var hasLock: boolean? = null
    val nickName: string
}
