// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdComposite
import com.neome.api.meta.base.Types.MetaIdForm

class DefnStudioMapOfDynamicRule : DefnField() {
    var compositeIdSet: MetaIdComposite[]? = null
    val formId: MetaIdForm
}
