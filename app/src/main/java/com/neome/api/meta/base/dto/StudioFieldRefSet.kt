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

interface StudioFieldRefSet : StudioFieldEditable
{
  val allowDuplicateValues: Boolean?
  val displayFieldId: MetaIdField?
  val ejectionPolicy: EnumDefnEjectionPolicy?
  val filterConditionVarId: StudioValueVarIdCondition?
  val layoutSpreadsheetId: MetaIdLayoutGrid?
  val maxSize: Long?
  val spreadsheetId: MetaIdSpreadsheet?
}