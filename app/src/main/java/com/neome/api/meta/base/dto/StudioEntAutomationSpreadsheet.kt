// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdSpreadsheet
import com.neome.api.meta.base.dto.StudioEntAutomation
import com.neome.api.meta.base.dto.StudioEntAutomationSpreadsheetEventMap

open class StudioEntAutomationSpreadsheet : StudioEntAutomation()
{
  lateinit var eventMap: StudioEntAutomationSpreadsheetEventMap
  lateinit var spreadsheetId: MetaIdSpreadsheet
}