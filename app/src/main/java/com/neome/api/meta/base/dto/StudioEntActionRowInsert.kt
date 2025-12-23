// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdLayoutForm
import com.neome.api.meta.base.Types.MetaIdSpreadsheet
import com.neome.api.meta.base.dto.StudioDtoChatBubbleHeader
import com.neome.api.meta.base.dto.StudioEntAction

open class StudioEntActionRowInsert : StudioEntAction()
{
  var chatBubbleHeader: StudioDtoChatBubbleHeader? = null
  var formEditorLayoutId: MetaIdLayoutForm? = null
  var mobileFormEditorLayoutId: MetaIdLayoutForm? = null
  var sendMessageToInbox: Boolean? = null
  var spreadsheetId: MetaIdSpreadsheet? = null
}