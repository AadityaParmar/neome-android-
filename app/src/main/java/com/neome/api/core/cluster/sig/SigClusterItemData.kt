// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.core.cluster.sig

import com.neome.api.core.base.dto.DtoClusterItemMetric
import com.neome.api.nucleus.base.sig.Sig

class SigClusterItemData : Sig() {
    val metricList: DtoClusterItemMetric[]
    val nameColList: string[]
}
