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

class DefnDtoTableStyle {
    var bgColor: DefnDtoColor? = null
    var conditionVar: DefnStudioDtoCondition? = null
    var fieldIdSet: MetaIdField[]? = null
    var fieldLayoutOn: EnumDefnDriveSheetFieldLayoutOn? = null
    var metaId: MetaIdTableStyle? = null
    var name: Symbol? = null
    var textColor: DefnDtoColor? = null
    var textSize: EnumDefnTextSize? = null
    var textStyleSet: EnumDefnTextStyle[]? = null
}
