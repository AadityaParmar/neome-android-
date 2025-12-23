// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.base.dto

import com.neome.api.ent.base.dto.DtoEntDeeplink
import com.neome.api.meta.base.Types.MetaIdLayoutGrid
import com.neome.api.meta.base.Types.MetaIdSpreadsheet

open class DtoEntDeeplinkSpreadsheetEditor : DtoEntDeeplink()
{
  var layoutSpreadsheetId: MetaIdLayoutGrid? = null
  var spreadsheetId: MetaIdSpreadsheet? = null
}