// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.core.deeplink.sig

import com.neome.api.nucleus.base.sig.Sig

class SigDeeplinkHtml : Sig() {
    var content: string? = null
    var contentHeaders: Record<string, string>? = null
    var contentType: string? = null
    var isBase64Content: boolean? = null
}
