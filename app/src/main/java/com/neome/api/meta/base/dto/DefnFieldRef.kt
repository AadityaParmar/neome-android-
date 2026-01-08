// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnDtoLayoutOverlaySpreadsheet
import com.neome.api.meta.base.dto.DefnField
import com.neome.api.meta.base.dto.DefnLayoutGrid
import com.neome.api.meta.base.Types.EnumDefnRefreshOn
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdSpreadsheet
import com.neome.api.meta.base.Types.MetaIdVar

interface DefnFieldRef : DefnField
{
  val canCreateRefRecord: Boolean?
  val categoryFilterDisplayFieldId: MetaIdField?
  val copyFieldMap: Map<MetaIdField, MetaIdField>?
  val createRefRecordMappingVarId: MetaIdVar?
  val editableFieldIdSet: Array<MetaIdField>?
  val forceOpenOnFormCreate: Boolean?
  val forceOpenOnGridRowCreate: Boolean?
  val keyFieldIdSet: Array<MetaIdField>?
  val layoutSpreadsheet: DefnLayoutGrid?
  val lookupFieldId: MetaIdField?
  val mobileLayoutSpreadsheet: DefnLayoutGrid?
  val mobileOverlayLayoutSpreadsheet: DefnDtoLayoutOverlaySpreadsheet?
  val overlayLayoutSpreadsheet: DefnDtoLayoutOverlaySpreadsheet?
  val refreshOn: EnumDefnRefreshOn?
  val showRefreshInMenu: Boolean?
  val showRefreshOnFieldIdSet: Array<MetaIdField>?
  val spreadsheetId: MetaIdSpreadsheet
}