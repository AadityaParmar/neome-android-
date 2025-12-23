// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnFieldEditable
import com.neome.api.meta.base.Types.MetaIdField

open class DefnFieldDecimal : DefnFieldEditable()
{
  var defaultFieldId: MetaIdField? = null
  var defaultValue: Number? = null
  var defaultVar: Number? = null
  var max: Number? = null
  var maxFieldId: MetaIdField? = null
  var maxVar: Number? = null
  var min: Number? = null
  var minDisplayValue: Number? = null
  var minFieldId: MetaIdField? = null
  var minVar: Number? = null
  var numberFormat: String? = null
  var numberOfDigitsAfterPeriod: Number? = null
  var numberOfDigitsAfterPeriodFieldId: MetaIdField? = null
  var numberOfDigitsAfterPeriodVar: Number? = null
}