// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdForm
import com.neome.api.meta.base.Types.MetaIdLayoutForm

open class DefnStudioMapOfLayoutFormContent : DefnField() {
    var defaultId: MetaIdLayoutForm? = null
    lateinit var formId: MetaIdForm
}
