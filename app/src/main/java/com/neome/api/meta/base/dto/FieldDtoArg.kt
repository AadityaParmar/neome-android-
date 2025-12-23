// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import java.util.Date
import com.neome.api.meta.base.Types.MetaIdField
import java.util.Set
import com.neome.api.meta.base.SysId

open class FieldDtoArg
{
  var valueBoolean: Boolean? = null
  var valueDate: String? = null
  var valueDouble: Number? = null
  var valueFieldId: MetaIdField? = null
  var valueLong: Number? = null
  var valueSysId: SysId? = null
  var valueSysIdArray: Array<SysId>? = null
  var valueSysIdSet: Array<SysId>? = null
  var valueText: String? = null
  var valueTextArray: Array<String>? = null
}