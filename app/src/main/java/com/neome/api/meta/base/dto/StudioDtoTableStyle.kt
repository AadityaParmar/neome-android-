// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Symbol
import com.neome.api.meta.base.Types.EnumDefnDriveSheetFieldLayoutOn
import com.neome.api.meta.base.Types.EnumDefnTextSize
import com.neome.api.meta.base.Types.EnumDefnTextStyle
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdTableStyle

interface StudioDtoTableStyle : StudioBase {
    val bgColor: StudioDtoColor?
    val conditionVarId: StudioValueVarIdCondition?
    val fieldIdSet: List<MetaIdField>?
    val fieldLayoutOn: EnumDefnDriveSheetFieldLayoutOn?
    val metaId: MetaIdTableStyle?
    val name: Symbol?
    val textColor: StudioDtoColor?
    val textSize: EnumDefnTextSize?
    val textStyleSet: List<EnumDefnTextStyle>?
}
