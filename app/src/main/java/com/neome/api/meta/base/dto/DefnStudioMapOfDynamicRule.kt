// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdComposite
import com.neome.api.meta.base.Types.MetaIdForm

open class DefnStudioMapOfDynamicRule : DefnField() {
    var compositeIdSet: Array<MetaIdComposite>? = null
    lateinit var formId: MetaIdForm
}
