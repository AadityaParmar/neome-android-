// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.app.cli.msg

import com.neome.api.app.base.dto.DtoNeoScript
import com.neome.api.meta.base.Types.MetaIdModule
import com.neome.api.nucleus.base.msg.Msg

class MsgNeoScriptCtxSet : Msg() {
    var cliCodeId: string? = null
    val ctx: DtoNeoScript
    var moduleId: MetaIdModule? = null
}
