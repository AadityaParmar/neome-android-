// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DtoLogTreeItem
import com.neome.api.meta.base.Types.DtoLogTreeKeyValueType

interface DtoLogTreeKeyValue : DtoLogTreeItem
{
  val children: Array<DtoLogTreeKeyValue>?
  val keyColor: String?
  val keyText: String
  val keyTooltip: Boolean?
  val keyWidth: Long?
  val value: String?
  val valueColor: String?
  val valueTooltip: Boolean?
  val valueType: DtoLogTreeKeyValueType?
}