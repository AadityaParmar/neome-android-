// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnRefreshOn
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdSpreadsheet
import com.neome.api.meta.base.Types.MetaIdVar

class DefnFieldRef : DefnField() {
    var canCreateRefRecord: boolean? = null
    var categoryFilterDisplayFieldId: MetaIdField? = null
    var copyFieldMap: Record<MetaIdField, MetaIdField>? = null
    var createRefRecordMappingVarId: MetaIdVar? = null
    var editableFieldIdSet: MetaIdField[]? = null
    var forceOpenOnFormCreate: boolean? = null
    var forceOpenOnGridRowCreate: boolean? = null
    var keyFieldIdSet: MetaIdField[]? = null
    var layoutSpreadsheet: DefnLayoutGrid? = null
    var lookupFieldId: MetaIdField? = null
    var overlayLayoutSpreadsheet: DefnDtoLayoutOverlaySpreadsheet? = null
    var refreshOn: EnumDefnRefreshOn? = null
    var showRefreshInMenu: boolean? = null
    var showRefreshOnFieldIdSet: MetaIdField[]? = null
    val spreadsheetId: MetaIdSpreadsheet
}
