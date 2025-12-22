// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.studio.base.dto

import com.neome.api.meta.base.Types.EnumDefnEntStage
import com.neome.api.studio.base.Types.EnumEntActivityState

class DtoAnalyticDashboardState {
    val activityState: EnumEntActivityState
    val dailyActiveUsers: number
    val entName: string
    val monthlyActiveUsers: number
    val stage: EnumDefnEntStage
    val totalActiveUsers: number
    val totalMediaIn: number
    val totalMediaOut: number
    val totalMessages: number
    val totalNetworkIn: number
    val totalNetworkOut: number
    val totalReportAccess: number
    val totalSpreadsheetEdits: number
}
