// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdSpreadsheet

class StudioEntSpreadsheetMap : StudioBase() {
    val keys: MetaIdSpreadsheet[]
    val map: Record<MetaIdSpreadsheet, StudioEntSpreadsheet>
}
