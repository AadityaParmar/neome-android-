// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.app.cli.msg

import com.neome.api.meta.base.Types.ArtifactId
import com.neome.api.meta.base.Types.MetaIdModule
import com.neome.api.meta.base.Types.TimeZoneKey
import com.neome.api.nucleus.base.msg.Msg

open class MsgNeoScriptPut : Msg() {
    lateinit var artifactId: ArtifactId
    var cliCodeId: String? = null
    lateinit var displayDateFormat: String
    var moduleId: MetaIdModule? = null
    lateinit var neoScriptOrUserMessage: String
    lateinit var timeZone: TimeZoneKey
}
