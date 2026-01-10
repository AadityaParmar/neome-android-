// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnShowBorderKind
import com.neome.api.meta.base.Types.MetaIdLayoutGrid

interface DefnLayoutGridMap {
    val asideDefaultLayoutId: MetaIdLayoutGrid?
    val keys: List<MetaIdLayoutGrid>
    val map: Map<MetaIdLayoutGrid, DefnLayoutGrid>
    val placeholder: DefnDtoPlaceholder?
    val showBorderSet: List<EnumDefnShowBorderKind>?
}
