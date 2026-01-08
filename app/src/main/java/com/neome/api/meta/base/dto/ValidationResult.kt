// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.EnvValidationError
import com.neome.api.meta.base.Types.SearchPath

interface ValidationResult
{
  val errorCountMap: Map<SearchPath, Number>?
  val errorMap: Map<SearchPath, EnvValidationError>?
}