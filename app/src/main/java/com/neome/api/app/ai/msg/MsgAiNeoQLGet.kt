// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.app.ai.msg

import com.neome.api.meta.base.dto.FormRefKey
import java.util.Map
import com.neome.api.meta.base.Types.MetaIdSpreadsheet
import com.neome.api.nucleus.base.msg.Msg
import java.util.Set

open class MsgAiNeoQLGet : Msg()
{
  var inputFormRefKey: FormRefKey? = null
  var neoQL: String? = null
  var outputFormRefKey: FormRefKey? = null
  var paramMap: Map<String, FormRefKey>? = null
  lateinit var spreadsheetIdSet: Array<MetaIdSpreadsheet>
  lateinit var userMessage: String
}