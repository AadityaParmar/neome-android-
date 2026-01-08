// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DtoLogItem
import com.neome.api.meta.base.dto.DtoLogTableCellHeader
import com.neome.api.meta.base.dto.DtoLogTableRow
import com.neome.api.meta.base.Types.EnumLogTableTextStyle

interface DtoLogTable : DtoLogItem
{
  val header: Array<DtoLogTableCellHeader>?
  val headerBgColor: String
  val headerColor: String
  val headerStyle: EnumLogTableTextStyle
  val label: String?
  val rowBgColor: String
  val rowColor: String
  val rowStyle: EnumLogTableTextStyle
  val rows: Array<DtoLogTableRow>?
  val showRows: Long?
}