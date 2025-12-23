// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdForm
import com.neome.api.meta.base.Types.MetaIdGrid
import com.neome.api.meta.base.Types.MetaIdPlugin
import com.neome.api.meta.base.Types.MetaIdVar

open class DefnStudioMapOfCondition : DefnField() {
    var excludeVarIdSet: Array<MetaIdVar>? = null
    var inputFormId: MetaIdForm? = null
    lateinit var sourceFormId: MetaIdForm
    var sourceGridId: MetaIdGrid? = null
    var sourcePluginId: MetaIdPlugin? = null
}
