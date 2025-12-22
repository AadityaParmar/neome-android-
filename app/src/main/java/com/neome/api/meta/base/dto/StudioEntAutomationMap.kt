// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdAutomation

class StudioEntAutomationMap : StudioBase() {
    val keys: MetaIdAutomation[]
    val map: Record<MetaIdAutomation, StudioEntAutomation>
}
