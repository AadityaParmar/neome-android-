package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.SearchResult
import com.neome.core.common.serializer.sysId.SearchPathSer
import kotlinx.serialization.Serializable


@Serializable
data class SearchResultData(
    override val result: Map<@Serializable(with = SearchPathSer::class) Types.SearchPath, List<String>>? = null
) : SearchResult
