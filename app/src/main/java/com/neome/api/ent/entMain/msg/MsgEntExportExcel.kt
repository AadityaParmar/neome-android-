// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.entMain.msg

import com.neome.api.ent.base.dto.DtoEntFormExportExcel
import com.neome.api.ent.base.dto.DtoEntSpreadsheetExportExcel
import com.neome.api.meta.base.Types.EntId
import com.neome.api.nucleus.base.msg.Msg

open class MsgEntExportExcel : Msg() {
    lateinit var entId: EntId
    var formExportConfig: DtoEntFormExportExcel? = null
    var spreadsheetExportConfig: DtoEntSpreadsheetExportExcel? = null
}
