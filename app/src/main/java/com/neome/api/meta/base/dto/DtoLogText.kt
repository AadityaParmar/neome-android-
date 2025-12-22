// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumFormContentPosition
import com.neome.api.meta.base.Types.EnumLogTextType

class DtoLogText : DtoLogItem() {
    val bgColor: string
    var bold: boolean? = null
    var caption: string? = null
    var child: DtoLogItem? = null
    var contentPosition: EnumFormContentPosition? = null
    var executable: boolean? = null
    var iconEnd: string? = null
    var iconEndColor: string? = null
    var iconStart: string? = null
    var iconStartColor: string? = null
    var showChildDivider: boolean? = null
    val text: string
    var textColor: string? = null
    var textType: EnumLogTextType? = null
}
