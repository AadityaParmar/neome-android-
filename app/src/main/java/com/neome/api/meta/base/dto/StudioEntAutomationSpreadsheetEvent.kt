// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnKindSpreadsheetEvent
import com.neome.api.meta.base.dto.StudioEntAutomationEvent

interface StudioEntAutomationSpreadsheetEvent : StudioEntAutomationEvent
{
  val fire: EnumDefnKindSpreadsheetEvent
}