// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.entDrawer.msg

import com.neome.api.meta.base.Types.MetaIdVar
import com.neome.api.nucleus.base.msg.Msg
import java.util.Map

open class MsgEntVariableUpdate : Msg() {
    var variableObjectMap: Map<MetaIdVar, Any>? = null
}
