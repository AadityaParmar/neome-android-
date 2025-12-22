// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdForm
import com.neome.api.meta.base.Types.MetaIdGroup
import com.neome.api.meta.base.Types.MetaIdLayoutGrid
import com.neome.api.meta.base.Types.MetaIdRole
import com.neome.api.meta.base.Types.MetaIdSpreadsheet

class StudioEntActionSpreadsheetEditor : StudioEntAction() {
    var actionPermissionMap: StudioMapOfActionPermission? = null
    var bulkInsertRoleSet: MetaIdRole[]? = null
    var bulkUpdateFieldIdSet: MetaIdField[]? = null
    var bulkUpdateRoleSet: MetaIdRole[]? = null
    var doNotOpenAside: boolean? = null
    var filterConditionVarId: StudioValueVarIdCondition? = null
    var inputFormId: MetaIdForm? = null
    var layoutSpreadsheetId: MetaIdLayoutGrid? = null
    var readOnly: boolean? = null
    var sendMessageToGroupId: MetaIdGroup? = null
    var spreadsheetId: MetaIdSpreadsheet? = null
}
