// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdAutomation
import java.util.Map

open class StudioEntAutomationMap : StudioBase() {
    lateinit var keys: Array<MetaIdAutomation>
    lateinit var map: Map<MetaIdAutomation, StudioEntAutomation>
}
