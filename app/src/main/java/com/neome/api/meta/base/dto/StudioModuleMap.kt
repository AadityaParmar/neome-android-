// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import java.util.Map
import com.neome.api.meta.base.Types.MetaIdModule
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioModule

interface StudioModuleMap : StudioBase
{
  val keys: Array<MetaIdModule>
  val map: Map<MetaIdModule, StudioModule>
}