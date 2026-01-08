// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnDtoColor
import com.neome.api.meta.base.dto.DefnField
import com.neome.api.meta.base.Types.EnumDefnThemeColor
import com.neome.api.meta.base.Types.EnumDefnThemeDirection
import com.neome.api.meta.base.Types.EnumDefnThemeDividerKind

interface DefnFieldDivider : DefnField
{
  val color: DefnDtoColor?
  val colorVar: EnumDefnThemeColor?
  val dividerKind: EnumDefnThemeDividerKind?
  val dividerKindVar: EnumDefnThemeDividerKind?
  val sectionDirection: EnumDefnThemeDirection?
}