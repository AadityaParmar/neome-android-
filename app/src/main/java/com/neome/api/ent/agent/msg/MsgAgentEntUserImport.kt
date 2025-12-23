// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.agent.msg

import com.neome.api.ent.base.dto.DtoAgentEntUserImport
import com.neome.api.nucleus.base.msg.Msg

open class MsgAgentEntUserImport : Msg() {
    var ignoreManager: Boolean? = null
    var ignoreUserSettings: Boolean? = null
    lateinit var users: Array<DtoAgentEntUserImport>
}
