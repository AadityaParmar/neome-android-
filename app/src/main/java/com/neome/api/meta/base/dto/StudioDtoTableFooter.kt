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

open class StudioDtoTableFooter : StudioBase() {
    var alignment: EnumDefnPlacement? = null
    var bgColor: StudioDtoColor? = null
    var displayFieldId: MetaIdField? = null
    lateinit var fieldIdSet: Array<MetaIdField>
    lateinit var metaId: MetaIdFooter
    var name: Symbol? = null
    var showLabel: Boolean? = null
    var textColor: StudioDtoColor? = null
    var textSize: EnumDefnTextSize? = null
    var textStyleSet: Array<EnumDefnTextStyle>? = null
}
