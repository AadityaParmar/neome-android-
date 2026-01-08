// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.app.cli.msg

import com.neome.api.meta.base.Types.ArtifactId
import com.neome.api.nucleus.base.msg.Msg
import com.neome.api.meta.base.SysId
import com.neome.api.meta.base.Types.TimeZoneKey

interface MsgNeoScriptGet : Msg
{
  val artifactId: ArtifactId
  val displayDateFormat: String
  val metaId: SysId?
  val timeZone: TimeZoneKey
}