// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdPaymentProvider
import java.util.Map

open class StudioEntDeployPaymentProviderMap : StudioBase() {
    var defaultPaymentProviderId: MetaIdPaymentProvider? = null
    lateinit var keys: Array<MetaIdPaymentProvider>
    lateinit var map: Map<MetaIdPaymentProvider, StudioEntPaymentProvider>
}
