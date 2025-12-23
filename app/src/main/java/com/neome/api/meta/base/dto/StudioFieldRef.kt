// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnRefreshOn
import java.util.Map
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdLayoutGrid
import com.neome.api.meta.base.Types.MetaIdSpreadsheet
import com.neome.api.meta.base.Types.MetaIdVar
import com.neome.api.meta.base.dto.StudioDtoLayoutOverlaySpreadsheet
import com.neome.api.meta.base.dto.StudioField
import com.neome.api.meta.base.dto.StudioValueVarIdCondition

open class StudioFieldRef : StudioField()
{
  var canCreateRefRecord: Boolean? = null
  var categoryFilterDisplayFieldId: MetaIdField? = null
  var copyFieldMap: Map<MetaIdField, MetaIdField>? = null
  var createRefRecordMappingVarId: MetaIdVar? = null
  var editableFieldIdSet: Array<MetaIdField>? = null
  var filterConditionVarId: StudioValueVarIdCondition? = null
  var forceOpenOnFormCreate: Boolean? = null
  var forceOpenOnGridRowCreate: Boolean? = null
  var keyFieldIdSet: Array<MetaIdField>? = null
  var layoutSpreadsheetId: MetaIdLayoutGrid? = null
  var lookupFieldId: MetaIdField? = null
  var mobileLayoutSpreadsheetId: MetaIdLayoutGrid? = null
  var mobileOverlayLayoutSpreadsheet: StudioDtoLayoutOverlaySpreadsheet? = null
  var overlayLayoutSpreadsheet: StudioDtoLayoutOverlaySpreadsheet? = null
  var refreshOn: EnumDefnRefreshOn? = null
  var showRefreshInMenu: Boolean? = null
  var showRefreshOnFieldIdSet: Array<MetaIdField>? = null
  var spreadsheetId: MetaIdSpreadsheet? = null
}