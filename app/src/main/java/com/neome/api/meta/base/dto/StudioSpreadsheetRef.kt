// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdLayoutGrid
import com.neome.api.meta.base.Types.MetaIdSpreadsheet
import com.neome.api.meta.base.Types.MetaIdSpreadsheetRef
import com.neome.api.meta.base.dto.StudioComposite
import com.neome.api.meta.base.dto.StudioMapOfActionPermission
import com.neome.api.meta.base.dto.StudioValueVarIdCondition

interface StudioSpreadsheetRef : StudioComposite
{
  val filterConditionVarId: StudioValueVarIdCondition?
  val layoutSpreadsheetId: MetaIdLayoutGrid?
  val maxRecords: Long?
  val metaId: MetaIdSpreadsheetRef
  val refTargetFieldId: MetaIdField?
  val rowActionPermissionMap: StudioMapOfActionPermission?
  val spreadsheetId: MetaIdSpreadsheet?
}