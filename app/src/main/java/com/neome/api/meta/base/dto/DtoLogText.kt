// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumFormContentPosition
import com.neome.api.meta.base.Types.EnumLogTextType

open class DtoLogText : DtoLogItem() {
    lateinit var bgColor: String
    var bold: Boolean? = null
    var caption: String? = null
    var child: DtoLogItem? = null
    var contentPosition: EnumFormContentPosition? = null
    var executable: Boolean? = null
    var iconEnd: String? = null
    var iconEndColor: String? = null
    var iconStart: String? = null
    var iconStartColor: String? = null
    var showChildDivider: Boolean? = null
    lateinit var text: String
    var textColor: String? = null
    var textType: EnumLogTextType? = null
}
