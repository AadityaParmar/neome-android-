// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.entMain.msg

import com.neome.api.meta.base.dto.FormValueRaw
import com.neome.api.meta.base.Types.MetaIdSpreadsheet
import com.neome.api.nucleus.base.msg.Msg

interface MsgSpreadsheetRowUpdate : Msg
{
  val formValueRaw: FormValueRaw
  val spreadsheetId: MetaIdSpreadsheet
  val transactionId: String?
}