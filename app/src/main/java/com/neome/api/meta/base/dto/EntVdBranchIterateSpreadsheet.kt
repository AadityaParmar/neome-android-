// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.EntVdAutoStep
import com.neome.api.meta.base.Types.EnumDefnSortOrder
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdSpreadsheet
import com.neome.api.meta.base.dto.StudioMapOfCondition

interface EntVdBranchIterateSpreadsheet : EntVdAutoStep
{
  val ascendingOrder: EnumDefnSortOrder?
  val filterCondition: StudioMapOfCondition?
  val numberOfRows: Long?
  val orderByFieldIds: List<MetaIdField>?
  val selectFieldIds: List<MetaIdField>?
  val spreadsheetId: MetaIdSpreadsheet?
}