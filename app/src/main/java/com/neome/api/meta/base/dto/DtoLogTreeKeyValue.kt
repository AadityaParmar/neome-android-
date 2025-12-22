// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.DtoLogTreeKeyValueType

class DtoLogTreeKeyValue : DtoLogTreeItem() {
    var children: DtoLogTreeKeyValue[]? = null
    var keyColor: string? = null
    val keyText: string
    var keyTooltip: boolean? = null
    var keyWidth: number? = null
    var value: string? = null
    var valueColor: string? = null
    var valueTooltip: boolean? = null
    var valueType: DtoLogTreeKeyValueType? = null
}
