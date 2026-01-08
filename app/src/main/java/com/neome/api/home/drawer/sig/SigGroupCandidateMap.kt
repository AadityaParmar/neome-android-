// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.drawer.sig

import com.neome.api.nucleus.base.Types.AnyPrefixKey
import com.neome.api.nucleus.base.sig.Sig
import com.neome.api.home.drawer.sig.SigUserAvatar

interface SigGroupCandidateMap : Sig
{
  val candidateMap: Map<AnyPrefixKey, Array<SigUserAvatar>>
}