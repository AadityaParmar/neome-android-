// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnPaymentStatus
import com.neome.api.meta.base.Types.MetaIdField

class DefnFieldPaymentStatus : DefnFieldEditable() {
    var defaultFieldId: MetaIdField? = null
    var defaultValue: EnumDefnPaymentStatus? = null
}
