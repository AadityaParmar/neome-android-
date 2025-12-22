// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumLogTreeItemType

class DtoLogTreeItem {
    var bgColor: string? = null
    val id: string
    val type: EnumLogTreeItemType
}
