// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.SearchPath
import java.util.Map

open class SearchResult {
    var result: Map<SearchPath, Array<String>>? = null
}
