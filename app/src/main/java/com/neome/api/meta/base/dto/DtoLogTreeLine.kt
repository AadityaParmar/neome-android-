// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DtoLogTreeItem
import com.neome.api.meta.base.dto.DtoLogTreeKeyValue
import com.neome.api.meta.base.Types.EnumFormContentPosition
import com.neome.api.meta.base.Types.EnumLogTreeLineCollapse

interface DtoLogTreeLine : DtoLogTreeItem
{
  val bold: Boolean?
  val children: List<DtoLogTreeKeyValue>?
  val collapse: EnumLogTreeLineCollapse?
  val contentPosition: EnumFormContentPosition?
  val line: String
  val lineColor: String?
}