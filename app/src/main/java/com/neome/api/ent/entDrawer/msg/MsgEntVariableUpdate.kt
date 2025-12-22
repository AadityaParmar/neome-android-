// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.entDrawer.msg

import com.neome.api.meta.base.Types.MetaIdVar
import com.neome.api.nucleus.base.msg.Msg

class MsgEntVariableUpdate : Msg() {
    var variableObjectMap: Record<MetaIdVar, any>? = null
}
