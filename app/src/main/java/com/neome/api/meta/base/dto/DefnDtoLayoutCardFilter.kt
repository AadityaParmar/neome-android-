// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnLayoutCardFilterKind
import com.neome.api.meta.base.Types.EnumDefnSortOrder
import com.neome.api.meta.base.Types.MetaIdField

open class DefnDtoLayoutCardFilter {
    var advanceFilterFieldIdSet: Array<MetaIdField>? = null
    var categoryFieldIdSet: Array<MetaIdField>? = null
    var kind: EnumDefnLayoutCardFilterKind? = null
    var showSearchBar: Boolean? = null
    var sortByFieldIdSet: Array<MetaIdField>? = null
    var sortOrder: EnumDefnSortOrder? = null
}
