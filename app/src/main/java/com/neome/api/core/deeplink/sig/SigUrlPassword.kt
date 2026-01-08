// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.core.deeplink.sig

import com.neome.api.core.deeplink.sig.SigUrl

interface SigUrlPassword : SigUrl
{
  val password: String?
}