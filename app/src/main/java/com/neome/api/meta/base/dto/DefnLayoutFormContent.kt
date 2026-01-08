// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnDtoColor
import com.neome.api.meta.base.dto.DefnDtoLayoutFormContentItem
import com.neome.api.meta.base.dto.DefnLayoutForm
import com.neome.api.meta.base.Types.EnumDefnRenderingKind
import com.neome.api.meta.base.Types.EnumDefnShowBorderKind
import com.neome.api.meta.base.Types.EnumDefnShowBorderRadiusKind
import com.neome.api.meta.base.Types.EnumDefnThemeDirection
import com.neome.api.meta.base.Types.EnumDefnThemeDividerKind
import com.neome.api.meta.base.Types.MetaIdLayoutForm

interface DefnLayoutFormContent : DefnLayoutForm
{
  val allowToSwitchLayoutIdSet: Array<MetaIdLayoutForm>?
  val backgroundColor: DefnDtoColor?
  val backgroundColorVar: DefnDtoColor?
  val borderColor: DefnDtoColor?
  val borderColorVar: DefnDtoColor?
  val borderPositionSet: Array<EnumDefnShowBorderKind>?
  val borderRadiusSet: Array<EnumDefnShowBorderRadiusKind>?
  val borderRadiusSize: EnumDefnThemeDividerKind?
  val direction: EnumDefnThemeDirection?
  val displayLabel: String?
  val end: DefnDtoLayoutFormContentItem?
  val flexCenter: DefnDtoLayoutFormContentItem?
  val paddingPositionSet: Array<EnumDefnShowBorderKind>?
  val paddingSize: EnumDefnThemeDividerKind?
  val renderingMode: EnumDefnRenderingKind?
  val start: DefnDtoLayoutFormContentItem?
}