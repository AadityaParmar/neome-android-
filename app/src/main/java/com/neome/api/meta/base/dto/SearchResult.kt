// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import java.util.Map
import com.neome.api.meta.base.Types.SearchPath
import java.util.Set

open class SearchResult
{
  var result: Map<SearchPath, Array<String>>? = null
}