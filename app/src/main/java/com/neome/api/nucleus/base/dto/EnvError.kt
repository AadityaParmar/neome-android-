// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.nucleus.base.dto

import com.neome.api.nucleus.base.Types.EnumEnvErrorCode
import com.neome.api.meta.base.dto.EnvValidationError

interface EnvError
{
  val errorCode: EnumEnvErrorCode?
  val errorMessage: String?
  val errorParams: Array<String>?
  val validationErrors: Array<EnvValidationError>?
}