// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnSortOrder
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdSpreadsheet

open class EntVdBranchIterateSpreadsheet : EntVdAutoStep() {
    var ascendingOrder: EnumDefnSortOrder? = null
    var filterCondition: StudioMapOfCondition? = null
    var numberOfRows: Number? = null
    var orderByFieldIds: Array<MetaIdField>? = null
    var selectFieldIds: Array<MetaIdField>? = null
    var spreadsheetId: MetaIdSpreadsheet? = null
}
