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

class SigSpreadsheetRow : SigVersion() {
    val formId: MetaIdForm
    var formValue: FormValueRaw? = null
    var rowCommentCount: SigSpreadsheetRowCommentCount? = null
    val spreadsheetId: MetaIdSpreadsheet
    val spreadsheetPartitionId: SpreadsheetPartitionId
    var updatedKeySet: MetaIdComp[]? = null
}
