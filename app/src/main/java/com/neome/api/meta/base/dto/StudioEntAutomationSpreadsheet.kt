// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdSpreadsheet
import com.neome.api.meta.base.dto.StudioEntAutomation
import com.neome.api.meta.base.dto.StudioEntAutomationSpreadsheetEventMap

interface StudioEntAutomationSpreadsheet : StudioEntAutomation
{
  val eventMap: StudioEntAutomationSpreadsheetEventMap
  val spreadsheetId: MetaIdSpreadsheet
}