package com.neome.core.common.serializer.api.nucleus.base.dto

import com.neome.api.meta.base.dto.EnvValidationError
import com.neome.api.nucleus.base.Types.EnumEnvErrorCode
import com.neome.api.nucleus.base.dto.EnvError
import com.neome.core.common.serializer.api.meta.base.dto.EnvValidationErrorData
import kotlinx.serialization.Serializable


@Serializable
data class EnvErrorData(
    override val errorCode: EnumEnvErrorCode? = null,
    override val errorMessage: String? = null,
    override val errorParams: List<String>? = null,
    override val validationErrors: List<EnvValidationErrorData>? = null
) : EnvError
