// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.base.dto

import com.neome.api.meta.base.dto.EnvValidationError
import java.util.Map
import com.neome.api.meta.base.Types.RowId

open class DtoBulkOperationResult
{
  lateinit var errorMap: Map<RowId, EnvValidationError>
}