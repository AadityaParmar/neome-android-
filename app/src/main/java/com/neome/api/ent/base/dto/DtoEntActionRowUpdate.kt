// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.base.dto

import com.neome.api.ent.base.dto.DtoEntAction
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdForm
import com.neome.api.meta.base.Types.MetaIdLayoutGrid
import com.neome.api.meta.base.Types.MetaIdSpreadsheet
import com.neome.api.meta.base.dto.StudioValueVarIdCondition

interface DtoEntActionRowUpdate : DtoEntAction
{
  val filterConditionVarId: StudioValueVarIdCondition?
  val layoutSpreadsheetId: MetaIdLayoutGrid?
  val lookupFieldId: MetaIdField?
  val spreadsheetFormId: MetaIdForm
  val spreadsheetId: MetaIdSpreadsheet
}