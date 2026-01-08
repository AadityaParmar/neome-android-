// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.nucleus.api.sig

import com.neome.api.nucleus.base.dto.DescApiModule
import com.neome.api.nucleus.base.dto.DescApiPushSigs
import com.neome.api.nucleus.base.sig.Sig

interface SigApiLib : Sig
{
  val api: Map<String, DescApiModule>
  val pushSigs: DescApiPushSigs
}