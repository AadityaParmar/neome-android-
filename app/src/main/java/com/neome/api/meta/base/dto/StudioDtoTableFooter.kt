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

interface StudioDtoTableFooter : StudioBase {
    val alignment: EnumDefnPlacement?
    val bgColor: StudioDtoColor?
    val displayFieldId: MetaIdField?
    val fieldIdSet: List<MetaIdField>
    val metaId: MetaIdFooter
    val name: Symbol?
    val showLabel: Boolean?
    val textColor: StudioDtoColor?
    val textSize: EnumDefnTextSize?
    val textStyleSet: List<EnumDefnTextStyle>?
}
