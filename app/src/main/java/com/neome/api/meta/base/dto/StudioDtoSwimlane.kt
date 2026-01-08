// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdSwimlane
import com.neome.api.meta.base.Types.MetaIdVar
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioDtoColor
import com.neome.api.meta.base.Symbol

interface StudioDtoSwimlane : StudioBase
{
  val color: StudioDtoColor?
  val colorVarId: MetaIdVar?
  val label: String?
  val metaId: MetaIdSwimlane
  val name: Symbol?
  val valueOptionId: String?
}