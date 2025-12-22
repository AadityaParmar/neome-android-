// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumLogTableAlignment

class DtoLogTableCellHeader : DtoLogTableCell() {
    var flexWeight: number? = null
    var headerAlignment: EnumLogTableAlignment? = null
    var rowAlignment: EnumLogTableAlignment? = null
}
