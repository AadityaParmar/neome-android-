// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.entMain.sig

import kotlin.properties.Delegates
import com.neome.api.meta.base.dto.DefnForm
import com.neome.api.meta.base.dto.DefnLayoutGridMap
import com.neome.api.ent.base.dto.DtoFieldFilter
import com.neome.api.meta.base.Types.MetaIdSpreadsheet
import com.neome.api.nucleus.base.sig.Sig
import com.neome.api.home.main.sig.SigSpreadsheetRow

open class SigSpreadsheetRowsPage : Sig()
{
  lateinit var filterList: Array<DtoFieldFilter>
  var hasMoreRows: Boolean by Delegates.notNull<Boolean>()
  lateinit var outputForm: DefnForm
  lateinit var rowList: Array<SigSpreadsheetRow>
  var spreadSheetLayoutMap: DefnLayoutGridMap? = null
  var spreadsheetId: MetaIdSpreadsheet? = null
}