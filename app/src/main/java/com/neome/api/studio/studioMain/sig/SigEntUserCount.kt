// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.studio.studioMain.sig

import kotlin.properties.Delegates
import com.neome.api.nucleus.base.sig.Sig

open class SigEntUserCount : Sig()
{
  var acceptedInvite: Number by Delegates.notNull<Number>()
  var total: Number by Delegates.notNull<Number>()
}