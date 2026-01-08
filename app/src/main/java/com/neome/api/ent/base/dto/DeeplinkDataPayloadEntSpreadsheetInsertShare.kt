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
import com.neome.api.meta.base.Types.MetaIdAction
import com.neome.api.meta.base.Types.MetaIdComp
import com.neome.api.meta.base.Types.MetaIdLayoutForm
import com.neome.api.meta.base.Types.MetaIdSpreadsheet

interface DeeplinkDataPayloadEntSpreadsheetInsertShare : DeeplinkDataPayloadEnt
{
  val chatId: ChatId?
  val defnForm: DefnForm
  val entId: EntId
  val formEditorLayoutId: MetaIdLayoutForm?
  val metaIdAction: MetaIdAction?
  val mobileFormEditorLayoutId: MetaIdLayoutForm?
  val repeatButtonLabel: String?
  val sendMessageToInbox: Boolean?
  val showRepeatButton: Boolean?
  val spreadsheetId: MetaIdSpreadsheet?
  val successMessage: DefnDtoParagraph
  val successMessageBgColor: DefnDtoColor?
  val successMessageTextSize: EnumDefnTextSize?
  val valueMap: Map<MetaIdComp, Any>?
}