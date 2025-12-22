// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.app.cli.sig

import com.neome.api.meta.base.SysId
import com.neome.api.meta.base.Types.ArtifactId
import com.neome.api.nucleus.base.sig.Sig

class SigNeoScriptGet : Sig() {
    val artifactId: ArtifactId
    var metaId: SysId? = null
    var neoScript: string? = null
}
