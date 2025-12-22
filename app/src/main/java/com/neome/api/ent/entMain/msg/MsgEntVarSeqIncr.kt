// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.entMain.msg

import com.neome.api.meta.base.Types.MetaIdVar
import com.neome.api.nucleus.base.msg.Msg

class MsgEntVarSeqIncr : Msg() {
    val seqVarId: MetaIdVar
    var step: number? = null
}
