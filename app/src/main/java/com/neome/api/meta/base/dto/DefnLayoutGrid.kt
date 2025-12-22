// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Symbol
import com.neome.api.meta.base.Types.EnumDefnLayoutGridKind
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdLayoutGrid

class DefnLayoutGrid {
    var allowToSwitchLayoutIdSet: MetaIdLayoutGrid[]? = null
    var bgColorFieldId: MetaIdField? = null
    var description: string? = null
    val kind: EnumDefnLayoutGridKind
    var label: string? = null
    val metaId: MetaIdLayoutGrid
    val name: Symbol
    var toolTipFieldId: MetaIdField? = null
}
