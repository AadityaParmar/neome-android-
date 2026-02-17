// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdFuncArg
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioDtoFuncArg

interface StudioMapOfFuncArg : StudioBase
{
  val keys: List<MetaIdFuncArg>?
  val map: Map<MetaIdFuncArg, StudioDtoFuncArg>
}