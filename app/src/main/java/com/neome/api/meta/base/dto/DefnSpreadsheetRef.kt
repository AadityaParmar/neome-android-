// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdSpreadsheet
import com.neome.api.meta.base.Types.MetaIdSpreadsheetRef

class DefnSpreadsheetRef : DefnComp() {
    val layoutSpreadsheet: DefnLayoutGrid
    var maxRecords: number? = null
    val metaId: MetaIdSpreadsheetRef
    var refTargetFieldId: MetaIdField? = null
    var rowActionPermissionMap: DefnStudioMapOfActionPermission? = null
    val spreadsheetId: MetaIdSpreadsheet
}
