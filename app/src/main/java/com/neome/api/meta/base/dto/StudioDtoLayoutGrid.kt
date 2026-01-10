// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Symbol
import com.neome.api.meta.base.Types.EnumDefnLayoutGridKind
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdLayoutGrid

interface StudioDtoLayoutGrid : StudioBase {
    val allowToSwitchLayoutIdSet: List<MetaIdLayoutGrid>?
    val bgColorFieldId: MetaIdField?
    val description: String?
    val kind: EnumDefnLayoutGridKind
    val label: String?
    val metaId: MetaIdLayoutGrid
    val name: Symbol
    val toolTipFieldId: MetaIdField?
}
