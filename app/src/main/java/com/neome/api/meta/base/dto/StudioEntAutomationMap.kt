// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import java.util.Map
import com.neome.api.meta.base.Types.MetaIdAutomation
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioEntAutomation

interface StudioEntAutomationMap : StudioBase
{
  val keys: Array<MetaIdAutomation>
  val map: Map<MetaIdAutomation, StudioEntAutomation>
}