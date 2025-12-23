// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.dto.StudioDtoLayoutGrid

open class StudioDtoLayoutCalendar : StudioDtoLayoutGrid()
{
  var colorFieldId: MetaIdField? = null
  var fromDateFieldId: MetaIdField? = null
  var fromTimeFieldId: MetaIdField? = null
  var showFieldIdSet: Array<MetaIdField>? = null
  var titleFieldId: MetaIdField? = null
  var toDateFieldId: MetaIdField? = null
  var toTimeFieldId: MetaIdField? = null
}