// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnRenderingKind
import com.neome.api.meta.base.Types.EnumDefnShowBorderKind
import com.neome.api.meta.base.Types.EnumDefnShowBorderRadiusKind
import com.neome.api.meta.base.Types.EnumDefnThemeDirection
import com.neome.api.meta.base.Types.EnumDefnThemeDividerKind
import com.neome.api.meta.base.Types.MetaIdLayoutForm
import com.neome.api.meta.base.Types.MetaIdVar
import com.neome.api.meta.base.dto.StudioDtoColor
import com.neome.api.meta.base.dto.StudioDtoLayoutForm
import com.neome.api.meta.base.dto.StudioDtoLayoutFormContentItem

interface StudioDtoLayoutFormContent : StudioDtoLayoutForm
{
  val allowToSwitchLayoutIdSet: Array<MetaIdLayoutForm>?
  val backgroundColor: StudioDtoColor?
  val backgroundColorVarId: MetaIdVar?
  val borderColor: StudioDtoColor?
  val borderColorVarId: MetaIdVar?
  val borderPositionSet: Array<EnumDefnShowBorderKind>?
  val borderRadiusSet: Array<EnumDefnShowBorderRadiusKind>?
  val borderRadiusSize: EnumDefnThemeDividerKind?
  val direction: EnumDefnThemeDirection?
  val displayLabel: String?
  val end: StudioDtoLayoutFormContentItem?
  val flexCenter: StudioDtoLayoutFormContentItem?
  val paddingPositionSet: Array<EnumDefnShowBorderKind>?
  val paddingSize: EnumDefnThemeDividerKind?
  val renderingMode: EnumDefnRenderingKind?
  val rootLayout: Boolean?
  val start: StudioDtoLayoutFormContentItem?
}