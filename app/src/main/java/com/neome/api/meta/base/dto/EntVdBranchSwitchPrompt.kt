// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.EntVdAutoStepWithError
import com.neome.api.meta.base.dto.EntVdPromptMap
import com.neome.api.meta.base.dto.StudioDtoArgValueParameter

open class EntVdBranchSwitchPrompt : EntVdAutoStepWithError()
{
  var field: StudioDtoArgValueParameter? = null
  var promptMap: EntVdPromptMap? = null
}