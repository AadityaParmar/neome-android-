// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.base.dto

import com.neome.api.meta.base.Types.CurrencyKey
import com.neome.api.meta.base.Types.EnumDefnPaymentMethodKind

open class DtoPaymentProviderRazorpay : DtoPaymentProvider() {
    var allowedPaymentMethodSet: Array<EnumDefnPaymentMethodKind>? = null
    lateinit var apiKey: String
    lateinit var defaultCurrency: CurrencyKey
}
