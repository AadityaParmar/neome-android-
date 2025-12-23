// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.main.msg

import com.neome.api.meta.base.dto.FormValueRaw
import java.util.Map
import com.neome.api.meta.base.Types.MetaIdSpreadsheet
import com.neome.api.nucleus.base.msg.Msg
import com.neome.api.meta.base.Types.RowId

open class MsgSpreadsheetBulkRowInsert : Msg()
{
  lateinit var rowMap: Map<RowId, FormValueRaw>
  lateinit var spreadsheetId: MetaIdSpreadsheet
}