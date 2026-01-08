// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.main.msg

import com.google.gson.JsonElement
import com.neome.api.meta.base.Types.MetaIdAction
import com.neome.api.meta.base.Types.MetaIdComp
import com.neome.api.nucleus.base.msg.Msg
import com.neome.api.meta.base.Types.RowId

interface MsgSpreadsheetBulkRowUpdate : Msg
{
  val actionId: MetaIdAction
  val rowIdSet: Array<RowId>
  val valueMap: Map<MetaIdComp, Any>
}