// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.app.ai.sig

import com.neome.api.nucleus.base.sig.Sig

class SigAiNeoScriptGet : Sig() {
    var error: string? = null
    var neoScript: string? = null
    var userMessage: string? = null
}
