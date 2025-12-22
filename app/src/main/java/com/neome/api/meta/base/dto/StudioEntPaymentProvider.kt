// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Symbol
import com.neome.api.meta.base.Types.EnumPaymentProviderKind
import com.neome.api.meta.base.Types.MetaIdPaymentProvider

class StudioEntPaymentProvider : StudioBase() {
    val kind: EnumPaymentProviderKind
    val metaId: MetaIdPaymentProvider
    var name: Symbol? = null
}
