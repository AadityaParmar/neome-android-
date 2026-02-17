// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnDtoLayoutCardItem
import com.neome.api.meta.base.dto.DefnFieldLabel
import com.neome.api.meta.base.Types.MetaIdField

interface DefnFieldFormListItem : DefnFieldLabel
{
  val editableFieldIdSet: List<MetaIdField>?
  val isCard: Boolean?
  val layout: DefnDtoLayoutCardItem?
}