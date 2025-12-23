// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DtoLogTreeItem
import com.neome.api.meta.base.dto.DtoLogTreeKeyValue
import com.neome.api.meta.base.Types.EnumFormContentPosition
import com.neome.api.meta.base.Types.EnumLogTreeLineCollapse

open class DtoLogTreeLine : DtoLogTreeItem()
{
  var bold: Boolean? = null
  var children: Array<DtoLogTreeKeyValue>? = null
  var collapse: EnumLogTreeLineCollapse? = null
  var contentPosition: EnumFormContentPosition? = null
  lateinit var line: String
  var lineColor: String? = null
}