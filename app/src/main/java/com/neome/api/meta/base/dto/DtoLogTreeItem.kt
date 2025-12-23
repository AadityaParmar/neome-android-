// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumLogTreeItemType

open class DtoLogTreeItem {
    var bgColor: String? = null
    lateinit var id: String
    lateinit var type: EnumLogTreeItemType
}
