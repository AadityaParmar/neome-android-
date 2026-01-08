// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.base.dto

import com.neome.api.ent.base.dto.DtoEntDeeplink
import com.neome.api.meta.base.Types.MetaIdLayoutForm
import com.neome.api.meta.base.Types.MetaIdSpreadsheet

interface DtoEntDeeplinkSpreadsheetRow : DtoEntDeeplink
{
  val formContentLayoutId: MetaIdLayoutForm?
  val formTemplateLayoutId: MetaIdLayoutForm?
  val spreadsheetId: MetaIdSpreadsheet?
}