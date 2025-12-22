// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.core.base.dto

class DtoClusterItemMetric {
    val avgTime: number
    val emptyCount: number
    val failureCount: number
    val maxTime: number
    val medianTime: number
    val minTime: number
    val name: string[]
    val p80Time: number
    val p90Time: number
    val p95Time: number
    val p999Time: number
    val p99Time: number
    var sla: number? = null
    val successCount: number
    val totalCount: number
}
