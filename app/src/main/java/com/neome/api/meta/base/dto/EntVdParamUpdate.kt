// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.EntVdAutoStep
import com.neome.api.meta.base.Types.EnumDefnKindPipelineUpdate
import com.neome.api.meta.base.Types.MetaIdPipelineParam
import com.neome.api.meta.base.Types.MetaIdVar
import com.neome.api.meta.base.dto.StudioDtoMapping

interface EntVdParamUpdate : EntVdAutoStep
{
  val option: EnumDefnKindPipelineUpdate?
  val outputMapping: StudioDtoMapping?
  val outputMappingVarId: MetaIdVar?
  val pipelineParamId: MetaIdPipelineParam?
}