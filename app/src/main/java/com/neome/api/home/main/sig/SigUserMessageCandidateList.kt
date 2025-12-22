// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.main.sig

import com.neome.api.home.drawer.sig.SigUserAvatar
import com.neome.api.nucleus.base.Types.AnyPrefixKey
import com.neome.api.nucleus.base.sig.Sig

class SigUserMessageCandidateList : Sig() {
    val candidateMap: Record<AnyPrefixKey, SigUserAvatar[]>
}
