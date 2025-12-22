// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.studio.studioMain.sig

import com.neome.api.meta.base.Types.EntId
import com.neome.api.nucleus.base.sig.Sig
import com.neome.api.studio.base.dto.DtoAnalyticDashboardState

class SigAnalyticsDashboardStateGet : Sig() {
    val dashboardState: Record<EntId, DtoAnalyticDashboardState>
}
