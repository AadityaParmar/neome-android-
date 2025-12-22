// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.ent.sig

import com.neome.api.meta.base.Types.RowId
import com.neome.api.meta.base.dto.FormValueRaw
import com.neome.api.nucleus.base.sig.Sig

class SigEntSpreadsheetData : Sig() {
    val rowMap: Record<RowId, FormValueRaw>
    var topGridVer: string? = null
}
