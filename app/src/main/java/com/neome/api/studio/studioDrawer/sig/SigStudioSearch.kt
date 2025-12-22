// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.studio.studioDrawer.sig

import com.neome.api.meta.base.Types.ArtifactId
import com.neome.api.nucleus.base.sig.Sig
import com.neome.api.studio.base.dto.DtoNeatPathSearchResult

class SigStudioSearch : Sig() {
    val searchResultMap: Record<ArtifactId, DtoNeatPathSearchResult>
}
