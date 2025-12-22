// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdPaymentProvider

class StudioEntDeployPaymentProviderMap : StudioBase() {
    var defaultPaymentProviderId: MetaIdPaymentProvider? = null
    val keys: MetaIdPaymentProvider[]
    val map: Record<MetaIdPaymentProvider, StudioEntPaymentProvider>
}
