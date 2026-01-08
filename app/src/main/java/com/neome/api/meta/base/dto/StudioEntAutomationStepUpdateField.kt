// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.dto.StudioBuildArgBinderHolder
import com.neome.api.meta.base.dto.StudioEntAutomationStep

interface StudioEntAutomationStepUpdateField : StudioEntAutomationStep
{
  val assignValueFieldId: MetaIdField?
  val value: StudioBuildArgBinderHolder?
}