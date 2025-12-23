// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.main.sig

import com.neome.api.home.drawer.sig.SigUserAvatar
import com.neome.api.nucleus.base.Types.AnyPrefixKey
import com.neome.api.nucleus.base.sig.Sig
import java.util.Map

open class SigUserMessageCandidateList : Sig() {
    lateinit var candidateMap: Map<AnyPrefixKey, Array<SigUserAvatar>>
}
