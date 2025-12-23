// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.studio.studioMain.sig

import com.neome.api.studio.base.dto.DtoAnalyticDashboardState
import com.neome.api.meta.base.Types.EntId
import java.util.Map
import com.neome.api.nucleus.base.sig.Sig

open class SigAnalyticsDashboardStateGet : Sig()
{
  lateinit var dashboardState: Map<EntId, DtoAnalyticDashboardState>
}