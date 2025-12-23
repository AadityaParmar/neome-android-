// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.entMain.sig

import com.neome.api.nucleus.base.sig.Sig
import kotlin.properties.Delegates

open class SigEntVarSeq : Sig() {
    var endSeq: Number by Delegates.notNull<Number>()
    var startSeq: Number by Delegates.notNull<Number>()
}
