// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DtoLogItem
import com.neome.api.meta.base.dto.DtoLogTableCellHeader
import com.neome.api.meta.base.dto.DtoLogTableRow
import com.neome.api.meta.base.Types.EnumLogTableTextStyle

open class DtoLogTable : DtoLogItem() {
    var header: Array<DtoLogTableCellHeader>? = null
    lateinit var headerBgColor: String
    lateinit var headerColor: String
    lateinit var headerStyle: EnumLogTableTextStyle
    var label: String? = null
    lateinit var rowBgColor: String
    lateinit var rowColor: String
    lateinit var rowStyle: EnumLogTableTextStyle
    var rows: Array<DtoLogTableRow>? = null
    var showRows: Number? = null
}
