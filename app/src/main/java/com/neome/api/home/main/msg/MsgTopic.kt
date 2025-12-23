// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.main.msg

import com.neome.api.core.base.Types.EnumTopicType
import com.neome.api.meta.base.SysId
import com.neome.api.nucleus.base.msg.Msg

open class MsgTopic : Msg() {
    lateinit var aboutId: SysId
    lateinit var type: EnumTopicType
}
