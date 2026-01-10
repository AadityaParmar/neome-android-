// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnShowBorderKind
import com.neome.api.meta.base.Types.MetaIdLayoutGrid

interface StudioMapOfLayoutGrid : StudioBase {
    val asideDefaultLayoutId: MetaIdLayoutGrid?
    val keys: List<MetaIdLayoutGrid>
    val map: Map<MetaIdLayoutGrid, StudioDtoLayoutGrid>
    val placeholder: StudioDtoPlaceHolder?
    val showBorderSet: List<EnumDefnShowBorderKind>?
}
