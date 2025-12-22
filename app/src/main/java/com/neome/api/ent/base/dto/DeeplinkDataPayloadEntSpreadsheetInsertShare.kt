// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.base.dto

import com.neome.api.meta.base.Types.ChatId
import com.neome.api.meta.base.Types.EntId
import com.neome.api.meta.base.Types.EnumDefnTextSize
import com.neome.api.meta.base.Types.MetaIdAction
import com.neome.api.meta.base.Types.MetaIdComp
import com.neome.api.meta.base.Types.MetaIdLayoutForm
import com.neome.api.meta.base.Types.MetaIdSpreadsheet
import com.neome.api.meta.base.dto.DefnDtoColor
import com.neome.api.meta.base.dto.DefnDtoParagraph
import com.neome.api.meta.base.dto.DefnForm

class DeeplinkDataPayloadEntSpreadsheetInsertShare : DeeplinkDataPayloadEnt() {
    var chatId: ChatId? = null
    val defnForm: DefnForm
    val entId: EntId
    var formEditorLayoutId: MetaIdLayoutForm? = null
    var metaIdAction: MetaIdAction? = null
    var mobileFormEditorLayoutId: MetaIdLayoutForm? = null
    var repeatButtonLabel: string? = null
    var sendMessageToInbox: boolean? = null
    var showRepeatButton: boolean? = null
    var spreadsheetId: MetaIdSpreadsheet? = null
    val successMessage: DefnDtoParagraph
    var successMessageBgColor: DefnDtoColor? = null
    var successMessageTextSize: EnumDefnTextSize? = null
    var valueMap: Record<MetaIdComp, any>? = null
}
