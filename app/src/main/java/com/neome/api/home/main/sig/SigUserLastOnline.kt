// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.main.sig

import com.neome.api.meta.base.Types.EntId
import com.neome.api.meta.base.Types.EntUserId
import com.neome.api.nucleus.base.sig.Sig

class SigUserLastOnline : Sig() {
    val entId: EntId
    val entUserId: EntUserId
    var lastOnline: string? = null
    var online: boolean? = null
}
