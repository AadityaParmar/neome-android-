// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.core.user.sig

import com.neome.api.nucleus.base.sig.Sig
import com.neome.api.core.user.sig.SigCaller

interface SigBearerToken : Sig
{
  val bearerToken: String
  val caller: SigCaller?
  val updateRefreshToken: Boolean
}