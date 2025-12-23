// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Symbol
import com.neome.api.meta.base.Types.EnumDefnLayoutGridKind
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdLayoutGrid

open class StudioDtoLayoutGrid : StudioBase() {
    var allowToSwitchLayoutIdSet: Array<MetaIdLayoutGrid>? = null
    var bgColorFieldId: MetaIdField? = null
    var description: String? = null
    lateinit var kind: EnumDefnLayoutGridKind
    var label: String? = null
    lateinit var metaId: MetaIdLayoutGrid
    lateinit var name: Symbol
    var toolTipFieldId: MetaIdField? = null
}
