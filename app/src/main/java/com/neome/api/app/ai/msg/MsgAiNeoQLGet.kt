// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.app.ai.msg

import com.neome.api.meta.base.dto.FormRefKey
import com.neome.api.meta.base.Types.MetaIdSpreadsheet
import com.neome.api.nucleus.base.msg.Msg

interface MsgAiNeoQLGet : Msg
{
  val inputFormRefKey: FormRefKey?
  val neoQL: String?
  val outputFormRefKey: FormRefKey?
  val paramMap: Map<String, FormRefKey>?
  val spreadsheetIdSet: Set<MetaIdSpreadsheet>
  val userMessage: String
}