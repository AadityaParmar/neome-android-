// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnFieldEditable
import com.neome.api.meta.base.Types.EnumDefnDurationUnit
import com.neome.api.meta.base.dto.FieldDtoDuration
import com.neome.api.meta.base.Types.MetaIdField

open class DefnFieldDuration : DefnFieldEditable()
{
  var autoFormatValue: Boolean? = null
  var defaultFieldId: MetaIdField? = null
  var defaultValue: FieldDtoDuration? = null
  var defaultVar: FieldDtoDuration? = null
  var excludeDurationUnits: Array<EnumDefnDurationUnit>? = null
  var filterOptionSet: Array<String>? = null
  var max: FieldDtoDuration? = null
  var maxFieldId: MetaIdField? = null
  var maxVar: FieldDtoDuration? = null
  var min: FieldDtoDuration? = null
  var minFieldId: MetaIdField? = null
  var minVar: FieldDtoDuration? = null
}