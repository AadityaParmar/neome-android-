// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdSpreadsheet
import com.neome.api.meta.base.Types.MetaIdSpreadsheetRef

class StudioDtoArgValueRefTarget : StudioDtoArgValueField() {
    val spreadsheetId: MetaIdSpreadsheet
    val spreadsheetRefId: MetaIdSpreadsheetRef
}
