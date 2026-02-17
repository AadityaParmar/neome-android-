// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnErrorSeverity

interface FieldValueError
{
  val errorCounter: Long
  val errorParameterSet: List<String>?
  val errorReason: String
  val severity: EnumDefnErrorSeverity
}