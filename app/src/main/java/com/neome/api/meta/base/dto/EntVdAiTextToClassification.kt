// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.EntVdAi
import com.neome.api.meta.base.Types.MetaIdVar
import com.neome.api.meta.base.dto.StudioDtoArgValueParameter

open class EntVdAiTextToClassification : EntVdAi()
{
  var classificationVarId: MetaIdVar? = null
  var inputField: StudioDtoArgValueParameter? = null
}