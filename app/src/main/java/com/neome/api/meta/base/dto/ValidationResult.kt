// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.SearchPath

class ValidationResult {
    var errorCountMap: Record<SearchPath, number>? = null
    var errorMap: Record<SearchPath, EnvValidationError>? = null
}
