// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnPlacement
import com.neome.api.meta.base.Types.EnumDefnTextSize
import com.neome.api.meta.base.Types.EnumDefnTextStyle
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdFooter

open class DefnDtoTableFooter {
    var alignment: EnumDefnPlacement? = null
    var bgColor: DefnDtoColor? = null
    lateinit var displayFieldId: MetaIdField
    lateinit var fieldIdSet: Array<MetaIdField>
    lateinit var metaId: MetaIdFooter
    var showLabel: Boolean? = null
    var textColor: DefnDtoColor? = null
    var textSize: EnumDefnTextSize? = null
    var textStyleSet: Array<EnumDefnTextStyle>? = null
}
