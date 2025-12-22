// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.app.ai.msg

import com.neome.api.app.base.Types.EnumKindAiAssist
import com.neome.api.meta.base.Types.MetaId
import com.neome.api.nucleus.base.msg.Msg

class MsgAiNeoScriptGet : Msg() {
    val kind: EnumKindAiAssist
    val neoScriptOrUserMessage: string
    var paramPath: MetaId[]? = null
}
