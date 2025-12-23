// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnShowBorderKind
import com.neome.api.meta.base.Types.MetaIdLayoutGrid
import java.util.Map

open class DefnLayoutGridMap {
    var asideDefaultLayoutId: MetaIdLayoutGrid? = null
    lateinit var keys: Array<MetaIdLayoutGrid>
    lateinit var map: Map<MetaIdLayoutGrid, DefnLayoutGrid>
    var placeholder: DefnDtoPlaceholder? = null
    var showBorderSet: Array<EnumDefnShowBorderKind>? = null
}
