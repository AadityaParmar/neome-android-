// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import java.util.Map
import com.neome.api.meta.base.Types.MetaIdModule
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioModule

open class StudioModuleMap : StudioBase()
{
  lateinit var keys: Array<MetaIdModule>
  lateinit var map: Map<MetaIdModule, StudioModule>
}