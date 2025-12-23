// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdSpreadsheet

open class DefnDtoRefTarget {
    lateinit var displayFieldIdSet: Array<MetaIdField>
    lateinit var metaId: MetaIdSpreadsheet
    lateinit var overrideLayoutSpreadsheet: DefnLayoutGrid
}
