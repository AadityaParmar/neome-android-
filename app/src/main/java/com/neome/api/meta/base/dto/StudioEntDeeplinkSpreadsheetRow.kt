// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdLayoutForm
import com.neome.api.meta.base.Types.MetaIdSpreadsheet

class StudioEntDeeplinkSpreadsheetRow : StudioEntDeeplinkWithHeader() {
    var formContentLayoutId: MetaIdLayoutForm? = null
    var formTemplateLayoutId: MetaIdLayoutForm? = null
    var spreadsheetId: MetaIdSpreadsheet? = null
}
