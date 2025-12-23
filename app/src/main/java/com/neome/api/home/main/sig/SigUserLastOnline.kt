// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.main.sig

import com.neome.api.meta.base.Types.EntId
import com.neome.api.meta.base.Types.EntUserId
import com.neome.api.nucleus.base.sig.Sig

open class SigUserLastOnline : Sig() {
    lateinit var entId: EntId
    lateinit var entUserId: EntUserId
    var lastOnline: String? = null
    var online: Boolean? = null
}
