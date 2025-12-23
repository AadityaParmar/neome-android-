// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.agent.sig

import kotlin.properties.Delegates
import com.neome.api.ent.base.dto.GuaranteedRequest
import com.neome.api.nucleus.base.sig.Sig

open class SigGuaranteedRequestListGet : Sig()
{
  var bottomOffset: Number by Delegates.notNull<Number>()
  lateinit var list: Array<GuaranteedRequest>
  var pageBottomOffset: Number by Delegates.notNull<Number>()
}