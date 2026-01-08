// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnDtoColor
import com.neome.api.meta.base.dto.DefnStudioDtoCondition
import com.neome.api.meta.base.Types.EnumDefnDriveSheetFieldLayoutOn
import com.neome.api.meta.base.Types.EnumDefnTextSize
import com.neome.api.meta.base.Types.EnumDefnTextStyle
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdTableStyle
import com.neome.api.meta.base.Symbol

interface DefnDtoTableStyle
{
  val bgColor: DefnDtoColor?
  val conditionVar: DefnStudioDtoCondition?
  val fieldIdSet: Array<MetaIdField>?
  val fieldLayoutOn: EnumDefnDriveSheetFieldLayoutOn?
  val metaId: MetaIdTableStyle?
  val name: Symbol?
  val textColor: DefnDtoColor?
  val textSize: EnumDefnTextSize?
  val textStyleSet: Array<EnumDefnTextStyle>?
}