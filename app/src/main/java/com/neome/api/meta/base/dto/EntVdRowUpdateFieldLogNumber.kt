// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.EntVdAutoStepWithError
import com.neome.api.meta.base.Types.EnumDefnLogOperationKind
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.dto.StudioBuildArgBinder
import com.neome.api.meta.base.dto.StudioDtoRowIdPointer
import com.neome.api.meta.base.dto.StudioValueText

interface EntVdRowUpdateFieldLogNumber : EntVdAutoStepWithError
{
  val inputField: StudioBuildArgBinder?
  val operation: EnumDefnLogOperationKind?
  val operationMessage: StudioValueText?
  val outputLogNumberFieldId: MetaIdField?
  val rowIdPointer: StudioDtoRowIdPointer?
}