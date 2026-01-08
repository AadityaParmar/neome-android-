// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.app.ai.sig

import com.neome.api.nucleus.base.sig.Sig

interface SigAiNeoQLGet : Sig
{
  val error: Boolean
  val errorReason: String?
  val response: String?
}