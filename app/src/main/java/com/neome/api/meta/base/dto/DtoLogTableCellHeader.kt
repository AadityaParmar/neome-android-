// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DtoLogTableCell
import com.neome.api.meta.base.Types.EnumLogTableAlignment

open class DtoLogTableCellHeader : DtoLogTableCell()
{
  var flexWeight: Number? = null
  var headerAlignment: EnumLogTableAlignment? = null
  var rowAlignment: EnumLogTableAlignment? = null
}