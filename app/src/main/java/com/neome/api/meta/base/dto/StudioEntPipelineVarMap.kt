// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import java.util.Map
import com.neome.api.meta.base.Types.MetaIdPipelineVar
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioEntPipelineVar

open class StudioEntPipelineVarMap : StudioBase()
{
  lateinit var keys: Array<MetaIdPipelineVar>
  lateinit var map: Map<MetaIdPipelineVar, StudioEntPipelineVar>
}