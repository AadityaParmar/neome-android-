// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumLogTableTextStyle

interface DtoLogTable : DtoLogItem {
    val header: List<DtoLogTableCellHeader>?
    val headerBgColor: String
    val headerColor: String
    val headerStyle: EnumLogTableTextStyle
    val label: String?
    val rowBgColor: String
    val rowColor: String
    val rowStyle: EnumLogTableTextStyle
    val rows: List<DtoLogTableRow>?
    val showRows: Long?
}
