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
import kotlinx.serialization.json.JsonElement

interface DtoEntActionSpreadsheetEditor : DtoEntAction {
    val actionPermissionMap: Map<MetaIdAction, DtoEntActionPermission>?
    val bulkInsertRoleSet: List<MetaIdRole>?
    val bulkUpdateFieldIdSet: List<MetaIdField>?
    val bulkUpdateRoleSet: List<MetaIdRole>?
    val defaultValueMap: Map<MetaIdComp, JsonElement>?
    val doNotOpenAside: Boolean?
    val inputFormId: MetaIdForm?
    val layoutSpreadsheetId: MetaIdLayoutGrid
    val readOnly: Boolean?
    val sendMessageToGroupId: MetaIdGroup?
    val spreadsheetFormId: MetaIdForm
    val spreadsheetId: MetaIdSpreadsheet
}
