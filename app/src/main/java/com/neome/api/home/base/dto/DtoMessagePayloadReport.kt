// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.base.dto

import com.neome.api.home.base.dto.DtoMessagePayload
import com.neome.api.meta.base.dto.FormValueRaw
import com.neome.api.meta.base.Types.MetaIdAction
import com.neome.api.meta.base.Types.MetaIdForm
import com.neome.api.meta.base.Types.MetaIdReport
import com.neome.api.meta.base.Types.RowId

interface DtoMessagePayloadReport : DtoMessagePayload
{
  val actionId: MetaIdAction
  val formValueRaw: FormValueRaw?
  val inputFormId: MetaIdForm?
  val reportId: MetaIdReport?
  val reportLabel: String?
  val reportName: String?
  val rowId: RowId?
}