// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.studio.studioDrawer.msg

import com.neome.api.meta.base.Types.EntId
import com.neome.api.nucleus.base.msg.Msg

class MsgStudioEntMergeTest : Msg() {
    val srcEntId: EntId
    val tgtEntId: EntId
}
