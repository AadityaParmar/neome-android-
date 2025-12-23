// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.core.cluster.msg

import com.neome.api.meta.base.Types.EntId
import com.neome.api.nucleus.base.msg.Msg

open class MsgClusterItemDataGet : Msg() {
    lateinit var clusterItemId: String
    var entId: EntId? = null
}
