// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.ent.msg

import com.neome.api.meta.base.Types.DemoAppId
import com.neome.api.nucleus.base.msg.Msg

open class MsgDemoApp : Msg() {
    lateinit var demoAppId: DemoAppId
}
