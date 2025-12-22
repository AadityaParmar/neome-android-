// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.base.dto

import com.neome.api.meta.base.Types.MetaIdAction
import com.neome.api.meta.base.Types.MetaIdComp
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdForm
import com.neome.api.meta.base.Types.MetaIdGroup
import com.neome.api.meta.base.Types.MetaIdLayoutGrid
import com.neome.api.meta.base.Types.MetaIdRole
import com.neome.api.meta.base.Types.MetaIdSpreadsheet

class DtoEntActionSpreadsheetEditor : DtoEntAction() {
    var actionPermissionMap: Record<MetaIdAction, DtoEntActionPermission>? = null
    var bulkInsertRoleSet: MetaIdRole[]? = null
    var bulkUpdateFieldIdSet: MetaIdField[]? = null
    var bulkUpdateRoleSet: MetaIdRole[]? = null
    var defaultValueMap: Record<MetaIdComp, any>? = null
    var doNotOpenAside: boolean? = null
    var inputFormId: MetaIdForm? = null
    val layoutSpreadsheetId: MetaIdLayoutGrid
    var readOnly: boolean? = null
    var sendMessageToGroupId: MetaIdGroup? = null
    val spreadsheetFormId: MetaIdForm
    val spreadsheetId: MetaIdSpreadsheet
}
