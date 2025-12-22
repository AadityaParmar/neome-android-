// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnTextSize
import com.neome.api.meta.base.Types.EnumDefnTextStyle
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdHeader

class DefnDtoTableHeader {
    var bgColor: DefnDtoColor? = null
    val displayText: string
    val fieldIdSet: MetaIdField[]
    val metaId: MetaIdHeader
    var textColor: DefnDtoColor? = null
    var textSize: EnumDefnTextSize? = null
    var textStyleSet: EnumDefnTextStyle[]? = null
}
