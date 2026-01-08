// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.EntVdAi
import com.neome.api.meta.base.Types.EnumDefnSortOrder
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdSpreadsheet
import com.neome.api.meta.base.dto.StudioDtoArgValueParameter
import com.neome.api.meta.base.dto.StudioMapOfCondition

interface EntVdAiSpreadsheetToField : EntVdAi
{
  val ascendingOrder: EnumDefnSortOrder?
  val filterCondition: StudioMapOfCondition?
  val numberOfRows: Long?
  val orderByFieldIds: Array<MetaIdField>?
  val outputField: StudioDtoArgValueParameter?
  val selectFieldIds: Array<MetaIdField>?
  val spreadsheetId: MetaIdSpreadsheet?
}