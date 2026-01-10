// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.entMain.msg

import com.neome.api.meta.base.Types.EntId
import com.neome.api.nucleus.base.msg.Msg
import kotlinx.serialization.json.JsonElement

interface MsgLocationLogPut : Msg {
    val entIdSet: List<EntId>
    val name: String
    val summary: JsonElement
}
