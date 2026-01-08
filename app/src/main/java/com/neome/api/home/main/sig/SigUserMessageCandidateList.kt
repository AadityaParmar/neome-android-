// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.main.sig

import com.neome.api.nucleus.base.Types.AnyPrefixKey
import com.neome.api.nucleus.base.sig.Sig
import com.neome.api.home.drawer.sig.SigUserAvatar

interface SigUserMessageCandidateList : Sig
{
  val candidateMap: Map<AnyPrefixKey, Array<SigUserAvatar>>
}