// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnDtoColor
import com.neome.api.meta.base.Types.MetaIdSwimlane

interface DefnDtoSwimlane
{
  val color: DefnDtoColor?
  val colorVar: DefnDtoColor?
  val label: String?
  val metaId: MetaIdSwimlane
  val valueOptionId: String?
}