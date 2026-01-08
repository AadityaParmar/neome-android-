// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.base.dto

import com.neome.api.meta.base.Types.EntId
import com.neome.api.meta.base.Types.EntUserId
import com.neome.api.ent.base.Types.EnumAuditAction
import com.neome.api.meta.base.Types.MetaIdForm
import com.neome.api.meta.base.Types.MetaIdSpreadsheet
import com.neome.api.meta.base.Types.RowId

interface DtoAuditRecord
{
  val auditAction: EnumAuditAction?
  val dateTime: String?
  val entId: EntId?
  val entUserId: EntUserId?
  val formId: MetaIdForm?
  val formValueRefKey: String?
  val historyFieldLabelSet: Array<String>?
  val historyFieldValueSet: Array<String>?
  val offset: String?
  val rowId: RowId?
  val spreadsheetId: MetaIdSpreadsheet?
  val spreadsheetName: String?
  val version: String?
}