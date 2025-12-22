// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.studio.base.dto

import com.neome.api.meta.base.Types.SearchPath
import com.neome.api.meta.base.dto.NeatPath
import com.neome.api.meta.base.dto.SearchResult

class DtoNeatPathSearchResult {
    var neatPathMap: Record<SearchPath, NeatPath>? = null
    var searchResult: SearchResult? = null
}
