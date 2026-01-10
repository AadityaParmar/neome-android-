// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.drawer.sig

import com.neome.api.nucleus.base.Types.AnyPrefixKey
import com.neome.api.nucleus.base.sig.Sig

interface SigGroupCandidateMap : Sig {
    val candidateMap: Map<AnyPrefixKey, List<SigUserAvatar>>
}
