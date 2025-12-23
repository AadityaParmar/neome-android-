// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import java.util.Map
import com.neome.api.meta.base.Types.MetaIdFooter
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioDtoTableFooter

open class StudioMapOfTableFooter : StudioBase()
{
  lateinit var keys: Array<MetaIdFooter>
  lateinit var map: Map<MetaIdFooter, StudioDtoTableFooter>
}