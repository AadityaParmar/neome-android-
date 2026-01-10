package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumEnvValidationError
import com.neome.api.meta.base.dto.EnvValidationError
import com.neome.core.common.serializer.api.meta.base.dto.EnvValidationErrorData
import kotlinx.serialization.Serializable


@Serializable
data class EnvValidationErrorData(
    override val children: List<EnvValidationErrorData>? = null,
    override val errorCode: EnumEnvValidationError? = null,
    override val errorMessage: String? = null,
    override val errorParams: List<String>? = null,
    override val paramName: String? = null,
    override val paramNameSet: List<String>? = null
) : EnvValidationError
