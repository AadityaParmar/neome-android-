// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdForm
import com.neome.api.meta.base.Types.MetaIdGrid

open class DefnStudioMapOfLayoutGrid : DefnField() {
    lateinit var formId: MetaIdForm
    lateinit var gridId: MetaIdGrid
    var isPluginForm: Boolean? = null
}
