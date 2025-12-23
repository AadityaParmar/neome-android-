// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.dto.StudioBuildArgBinderHolder
import com.neome.api.meta.base.dto.StudioEntAutomationStep

open class StudioEntAutomationStepUpdateField : StudioEntAutomationStep()
{
  var assignValueFieldId: MetaIdField? = null
  var value: StudioBuildArgBinderHolder? = null
}