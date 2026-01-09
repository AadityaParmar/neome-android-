package com.neome.core.common.serializer.api.core.base.dto

import com.neome.api.core.base.dto.DtoClusterItemMetric
import kotlinx.serialization.Serializable


@Serializable
data class DtoClusterItemMetricData(
    override val avgTime: Long? = null,
    override val emptyCount: Long? = null,
    override val failureCount: Long? = null,
    override val maxTime: Long? = null,
    override val medianTime: Long? = null,
    override val minTime: Long? = null,
    override val name: Array<String>,
    override val p80Time: Long? = null,
    override val p90Time: Long? = null,
    override val p95Time: Long? = null,
    override val p999Time: Long? = null,
    override val p99Time: Long? = null,
    override val sla: Long? = null,
    override val successCount: Long? = null,
    override val totalCount: Long? = null
) : DtoClusterItemMetric
