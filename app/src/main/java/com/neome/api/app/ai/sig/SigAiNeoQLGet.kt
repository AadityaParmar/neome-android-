// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.app.ai.sig

import com.neome.api.nucleus.base.sig.Sig

class SigAiNeoQLGet : Sig() {
    val error: boolean
    var errorReason: string? = null
    var response: string? = null
}
