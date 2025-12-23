// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.entAside.sig

import com.neome.api.home.main.sig.SigSpreadsheetRow
import com.neome.api.meta.base.Types.MetaIdSpreadsheet
import com.neome.api.meta.base.dto.DefnForm
import com.neome.api.meta.base.dto.DefnLayoutGridMap
import com.neome.api.nucleus.base.sig.SigVersion

open class SigSpreadsheetRefFieldData : SigVersion() {
    lateinit var outputForm: DefnForm
    lateinit var rowList: Array<SigSpreadsheetRow>
    var spreadSheetLayoutMap: DefnLayoutGridMap? = null
    var spreadsheetId: MetaIdSpreadsheet? = null
}
