// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DtoLogTreeItem
import com.neome.api.meta.base.Types.DtoLogTreeKeyValueType

open class DtoLogTreeKeyValue : DtoLogTreeItem()
{
  var children: Array<DtoLogTreeKeyValue>? = null
  var keyColor: String? = null
  lateinit var keyText: String
  var keyTooltip: Boolean? = null
  var keyWidth: Number? = null
  var value: String? = null
  var valueColor: String? = null
  var valueTooltip: Boolean? = null
  var valueType: DtoLogTreeKeyValueType? = null
}