// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.app.ai.sig

import com.neome.api.nucleus.base.sig.Sig

interface SigAiNeoScriptGet : Sig
{
  val error: String?
  val neoScript: String?
  val userMessage: String?
}