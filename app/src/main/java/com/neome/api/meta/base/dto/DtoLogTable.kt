// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumLogTableTextStyle

class DtoLogTable : DtoLogItem() {
    var header: DtoLogTableCellHeader[]? = null
    val headerBgColor: string
    val headerColor: string
    val headerStyle: EnumLogTableTextStyle
    var label: string? = null
    val rowBgColor: string
    val rowColor: string
    val rowStyle: EnumLogTableTextStyle
    var rows: DtoLogTableRow[]? = null
    var showRows: number? = null
}
