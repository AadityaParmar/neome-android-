// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.entAside.sig

import com.neome.api.home.main.sig.SigSpreadsheetRow
import com.neome.api.meta.base.Types.MetaIdSpreadsheet
import com.neome.api.meta.base.dto.DefnForm
import com.neome.api.meta.base.dto.DefnLayoutGridMap
import com.neome.api.nucleus.base.sig.SigVersion

class SigSpreadsheetRefFieldData : SigVersion() {
    val outputForm: DefnForm
    val rowList: SigSpreadsheetRow[]
    var spreadSheetLayoutMap: DefnLayoutGridMap? = null
    var spreadsheetId: MetaIdSpreadsheet? = null
}
