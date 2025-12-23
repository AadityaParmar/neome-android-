// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnEjectionPolicy
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdLayoutGrid
import com.neome.api.meta.base.Types.MetaIdSpreadsheet
import com.neome.api.meta.base.dto.StudioFieldEditable
import com.neome.api.meta.base.dto.StudioValueVarIdCondition

open class StudioFieldRefSet : StudioFieldEditable()
{
  var allowDuplicateValues: Boolean? = null
  var displayFieldId: MetaIdField? = null
  var ejectionPolicy: EnumDefnEjectionPolicy? = null
  var filterConditionVarId: StudioValueVarIdCondition? = null
  var layoutSpreadsheetId: MetaIdLayoutGrid? = null
  var maxSize: Number? = null
  var spreadsheetId: MetaIdSpreadsheet? = null
}