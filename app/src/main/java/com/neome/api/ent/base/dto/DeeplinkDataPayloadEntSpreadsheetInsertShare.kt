// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.base.dto

import com.neome.api.meta.base.Types.ChatId
import com.neome.api.ent.base.dto.DeeplinkDataPayloadEnt
import com.neome.api.meta.base.dto.DefnDtoColor
import com.neome.api.meta.base.dto.DefnDtoParagraph
import com.neome.api.meta.base.dto.DefnForm
import com.neome.api.meta.base.Types.EntId
import com.neome.api.meta.base.Types.EnumDefnTextSize
import com.google.gson.JsonElement
import java.util.Map
import com.neome.api.meta.base.Types.MetaIdAction
import com.neome.api.meta.base.Types.MetaIdComp
import com.neome.api.meta.base.Types.MetaIdLayoutForm
import com.neome.api.meta.base.Types.MetaIdSpreadsheet

open class DeeplinkDataPayloadEntSpreadsheetInsertShare : DeeplinkDataPayloadEnt()
{
  var chatId: ChatId? = null
  lateinit var defnForm: DefnForm
  lateinit var entId: EntId
  var formEditorLayoutId: MetaIdLayoutForm? = null
  var metaIdAction: MetaIdAction? = null
  var mobileFormEditorLayoutId: MetaIdLayoutForm? = null
  var repeatButtonLabel: String? = null
  var sendMessageToInbox: Boolean? = null
  var showRepeatButton: Boolean? = null
  var spreadsheetId: MetaIdSpreadsheet? = null
  lateinit var successMessage: DefnDtoParagraph
  var successMessageBgColor: DefnDtoColor? = null
  var successMessageTextSize: EnumDefnTextSize? = null
  var valueMap: Map<MetaIdComp, Any>? = null
}