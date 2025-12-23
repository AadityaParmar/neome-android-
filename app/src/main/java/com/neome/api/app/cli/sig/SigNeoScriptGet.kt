// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.app.cli.sig

import com.neome.api.meta.base.Types.ArtifactId
import com.neome.api.nucleus.base.sig.Sig
import com.neome.api.meta.base.SysId

open class SigNeoScriptGet : Sig()
{
  lateinit var artifactId: ArtifactId
  var metaId: SysId? = null
  var neoScript: String? = null
}