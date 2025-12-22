// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.agent.msg

import com.neome.api.ent.base.dto.DtoAgentEntUserImport
import com.neome.api.nucleus.base.msg.Msg

class MsgAgentEntUserImport : Msg() {
    var ignoreManager: boolean? = null
    var ignoreUserSettings: boolean? = null
    val users: DtoAgentEntUserImport[]
}
