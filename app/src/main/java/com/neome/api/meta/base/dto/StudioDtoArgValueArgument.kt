// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnArgBinderArgument
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.dto.StudioDtoArgValue

interface StudioDtoArgValueArgument : StudioDtoArgValue
{
  val arg1: EnumDefnArgBinderArgument
  val arg2: EnumDefnArgBinderArgument?
  val fieldId: MetaIdField
  val valuePathArray: Array<String>?
}