// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdEvent

class StudioEntAutomationSpreadsheetEventMap : StudioBase() {
    val keys: MetaIdEvent[]
    val map: Record<MetaIdEvent, StudioEntAutomationSpreadsheetEvent>
}
