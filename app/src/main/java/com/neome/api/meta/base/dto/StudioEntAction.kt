// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnKindAction
import com.neome.api.meta.base.Types.MetaIdAction
import com.neome.api.meta.base.Types.MetaIdComp
import java.util.Map

open class StudioEntAction : StudioBase() {
    var aiInstructions: String? = null
    var defaultValueMap: Map<MetaIdComp, Any>? = null
    lateinit var details: StudioDetails
    var icon: String? = null
    var increaseAsideWidth: Boolean? = null
    lateinit var kind: EnumDefnKindAction
    lateinit var metaId: MetaIdAction
    var tooltip: String? = null
}
