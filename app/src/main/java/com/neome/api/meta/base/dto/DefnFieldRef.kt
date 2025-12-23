// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnDtoLayoutOverlaySpreadsheet
import com.neome.api.meta.base.dto.DefnField
import com.neome.api.meta.base.dto.DefnLayoutGrid
import com.neome.api.meta.base.Types.EnumDefnRefreshOn
import java.util.Map
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdSpreadsheet
import com.neome.api.meta.base.Types.MetaIdVar

open class DefnFieldRef : DefnField() {
    var canCreateRefRecord: Boolean? = null
    var categoryFilterDisplayFieldId: MetaIdField? = null
    var copyFieldMap: Map<MetaIdField, MetaIdField>? = null
    var createRefRecordMappingVarId: MetaIdVar? = null
    var editableFieldIdSet: Array<MetaIdField>? = null
    var forceOpenOnFormCreate: Boolean? = null
    var forceOpenOnGridRowCreate: Boolean? = null
    var keyFieldIdSet: Array<MetaIdField>? = null
    var layoutSpreadsheet: DefnLayoutGrid? = null
    var lookupFieldId: MetaIdField? = null
    var mobileLayoutSpreadsheet: DefnLayoutGrid? = null
    var mobileOverlayLayoutSpreadsheet: DefnDtoLayoutOverlaySpreadsheet? = null
    var overlayLayoutSpreadsheet: DefnDtoLayoutOverlaySpreadsheet? = null
    var refreshOn: EnumDefnRefreshOn? = null
    var showRefreshInMenu: Boolean? = null
    var showRefreshOnFieldIdSet: Array<MetaIdField>? = null
    lateinit var spreadsheetId: MetaIdSpreadsheet
}
