// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.store.store.sig

import com.neome.api.meta.base.Types.ArtifactId
import com.neome.api.nucleus.base.sig.Sig
import com.neome.api.studio.base.dto.DtoNeatPathSearchResult

class SigStoreSearch : Sig() {
    val searchResultMap: Record<ArtifactId, DtoNeatPathSearchResult>
}
