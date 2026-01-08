// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import java.util.Map
import com.neome.api.meta.base.Types.MetaIdFuncArg
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioDtoFuncArg

interface StudioMapOfFuncArg : StudioBase
{
  val keys: Array<MetaIdFuncArg>?
  val map: Map<MetaIdFuncArg, StudioDtoFuncArg>
}