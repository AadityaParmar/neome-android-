// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import java.util.Map
import com.neome.api.meta.base.Types.MetaIdFooter
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioDtoTableFooter

interface StudioMapOfTableFooter : StudioBase
{
  val keys: Array<MetaIdFooter>
  val map: Map<MetaIdFooter, StudioDtoTableFooter>
}