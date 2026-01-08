// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnKindHyperlink
import com.neome.api.meta.base.Types.MetaIdVar
import com.neome.api.meta.base.dto.StudioDtoColor

interface StudioVarValueHyperlink
{
  val color: StudioDtoColor?
  val colorVarId: MetaIdVar?
  val displayText: String?
  val kind: EnumDefnKindHyperlink?
  val value: String?
}