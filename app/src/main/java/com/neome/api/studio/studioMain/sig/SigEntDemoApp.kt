// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.studio.studioMain.sig

import com.neome.api.meta.base.Types.DemoAppId
import com.neome.api.nucleus.base.sig.Sig

open class SigEntDemoApp : Sig()
{
  var app: Object? = null
  var demoAppId: DemoAppId? = null
}