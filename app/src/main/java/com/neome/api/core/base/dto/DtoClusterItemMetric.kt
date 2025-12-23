// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.core.base.dto

import kotlin.properties.Delegates

open class DtoClusterItemMetric
{
  var avgTime: Number by Delegates.notNull<Number>()
  var emptyCount: Number by Delegates.notNull<Number>()
  var failureCount: Number by Delegates.notNull<Number>()
  var maxTime: Number by Delegates.notNull<Number>()
  var medianTime: Number by Delegates.notNull<Number>()
  var minTime: Number by Delegates.notNull<Number>()
  lateinit var name: Array<String>
  var p80Time: Number by Delegates.notNull<Number>()
  var p90Time: Number by Delegates.notNull<Number>()
  var p95Time: Number by Delegates.notNull<Number>()
  var p999Time: Number by Delegates.notNull<Number>()
  var p99Time: Number by Delegates.notNull<Number>()
  var sla: Number? = null
  var successCount: Number by Delegates.notNull<Number>()
  var totalCount: Number by Delegates.notNull<Number>()
}