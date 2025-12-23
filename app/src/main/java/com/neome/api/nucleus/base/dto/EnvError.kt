// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.nucleus.base.dto

import com.neome.api.nucleus.base.Types.EnumEnvErrorCode
import com.neome.api.meta.base.dto.EnvValidationError

open class EnvError
{
  var errorCode: EnumEnvErrorCode? = null
  var errorMessage: String? = null
  var errorParams: Array<String>? = null
  var validationErrors: Array<EnvValidationError>? = null
}