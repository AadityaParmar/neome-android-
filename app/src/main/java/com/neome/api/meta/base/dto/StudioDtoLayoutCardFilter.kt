// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnLayoutCardFilterKind
import com.neome.api.meta.base.Types.EnumDefnSortOrder
import com.neome.api.meta.base.Types.MetaIdField

class StudioDtoLayoutCardFilter : StudioBase() {
    var advanceFilterFieldIdSet: MetaIdField[]? = null
    var categoryFieldIdSet: MetaIdField[]? = null
    var kind: EnumDefnLayoutCardFilterKind? = null
    var showSearchBar: boolean? = null
    var sortByFieldIdSet: MetaIdField[]? = null
    var sortOrder: EnumDefnSortOrder? = null
}
