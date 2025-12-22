// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnShowBorderKind
import com.neome.api.meta.base.Types.MetaIdLayoutGrid

class DefnLayoutGridMap {
    var asideDefaultLayoutId: MetaIdLayoutGrid? = null
    val keys: MetaIdLayoutGrid[]
    val map: Record<MetaIdLayoutGrid, DefnLayoutGrid>
    var placeholder: DefnDtoPlaceholder? = null
    var showBorderSet: EnumDefnShowBorderKind[]? = null
}
