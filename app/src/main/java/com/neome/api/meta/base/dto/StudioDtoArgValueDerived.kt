// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import java.util.Date
import com.neome.api.meta.base.Types.EnumDefnCompType
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.dto.StudioDtoArgValue

open class StudioDtoArgValueDerived : StudioDtoArgValue()
{
  lateinit var derivedFieldId: MetaIdField
  var derivedFieldType: EnumDefnCompType? = null
  var valueBoolean: Boolean? = null
  var valueDate: String? = null
  var valueDouble: Number? = null
  var valueLong: Number? = null
  var valueOptionId: String? = null
  var valueText: String? = null
}