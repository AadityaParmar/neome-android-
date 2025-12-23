// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.studio.studioMain.sig

import com.neome.api.meta.base.Types.AdminId
import com.neome.api.nucleus.base.sig.SigVersion

open class SigAdminEditLockDetail : SigVersion() {
    var adminId: AdminId? = null
    var handle: String? = null
    var nickName: String? = null
}
