package com.neome.core.common.serializer.api.nucleus.base.dto

import com.neome.api.meta.base.dto.EnvValidationError
import com.neome.api.nucleus.base.Types.EnumEnvErrorCode
import com.neome.api.nucleus.base.dto.EnvError
import kotlinx.serialization.Serializable


@Serializable
data class EnvErrorData(
    override val errorCode: EnumEnvErrorCode? = null,
    override val errorMessage: String? = null,
    override val errorParams: Array<String>? = null,
    override val validationErrors: Array<EnvValidationError>? = null
) : EnvError
