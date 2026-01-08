// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.EntVdPipelineVar
import java.util.Map
import com.neome.api.meta.base.Types.MetaIdPipelineVar
import com.neome.api.meta.base.dto.StudioBase

interface EntVdPipelineVarMap : StudioBase
{
  val keys: Array<MetaIdPipelineVar>
  val map: Map<MetaIdPipelineVar, EntVdPipelineVar>
}