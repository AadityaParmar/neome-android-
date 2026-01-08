// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdLayoutForm
import com.neome.api.meta.base.Types.MetaIdSpreadsheet
import com.neome.api.meta.base.dto.StudioEntDeeplinkWithHeader

interface StudioEntDeeplinkSpreadsheetRow : StudioEntDeeplinkWithHeader
{
  val formContentLayoutId: MetaIdLayoutForm?
  val formTemplateLayoutId: MetaIdLayoutForm?
  val spreadsheetId: MetaIdSpreadsheet?
}