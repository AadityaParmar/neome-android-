// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import java.util.Map
import com.neome.api.meta.base.Types.MetaIdAutomation
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioEntAutomation

open class StudioEntAutomationMap : StudioBase()
{
  lateinit var keys: Array<MetaIdAutomation>
  lateinit var map: Map<MetaIdAutomation, StudioEntAutomation>
}