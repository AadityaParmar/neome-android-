// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumLogItemType

open class DtoLogItem
{
  lateinit var id: String
  lateinit var type: EnumLogItemType
}