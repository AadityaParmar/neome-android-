package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumEnvValidationError
import com.neome.api.meta.base.dto.EnvValidationError
import kotlinx.serialization.Serializable


@Serializable
data class EnvValidationErrorData(
    override val children: Array<EnvValidationError>? = null,
    override val errorCode: EnumEnvValidationError? = null,
    override val errorMessage: String? = null,
    override val errorParams: Array<String>? = null,
    override val paramName: String? = null,
    override val paramNameSet: Array<String>? = null
) : EnvValidationError
