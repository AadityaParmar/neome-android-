// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.core.user.sig

import com.neome.api.nucleus.base.sig.Sig

interface SigAppVersion : Sig
{
  val currVersionCode: Long?
  val hasForceUpdate: Boolean
  val hasUpdate: Boolean
  val mmkvVersion: Long?
  val sqlVersion: Long?
}