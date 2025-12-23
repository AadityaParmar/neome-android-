// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.EntVdAutoStepWithError
import com.neome.api.meta.base.dto.StudioDtoRowIdPointer

open class EntVdRowRemove : EntVdAutoStepWithError()
{
  var rowIdPointer: StudioDtoRowIdPointer? = null
}