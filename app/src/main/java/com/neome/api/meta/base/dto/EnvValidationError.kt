// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumEnvValidationError

class EnvValidationError {
    var children: EnvValidationError[]? = null
    var errorCode: EnumEnvValidationError? = null
    var errorMessage: string? = null
    var errorParams: string[]? = null
    var paramName: string? = null
    var paramNameSet: string[]? = null
}
