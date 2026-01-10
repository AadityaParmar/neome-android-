// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Symbol
import com.neome.api.meta.base.Types.EnumDefnTextSize
import com.neome.api.meta.base.Types.EnumDefnTextStyle
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdHeader

interface StudioDtoTableHeader : StudioBase {
    val bgColor: StudioDtoColor?
    val displayText: String
    val fieldIdSet: List<MetaIdField>
    val metaId: MetaIdHeader
    val name: Symbol?
    val textColor: StudioDtoColor?
    val textSize: EnumDefnTextSize?
    val textStyleSet: List<EnumDefnTextStyle>?
}
