// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.base.dto

import com.neome.api.meta.base.Types.CurrencyKey
import com.neome.api.meta.base.Types.EnumDefnPaymentMethodKind

class DtoPaymentProviderRazorpay : DtoPaymentProvider() {
    var allowedPaymentMethodSet: EnumDefnPaymentMethodKind[]? = null
    val apiKey: string
    val defaultCurrency: CurrencyKey
}
