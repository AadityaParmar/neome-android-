// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.app.cli.msg

import com.neome.api.meta.base.Types.ArtifactId
import com.neome.api.meta.base.Types.MetaIdModule
import com.neome.api.nucleus.base.msg.Msg
import com.neome.api.meta.base.Types.TimeZoneKey

interface MsgNeoScriptPut : Msg
{
  val artifactId: ArtifactId
  val cliCodeId: String?
  val displayDateFormat: String
  val moduleId: MetaIdModule?
  val neoScriptOrUserMessage: String
  val timeZone: TimeZoneKey
}