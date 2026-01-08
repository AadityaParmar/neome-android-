// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.EntVdAutoStepWithOutputAndError
import com.neome.api.meta.base.Types.EnumDefnKindPipelineUpdate
import com.neome.api.meta.base.Types.MetaIdVar
import com.neome.api.meta.base.dto.StudioDtoMapping
import com.neome.api.meta.base.dto.StudioDtoRowIdPointer

interface EntVdRowUpdate : EntVdAutoStepWithOutputAndError
{
  val option: EnumDefnKindPipelineUpdate?
  val outputMapping: StudioDtoMapping?
  val outputMappingVarId: MetaIdVar?
  val overwriteRow: Boolean?
  val rowIdPointer: StudioDtoRowIdPointer?
  val skipSpreadsheetUpdateTrigger: Boolean?
}