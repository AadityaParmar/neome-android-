// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.nucleus.api.sig

import com.neome.api.nucleus.base.dto.DescApiModule
import com.neome.api.nucleus.base.dto.DescApiPushSigs
import com.neome.api.nucleus.base.sig.Sig

class SigApiLib : Sig() {
    val api: Record<string, DescApiModule>
    val pushSigs: DescApiPushSigs
}
