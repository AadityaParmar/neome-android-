// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdForm
import com.neome.api.meta.base.Types.MetaIdPlugin

open class StudioVarValueMapping : StudioDtoMapping() {
    var fromFormId: MetaIdForm? = null
    var fromPluginId: MetaIdPlugin? = null
    var toFormId: MetaIdForm? = null
    var toPluginId: MetaIdPlugin? = null
}
