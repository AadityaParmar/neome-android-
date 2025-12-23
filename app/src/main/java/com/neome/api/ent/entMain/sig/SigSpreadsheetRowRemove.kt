// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.entMain.sig

import com.neome.api.meta.base.dto.EnvValidationError
import java.util.Map
import com.neome.api.meta.base.Types.RowId
import com.neome.api.nucleus.base.sig.Sig

open class SigSpreadsheetRowRemove : Sig()
{
  lateinit var errorMap: Map<RowId, EnvValidationError>
}