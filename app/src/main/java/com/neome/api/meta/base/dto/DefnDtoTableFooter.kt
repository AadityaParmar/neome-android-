// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnPlacement
import com.neome.api.meta.base.Types.EnumDefnTextSize
import com.neome.api.meta.base.Types.EnumDefnTextStyle
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdFooter

class DefnDtoTableFooter {
    var alignment: EnumDefnPlacement? = null
    var bgColor: DefnDtoColor? = null
    val displayFieldId: MetaIdField
    val fieldIdSet: MetaIdField[]
    val metaId: MetaIdFooter
    var showLabel: boolean? = null
    var textColor: DefnDtoColor? = null
    var textSize: EnumDefnTextSize? = null
    var textStyleSet: EnumDefnTextStyle[]? = null
}
