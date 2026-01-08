// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnFuncArg
import com.neome.api.meta.base.dto.StudioMapOfFuncArg
import com.neome.api.meta.base.dto.StudioValueCodeJavascript

interface StudioVarValueFunc
{
  val inputFuncArgMap: StudioMapOfFuncArg?
  val javascript: StudioValueCodeJavascript?
  val outputKind: EnumDefnFuncArg?
}