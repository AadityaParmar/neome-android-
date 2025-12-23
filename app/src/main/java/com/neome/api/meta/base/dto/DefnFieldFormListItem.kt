// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnDtoLayoutCardItem
import com.neome.api.meta.base.dto.DefnFieldLabel
import com.neome.api.meta.base.Types.MetaIdField

open class DefnFieldFormListItem : DefnFieldLabel()
{
  var editableFieldIdSet: Array<MetaIdField>? = null
  var isCard: Boolean? = null
  var layout: DefnDtoLayoutCardItem? = null
}