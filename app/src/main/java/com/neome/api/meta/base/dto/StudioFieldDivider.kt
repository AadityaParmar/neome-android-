// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnThemeDividerKind
import com.neome.api.meta.base.Types.MetaIdVar
import com.neome.api.meta.base.dto.StudioDtoColor
import com.neome.api.meta.base.dto.StudioField

interface StudioFieldDivider : StudioField
{
  val color: StudioDtoColor?
  val colorVarId: MetaIdVar?
  val dividerKind: EnumDefnThemeDividerKind?
  val dividerKindVarId: MetaIdVar?
}