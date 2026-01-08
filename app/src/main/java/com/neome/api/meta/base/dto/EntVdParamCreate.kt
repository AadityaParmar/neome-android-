// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.EntVdAutoStepWithOutput
import com.neome.api.meta.base.Types.EnumDefnKindPipelineUpdate
import com.neome.api.meta.base.dto.FormRefKey
import com.neome.api.meta.base.Types.MetaIdVar
import com.neome.api.meta.base.dto.StudioDtoMapping

interface EntVdParamCreate : EntVdAutoStepWithOutput
{
  val option: EnumDefnKindPipelineUpdate?
  val outputForm: FormRefKey?
  val outputMapping: StudioDtoMapping?
  val outputMappingVarId: MetaIdVar?
}