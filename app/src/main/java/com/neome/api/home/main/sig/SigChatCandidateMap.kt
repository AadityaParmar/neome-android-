// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.main.sig

import com.neome.api.home.base.dto.DtoNewChatCandidate
import com.neome.api.nucleus.base.Types.AnyPrefixKey
import com.neome.api.nucleus.base.sig.Sig

class SigChatCandidateMap : Sig() {
    val candidateMap: Record<AnyPrefixKey, DtoNewChatCandidate[]>
}
