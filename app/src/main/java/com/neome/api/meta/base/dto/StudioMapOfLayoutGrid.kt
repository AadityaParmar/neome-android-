// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnShowBorderKind
import com.neome.api.meta.base.Types.MetaIdLayoutGrid
import java.util.Map

open class StudioMapOfLayoutGrid : StudioBase() {
    var asideDefaultLayoutId: MetaIdLayoutGrid? = null
    lateinit var keys: Array<MetaIdLayoutGrid>
    lateinit var map: Map<MetaIdLayoutGrid, StudioDtoLayoutGrid>
    var placeholder: StudioDtoPlaceHolder? = null
    var showBorderSet: Array<EnumDefnShowBorderKind>? = null
}
