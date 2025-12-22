// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Symbol
import com.neome.api.meta.base.Types.EnumDefnTextSize
import com.neome.api.meta.base.Types.EnumDefnTextStyle
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdHeader

class StudioDtoTableHeader : StudioBase() {
    var bgColor: StudioDtoColor? = null
    val displayText: string
    val fieldIdSet: MetaIdField[]
    val metaId: MetaIdHeader
    var name: Symbol? = null
    var textColor: StudioDtoColor? = null
    var textSize: EnumDefnTextSize? = null
    var textStyleSet: EnumDefnTextStyle[]? = null
}
