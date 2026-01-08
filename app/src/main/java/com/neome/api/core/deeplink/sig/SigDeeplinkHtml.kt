// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.core.deeplink.sig

import java.util.Map
import com.neome.api.nucleus.base.sig.Sig

interface SigDeeplinkHtml : Sig
{
  val content: String?
  val contentHeaders: Map<String, String>?
  val contentType: String?
  val isBase64Content: Boolean?
}