package com.neome.core.common.serializer.api.core.base.dto

import com.neome.api.core.base.dto.DtoClusterItemMetric
import kotlinx.serialization.Serializable


@Serializable
data class DtoClusterItemMetricData(
    override val avgTime: Double,
    override val emptyCount: Long,
    override val failureCount: Long,
    override val maxTime: Long,
    override val medianTime: Double,
    override val minTime: Long,
    override val name: List<String>,
    override val p80Time: Double,
    override val p90Time: Double,
    override val p95Time: Double,
    override val p999Time: Double,
    override val p99Time: Double,
    override val sla: Long? = null,
    override val successCount: Long,
    override val totalCount: Long
) : DtoClusterItemMetric
