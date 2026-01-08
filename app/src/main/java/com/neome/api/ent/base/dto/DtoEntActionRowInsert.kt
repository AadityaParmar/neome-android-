// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.base.dto

import com.neome.api.ent.base.dto.DtoEntAction
import com.google.gson.JsonElement
import java.util.Map
import com.neome.api.meta.base.Types.MetaIdComp
import com.neome.api.meta.base.Types.MetaIdForm
import com.neome.api.meta.base.Types.MetaIdLayoutForm
import com.neome.api.meta.base.Types.MetaIdSpreadsheet

interface DtoEntActionRowInsert : DtoEntAction
{
  val defaultValueMap: Map<MetaIdComp, Any>?
  val formEditorLayoutId: MetaIdLayoutForm?
  val hasPartitions: Boolean?
  val mobileFormEditorLayoutId: MetaIdLayoutForm?
  val sendMessageToInbox: Boolean?
  val spreadsheetFormId: MetaIdForm
  val spreadsheetId: MetaIdSpreadsheet
}