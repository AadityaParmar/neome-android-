// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.nucleus.base.dto

import com.neome.api.meta.base.dto.EnvValidationError
import com.neome.api.nucleus.base.Types.EnumEnvErrorCode

class EnvError {
    var errorCode: EnumEnvErrorCode? = null
    var errorMessage: string? = null
    var errorParams: string[]? = null
    var validationErrors: EnvValidationError[]? = null
}
