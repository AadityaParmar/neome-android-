// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.CurrencyKey
import com.neome.api.meta.base.Types.EnumDefnPaymentMethodKind
import com.neome.api.meta.base.dto.StudioEntPaymentProvider

interface StudioEntPaymentProviderRazorPay : StudioEntPaymentProvider
{
  val allowedPaymentMethodSet: Array<EnumDefnPaymentMethodKind>?
  val apiKey: String?
  val apiSecret: String?
  val defaultCurrency: CurrencyKey?
  val webhookSecret: String?
}