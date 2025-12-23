// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.app.cli.msg

import com.neome.api.meta.base.Types.ArtifactId
import com.neome.api.nucleus.base.msg.Msg
import com.neome.api.meta.base.SysId
import com.neome.api.meta.base.Types.TimeZoneKey

open class MsgNeoScriptGet : Msg()
{
  lateinit var artifactId: ArtifactId
  lateinit var displayDateFormat: String
  var metaId: SysId? = null
  lateinit var timeZone: TimeZoneKey
}