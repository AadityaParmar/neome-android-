// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DtoLogTableCell
import com.neome.api.meta.base.Types.EnumLogTableAlignment

interface DtoLogTableCellHeader : DtoLogTableCell
{
  val flexWeight: Long?
  val headerAlignment: EnumLogTableAlignment?
  val rowAlignment: EnumLogTableAlignment?
}