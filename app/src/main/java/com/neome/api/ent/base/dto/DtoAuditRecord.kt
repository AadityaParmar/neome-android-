// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.base.dto

import com.neome.api.ent.base.Types.EnumAuditAction
import com.neome.api.meta.base.Types.EntId
import com.neome.api.meta.base.Types.EntUserId
import com.neome.api.meta.base.Types.MetaIdForm
import com.neome.api.meta.base.Types.MetaIdSpreadsheet
import com.neome.api.meta.base.Types.RowId

class DtoAuditRecord {
    var auditAction: EnumAuditAction? = null
    var dateTime: string? = null
    var entId: EntId? = null
    var entUserId: EntUserId? = null
    var formId: MetaIdForm? = null
    var formValueRefKey: string? = null
    var historyFieldLabelSet: string[]? = null
    var historyFieldValueSet: string[]? = null
    var offset: string? = null
    var rowId: RowId? = null
    var spreadsheetId: MetaIdSpreadsheet? = null
    var spreadsheetName: string? = null
    var version: string? = null
}
