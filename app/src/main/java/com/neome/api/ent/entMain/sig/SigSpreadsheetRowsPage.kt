// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.entMain.sig

import com.neome.api.ent.base.dto.DtoFieldFilter
import com.neome.api.home.main.sig.SigSpreadsheetRow
import com.neome.api.meta.base.Types.MetaIdSpreadsheet
import com.neome.api.meta.base.dto.DefnForm
import com.neome.api.meta.base.dto.DefnLayoutGridMap
import com.neome.api.nucleus.base.sig.Sig

class SigSpreadsheetRowsPage : Sig() {
    val filterList: DtoFieldFilter[]
    val hasMoreRows: boolean
    val outputForm: DefnForm
    val rowList: SigSpreadsheetRow[]
    var spreadSheetLayoutMap: DefnLayoutGridMap? = null
    var spreadsheetId: MetaIdSpreadsheet? = null
}
