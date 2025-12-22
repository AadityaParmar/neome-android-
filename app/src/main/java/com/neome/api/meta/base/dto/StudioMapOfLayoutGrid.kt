// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnShowBorderKind
import com.neome.api.meta.base.Types.MetaIdLayoutGrid

class StudioMapOfLayoutGrid : StudioBase() {
    var asideDefaultLayoutId: MetaIdLayoutGrid? = null
    val keys: MetaIdLayoutGrid[]
    val map: Record<MetaIdLayoutGrid, StudioDtoLayoutGrid>
    var placeholder: StudioDtoPlaceHolder? = null
    var showBorderSet: EnumDefnShowBorderKind[]? = null
}
