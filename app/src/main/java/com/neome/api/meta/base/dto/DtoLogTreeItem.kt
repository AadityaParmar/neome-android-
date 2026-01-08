// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumLogTreeItemType

interface DtoLogTreeItem
{
  val bgColor: String?
  val id: String
  val type: EnumLogTreeItemType
}