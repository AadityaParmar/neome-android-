// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.core.user.sig

import com.neome.api.nucleus.base.sig.Sig
import kotlin.properties.Delegates

open class SigBearerToken : Sig() {
    lateinit var bearerToken: String
    var caller: SigCaller? = null
    var updateRefreshToken: Boolean by Delegates.notNull<Boolean>()
}
