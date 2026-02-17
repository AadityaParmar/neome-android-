// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.main.msg

import kotlinx.serialization.json.JsonElement
import com.neome.api.meta.base.Types.MetaIdAction
import com.neome.api.meta.base.Types.MetaIdComp
import com.neome.api.nucleus.base.msg.Msg
import com.neome.api.meta.base.Types.RowId

interface MsgSpreadsheetBulkRowUpdate : Msg
{
  val actionId: MetaIdAction
  val rowIdSet: List<RowId>
  val valueMap: Map<MetaIdComp, JsonElement>
}