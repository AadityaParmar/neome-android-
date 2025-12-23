// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.core.deeplink.sig

import com.neome.api.nucleus.base.sig.Sig
import java.util.Map

open class SigDeeplinkHtml : Sig() {
    var content: String? = null
    var contentHeaders: Map<String, String>? = null
    var contentType: String? = null
    var isBase64Content: Boolean? = null
}
