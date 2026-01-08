// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnDtoColor
import com.neome.api.meta.base.Types.EnumDefnConditionOperator
import com.neome.api.meta.base.Types.EnumDefnContentAlignment
import com.neome.api.meta.base.Types.EnumDefnDriveSheetFieldLayoutOn
import com.neome.api.meta.base.Types.EnumDefnDriveSheetLayoutFor
import com.neome.api.meta.base.Types.EnumDefnShowBorderKind
import com.neome.api.meta.base.Types.EnumDefnTextStyle
import com.neome.api.meta.base.Types.MetaIdComposite
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdLayoutDriveSheet
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioBuildArgBinder
import com.neome.api.meta.base.Symbol

interface StudioDtoLayoutDriveSheet : StudioBase
{
  val alignment: EnumDefnContentAlignment?
  val bgColor: DefnDtoColor?
  val borderSet: Array<EnumDefnShowBorderKind>?
  val compositeId: MetaIdComposite?
  val conditionOperator: EnumDefnConditionOperator?
  val conditionValue: StudioBuildArgBinder?
  val fieldId: MetaIdField?
  val fieldLayoutOn: EnumDefnDriveSheetFieldLayoutOn?
  val fontSize: Long?
  val layoutFor: EnumDefnDriveSheetLayoutFor
  val metaId: MetaIdLayoutDriveSheet
  val name: Symbol?
  val textColor: DefnDtoColor?
  val textStyleSet: Array<EnumDefnTextStyle>?
  val width: Long?
}