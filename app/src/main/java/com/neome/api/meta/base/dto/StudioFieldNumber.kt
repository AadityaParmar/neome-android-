// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdVar
import com.neome.api.meta.base.dto.StudioFieldEditable

open class StudioFieldNumber : StudioFieldEditable()
{
  var defaultFieldId: MetaIdField? = null
  var defaultValue: Number? = null
  var defaultVarId: MetaIdVar? = null
  var max: Number? = null
  var maxFieldId: MetaIdField? = null
  var maxVarId: MetaIdVar? = null
  var min: Number? = null
  var minDisplayValue: Number? = null
  var minFieldId: MetaIdField? = null
  var minVarId: MetaIdVar? = null
  var numberFormat: String? = null
}