// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.app.ai.sig

import com.neome.api.nucleus.base.sig.Sig

open class SigAiNeoScriptGen : Sig()
{
  var error: String? = null
  var neoScripts: Array<String>? = null
  var userMessage: String? = null
}