// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.base.dto

import com.neome.api.ent.base.dto.DtoEntDeeplink
import com.neome.api.meta.base.Types.MetaIdDeeplink
import com.neome.api.meta.base.Types.MetaIdLayoutForm
import com.neome.api.meta.base.Types.MetaIdSpreadsheet

interface DtoEntDeeplinkSpreadsheetInsert : DtoEntDeeplink
{
  val formEditorLayoutId: MetaIdLayoutForm?
  val mobileFormEditorLayoutId: MetaIdLayoutForm?
  val spreadsheetId: MetaIdSpreadsheet?
  val successDeeplinkId: MetaIdDeeplink?
}