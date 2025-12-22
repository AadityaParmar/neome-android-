// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.app.cli.msg

import com.neome.api.meta.base.Types.ArtifactId
import com.neome.api.meta.base.Types.MetaIdModule
import com.neome.api.meta.base.Types.TimeZoneKey
import com.neome.api.nucleus.base.msg.Msg

class MsgNeoScriptPut : Msg() {
    val artifactId: ArtifactId
    var cliCodeId: string? = null
    val displayDateFormat: string
    var moduleId: MetaIdModule? = null
    val neoScriptOrUserMessage: string
    val timeZone: TimeZoneKey
}
