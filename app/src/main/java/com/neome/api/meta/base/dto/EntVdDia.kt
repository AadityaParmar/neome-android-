// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdModule
import com.neome.api.meta.base.Types.MetaIdVdNote
import com.neome.api.meta.base.Types.MetaIdVdRegion

class EntVdDia : StudioBase() {
    var isDefault: boolean? = null
    var moduleId: MetaIdModule? = null
    val noteMap: Record<MetaIdVdNote, EntVdNote>
    val regionMap: Record<MetaIdVdRegion, EntVdRegion>
    var viewport: EntVdViewport? = null
}
