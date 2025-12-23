// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.EntVdAi
import com.neome.api.meta.base.dto.StudioDtoArgValueParameter

open class EntVdAiTextToSummary : EntVdAi()
{
  var inputField: StudioDtoArgValueParameter? = null
  var outputField: StudioDtoArgValueParameter? = null
}