// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.main.sig

import com.neome.api.meta.base.Types.MetaIdComp
import com.neome.api.meta.base.Types.MetaIdForm
import com.neome.api.meta.base.Types.MetaIdSpreadsheet
import com.neome.api.meta.base.Types.SpreadsheetPartitionId
import com.neome.api.meta.base.dto.FormValueRaw
import com.neome.api.nucleus.base.sig.SigVersion

open class SigSpreadsheetRow : SigVersion() {
    lateinit var formId: MetaIdForm
    var formValue: FormValueRaw? = null
    var rowCommentCount: SigSpreadsheetRowCommentCount? = null
    lateinit var spreadsheetId: MetaIdSpreadsheet
    lateinit var spreadsheetPartitionId: SpreadsheetPartitionId
    var updatedKeySet: Array<MetaIdComp>? = null
}
