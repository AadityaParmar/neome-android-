// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumEnvValidationError

interface EnvValidationError
{
  val children: List<EnvValidationError>?
  val errorCode: EnumEnvValidationError?
  val errorMessage: String?
  val errorParams: List<String>?
  val paramName: String?
  val paramNameSet: List<String>?
}