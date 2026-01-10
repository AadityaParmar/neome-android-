// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdStep

interface StudioEntAutomationStepMap : StudioBase {
    val keys: List<MetaIdStep>
    val map: Map<MetaIdStep, StudioEntAutomationStep>
}
