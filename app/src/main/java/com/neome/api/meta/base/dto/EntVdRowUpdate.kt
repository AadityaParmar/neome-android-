// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.EntVdAutoStepWithOutputAndError
import com.neome.api.meta.base.Types.EnumDefnKindPipelineUpdate
import com.neome.api.meta.base.Types.MetaIdVar
import com.neome.api.meta.base.dto.StudioDtoMapping
import com.neome.api.meta.base.dto.StudioDtoRowIdPointer

open class EntVdRowUpdate : EntVdAutoStepWithOutputAndError()
{
  var option: EnumDefnKindPipelineUpdate? = null
  var outputMapping: StudioDtoMapping? = null
  var outputMappingVarId: MetaIdVar? = null
  var overwriteRow: Boolean? = null
  var rowIdPointer: StudioDtoRowIdPointer? = null
}