// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.core.cluster.msg

import com.neome.api.meta.base.Types.EntId
import com.neome.api.nucleus.base.msg.Msg

class MsgClusterItemDataGet : Msg() {
    val clusterItemId: string
    var entId: EntId? = null
}
