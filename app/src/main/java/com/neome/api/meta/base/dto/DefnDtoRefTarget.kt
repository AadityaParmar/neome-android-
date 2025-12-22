// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdSpreadsheet

class DefnDtoRefTarget {
    val displayFieldIdSet: MetaIdField[]
    val metaId: MetaIdSpreadsheet
    val overrideLayoutSpreadsheet: DefnLayoutGrid
}
