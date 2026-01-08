// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnFuncArg
import com.neome.api.meta.base.Types.MetaIdFuncArg
import com.neome.api.meta.base.dto.StudioBase

interface StudioDtoFuncArg : StudioBase
{
  val funcArgKind: EnumDefnFuncArg?
  val metaId: MetaIdFuncArg
  val name: String
  val required: Boolean?
}