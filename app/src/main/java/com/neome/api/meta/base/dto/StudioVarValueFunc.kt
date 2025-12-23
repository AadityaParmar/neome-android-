// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnFuncArg
import com.neome.api.meta.base.dto.StudioMapOfFuncArg
import com.neome.api.meta.base.dto.StudioValueCodeJavascript

open class StudioVarValueFunc
{
  var inputFuncArgMap: StudioMapOfFuncArg? = null
  var javascript: StudioValueCodeJavascript? = null
  var outputKind: EnumDefnFuncArg? = null
}