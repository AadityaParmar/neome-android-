// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.app.ai.sig

import com.neome.api.nucleus.base.sig.Sig

open class SigAiNeoScriptGet : Sig() {
    var error: String? = null
    var neoScript: String? = null
    var userMessage: String? = null
}
