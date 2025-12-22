// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.core.user.sig

import com.neome.api.nucleus.base.sig.Sig

class SigBearerToken : Sig() {
    val bearerToken: string
    var caller: SigCaller? = null
    val updateRefreshToken: boolean
}
