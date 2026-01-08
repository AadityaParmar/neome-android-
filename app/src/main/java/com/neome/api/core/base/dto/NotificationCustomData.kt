// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.core.base.dto

import com.neome.api.meta.base.Types.ChatId
import com.neome.api.meta.base.Types.EntId
import com.neome.api.meta.base.Types.EntUserId
import com.neome.api.meta.base.Types.MessageId
import com.neome.api.meta.base.Types.MetaIdForm
import com.neome.api.meta.base.Types.MetaIdSpreadsheet
import com.neome.api.meta.base.Types.RowId

interface NotificationCustomData
{
  val chatId: ChatId?
  val entId: EntId?
  val formId: MetaIdForm?
  val isEntInvite: Boolean?
  val messageId: MessageId?
  val messageType: String?
  val parentChatId: ChatId?
  val parentMessageId: MessageId?
  val rowId: RowId?
  val senderId: EntUserId?
  val spreadsheetId: MetaIdSpreadsheet?
}