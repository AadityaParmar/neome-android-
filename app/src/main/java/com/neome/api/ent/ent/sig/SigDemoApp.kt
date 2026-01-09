// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.ent.sig

import kotlinx.serialization.json.JsonElement
import com.neome.api.meta.base.Types.DemoAppId
import com.neome.api.meta.base.Types.EntId
import com.neome.api.nucleus.base.sig.Sig

interface SigDemoApp : Sig
{
  val app: JsonElement
  val demoAppId: DemoAppId
  val entId: EntId
}