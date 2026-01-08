// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.RowId

interface FieldValueRefTarget
{
  val displayValue: String?
  val token: String
  val value: RowId
  val version: String?
}