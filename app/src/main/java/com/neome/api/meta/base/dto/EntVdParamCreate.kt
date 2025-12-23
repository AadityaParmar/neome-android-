// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.EntVdAutoStepWithOutput
import com.neome.api.meta.base.Types.EnumDefnKindPipelineUpdate
import com.neome.api.meta.base.dto.FormRefKey
import com.neome.api.meta.base.Types.MetaIdVar
import com.neome.api.meta.base.dto.StudioDtoMapping

open class EntVdParamCreate : EntVdAutoStepWithOutput()
{
  var option: EnumDefnKindPipelineUpdate? = null
  var outputForm: FormRefKey? = null
  var outputMapping: StudioDtoMapping? = null
  var outputMappingVarId: MetaIdVar? = null
}