// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.core.user.sig

import com.neome.api.nucleus.base.sig.Sig

class SigAppVersion : Sig() {
    val currVersionCode: number
    val hasForceUpdate: boolean
    val hasUpdate: boolean
    val mmkvVersion: number
    val sqlVersion: number
}
