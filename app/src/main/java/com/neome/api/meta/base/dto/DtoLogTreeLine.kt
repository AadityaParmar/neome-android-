// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumFormContentPosition
import com.neome.api.meta.base.Types.EnumLogTreeLineCollapse

class DtoLogTreeLine : DtoLogTreeItem() {
    var bold: boolean? = null
    var children: DtoLogTreeKeyValue[]? = null
    var collapse: EnumLogTreeLineCollapse? = null
    var contentPosition: EnumFormContentPosition? = null
    val line: string
    var lineColor: string? = null
}
