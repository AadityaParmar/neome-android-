// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Symbol
import com.neome.api.meta.base.Types.EnumDefnConditionOperator
import com.neome.api.meta.base.Types.EnumDefnContentAlignment
import com.neome.api.meta.base.Types.EnumDefnDriveSheetFieldLayoutOn
import com.neome.api.meta.base.Types.EnumDefnDriveSheetLayoutFor
import com.neome.api.meta.base.Types.EnumDefnShowBorderKind
import com.neome.api.meta.base.Types.EnumDefnTextStyle
import com.neome.api.meta.base.Types.MetaIdComposite
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdLayoutDriveSheet

class StudioDtoLayoutDriveSheet : StudioBase() {
    var alignment: EnumDefnContentAlignment? = null
    var bgColor: DefnDtoColor? = null
    var borderSet: EnumDefnShowBorderKind[]? = null
    var compositeId: MetaIdComposite? = null
    var conditionOperator: EnumDefnConditionOperator? = null
    var conditionValue: StudioBuildArgBinder? = null
    var fieldId: MetaIdField? = null
    var fieldLayoutOn: EnumDefnDriveSheetFieldLayoutOn? = null
    var fontSize: number? = null
    val layoutFor: EnumDefnDriveSheetLayoutFor
    val metaId: MetaIdLayoutDriveSheet
    var name: Symbol? = null
    var textColor: DefnDtoColor? = null
    var textStyleSet: EnumDefnTextStyle[]? = null
    var width: number? = null
}
