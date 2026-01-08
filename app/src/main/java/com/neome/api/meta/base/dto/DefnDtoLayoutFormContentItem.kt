// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnDtoColor
import com.neome.api.meta.base.Types.EnumDefnShowBorderKind
import com.neome.api.meta.base.Types.EnumDefnThemeDividerKind
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdGrid
import com.neome.api.meta.base.Types.MetaIdLayoutForm
import com.neome.api.meta.base.Types.MetaIdLayoutGrid

interface DefnDtoLayoutFormContentItem
{
  val borderColorVar: DefnDtoColor?
  val borderPositionSet: Array<EnumDefnShowBorderKind>?
  val fieldIdSet: Array<MetaIdField>?
  val formLayoutIdSet: Array<MetaIdLayoutForm>?
  val gridLayoutIdSet: Array<MetaIdLayoutGrid>?
  val paddingPositionSet: Array<EnumDefnShowBorderKind>?
  val paddingSize: EnumDefnThemeDividerKind?
  val showGridSwitcher: Array<MetaIdGrid>?
}