// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.core.cluster.sig

import com.neome.api.core.base.dto.DtoClusterItemMetric
import com.neome.api.nucleus.base.sig.Sig

open class SigClusterItemData : Sig() {
    lateinit var metricList: Array<DtoClusterItemMetric>
    lateinit var nameColList: Array<String>
}
