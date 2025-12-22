// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.base.dto

import com.neome.api.meta.base.Types.MetaIdDeeplink
import com.neome.api.meta.base.Types.MetaIdLayoutForm
import com.neome.api.meta.base.Types.MetaIdSpreadsheet

class DtoEntDeeplinkSpreadsheetInsert : DtoEntDeeplink() {
    var formEditorLayoutId: MetaIdLayoutForm? = null
    var mobileFormEditorLayoutId: MetaIdLayoutForm? = null
    var spreadsheetId: MetaIdSpreadsheet? = null
    var successDeeplinkId: MetaIdDeeplink? = null
}
