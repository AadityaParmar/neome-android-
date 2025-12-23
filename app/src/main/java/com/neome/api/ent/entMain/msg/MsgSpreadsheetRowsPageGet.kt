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

open class MsgSpreadsheetRowsPageGet : Msg()
{
  lateinit var actionId: MetaIdAction
  var ascOrder: Boolean? = null
  var filterValue: SpreadsheetFilterComposite? = null
  var includeFilters: Boolean? = null
  var inputFormCompositeId: MetaIdComposite? = null
  var inputFormGridRowId: RowId? = null
  var inputFormValueRaw: FormValueRaw? = null
  var layoutSpreadsheetId: MetaIdLayoutGrid? = null
  var orderByFieldId: MetaIdField? = null
  var pageNumber: Number? = null
  var pageSize: Number? = null
  var searchText: String? = null
}