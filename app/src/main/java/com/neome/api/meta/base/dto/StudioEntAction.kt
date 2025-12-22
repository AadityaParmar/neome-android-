// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnKindAction
import com.neome.api.meta.base.Types.MetaIdAction
import com.neome.api.meta.base.Types.MetaIdComp

class StudioEntAction : StudioBase() {
    var aiInstructions: string? = null
    var defaultValueMap: Record<MetaIdComp, any>? = null
    val details: StudioDetails
    var icon: string? = null
    var increaseAsideWidth: boolean? = null
    val kind: EnumDefnKindAction
    val metaId: MetaIdAction
    var tooltip: string? = null
}
