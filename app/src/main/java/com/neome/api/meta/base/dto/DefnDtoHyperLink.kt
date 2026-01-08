// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnDtoColor
import com.neome.api.meta.base.Types.EnumDefnKindHyperlink
import com.neome.api.meta.base.Types.MetaIdHyperlink

interface DefnDtoHyperLink
{
  val color: DefnDtoColor?
  val colorVar: DefnDtoColor?
  val displayText: String?
  val kind: EnumDefnKindHyperlink?
  val metaId: MetaIdHyperlink
  val value: String?
}