// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.studio.studioDrawer.msg

import com.neome.api.core.base.dto.DtoCloneConfig
import com.neome.api.nucleus.base.msg.Msg
import kotlin.properties.Delegates

open class MsgArtifactDuplicate : Msg() {
    var cloneConfig: DtoCloneConfig? = null
    var includeData: Boolean by Delegates.notNull<Boolean>()
}
