// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.main.sig

import com.neome.api.meta.base.Types.RowId
import com.neome.api.meta.base.dto.EnvValidationError
import com.neome.api.nucleus.base.sig.Sig

class SigSpreadsheetBulkRowInsert : Sig() {
    val errorMap: Record<RowId, EnvValidationError>
}
