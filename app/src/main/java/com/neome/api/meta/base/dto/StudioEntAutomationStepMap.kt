// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdStep
import java.util.Map

open class StudioEntAutomationStepMap : StudioBase() {
    lateinit var keys: Array<MetaIdStep>
    lateinit var map: Map<MetaIdStep, StudioEntAutomationStep>
}
