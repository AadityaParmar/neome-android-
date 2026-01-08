// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnFormLayoutType
import com.neome.api.meta.base.Types.MetaIdLayoutForm
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.Symbol

interface StudioDtoLayoutForm : StudioBase
{
  val description: String?
  val metaId: MetaIdLayoutForm
  val name: Symbol
  val type: EnumDefnFormLayoutType?
}