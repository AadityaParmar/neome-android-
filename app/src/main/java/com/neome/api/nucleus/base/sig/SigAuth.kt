// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.nucleus.base.sig

import kotlin.properties.Delegates
import com.neome.api.nucleus.base.sig.Sig

open class SigAuth : Sig()
{
  var unauthorizedBearerToken: Boolean by Delegates.notNull<Boolean>()
}