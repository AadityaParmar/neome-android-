// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import java.util.Map
import com.neome.api.meta.base.Types.MetaIdPipelineVar
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioEntPipelineVar

interface StudioEntPipelineVarMap : StudioBase
{
  val keys: Array<MetaIdPipelineVar>
  val map: Map<MetaIdPipelineVar, StudioEntPipelineVar>
}