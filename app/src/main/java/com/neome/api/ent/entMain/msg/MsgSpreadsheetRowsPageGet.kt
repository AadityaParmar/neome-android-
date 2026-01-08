// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.entMain.msg

import com.neome.api.meta.base.dto.FormValueRaw
import com.neome.api.meta.base.Types.MetaIdAction
import com.neome.api.meta.base.Types.MetaIdComposite
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdLayoutGrid
import com.neome.api.nucleus.base.msg.Msg
import com.neome.api.meta.base.Types.RowId
import com.neome.api.ent.base.dto.SpreadsheetFilterComposite

interface MsgSpreadsheetRowsPageGet : Msg
{
  val actionId: MetaIdAction
  val ascOrder: Boolean?
  val filterValue: SpreadsheetFilterComposite?
  val includeFilters: Boolean?
  val inputFormCompositeId: MetaIdComposite?
  val inputFormGridRowId: RowId?
  val inputFormValueRaw: FormValueRaw?
  val layoutSpreadsheetId: MetaIdLayoutGrid?
  val orderByFieldId: MetaIdField?
  val pageNumber: Long?
  val pageSize: Long?
  val searchText: String?
}