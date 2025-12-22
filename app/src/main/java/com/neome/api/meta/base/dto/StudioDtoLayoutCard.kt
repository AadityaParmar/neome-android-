// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnGridRenderingMode
import com.neome.api.meta.base.Types.MetaIdField

class StudioDtoLayoutCard : StudioDtoLayoutGrid() {
    var filter: StudioDtoLayoutCardFilter? = null
    var groupByFieldId: MetaIdField? = null
    var hideBorders: boolean? = null
    var item: StudioDtoLayoutCardItem? = null
    var numOfColumns: number? = null
    var renderingMode: EnumDefnGridRenderingMode? = null
    var showSearchBar: boolean? = null
}
