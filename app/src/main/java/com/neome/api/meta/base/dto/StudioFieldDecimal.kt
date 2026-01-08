// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdVar
import com.neome.api.meta.base.dto.StudioFieldEditable

interface StudioFieldDecimal : StudioFieldEditable
{
  val defaultFieldId: MetaIdField?
  val defaultValue: Long?
  val defaultVarId: MetaIdVar?
  val max: Long?
  val maxFieldId: MetaIdField?
  val maxVarId: MetaIdVar?
  val min: Long?
  val minDisplayValue: Long?
  val minFieldId: MetaIdField?
  val minVarId: MetaIdVar?
  val numberFormat: String?
  val numberOfDigitsAfterPeriod: Long?
  val numberOfDigitsAfterPeriodFieldId: MetaIdField?
  val numberOfDigitsAfterPeriodVarId: MetaIdVar?
}