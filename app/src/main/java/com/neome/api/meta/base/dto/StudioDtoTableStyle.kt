// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnDriveSheetFieldLayoutOn
import com.neome.api.meta.base.Types.EnumDefnTextSize
import com.neome.api.meta.base.Types.EnumDefnTextStyle
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdTableStyle
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioDtoColor
import com.neome.api.meta.base.dto.StudioValueVarIdCondition
import com.neome.api.meta.base.Symbol

open class StudioDtoTableStyle : StudioBase()
{
  var bgColor: StudioDtoColor? = null
  var conditionVarId: StudioValueVarIdCondition? = null
  var fieldIdSet: Array<MetaIdField>? = null
  var fieldLayoutOn: EnumDefnDriveSheetFieldLayoutOn? = null
  var metaId: MetaIdTableStyle? = null
  var name: Symbol? = null
  var textColor: StudioDtoColor? = null
  var textSize: EnumDefnTextSize? = null
  var textStyleSet: Array<EnumDefnTextStyle>? = null
}