// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.core.base.sig

import com.neome.api.meta.base.AnyKey
import com.neome.api.nucleus.base.sig.Sig

interface SigVerifyKey : Sig
{
  val expiryMins: Long?
  val verifyKey: AnyKey
}