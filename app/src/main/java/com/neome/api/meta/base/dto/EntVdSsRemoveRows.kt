// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdSpreadsheet

open class EntVdSsRemoveRows : EntVdAutoStep() {
    var filterCondition: StudioMapOfCondition? = null
    var spreadsheetId: MetaIdSpreadsheet? = null
}
