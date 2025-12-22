// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdStep

class StudioEntAutomationStepMap : StudioBase() {
    val keys: MetaIdStep[]
    val map: Record<MetaIdStep, StudioEntAutomationStep>
}
