// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.main.sig

import com.neome.api.home.drawer.sig.SigGroupAvatar
import com.neome.api.nucleus.base.Types.AnyPrefixKey
import com.neome.api.nucleus.base.sig.Sig

class SigGroupMessageCandidateList : Sig() {
    val candidateMap: Record<AnyPrefixKey, SigGroupAvatar[]>
}
