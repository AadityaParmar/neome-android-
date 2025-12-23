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

open class StudioEntActionSpreadsheetEditor : StudioEntAction() {
    var actionPermissionMap: StudioMapOfActionPermission? = null
    var bulkInsertRoleSet: Array<MetaIdRole>? = null
    var bulkUpdateFieldIdSet: Array<MetaIdField>? = null
    var bulkUpdateRoleSet: Array<MetaIdRole>? = null
    var doNotOpenAside: Boolean? = null
    var filterConditionVarId: StudioValueVarIdCondition? = null
    var inputFormId: MetaIdForm? = null
    var layoutSpreadsheetId: MetaIdLayoutGrid? = null
    var readOnly: Boolean? = null
    var sendMessageToGroupId: MetaIdGroup? = null
    var spreadsheetId: MetaIdSpreadsheet? = null
}
