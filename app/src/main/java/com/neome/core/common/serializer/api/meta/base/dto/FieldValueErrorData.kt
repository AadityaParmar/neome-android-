package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnErrorSeverity
import com.neome.api.meta.base.dto.FieldValueError
import kotlinx.serialization.Serializable


@Serializable
data class FieldValueErrorData(
    override val errorCounter: Long,
    override val errorParameterSet: List<String>? = null,
    override val errorReason: String,
    override val severity: EnumDefnErrorSeverity
) : FieldValueError
