// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Symbol
import com.neome.api.meta.base.Types.EnumDefnPlacement
import com.neome.api.meta.base.Types.EnumDefnTextSize
import com.neome.api.meta.base.Types.EnumDefnTextStyle
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdFooter

class StudioDtoTableFooter : StudioBase() {
    var alignment: EnumDefnPlacement? = null
    var bgColor: StudioDtoColor? = null
    var displayFieldId: MetaIdField? = null
    val fieldIdSet: MetaIdField[]
    val metaId: MetaIdFooter
    var name: Symbol? = null
    var showLabel: boolean? = null
    var textColor: StudioDtoColor? = null
    var textSize: EnumDefnTextSize? = null
    var textStyleSet: EnumDefnTextStyle[]? = null
}
