// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.core.base.dto

interface DtoClusterItemMetric {
    val avgTime: Long?
    val emptyCount: Long?
    val failureCount: Long?
    val maxTime: Long?
    val medianTime: Long?
    val minTime: Long?
    val name: List<String>
    val p80Time: Long?
    val p90Time: Long?
    val p95Time: Long?
    val p999Time: Long?
    val p99Time: Long?
    val sla: Long?
    val successCount: Long?
    val totalCount: Long?
}
