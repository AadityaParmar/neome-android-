// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdSpreadsheet

open class EntVdAiExcelToSpreadsheet : EntVdAi() {
    var inputField: StudioDtoArgValueParameter? = null
    var spreadsheetId: MetaIdSpreadsheet? = null
}
