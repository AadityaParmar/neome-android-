package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.EnvValidationError
import com.neome.api.meta.base.dto.ValidationResult
import com.neome.core.common.serializer.api.meta.base.dto.EnvValidationErrorData
import com.neome.core.common.serializer.sysId.SearchPathSer
import kotlinx.serialization.Serializable


@Serializable
data class ValidationResultData(
    override val errorCountMap: Map<@Serializable(with = SearchPathSer::class) Types.SearchPath, Long>? = null,
    override val errorMap: Map<@Serializable(with = SearchPathSer::class) Types.SearchPath, EnvValidationErrorData>? = null
) : ValidationResult
