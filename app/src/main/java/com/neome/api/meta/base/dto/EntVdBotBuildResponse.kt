// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.EntVdAutoStepWithOutput
import com.neome.api.meta.base.dto.StudioBuildArgBinder
import com.neome.api.meta.base.dto.StudioDtoArgValueParameter

open class EntVdBotBuildResponse : EntVdAutoStepWithOutput()
{
  var attachmentField: StudioDtoArgValueParameter? = null
  var contentField: StudioBuildArgBinder? = null
}