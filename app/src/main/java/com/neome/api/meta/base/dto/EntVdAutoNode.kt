// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Symbol
import com.neome.api.meta.base.Types.EnumDefnKindAutoNode
import com.neome.api.meta.base.Types.MetaIdVdAutoNode
import com.neome.api.meta.base.Types.MetaIdVdRegion

class EntVdAutoNode : VdBase() {
    val kind: EnumDefnKindAutoNode
    var logMsg: StudioValueParagraph? = null
    val metaId: MetaIdVdAutoNode
    val name: Symbol
    var parentRegionId: MetaIdVdRegion? = null
    var point: Point? = null
    var size: Size? = null
}
