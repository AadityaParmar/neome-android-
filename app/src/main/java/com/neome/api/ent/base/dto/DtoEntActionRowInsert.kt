// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.base.dto

import kotlinx.serialization.json.JsonElement
import com.neome.api.ent.base.dto.DtoEntAction
import com.neome.api.meta.base.Types.EnumDefnKindFormRenderingMode
import com.neome.api.meta.base.Types.MetaIdComp
import com.neome.api.meta.base.Types.MetaIdForm
import com.neome.api.meta.base.Types.MetaIdLayoutForm
import com.neome.api.meta.base.Types.MetaIdSpreadsheet

interface DtoEntActionRowInsert : DtoEntAction
{
  val defaultValueMap: Map<MetaIdComp, JsonElement>?
  val formEditorLayoutId: MetaIdLayoutForm?
  val formRenderingModeKind: EnumDefnKindFormRenderingMode?
  val hasPartitions: Boolean?
  val mobileFormEditorLayoutId: MetaIdLayoutForm?
  val sendMessageToInbox: Boolean?
  val spreadsheetFormId: MetaIdForm
  val spreadsheetId: MetaIdSpreadsheet
}