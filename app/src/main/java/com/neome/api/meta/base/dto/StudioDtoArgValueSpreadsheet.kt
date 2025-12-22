// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdComposite
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdSpreadsheet

class StudioDtoArgValueSpreadsheet : StudioDtoArgValue() {
    var compositeId: MetaIdComposite? = null
    var fieldId: MetaIdField? = null
    var spreadsheetAlias: string? = null
    var spreadsheetId: MetaIdSpreadsheet? = null
    var valuePathArray: string[]? = null
}
