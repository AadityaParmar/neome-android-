// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.CurrencyKey
import com.neome.api.meta.base.Types.EnumDefnPaymentMethodKind

class StudioEntPaymentProviderRazorPay : StudioEntPaymentProvider() {
    var allowedPaymentMethodSet: EnumDefnPaymentMethodKind[]? = null
    var apiKey: string? = null
    var apiSecret: string? = null
    var defaultCurrency: CurrencyKey? = null
    var webhookSecret: string? = null
}
