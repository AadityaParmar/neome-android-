// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnShowBorderKind
import com.neome.api.meta.base.Types.EnumDefnThemeDividerKind
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdGrid
import com.neome.api.meta.base.Types.MetaIdLayoutForm
import com.neome.api.meta.base.Types.MetaIdLayoutGrid
import com.neome.api.meta.base.Types.MetaIdVar
import com.neome.api.meta.base.dto.StudioBase

interface StudioDtoLayoutFormContentItem : StudioBase
{
  val borderColorVarId: MetaIdVar?
  val borderPositionSet: Array<EnumDefnShowBorderKind>?
  val fieldIdSet: Array<MetaIdField>?
  val formLayoutIdSet: Array<MetaIdLayoutForm>?
  val gridLayoutIdSet: Array<MetaIdLayoutGrid>?
  val gridSwitcherSet: Array<MetaIdGrid>?
  val paddingPositionSet: Array<EnumDefnShowBorderKind>?
  val paddingSize: EnumDefnThemeDividerKind?
}