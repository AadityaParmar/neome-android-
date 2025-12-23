// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.studio.studioMain.msg

import com.neome.api.ent.base.dto.DtoEntConfig
import com.neome.api.nucleus.base.msg.Msg

open class MsgEntConfigUpdate : Msg() {
    lateinit var config: DtoEntConfig
}
