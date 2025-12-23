// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.CurrencyKey
import com.neome.api.meta.base.Types.EnumDefnPaymentMethodKind

open class StudioEntPaymentProviderRazorPay : StudioEntPaymentProvider() {
    var allowedPaymentMethodSet: Array<EnumDefnPaymentMethodKind>? = null
    var apiKey: String? = null
    var apiSecret: String? = null
    var defaultCurrency: CurrencyKey? = null
    var webhookSecret: String? = null
}
