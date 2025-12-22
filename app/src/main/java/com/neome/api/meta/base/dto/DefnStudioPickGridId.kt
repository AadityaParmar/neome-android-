// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdForm
import com.neome.api.meta.base.Types.MetaIdGrid

class DefnStudioPickGridId : DefnFieldEditable() {
    var excludeGridIdSet: MetaIdGrid[]? = null
    val formId: MetaIdForm
}
