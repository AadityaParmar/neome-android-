// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.entAside.msg

import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdGrid
import com.neome.api.meta.base.Types.MetaIdSpreadsheet
import com.neome.api.nucleus.base.msg.Msg
import com.neome.api.meta.base.Types.RowId

interface MsgEntLogNumberFieldDataGet : Msg
{
  val fieldId: MetaIdField
  val gridId: MetaIdGrid?
  val gridRowId: RowId?
  val rowId: RowId
  val spreadsheetId: MetaIdSpreadsheet
}