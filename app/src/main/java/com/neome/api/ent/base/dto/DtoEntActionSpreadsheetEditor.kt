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
import java.util.Map

open class DtoEntActionSpreadsheetEditor : DtoEntAction() {
    var actionPermissionMap: Map<MetaIdAction, DtoEntActionPermission>? = null
    var bulkInsertRoleSet: Array<MetaIdRole>? = null
    var bulkUpdateFieldIdSet: Array<MetaIdField>? = null
    var bulkUpdateRoleSet: Array<MetaIdRole>? = null
    var defaultValueMap: Map<MetaIdComp, Any>? = null
    var doNotOpenAside: Boolean? = null
    var inputFormId: MetaIdForm? = null
    lateinit var layoutSpreadsheetId: MetaIdLayoutGrid
    var readOnly: Boolean? = null
    var sendMessageToGroupId: MetaIdGroup? = null
    lateinit var spreadsheetFormId: MetaIdForm
    lateinit var spreadsheetId: MetaIdSpreadsheet
}
