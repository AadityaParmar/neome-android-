// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnSortOrder
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdSpreadsheet

class EntVdAiSpreadsheetToField : EntVdAi() {
    var ascendingOrder: EnumDefnSortOrder? = null
    var filterCondition: StudioMapOfCondition? = null
    var numberOfRows: number? = null
    var orderByFieldIds: MetaIdField[]? = null
    var outputField: StudioDtoArgValueParameter? = null
    var selectFieldIds: MetaIdField[]? = null
    var spreadsheetId: MetaIdSpreadsheet? = null
}
