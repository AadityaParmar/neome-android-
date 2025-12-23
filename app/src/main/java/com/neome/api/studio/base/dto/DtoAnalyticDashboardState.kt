// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.studio.base.dto

import kotlin.properties.Delegates
import com.neome.api.meta.base.Types.EnumDefnEntStage
import com.neome.api.studio.base.Types.EnumEntActivityState

open class DtoAnalyticDashboardState
{
  lateinit var activityState: EnumEntActivityState
  var dailyActiveUsers: Number by Delegates.notNull<Number>()
  lateinit var entName: String
  var monthlyActiveUsers: Number by Delegates.notNull<Number>()
  lateinit var stage: EnumDefnEntStage
  var totalActiveUsers: Number by Delegates.notNull<Number>()
  var totalMediaIn: Number by Delegates.notNull<Number>()
  var totalMediaOut: Number by Delegates.notNull<Number>()
  var totalMessages: Number by Delegates.notNull<Number>()
  var totalNetworkIn: Number by Delegates.notNull<Number>()
  var totalNetworkOut: Number by Delegates.notNull<Number>()
  var totalReportAccess: Number by Delegates.notNull<Number>()
  var totalSpreadsheetEdits: Number by Delegates.notNull<Number>()
}