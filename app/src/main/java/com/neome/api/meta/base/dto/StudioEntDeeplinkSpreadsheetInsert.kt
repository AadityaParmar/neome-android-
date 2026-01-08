// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdDeeplink
import com.neome.api.meta.base.Types.MetaIdLayoutForm
import com.neome.api.meta.base.Types.MetaIdSpreadsheet
import com.neome.api.meta.base.Types.MetaIdVar
import com.neome.api.meta.base.dto.StudioEntDeeplinkWithHeader
import com.neome.api.meta.base.dto.StudioValueVarIdParagraph

interface StudioEntDeeplinkSpreadsheetInsert : StudioEntDeeplinkWithHeader
{
  val formEditorLayoutId: MetaIdLayoutForm?
  val mobileFormEditorLayoutId: MetaIdLayoutForm?
  val repeatButtonLabel: String?
  val showRepeatButton: Boolean?
  val spreadsheetId: MetaIdSpreadsheet?
  val successDeeplinkId: MetaIdDeeplink?
  val successMessageBgColorVarId: MetaIdVar?
  val successMessageTextSizeVarId: MetaIdVar?
  val successMessageVarId: StudioValueVarIdParagraph?
}