// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdDeeplink
import com.neome.api.meta.base.Types.MetaIdLayoutForm
import com.neome.api.meta.base.Types.MetaIdSpreadsheet
import com.neome.api.meta.base.Types.MetaIdVar

class StudioEntDeeplinkSpreadsheetInsert : StudioEntDeeplinkWithHeader() {
    var formEditorLayoutId: MetaIdLayoutForm? = null
    var mobileFormEditorLayoutId: MetaIdLayoutForm? = null
    var repeatButtonLabel: string? = null
    var showRepeatButton: boolean? = null
    var spreadsheetId: MetaIdSpreadsheet? = null
    var successDeeplinkId: MetaIdDeeplink? = null
    var successMessageBgColorVarId: MetaIdVar? = null
    var successMessageTextSizeVarId: MetaIdVar? = null
    var successMessageVarId: StudioValueVarIdParagraph? = null
}
