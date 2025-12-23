// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.core.user.sig

import com.neome.api.nucleus.base.sig.Sig
import kotlin.properties.Delegates

open class SigAppVersion : Sig() {
    var currVersionCode: Number by Delegates.notNull<Number>()
    var hasForceUpdate: Boolean by Delegates.notNull<Boolean>()
    var hasUpdate: Boolean by Delegates.notNull<Boolean>()
    var mmkvVersion: Number by Delegates.notNull<Number>()
    var sqlVersion: Number by Delegates.notNull<Number>()
}
