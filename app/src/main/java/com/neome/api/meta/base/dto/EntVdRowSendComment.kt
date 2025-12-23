// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.EntVdAutoStepWithError
import com.neome.api.meta.base.dto.StudioBuildArgBinder
import com.neome.api.meta.base.dto.StudioDtoRowIdPointer
import com.neome.api.meta.base.dto.StudioValueParagraph

open class EntVdRowSendComment : EntVdAutoStepWithError()
{
  var message: StudioValueParagraph? = null
  var rowIdPointer: StudioDtoRowIdPointer? = null
  var sender: StudioBuildArgBinder? = null
}