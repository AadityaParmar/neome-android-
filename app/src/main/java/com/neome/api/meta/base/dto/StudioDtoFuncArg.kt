// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnFuncArg
import com.neome.api.meta.base.Types.MetaIdFuncArg
import com.neome.api.meta.base.dto.StudioBase

open class StudioDtoFuncArg : StudioBase()
{
  var funcArgKind: EnumDefnFuncArg? = null
  lateinit var metaId: MetaIdFuncArg
  lateinit var name: String
  var required: Boolean? = null
}