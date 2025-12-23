// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.ent.sig

import com.neome.api.meta.base.Types.RowId
import com.neome.api.meta.base.dto.FormValueRaw
import com.neome.api.nucleus.base.sig.Sig
import java.util.Map

open class SigEntSpreadsheetData : Sig() {
    lateinit var rowMap: Map<RowId, FormValueRaw>
    var topGridVer: String? = null
}
