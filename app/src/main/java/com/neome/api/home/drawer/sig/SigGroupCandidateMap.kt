// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.drawer.sig

import com.neome.api.nucleus.base.Types.AnyPrefixKey
import java.util.Map
import com.neome.api.nucleus.base.sig.Sig
import com.neome.api.home.drawer.sig.SigUserAvatar

open class SigGroupCandidateMap : Sig()
{
  lateinit var candidateMap: Map<AnyPrefixKey, Array<SigUserAvatar>>
}