// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.core.base.sig

import com.neome.api.meta.base.AnyKey
import com.neome.api.nucleus.base.sig.Sig
import kotlin.properties.Delegates

open class SigVerifyKey : Sig() {
    var expiryMins: Number by Delegates.notNull<Number>()
    lateinit var verifyKey: AnyKey
}
