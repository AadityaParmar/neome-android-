// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.base.dto

import com.neome.api.meta.base.Types.RowId
import com.neome.api.meta.base.dto.EnvValidationError

class DtoBulkOperationResult {
    val errorMap: Record<RowId, EnvValidationError>
}
