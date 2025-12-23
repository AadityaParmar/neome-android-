// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.entMain.msg

import com.neome.api.meta.base.Types.MetaIdSpreadsheet
import com.neome.api.nucleus.base.msg.Msg
import com.neome.api.meta.base.Types.RowId

open class MsgSpreadsheetHistoryGet : Msg()
{
  var offset: String? = null
  var pageSize: Number? = null
  var rowId: RowId? = null
  var searchText: String? = null
  lateinit var spreadsheetId: MetaIdSpreadsheet
}