// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.studio.studioDrawer.msg

import com.neome.api.meta.base.Types.ArtifactId
import com.neome.api.nucleus.base.msg.Msg

class MsgStudioSearch : Msg() {
    var filterArtifactIdSet: ArtifactId[]? = null
    val query: string
    val searchId: string
}
