// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnPaymentStatus
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.dto.StudioFieldEditable

class StudioFieldPaymentStatus : StudioFieldEditable() {
    var defaultFieldId: MetaIdField? = null
    var defaultValue: EnumDefnPaymentStatus? = null
}
