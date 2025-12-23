// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.base.dto

import com.neome.api.ent.base.dto.DtoEntDeeplink
import com.neome.api.meta.base.Types.MetaIdLayoutForm
import com.neome.api.meta.base.Types.MetaIdSpreadsheet

open class DtoEntDeeplinkSpreadsheetRow : DtoEntDeeplink()
{
  var formContentLayoutId: MetaIdLayoutForm? = null
  var formTemplateLayoutId: MetaIdLayoutForm? = null
  var spreadsheetId: MetaIdSpreadsheet? = null
}