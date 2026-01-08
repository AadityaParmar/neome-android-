// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.ent.msg

import com.neome.api.meta.base.Types.MetaIdSpreadsheet
import com.neome.api.nucleus.base.msg.Msg

interface MsgEntSpreadsheetData : Msg
{
  val fromGridVer: String?
  val pageSize: Long?
  val spreadsheetId: MetaIdSpreadsheet
  val toGridVer: String
}