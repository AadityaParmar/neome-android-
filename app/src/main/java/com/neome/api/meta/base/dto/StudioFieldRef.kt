// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnRefreshOn
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdLayoutGrid
import com.neome.api.meta.base.Types.MetaIdSpreadsheet
import com.neome.api.meta.base.Types.MetaIdVar

class StudioFieldRef : StudioField() {
    var canCreateRefRecord: boolean? = null
    var categoryFilterDisplayFieldId: MetaIdField? = null
    var copyFieldMap: Record<MetaIdField, MetaIdField>? = null
    var createRefRecordMappingVarId: MetaIdVar? = null
    var editableFieldIdSet: MetaIdField[]? = null
    var filterConditionVarId: StudioValueVarIdCondition? = null
    var forceOpenOnFormCreate: boolean? = null
    var forceOpenOnGridRowCreate: boolean? = null
    var keyFieldIdSet: MetaIdField[]? = null
    var layoutSpreadsheetId: MetaIdLayoutGrid? = null
    var lookupFieldId: MetaIdField? = null
    var overlayLayoutSpreadsheet: StudioDtoLayoutOverlaySpreadsheet? = null
    var refreshOn: EnumDefnRefreshOn? = null
    var showRefreshInMenu: boolean? = null
    var showRefreshOnFieldIdSet: MetaIdField[]? = null
    var spreadsheetId: MetaIdSpreadsheet? = null
}
