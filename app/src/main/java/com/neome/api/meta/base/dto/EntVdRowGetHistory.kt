// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.EntVdAutoStepWithOutput
import com.neome.api.meta.base.dto.StudioDtoArgValueParameter
import com.neome.api.meta.base.dto.StudioDtoRowIdPointer

interface EntVdRowGetHistory : EntVdAutoStepWithOutput
{
  val offset: StudioDtoArgValueParameter?
  val pageSize: Long?
  val rowIdPointer: StudioDtoRowIdPointer?
}