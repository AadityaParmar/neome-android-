// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.base.dto

import java.util.Date
import com.neome.api.meta.base.Types.EntId
import com.neome.api.meta.base.Types.EntUserId
import com.neome.api.ent.base.Types.EnumAuditAction
import com.neome.api.meta.base.Types.MetaIdForm
import com.neome.api.meta.base.Types.MetaIdSpreadsheet
import com.neome.api.meta.base.Types.RowId

open class DtoAuditRecord
{
  var auditAction: EnumAuditAction? = null
  var dateTime: String? = null
  var entId: EntId? = null
  var entUserId: EntUserId? = null
  var formId: MetaIdForm? = null
  var formValueRefKey: String? = null
  var historyFieldLabelSet: Array<String>? = null
  var historyFieldValueSet: Array<String>? = null
  var offset: String? = null
  var rowId: RowId? = null
  var spreadsheetId: MetaIdSpreadsheet? = null
  var spreadsheetName: String? = null
  var version: String? = null
}