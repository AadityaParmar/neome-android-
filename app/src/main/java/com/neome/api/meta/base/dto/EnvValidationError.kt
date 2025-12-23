// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumEnvValidationError

open class EnvValidationError
{
  var children: Array<EnvValidationError>? = null
  var errorCode: EnumEnvValidationError? = null
  var errorMessage: String? = null
  var errorParams: Array<String>? = null
  var paramName: String? = null
  var paramNameSet: Array<String>? = null
}