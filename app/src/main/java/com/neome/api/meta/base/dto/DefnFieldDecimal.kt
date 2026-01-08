// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnFieldEditable
import com.neome.api.meta.base.Types.MetaIdField

interface DefnFieldDecimal : DefnFieldEditable
{
  val defaultFieldId: MetaIdField?
  val defaultValue: Long?
  val defaultVar: Long?
  val max: Long?
  val maxFieldId: MetaIdField?
  val maxVar: Long?
  val min: Long?
  val minDisplayValue: Long?
  val minFieldId: MetaIdField?
  val minVar: Long?
  val numberFormat: String?
  val numberOfDigitsAfterPeriod: Long?
  val numberOfDigitsAfterPeriodFieldId: MetaIdField?
  val numberOfDigitsAfterPeriodVar: Long?
}