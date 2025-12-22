// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.studio.studioDrawer.msg

import com.neome.api.core.base.dto.DtoCloneConfig
import com.neome.api.nucleus.base.msg.Msg

class MsgArtifactDuplicate : Msg() {
    var cloneConfig: DtoCloneConfig? = null
    val includeData: boolean
}
