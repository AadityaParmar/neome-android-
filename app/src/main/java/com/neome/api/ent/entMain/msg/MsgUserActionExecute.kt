// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.entMain.msg

import com.neome.api.meta.base.Types.MetaIdAction
import com.neome.api.meta.base.Types.MetaIdLayoutUser
import com.neome.api.nucleus.base.msg.Msg

open class MsgUserActionExecute : Msg() {
    lateinit var actionId: MetaIdAction
    lateinit var layoutId: MetaIdLayoutUser
}
