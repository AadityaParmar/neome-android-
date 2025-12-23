// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.main.sig

import com.neome.api.home.main.sig.SigSpreadsheetRowCommentCount
import com.neome.api.meta.base.Types.RowId
import com.neome.api.meta.base.dto.EnvValidationError
import com.neome.api.nucleus.base.sig.Sig
import java.util.Map

open class SigSpreadsheetBulkRowCommentCount : Sig() {
    var errorMap: Map<RowId, EnvValidationError>? = null
    var rowCommentCountMap: Map<RowId, SigSpreadsheetRowCommentCount>? = null
}
