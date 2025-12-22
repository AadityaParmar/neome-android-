// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.studio.studioMain.sig

import com.neome.api.meta.base.dto.StudioEntDeployPaymentProviderMap
import com.neome.api.nucleus.base.sig.SigVersion

class SigEntPaymentMap : SigVersion() {
    val providerMap: StudioEntDeployPaymentProviderMap
}
