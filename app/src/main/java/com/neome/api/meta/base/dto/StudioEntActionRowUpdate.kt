// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdLayoutGrid
import com.neome.api.meta.base.Types.MetaIdSpreadsheet
import com.neome.api.meta.base.dto.StudioEntAction
import com.neome.api.meta.base.dto.StudioValueVarIdCondition

interface StudioEntActionRowUpdate : StudioEntAction
{
  val filterConditionVarId: StudioValueVarIdCondition?
  val layoutSpreadsheetId: MetaIdLayoutGrid?
  val lookupFieldId: MetaIdField?
  val spreadsheetId: MetaIdSpreadsheet?
}