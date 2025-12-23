// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.entMain.sig

import kotlin.properties.Delegates
import com.neome.api.nucleus.base.sig.Sig

open class SigEntVarSeq : Sig()
{
  var endSeq: Number by Delegates.notNull<Number>()
  var startSeq: Number by Delegates.notNull<Number>()
}