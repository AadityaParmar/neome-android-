// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.EntVdAutoStepWithError
import com.neome.api.meta.base.Types.EnumDefnKindAiProvider
import com.neome.api.meta.base.dto.StudioValueParagraph

open class EntVdAi : EntVdAutoStepWithError()
{
  var aiInstructions: StudioValueParagraph? = null
  var aiProvider: EnumDefnKindAiProvider? = null
}