// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import java.util.Map
import com.neome.api.meta.base.Types.MetaIdSwimlane
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioDtoSwimlane

open class StudioMapOfSwimlane : StudioBase()
{
  var keys: Array<MetaIdSwimlane>? = null
  lateinit var map: Map<MetaIdSwimlane, StudioDtoSwimlane>
}