// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumLogTableTextStyle

class DtoLogTableCell {
    var bgColor: string? = null
    var color: string? = null
    var style: EnumLogTableTextStyle? = null
    val text: string
}
