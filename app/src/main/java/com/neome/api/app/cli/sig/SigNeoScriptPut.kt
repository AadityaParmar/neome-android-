// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.app.cli.sig

import com.neome.api.meta.base.Types.ArtifactId
import com.neome.api.meta.base.dto.DtoLogItemList
import com.neome.api.nucleus.base.sig.Sig

class SigNeoScriptPut : Sig() {
    var appendItemList: DtoLogItemList? = null
    var cliCodeId: string? = null
    var lastArtifactName: string? = null
    var lastDeployUnitId: ArtifactId? = null
}
