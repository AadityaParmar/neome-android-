// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.core.base.dto

import com.neome.api.meta.base.Types.ChatId
import com.neome.api.meta.base.Types.MetaIdSpreadsheet

interface DtoChatMessageOffset
{
  val chatId: ChatId?
  val offset: Long?
  val spreadsheetId: MetaIdSpreadsheet?
}