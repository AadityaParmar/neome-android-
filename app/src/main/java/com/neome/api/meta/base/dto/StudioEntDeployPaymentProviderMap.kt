// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdPaymentProvider
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioEntPaymentProvider

interface StudioEntDeployPaymentProviderMap : StudioBase
{
  val defaultPaymentProviderId: MetaIdPaymentProvider?
  val keys: List<MetaIdPaymentProvider>
  val map: Map<MetaIdPaymentProvider, StudioEntPaymentProvider>
}