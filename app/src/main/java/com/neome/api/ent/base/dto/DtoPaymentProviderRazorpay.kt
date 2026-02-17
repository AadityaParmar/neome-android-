// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.base.dto

import com.neome.api.meta.base.Types.CurrencyKey
import com.neome.api.ent.base.dto.DtoPaymentProvider
import com.neome.api.meta.base.Types.EnumDefnPaymentMethodKind

interface DtoPaymentProviderRazorpay : DtoPaymentProvider
{
  val allowedPaymentMethodSet: List<EnumDefnPaymentMethodKind>?
  val apiKey: String
  val defaultCurrency: CurrencyKey
}