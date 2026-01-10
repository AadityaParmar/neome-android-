package com.neome.core.common.serializer.api.core.cluster.sig

import com.neome.api.core.base.dto.DtoClusterItemMetric
import com.neome.api.core.cluster.sig.SigClusterItemData
import com.neome.api.nucleus.base.sig.Sig
import com.neome.core.common.serializer.api.core.base.dto.DtoClusterItemMetricData
import kotlinx.serialization.Serializable


@Serializable
data class SigClusterItemDataData(
    override val metricList: List<DtoClusterItemMetricData>,
    override val nameColList: List<String>
) : SigClusterItemData
