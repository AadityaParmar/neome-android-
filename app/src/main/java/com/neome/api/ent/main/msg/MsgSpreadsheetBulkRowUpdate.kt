// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.main.msg

import com.google.gson.JsonElement
import java.util.Map
import com.neome.api.meta.base.Types.MetaIdAction
import com.neome.api.meta.base.Types.MetaIdComp
import com.neome.api.nucleus.base.msg.Msg
import com.neome.api.meta.base.Types.RowId

open class MsgSpreadsheetBulkRowUpdate : Msg()
{
  lateinit var actionId: MetaIdAction
  lateinit var rowIdSet: Array<RowId>
  lateinit var valueMap: Map<MetaIdComp, Any>
}