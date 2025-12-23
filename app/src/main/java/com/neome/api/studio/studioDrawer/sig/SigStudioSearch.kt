// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.studio.studioDrawer.sig

import com.neome.api.meta.base.Types.ArtifactId
import com.neome.api.studio.base.dto.DtoNeatPathSearchResult
import java.util.Map
import com.neome.api.nucleus.base.sig.Sig

open class SigStudioSearch : Sig()
{
  lateinit var searchResultMap: Map<ArtifactId, DtoNeatPathSearchResult>
}