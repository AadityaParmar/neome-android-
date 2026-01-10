// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.agent.sig

import com.neome.api.ent.base.dto.GuaranteedRequest
import com.neome.api.nucleus.base.sig.Sig

interface SigGuaranteedRequestListGet : Sig {
    val bottomOffset: Long?
    val list: List<GuaranteedRequest>
    val pageBottomOffset: Long?
}
