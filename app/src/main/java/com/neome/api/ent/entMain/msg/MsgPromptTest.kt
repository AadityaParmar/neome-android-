// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.entMain.msg

import com.neome.api.nucleus.base.msg.Msg

open class MsgPromptTest : Msg() {
    lateinit var handle: String
    lateinit var promptText: String
}
