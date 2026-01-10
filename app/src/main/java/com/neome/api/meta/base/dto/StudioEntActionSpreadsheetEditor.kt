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

interface StudioEntActionSpreadsheetEditor : StudioEntAction {
    val actionPermissionMap: StudioMapOfActionPermission?
    val bulkInsertRoleSet: List<MetaIdRole>?
    val bulkUpdateFieldIdSet: List<MetaIdField>?
    val bulkUpdateRoleSet: List<MetaIdRole>?
    val doNotOpenAside: Boolean?
    val filterConditionVarId: StudioValueVarIdCondition?
    val inputFormId: MetaIdForm?
    val layoutSpreadsheetId: MetaIdLayoutGrid?
    val readOnly: Boolean?
    val sendMessageToGroupId: MetaIdGroup?
    val spreadsheetId: MetaIdSpreadsheet?
}
