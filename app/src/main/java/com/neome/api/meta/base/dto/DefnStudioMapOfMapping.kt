// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdForm
import com.neome.api.meta.base.Types.MetaIdGrid
import com.neome.api.meta.base.Types.MetaIdPlugin

open class DefnStudioMapOfMapping : DefnFieldEditable() {
    var fromFormId: MetaIdForm? = null
    var fromGridId: MetaIdGrid? = null
    var fromPluginId: MetaIdPlugin? = null
    lateinit var toFormId: MetaIdForm
    var toGridId: MetaIdGrid? = null
    var toPluginId: MetaIdPlugin? = null
}
