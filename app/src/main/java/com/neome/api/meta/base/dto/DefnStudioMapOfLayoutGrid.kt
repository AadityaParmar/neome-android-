// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnField
import com.neome.api.meta.base.Types.MetaIdForm
import com.neome.api.meta.base.Types.MetaIdGrid

class DefnStudioMapOfLayoutGrid : DefnField() {
    val formId: MetaIdForm
    val gridId: MetaIdGrid
    var isPluginForm: boolean? = null
}
