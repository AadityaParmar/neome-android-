// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.ent.msg

import kotlin.properties.Delegates
import com.neome.api.meta.base.Types.MetaIdSpreadsheet
import com.neome.api.nucleus.base.msg.Msg

open class MsgEntSpreadsheetData : Msg()
{
  var fromGridVer: String? = null
  var pageSize: Number by Delegates.notNull<Number>()
  lateinit var spreadsheetId: MetaIdSpreadsheet
  lateinit var toGridVer: String
}