// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.entAside.msg

import com.neome.api.meta.base.dto.FormValueRaw
import com.neome.api.meta.base.Types.MetaIdAction
import com.neome.api.meta.base.Types.MetaIdComposite
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdSpreadsheet
import com.neome.api.nucleus.base.msg.Msg
import com.neome.api.meta.base.Types.RowId
import com.neome.api.ent.base.dto.SpreadsheetFilterComposite

interface MsgSpreadsheetRowsGet : Msg
{
  val actionId: MetaIdAction
  val ascOrder: Boolean?
  val dateFieldId: MetaIdField?
  val filterValue: SpreadsheetFilterComposite?
  val groupByFieldId: MetaIdField?
  val inputFormCompositeId: MetaIdComposite?
  val inputFormGridRowId: RowId?
  val inputFormValueRaw: FormValueRaw?
  val searchText: String?
  val sortByFieldIdSet: List<MetaIdField>?
  val spreadsheetId: MetaIdSpreadsheet
}