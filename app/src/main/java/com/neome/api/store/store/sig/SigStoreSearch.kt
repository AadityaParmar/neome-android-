// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.store.store.sig

import com.neome.api.meta.base.Types.ArtifactId
import com.neome.api.studio.base.dto.DtoNeatPathSearchResult
import java.util.Map
import com.neome.api.nucleus.base.sig.Sig

open class SigStoreSearch : Sig()
{
  lateinit var searchResultMap: Map<ArtifactId, DtoNeatPathSearchResult>
}