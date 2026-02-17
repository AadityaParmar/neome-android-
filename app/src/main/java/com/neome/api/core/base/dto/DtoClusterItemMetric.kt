// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.core.base.dto

interface DtoClusterItemMetric
{
  val avgTime: Double
  val emptyCount: Long
  val failureCount: Long
  val maxTime: Long
  val medianTime: Double
  val minTime: Long
  val name: List<String>
  val p80Time: Double
  val p90Time: Double
  val p95Time: Double
  val p999Time: Double
  val p99Time: Double
  val sla: Long?
  val successCount: Long
  val totalCount: Long
}