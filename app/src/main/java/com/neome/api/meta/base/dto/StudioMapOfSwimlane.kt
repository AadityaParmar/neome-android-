// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdSwimlane
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioDtoSwimlane

interface StudioMapOfSwimlane : StudioBase
{
  val keys: List<MetaIdSwimlane>?
  val map: Map<MetaIdSwimlane, StudioDtoSwimlane>
}