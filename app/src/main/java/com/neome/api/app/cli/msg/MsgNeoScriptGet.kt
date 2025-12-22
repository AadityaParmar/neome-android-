// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.app.cli.msg

import com.neome.api.meta.base.SysId
import com.neome.api.meta.base.Types.ArtifactId
import com.neome.api.meta.base.Types.TimeZoneKey
import com.neome.api.nucleus.base.msg.Msg

class MsgNeoScriptGet : Msg() {
    val artifactId: ArtifactId
    val displayDateFormat: string
    var metaId: SysId? = null
    val timeZone: TimeZoneKey
}
