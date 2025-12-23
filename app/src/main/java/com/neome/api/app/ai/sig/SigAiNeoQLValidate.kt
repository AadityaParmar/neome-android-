// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.app.ai.sig

import com.neome.api.nucleus.base.sig.Sig
import kotlin.properties.Delegates

open class SigAiNeoQLValidate : Sig() {
    var error: Boolean by Delegates.notNull<Boolean>()
    var errorReason: String? = null
}
