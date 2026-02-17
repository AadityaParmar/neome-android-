// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnRefreshOn
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdLayoutGrid
import com.neome.api.meta.base.Types.MetaIdSpreadsheet
import com.neome.api.meta.base.Types.MetaIdVar
import com.neome.api.meta.base.dto.StudioDtoLayoutOverlaySpreadsheet
import com.neome.api.meta.base.dto.StudioField
import com.neome.api.meta.base.dto.StudioValueVarIdCondition

interface StudioFieldRef : StudioField
{
  val canCreateRefRecord: Boolean?
  val categoryFilterDisplayFieldId: MetaIdField?
  val copyFieldMap: Map<MetaIdField, MetaIdField>?
  val createRefRecordMappingVarId: MetaIdVar?
  val editableFieldIdSet: List<MetaIdField>?
  val filterConditionVarId: StudioValueVarIdCondition?
  val forceOpenOnFormCreate: Boolean?
  val forceOpenOnGridRowCreate: Boolean?
  val keyFieldIdSet: List<MetaIdField>?
  val layoutSpreadsheetId: MetaIdLayoutGrid?
  val lookupFieldId: MetaIdField?
  val mobileLayoutSpreadsheetId: MetaIdLayoutGrid?
  val mobileOverlayLayoutSpreadsheet: StudioDtoLayoutOverlaySpreadsheet?
  val overlayLayoutSpreadsheet: StudioDtoLayoutOverlaySpreadsheet?
  val refreshOn: EnumDefnRefreshOn?
  val showRefreshInMenu: Boolean?
  val showRefreshOnFieldIdSet: List<MetaIdField>?
  val spreadsheetId: MetaIdSpreadsheet?
}