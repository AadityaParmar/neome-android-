// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.entMain.msg

import java.util.Map
import com.neome.api.meta.base.Types.MetaIdSpreadsheet
import com.neome.api.nucleus.base.msg.Msg
import com.neome.api.meta.base.Types.RowId

open class MsgSpreadsheetBulkRowGet : Msg()
{
  lateinit var rowIdVersionMap: Map<RowId, String>
  lateinit var spreadsheetId: MetaIdSpreadsheet
}